package hanu.english.controller;

import hanu.english.dto.request.UserCreationRequest;
import hanu.english.dto.response.ApiResponse;
import hanu.english.dto.response.UserDetailResponse;
import hanu.english.entity.User;
import hanu.english.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public List<User> getAllUser() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info("Name: {}", authentication.getName());

        authentication.getAuthorities().forEach(e -> log.info(e.getAuthority()));
        return userService.getListUser();
    }

    @GetMapping("/{id}")
    public ApiResponse<UserDetailResponse> getAllUser(@PathVariable long id) {
        return ApiResponse.<UserDetailResponse>builder().result(userService.getDetailUser(id)).build();
    }

    @PostMapping()
    public ApiResponse<User> createUser(@RequestBody @Valid UserCreationRequest request) {
        return ApiResponse.<User>builder()
                // .statusCode(1000)
                .result(userService.createUser(request)).build();
    }

    @GetMapping("/page")
    public Page<User> getUser(@RequestParam int page, @RequestParam int size, @RequestParam(defaultValue = "asc") String direction, @RequestParam(defaultValue = "id") String sort

    ) {
        Sort.Direction sortDirection = direction.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sortBy = Sort.by(sortDirection, sort);
        Pageable pageable = PageRequest.of(page, size, sortBy);
        return userService.getByPage(pageable);
    }

    @GetMapping("/search")
    public Page<User> getByName(@RequestParam int page, @RequestParam int size, @RequestParam(defaultValue = "asc") String direction, @RequestParam(defaultValue = "id") String sort, @RequestParam String name) {
        Sort.Direction sortDirection = direction.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sortBy = Sort.by(sortDirection, sort);
        Pageable pageable = PageRequest.of(page, size, sortBy);
        return userService.findByName(pageable, name);

    }
}
