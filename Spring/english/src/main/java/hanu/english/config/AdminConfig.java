package hanu.english.config;

import hanu.english.entity.User;
import hanu.english.enums.Role;
import hanu.english.exception.AppException;
import hanu.english.exception.ErrorCode;
import hanu.english.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
public class AdminConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        Set<String> roles = new HashSet<>();
        roles.add(Role.ADMIN.name());
        Optional<User> user = userRepository.findByName("admin");
        if(user.isEmpty()){
            userRepository.save(User.builder()
                            .email("admin@gmail.com")
                            .name("admin")
                            .password(passwordEncoder.encode("admin"))
                            .roles(roles)
                    .build());
        }
    }
}
