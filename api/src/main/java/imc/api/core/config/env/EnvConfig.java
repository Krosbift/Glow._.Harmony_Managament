package imc.api.core.config.env;

import imc.api.core.config.env.interfaces.EnvKeys;
import io.github.cdimascio.dotenv.Dotenv;

import java.io.File;

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

  public String get(EnvKeys key) {
    if (dotenv == null) {
      throw new IllegalStateException(".env file not found or could not be loaded");
    }
    return dotenv.get(key.name());
  }
}