package com.desktop.core.database.service;

import org.apache.http.client.methods.*;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import com.google.gson.Gson;

import java.io.IOException;

/**
 * The HttpService class provides methods to send HTTP requests (GET, POST, PATCH, DELETE)
 * and parse the responses into specified types using Gson for JSON deserialization.
 * It uses Apache HttpClient for executing HTTP requests.
 * 
 * <p>Usage example:
 * <pre>
 * {@code
 * HttpService httpService = new HttpService();
 * MyResponse response = httpService.sendGet("http://example.com/api/resource", MyResponse.class);
 * }
 * </pre>
 * 
 * <p>Methods:
 * <ul>
 *   <li>{@link #sendGet(String, Class)} - Sends an HTTP GET request and returns the response deserialized into the specified type.</li>
 *   <li>{@link #sendPost(String, Object, Class)} - Sends an HTTP POST request with a JSON body and returns the response deserialized into the specified type.</li>
 *   <li>{@link #sendPatch(String, Object, Class)} - Sends an HTTP PATCH request with a JSON body and returns the response deserialized into the specified type.</li>
 *   <li>{@link #sendDelete(String, Class)} - Sends an HTTP DELETE request and returns the response deserialized into the specified type.</li>
 * </ul>
 * 
 * <p>Dependencies:
 * <ul>
 *   <li>Apache HttpClient</li>
 *   <li>Gson</li>
 * </ul>
 */
public class HttpService {
  private final CloseableHttpClient httpClient;
  private final Gson gson;

  public HttpService() {
    this.httpClient = HttpClients.createDefault();
    this.gson = new Gson();
  }

  /**
   * Sends an HTTP GET request to the specified URL and returns the response
   * deserialized into the specified response type.
   *
   * @param <T> the type of the response object
   * @param url the URL to send the GET request to
   * @param responseType the class of the response type
   * @return the response deserialized into the specified response type
   * @throws IOException if an I/O error occurs
   */
  public <T> T sendGet(String url, Class<T> responseType) throws IOException {
    HttpGet request = new HttpGet(url);
    return executeRequest(request, responseType);
  }

  /**
   * Sends an HTTP POST request to the specified URL with the given body and 
   * returns the response as an object of the specified type.
   *
   * @param <T> the type of the response object
   * @param url the URL to send the POST request to
   * @param body the body of the POST request, which will be serialized to JSON
   * @param responseType the class of the response type
   * @return the response object of the specified type
   * @throws IOException if an I/O error occurs
   */
  public <T> T sendPost(String url, Object body, Class<T> responseType) throws IOException {
    HttpPost request = new HttpPost(url);
    if (body != null) {
      StringEntity entity = new StringEntity(gson.toJson(body));
      request.setEntity(entity);
      request.setHeader("Content-type", "application/json");
    }
    return executeRequest(request, responseType);
  }

  /**
   * Sends an HTTP PATCH request to the specified URL with the given request body and 
   * returns the response as an object of the specified type.
   *
   * @param <T> the type of the response object
   * @param url the URL to send the PATCH request to
   * @param body the request body to be sent with the PATCH request, can be null
   * @param responseType the class of the response type
   * @return the response from the server as an object of the specified type
   * @throws IOException if an I/O error occurs
   */
  public <T> T sendPatch(String url, Object body, Class<T> responseType) throws IOException {
    HttpPatch request = new HttpPatch(url);
    if (body != null) {
      StringEntity entity = new StringEntity(gson.toJson(body));
      request.setEntity(entity);
      request.setHeader("Content-type", "application/json");
    }
    return executeRequest(request, responseType);
  }

  /**
   * Sends an HTTP DELETE request to the specified URL and returns the response
   * deserialized into the specified response type.
   *
   * @param <T> the type of the response object
   * @param url the URL to send the DELETE request to
   * @param responseType the class of the response type
   * @return the response deserialized into the specified response type
   * @throws IOException if an I/O error occurs
   */
  public <T> T sendDelete(String url, Class<T> responseType) throws IOException {
    HttpDelete request = new HttpDelete(url);
    return executeRequest(request, responseType);
  }

  /**
   * Executes an HTTP request and parses the response into the specified type.
   *
   * @param <T> The type of the response object.
   * @param request The HTTP request to be executed.
   * @param responseType The class of the response type.
   * @return The response parsed into the specified type.
   * @throws IOException If an I/O error occurs during the request execution.
   */
  private <T> T executeRequest(HttpRequestBase request, Class<T> responseType) throws IOException {
    try (CloseableHttpResponse response = httpClient.execute(request)) {
      String jsonResponse = EntityUtils.toString(response.getEntity());
      return gson.fromJson(jsonResponse, responseType);
    }
  }
}
