package hanu.english.service;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import hanu.english.dto.request.AuthenticationRequest;
import hanu.english.dto.request.IntrospecRequest;
import hanu.english.dto.response.AuthenticationResponse;
import hanu.english.dto.response.IntrospecResponse;
import hanu.english.entity.User;
import hanu.english.exception.AppException;
import hanu.english.exception.ErrorCode;
import hanu.english.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Service
public class AuthenticationService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    private static final String SIGNER_KEY = "oAHo1AG6CbA9K3i01Qqs5JEmTQKhqYUlV9y9G0QzhmgBYnmiArzN1fxJMkRU6D8n";

    public AuthenticationResponse authenticate(AuthenticationRequest request) throws JOSEException {

        User user = userRepository.findByEmail(request.getEmail());
        boolean authenticated = passwordEncoder.matches(request.getPassword(), user.getPassword());
        if (!authenticated) {
            throw new AppException(ErrorCode.UNCATEGORIZED_EXCEPTION);
        }

        String token = generateToken(user);
        return AuthenticationResponse.builder()
                .isAuthenticated(true)
                .token(token).build();
    }

    public String generateToken(User user) throws JOSEException {
        var roles = user.getRoles();

        JWSHeader header = new JWSHeader(JWSAlgorithm.HS512);

        JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder()
                .subject(user.getEmail())
                .issuer("hieu.com")
                .issueTime(new Date())
                .expirationTime(new Date(Instant.now().plus(1, ChronoUnit.HOURS).toEpochMilli()))
                .claim("scope", roles  )
                .build();
        Payload payload = new Payload(jwtClaimsSet.toJSONObject());
        JWSObject jwsObject = new JWSObject(header, payload);

        jwsObject.sign(new MACSigner(SIGNER_KEY.getBytes())); // can chuoi 32 bytes
        return jwsObject.serialize();
    }

    public IntrospecResponse introspect(IntrospecRequest request) throws ParseException, JOSEException {
        JWSVerifier jwsVerifier = new MACVerifier(SIGNER_KEY.getBytes());
        SignedJWT signedJWT = SignedJWT.parse(request.getToken());
        Date experation = signedJWT.getJWTClaimsSet().getExpirationTime();
        boolean verified = signedJWT.verify(jwsVerifier);
        return IntrospecResponse.builder()
                .isValid(verified && experation.after(new Date()))
                .build();
    }

}
