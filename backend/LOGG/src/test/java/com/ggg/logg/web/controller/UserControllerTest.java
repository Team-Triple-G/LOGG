package com.ggg.logg.web.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static com.ggg.logg.TestConstant.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ggg.logg.domain.user.exception.UserNotFoundException;
import com.ggg.logg.web.response.ApiResponse;
import com.ggg.logg.domain.common.ResourceNotFoundException;
import com.ggg.logg.domain.user.exception.IllegalPasswordException;
import com.ggg.logg.web.request.user.UserLoginRequest;
import com.ggg.logg.web.response.user.UserLoginResponse;
import com.ggg.logg.application.user.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

@MockMvcFilterConfig
@WebMvcTest(UserController.class)
class UserControllerTest {

  @Autowired
  private MockMvc mockMvc;

  private ObjectMapper objectMapper;

  @MockBean
  UserService userService;

  @BeforeEach
  public void setUp() {
//    this.mockMvc = MockMvcBuilders.standaloneSetup(UserController.class).build();
    this.objectMapper = new ObjectMapper();
  }

  @Test
  @DisplayName("존재하는 사용자 Email와 비밀번호를 입력하면 200의 응답을 받는다")
  public void loginSuccessTest() throws Exception {
    //given
    given(this.userService.loginByUserEmailAndPassword(TEST_EMAIL, TEST_PASSWORD)).willReturn(TEST_USER_DTO);
    String uri = "/api/v1/user/login";

    //when
    UserLoginRequest userLoginRequest = new UserLoginRequest(TEST_EMAIL, TEST_PASSWORD);
    String content = objectMapper.writeValueAsString(userLoginRequest);

    ApiResponse<UserLoginResponse> response = ApiResponse.of(HttpStatus.OK, "success",
        UserLoginResponse.ofUserDto(TEST_USER_DTO));
    String exceptedResultString = objectMapper.writeValueAsString(response);

    //then
    mockMvcPostAssert(uri, content, exceptedResultString, status().isOk());
  }

  @Test
  @DisplayName("존재하지 않는 사용자 ID를 입력하면 404 응답을 보낸다.")
  public void invalidIdLoginFailureTest() throws Exception {
    //given
    ResourceNotFoundException exceptedException = new UserNotFoundException("email", INVALID_EMAIL);
    given(this.userService.loginByUserEmailAndPassword(INVALID_EMAIL, TEST_PASSWORD))
        .willThrow(exceptedException);
    String uri = "/api/v1/user/login";

    //when
    UserLoginRequest userLoginRequest = new UserLoginRequest(INVALID_EMAIL, TEST_PASSWORD);
    String content = objectMapper.writeValueAsString(userLoginRequest);

    ApiResponse<?> response = ApiResponse.of(HttpStatus.NOT_FOUND, exceptedException.getMessage(),
        null);
    String exceptedResultString = objectMapper.writeValueAsString(response);

    //then
    mockMvcPostAssert(uri, content, exceptedResultString, status().isNotFound());
  }

  @Test
  @DisplayName("올바르지 않은 비밀번호를 입력하면 404 응답을 보낸다.")
  public void invalidPasswordLoginFailureTest() throws Exception {
    //given
    RuntimeException exceptedException =  new IllegalPasswordException(TEST_EMAIL, INVALID_PASSWORD);
    given(this.userService.loginByUserEmailAndPassword(TEST_EMAIL, INVALID_PASSWORD))
        .willThrow(exceptedException);
    String uri = "/api/v1/user/login";

    //when
    UserLoginRequest userLoginRequest = new UserLoginRequest(TEST_EMAIL, INVALID_PASSWORD);
    String content = objectMapper.writeValueAsString(userLoginRequest);

    ApiResponse<?> response = ApiResponse.of(HttpStatus.UNAUTHORIZED, exceptedException.getMessage(),
        null);
    String exceptedResultString = objectMapper.writeValueAsString(response);

    //then
    mockMvcPostAssert(uri, content, exceptedResultString, status().isUnauthorized());
  }

  private void mockMvcPostAssert(String uri, String content, String exceptedResultString,
      ResultMatcher exceptedResultMat) throws Exception {

    mockMvc.perform(post(uri)
        .content(content)
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(exceptedResultMat)
        .andExpect(content().string(exceptedResultString))
        .andDo(print());
  }
}