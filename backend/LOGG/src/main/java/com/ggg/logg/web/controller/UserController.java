package com.ggg.logg.web.controller;


import com.ggg.logg.domain.common.DuplicatedException;
import com.ggg.logg.web.response.ApiResponse;
import com.ggg.logg.domain.user.User;
import com.ggg.logg.web.request.user.UserLoginRequest;
import com.ggg.logg.web.response.user.UserLoginResponse;
import com.ggg.logg.application.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @PostMapping("/login")
  @ResponseStatus(value = HttpStatus.OK)
  public ApiResponse<UserLoginResponse> loginByEmailAndPassword(
      @RequestBody UserLoginRequest userLoginRequest) {

    User user = userService.loginByEmailAndPassword(userLoginRequest.getEmail(),
        userLoginRequest.getPassword());
    return ApiResponse.of(HttpStatus.OK, "success",
        UserLoginResponse.ofUserDto(user));
  }

  @GetMapping("/check-email")
  public ApiResponse<?> checkDuplicateEmail(@RequestParam String email) {
    if (userService.isDuplicateEmail(email)) {
      throw new DuplicatedException("email", email);
    }
    return ApiResponse.of(HttpStatus.OK, "success", email);
  }

  @GetMapping("/check-nickname")
  public ApiResponse<?> checkDuplicateNickname(@RequestParam String nickname) {
    if (userService.isDuplicateNickname(nickname)) {
      throw new DuplicatedException("nickname", nickname);
    }
    return ApiResponse.of(HttpStatus.OK, "success", nickname);
  }
}
