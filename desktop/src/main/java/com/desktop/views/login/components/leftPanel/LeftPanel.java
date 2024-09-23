package com.desktop.views.login.components.leftPanel;

import javax.swing.JPanel;

import com.desktop.views.login.Login;

import java.awt.Color;
import java.util.concurrent.ExecutionException;

public class LeftPanel extends JPanel {
  private Login login;
  private SubPanel subPanel;

  public LeftPanel(Login _login) {
    this.login = _login;
    initConfig();
  }

  /**
   * Initializes the configuration for the panel.
   * Sets the background color to white and the layout to null.
   * Calls the method to initialize the components.
   */
  private void initConfig() {
    this.setBackground(Color.decode("#ffffff"));
    this.setLayout(null);

    initComponents();
  }

  /**
   * Initializes the components for the left panel.
   * This method creates a new instance of SubPanel and adds it to the current panel.
   */
  private void initComponents() {
    subPanel = new SubPanel(this);
    this.add(subPanel);
  }

  /**
   * Validates the user data by passing the provided email and password to the login validation method.
   *
   * @param email the email address of the user
   * @param password the password of the user
   * @throws ExecutionException if an error occurs during the execution of the validation process
   */
  public void passedToLogin(String email, String password) throws ExecutionException {
    login.validateUserData(email, password);
  }
}
