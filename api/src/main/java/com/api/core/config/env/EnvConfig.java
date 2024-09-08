package com.api.core.config.env;

import io.github.cdimascio.dotenv.Dotenv;

import java.io.File;

import com.api.core.config.env.enums.EnvKeys;



public class EnvConfig {

  private final Dotenv dotenv;

  public EnvConfig() {
    File envFile = new File(".env");
    if (envFile.exists()) {
      System.out.println(".env file found");
      dotenv = Dotenv.load();
    } else {
      System.out.println(".env file not found");
      dotenv = null;
    }
  }

  /**
   * Retrieves the value associated with the given environment key.
   *
   * @param key The environment key to retrieve the value for.
   * @return The value associated with the given key.
   * @throws IllegalStateException If the .env file is not found or could not be loaded.
   */
  public String get(EnvKeys key) {
    if (dotenv == null) {
      throw new IllegalStateException(".env file not found or could not be loaded");
    }
    return dotenv.get(key.name());
  }
}