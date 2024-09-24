package com.desktop.views.home.services;

import java.util.concurrent.ExecutionException;

import com.desktop.core.database.service.HttpClientService;
import com.desktop.views.home.models.UserModel;

public class HomeService {
  private final HttpClientService httpClientService = new HttpClientService();

  public HomeService() {
    httpClientService.endpoint = "/users";
  }
  
  public UserModel getUser(String userEmail) throws ExecutionException {
    StringBuilder params = new StringBuilder("/find-user?userEmail=" + userEmail);
    try {
      return httpClientService.get(params.toString(), UserModel.class);
    } catch (Exception e) {
      throw new ExecutionException(e.getMessage(), null);  
    }
  }
}
