package com.desktop.views.login.services;

import java.util.concurrent.ExecutionException;
import com.desktop.core.database.service.HttpClientService;
import com.desktop.views.login.models.SendLogin;

public class LoginService {
  private final HttpClientService httpClientService = new HttpClientService();

  public LoginService() {
    httpClientService.endpoint = "/users";
  }

  public boolean login(String email, String password) throws ExecutionException {
    StringBuilder params = new StringBuilder("/login");
    try {
      SendLogin sendLogin = new SendLogin()
          .setEmail(email)
          .setPassword(password)
          .build();
      return httpClientService.post(params.toString(), sendLogin, boolean.class);
    } catch (Exception e) {
      throw new ExecutionException(e.getMessage(), null);      
    }
  }
}
