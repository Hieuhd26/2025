package hanu.english.service.impl;

import hanu.english.dto.request.UserCreationRequest;
import hanu.english.dto.response.UserDetailResponse;
import hanu.english.entity.User;
import hanu.english.enums.Role;
import hanu.english.exception.AppException;
import hanu.english.exception.ErrorCode;
import hanu.english.mapper.UserMapper;
import hanu.english.repository.UserRepository;
import hanu.english.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public User createUser(UserCreationRequest request) {
//        return userRepository.save(User.builder()
//                .email(request.getEmail())
//                .name(request.getName())
//                .build());
        if(userRepository.existsByName(request.getName())){
            throw new AppException(ErrorCode.USER_EXISTED);
        }
        User user = userMapper.toUser(request);
        user.setRoles(new HashSet<>(Set.of(Role.USER.name())));
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        return userRepository.save(user);


    }

    @Override
    public List<User> getListUser() {
        return userRepository.findAll();
    }

    @Override
    @PostAuthorize("returnObject.email == authentication.name")
    public UserDetailResponse getDetailUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(()-> new AppException(ErrorCode.USER_NOT_FOUND));
        UserDetailResponse userDetailResponse = userMapper.toUserDetailResponse(user);
        return userDetailResponse;
    }

    @Override
    public Page<User> getByPage(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public Page<User> findByName(Pageable pageable, String name) {
        return userRepository.findByName(pageable, name);
    }
}
