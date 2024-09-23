package com.desktop.views.login;

import javax.swing.JPanel;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.concurrent.ExecutionException;

import com.desktop.AppFrame;
import com.desktop.views.login.components.leftPanel.LeftPanel;
import com.desktop.views.login.components.rightPanel.RightPanel;
import com.desktop.views.login.services.LoginService;

public class Login extends JPanel {
  private AppFrame appFrame;
  private LeftPanel leftPanel;
  private RightPanel rightPanel;

  private LoginService loginService = new LoginService();

  public Login(AppFrame _appFrame) {
    this.appFrame = _appFrame;
    initConfig();
  }

  /**
   * Initializes the configuration for the login view.
   * This method sets the layout to null, adjusts the bounds of the component
   * to match the dimensions of the application frame, initializes the components,
   * and sets up the listener for resizing.
   */
  private void initConfig() {
    this.setLayout(null);
    this.setBounds(0, 0, appFrame.getWidth(), appFrame.getHeight());
    initComponents();
    _listernerSizing();
  }

  /**
   * Initializes the components for the login view.
   * This method creates and adds the left and right panels to the view.
   */
  private void initComponents() {
    leftPanel = new LeftPanel(this);
    rightPanel = new RightPanel();

    this.add(leftPanel);
    this.add(rightPanel);
  }

  /**
   * Adds a component listener to the current component to handle resizing events.
   * When the component is resized, the {@code resizeComponents()} method is called
   * to adjust the size of the components accordingly.
   */
  private void _listernerSizing() {
    this.addComponentListener(new ComponentAdapter() {
      @Override
      public void componentResized(ComponentEvent e) {
        resizeComponents();
      }
    });
    resizeComponents();
  }

  /**
   * Resizes and repositions the left and right panels based on the current width and height of the container.
   * The left panel is set to one-third of the container's width or a minimum of 300 pixels, whichever is greater.
   * The right panel occupies the remaining width of the container.
   * Both panels are set to the full height of the container.
   * After resizing, the container is revalidated and repainted to reflect the changes.
   */
  private void resizeComponents() {
    int leftPanelWidth = Math.max(this.getWidth() / 3, 300);
    int rightPanelWidth = this.getWidth() - leftPanelWidth;

    leftPanel.setBounds(0, 0, leftPanelWidth, this.getHeight());
    rightPanel.setBounds(leftPanelWidth, 0, rightPanelWidth, this.getHeight());

    this.revalidate();
    this.repaint();
  }

  /**
   * Validates the user data by attempting to log in with the provided email and password.
   *
   * @param email the email address of the user
   * @param password the password of the user
   * @throws ExecutionException if an error occurs during the login process
   */
  public void validateUserData(String email, String password) throws ExecutionException {
    try {
      boolean response = loginService.login(email, password);
      System.out.println(response);
    } catch (ExecutionException e) {
      throw e;
    }
  }
}
