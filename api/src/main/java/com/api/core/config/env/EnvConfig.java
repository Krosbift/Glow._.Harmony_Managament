package com.api.core.config.env;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.github.cdimascio.dotenv.Dotenv;
import java.io.File;
import com.api.core.config.env.enums.EnvKeys;

/**
 * The EnvConfig class is responsible for loading and providing access to
 * environment variables
 * defined in a .env file. It uses the Dotenv library to load the environment
 * variables and
 * provides a method to retrieve the value associated with a specified
 * environment key.
 * 
 * <p>
 * This class will log an error and throw an IllegalStateException if the .env
 * file is not found
 * or could not be loaded.
 * </p>
 * 
 * <p>
 * Usage example:
 * </p>
 * 
 * <pre>
 * {@code
 * EnvConfig config = new EnvConfig();
 * String value = config.get(EnvKeys.SOME_KEY);
 * }
 * </pre>
 * 
 * <p>
 * Note: Ensure that the .env file is present in the root directory of the
 * project.
 * </p>
 */
public class EnvConfig {
  private static final Logger logger = LoggerFactory.getLogger(EnvConfig.class);
  private final Dotenv dotenv;

  public EnvConfig() {
    File envFile = new File(".env");

    if (envFile.exists() == false) {
      logger.error(".env file not found");
      throw new IllegalStateException(".env file not found");
    }

    logger.info(".env file found");
    dotenv = Dotenv.load();
  }

  /**
   * Retrieves the value associated with the specified environment key.
   *
   * @param key the environment key whose value is to be retrieved
   * @return the value associated with the specified environment key
   * @throws IllegalStateException if the .env file is not found or could not be
   *                               loaded
   */
  public String get(EnvKeys key) {
    if (dotenv == null) {
      throw new IllegalStateException(".env file not found or could not be loaded");
    }
    return dotenv.get(key.name());
  }
}
