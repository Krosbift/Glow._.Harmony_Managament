package com.desktop.views.login;

import javax.swing.JPanel;

import java.awt.BorderLayout;

import com.desktop.views.login.components.leftPanel.LeftPanel;
import com.desktop.views.login.components.rightPanel.RightPanel;

/**
 * The Login class represents a JPanel that contains the login view.
 * It consists of a left panel and a right panel, which are initialized
 * and added to the layout in the initComponents method.
 * 
 * <p>This class is responsible for setting up the layout and initializing
 * the components required for the login view.</p>
 * 
 * <p>Usage example:</p>
 * <pre>
 * {@code
 * Login loginPanel = new Login();
 * }
 * </pre>
 * 
 * @see LeftPanel
 * @see RightPanel
 */
public class Login extends JPanel {
  private LeftPanel leftPanel;
  private RightPanel righPanel;

  public Login() {
    initConfig();
  }

  /**
   * Initializes the configuration for the login view.
   * Sets the layout to BorderLayout and initializes the components.
   */
  private void initConfig() {
    this.setLayout(new BorderLayout());
    initComponents();
  }

  /**
   * Initializes the components for the login view.
   * This method creates instances of LeftPanel and RightPanel,
   * and adds them to the current container.
   */
  private void initComponents() {
    leftPanel = new LeftPanel(this);
    righPanel = new RightPanel(this);

    this.add(leftPanel);
    this.add(righPanel);
  }
}
