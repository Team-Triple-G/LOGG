package com.ggg.logg.controller;


import com.ggg.logg.model.ApiResponse;
import com.ggg.logg.model.response.user.UserLoginResponse;
import com.ggg.logg.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @PostMapping("/login")
  public ApiResponse<UserLoginResponse> loginByUserIdAndPassword(
      @RequestBody UserLoginResponse userLoginResponse) {
    return null;
  }

}
