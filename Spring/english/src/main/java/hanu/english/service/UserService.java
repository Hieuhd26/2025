package hanu.english.service;

import hanu.english.dto.request.UserCreationRequest;
import hanu.english.dto.response.UserDetailResponse;
import hanu.english.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    User createUser(UserCreationRequest request);
    List<User> getListUser();

    UserDetailResponse getDetailUser(Long id);

    Page<User> getByPage(Pageable pageable);

    Page<User> findByName(Pageable pageable, String name);
}
