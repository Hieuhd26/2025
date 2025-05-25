package hanu.english.controller;

import com.nimbusds.jose.JOSEException;
import hanu.english.dto.request.AuthenticationRequest;
import hanu.english.dto.request.IntrospecRequest;
import hanu.english.dto.response.ApiResponse;
import hanu.english.dto.response.AuthenticationResponse;
import hanu.english.dto.response.IntrospecResponse;
import hanu.english.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping()
    public ApiResponse<AuthenticationResponse> generateToken(@RequestBody AuthenticationRequest request) throws JOSEException {
      return ApiResponse.<AuthenticationResponse>builder()
              .result(authenticationService.authenticate(request))
              .build();
    }
    @PostMapping("/introspect")
    public ApiResponse<IntrospecResponse> introspect(@RequestBody IntrospecRequest request) throws ParseException, JOSEException {
        return ApiResponse.<IntrospecResponse>builder()
                .result(authenticationService.introspect(request))
                .build();
    }

}
