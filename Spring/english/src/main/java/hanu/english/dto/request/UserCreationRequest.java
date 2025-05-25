package hanu.english.dto.request;

import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class UserCreationRequest {

    @Size(min = 3, message = "USER_NAME_INVALID")
    private String name;

    private String password;

    private String email;
}
