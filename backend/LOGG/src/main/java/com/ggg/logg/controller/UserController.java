package com.ggg.logg.controller;


import com.ggg.logg.model.ApiResponse;
import com.ggg.logg.model.dto.UserDto;
import com.ggg.logg.model.request.user.UserLoginRequest;
import com.ggg.logg.model.response.user.UserLoginResponse;
import com.ggg.logg.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @PostMapping("/login")
  public ApiResponse<UserLoginResponse> loginByUserIdAndPassword(
      @RequestBody UserLoginRequest userLoginRequest) {

    UserDto userDto = userService.loginByUserIdAndPassword(userLoginRequest.getUserId(),
        userLoginRequest.getUserPassword());
    return ApiResponse.of(201, "success",
        UserLoginResponse.ofUserDto(userDto));
  }

}
