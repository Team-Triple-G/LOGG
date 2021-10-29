package com.ggg.logg.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ggg.logg.model.ApiResponse;
import com.ggg.logg.model.dto.UserDto;
import com.ggg.logg.model.exception.ResourceNotFoundException;
import com.ggg.logg.model.request.user.UserLoginRequest;
import com.ggg.logg.model.response.user.UserLoginResponse;
import com.ggg.logg.service.UserService;
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

  private final String TEST_ID = "GGG";
  private final String TEST_PASSWORD = "gurogarbageguys";
  private final String TEST_NICKNAME = "테스트유저";
  private final UserDto TEST_USER_DTO =
      UserDto.builder().userId(TEST_ID).userNickname(TEST_NICKNAME).build();

  private final String INVALID_ID = "Ggg";
  private final String INVALID_PASSWORD = "gugugur";

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
  @DisplayName("존재하는 사용자 ID와 비밀번호를 입력하면 201의 응답을 받는다")
  public void loginSuccessTest() throws Exception {
    //given
    given(this.userService.loginByUserIdAndPassword(TEST_ID, TEST_PASSWORD)).willReturn(TEST_USER_DTO);
    String uri = "/api/v1/user/login";

    //when
    UserLoginRequest userLoginRequest = new UserLoginRequest(TEST_ID, TEST_PASSWORD);
    String content = objectMapper.writeValueAsString(userLoginRequest);

    ApiResponse<UserLoginResponse> response = ApiResponse.of(HttpStatus.CREATED, "success",
        UserLoginResponse.ofUserDto(TEST_USER_DTO));
    String exceptedResultString = objectMapper.writeValueAsString(response);

    //then
    mockMvcPostAssert(uri, content, exceptedResultString, status().isCreated());
  }

//  throw new ResourceNotFoundException("userId", "user", userId);
//}
//    if (!userPassword.equals(TEMP_USER_PASSWORD)) {
//        throw new IllegalPasswordException(userId, userPassword);
//        }

  @Test
  @DisplayName("존재하지 않는 사용자 ID를 입력하면 404 응답을 보낸다.")
  public void invalidIdLoginFailureTest() throws Exception {
    //given
    ResourceNotFoundException exceptedException = new ResourceNotFoundException("userId", "user",
        INVALID_ID);
    given(this.userService.loginByUserIdAndPassword(INVALID_ID, TEST_PASSWORD))
        .willThrow(exceptedException);
    String uri = "/api/v1/user/login";

    //when
    UserLoginRequest userLoginRequest = new UserLoginRequest(INVALID_ID, TEST_PASSWORD);
    String content = objectMapper.writeValueAsString(userLoginRequest);

    ApiResponse<?> response = ApiResponse.of(HttpStatus.NOT_FOUND, exceptedException.getMessage(),
        null);
    String exceptedResultString = objectMapper.writeValueAsString(response);

    //then
    mockMvcPostAssert(uri, content, exceptedResultString, status().isNotFound());
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