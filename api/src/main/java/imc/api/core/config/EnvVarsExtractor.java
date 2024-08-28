package imc.api.core.config;

/**
 * Class to extract environment variables
 */
public class EnvVarsExtractor {

  /**
   * Get the value of an environment variable
   * 
   * @param envVarName The name of the environment variable
   * @return The value of the environment variable
   */
  public static String getEnvVar(String envVarName) {
    return System.getenv(envVarName);
  }

}
