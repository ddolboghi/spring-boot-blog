package com.siwoli.blog.controller;

import com.siwoli.blog.domain.User;
import com.siwoli.blog.dto.AddUserRequest;
import com.siwoli.blog.service.UserDetailService;
import com.siwoli.blog.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class UserControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    UserService userService;

    @Autowired
    UserDetailService userDetailService;

    @Autowired
    PasswordEncoder passwordEncoder;

    public Long createUser(String email, String password) {
        AddUserRequest addUserRequest = new AddUserRequest();
        addUserRequest.setEmail(email);
        addUserRequest.setPassword(password);
        return userService.save(addUserRequest);
    }

    @Test
    @DisplayName("로그인 성공 테스트")
    public void loginSuccessTest() throws Exception {
        String email = "test@email.com";
        String password = "1q2w3e4r";
        this.createUser(email, password);
        mockMvc.perform(formLogin().userParameter("email")
                        .loginProcessingUrl("/login")
                        .user(email).password(password))
                .andExpect(SecurityMockMvcResultMatchers.authenticated());
    }

    @Test
    @DisplayName("로그인 실패 테스트")
    public void loginFailTest() throws  Exception {
        String email = "test@email.com";
        String password = "1q2w3e4r";
        this.createUser(email, password);
        mockMvc.perform(formLogin().userParameter("email")
                        .loginProcessingUrl("/login")
                        .user(email).password("12345678"))
                .andExpect(SecurityMockMvcResultMatchers.unauthenticated());
    }

//    @Test
//    @DisplayName("회원가입 테스트")
//    public void saveMemberTest() {
//        String email = "test@email.com";
//        String password = "1q2w3e4r";
//        User user = createUser(email, password);
//        User savedUser = userDetailService.loadUserByUsername(email);
//
//        assertEquals(user.getEmail(), savedUser.getEmail());
//        assertEquals(user.getPassword(), savedUser.getPassword());
//    }
}
