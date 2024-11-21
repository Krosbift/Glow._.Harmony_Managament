package com.api.routes.auth;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.api.routes.auth.dtos.LoginUserDto;
import com.api.routes.shared.models.user.UserModel;

@RestController
@RequestMapping("auth")
@Tag(name = "autenticación")
public class AuthController {
  @Autowired
  private AuthService authService;

  @GetMapping("login")
  public UserModel login(@RequestBody LoginUserDto loginUserDto) {
    return authService.login(loginUserDto);
  }
}
