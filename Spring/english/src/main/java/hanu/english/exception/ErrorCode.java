package hanu.english.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999,"Uncategorized exception"),
    USER_EXISTED(1001, "User has existed"),
    EMAIL_EXISTED(1002, "Email has existed"),
    USER_NAME_INVALID(1003, "User name must be at least 3 characters"),
    USER_NOT_FOUND(1004,"User not found" );

    private int code;
    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
