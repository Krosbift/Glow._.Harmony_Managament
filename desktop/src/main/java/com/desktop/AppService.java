package com.desktop;

import com.desktop.core.database.service.HttpClientService;

public class AppService {
  private final HttpClientService httpClientService = new HttpClientService();

  public AppService() throws Exception {
    httpClientService.endpoint = "/activate";
    httpClientService.get("", String.class);
  }
}
