package com.api.core.config.env;
import io.github.cdimascio.dotenv.Dotenv;
import java.io.File;
import com.api.core.config.env.enums.EnvKeys;
/**
 * EnvConfig is responsible for loading environment variables from a .env file.
 * If the .env file is found in the current directory, it loads the environment
 * variables using Dotenv.
 * If the .env file is not found, it throws an IllegalStateException.
 *
 * <p>
 * This class provides a method to retrieve the value associated with a given
 * environment key.
 * It ensures that the .env file is loaded before attempting to retrieve any
 * values.
 * </p>
 *
 * <p>
 * Usage example:
 * </p>
 * 
 * <pre>{@code
 * EnvConfig config = new EnvConfig();
 * String value = config.get(EnvKeys.SOME_KEY);
 * }</pre>
 *
 * @throws IllegalStateException if the .env file is not found in the current
 *                               directory or could not be loaded.
 */
public class EnvConfig {
  private final Dotenv dotenv;
  public EnvConfig() {
    File envFile = new File(".env");
    if (envFile.exists()) {
      System.out.println(".env file found");
      dotenv = Dotenv.load();
    } else {
      System.out.println(".env file not found");
      throw new IllegalStateException(".env file not found");
    }
  }
  /**
   * Retrieves the value associated with the given environment key.
   *
   * @param key The environment key to retrieve the value for.
   * @return The value associated with the given key.
   * @throws IllegalStateException If the .env file is not found or could not be
   *                               loaded.
   */
  public String get(EnvKeys key) {
    if (dotenv == null) {
      throw new IllegalStateException(".env file not found or could not be loaded");
    }
    return dotenv.get(key.name());
  }
}
