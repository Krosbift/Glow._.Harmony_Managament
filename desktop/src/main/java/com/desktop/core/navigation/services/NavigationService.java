package com.desktop.core.navigation.services;

import com.desktop.core.database.service.HttpClientService;
import com.desktop.core.navigation.models.UserModel;
import com.desktop.core.navigation.models.ViewsModel;

public class NavigationService {
  private final HttpClientService httpClientService = new HttpClientService();

  /**
   * Retrieves a user by their email address.
   *
   * @param userEmail the email address of the user to retrieve
   * @return the UserModel object representing the user, or null if an exception
   *         occurs
   */
  public UserModel getUser(String userEmail) {
    httpClientService.endpoint = "/users";
    StringBuilder params = new StringBuilder("/find-user?userEmail=" + userEmail);
    try {
      return httpClientService.get(params.toString(), UserModel.class);
    } catch (Exception e) {
      return null;
    }
  }

  /**
   * Retrieves an array of ViewsModel objects from the server.
   * 
   * This method sets the endpoint to "/index" and constructs the parameters
   * for the request as "/find-views". It then makes a GET request to the server
   * using the httpClientService and attempts to parse the response into an array
   * of ViewsModel objects.
   * 
   * @return an array of ViewsModel objects if the request is successful;
   *         null if an exception occurs during the request.
   */
  public ViewsModel[] getViews() {
    httpClientService.endpoint = "/index";
    StringBuilder params = new StringBuilder("/find-views");
    try {
      return httpClientService.get(params.toString(), ViewsModel[].class);
    } catch (Exception e) {
      return null;
    }
  }
}
