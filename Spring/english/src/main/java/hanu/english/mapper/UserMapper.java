package hanu.english.mapper;

import hanu.english.dto.request.UserCreationRequest;
import hanu.english.dto.response.UserDetailResponse;
import hanu.english.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);
    UserDetailResponse toUserDetailResponse(User request);
}
