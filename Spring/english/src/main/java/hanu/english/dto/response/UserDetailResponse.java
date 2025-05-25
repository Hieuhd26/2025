package hanu.english.dto.response;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Set;

@Data
public class UserDetailResponse {

    private Long id;

    private String name;

    private String email;

    private Set<String> roles;
}
