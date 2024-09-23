package com.desktop.views.login.components.leftPanel;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import com.desktop.views.login.Login;

public class LeftPanel extends JPanel {
  private Login login;
  private SubPanel subPanel;

  /**
   * Constructs a new LeftPanel with the specified Login instance.
   *
   * @param _login the Login instance to be associated with this LeftPanel
   */
  public LeftPanel(Login _login) {
    this.login = _login;
    initConfig();
  }

  /**
   * Initializes the configuration for the panel.
   * <p>
   * This method sets the background color, border, and layout of the panel.
   * It also calls methods to set up component listeners and initialize components.
   * </p>
   */
  private void initConfig() {
    this.setBackground(Color.decode("#fff0d8"));
    this.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.decode("#e8db3b")));
    this.setLayout(new BorderLayout());
    listenerSizing();
    initComponents();
  }

  /**
   * Initializes the components for the left panel.
   * This method creates a new instance of SubPanel with the provided login and this panel,
   * and then adds the subPanel to the current panel.
   */
  private void initComponents() {
    subPanel = new SubPanel(this);
    this.add(subPanel);
  }

  /**
   * Adds a component listener to the login component to handle resizing events.
   * When the login component is resized, the resizeComponents method is called
   * to adjust the sizes of the components accordingly.
   */
  private void listenerSizing() {
    login.addComponentListener(new ComponentAdapter() {
      @Override
      public void componentResized(ComponentEvent e) {
        resizeComponents();
      }
    });
    resizeComponents();
  }

  /**
   * Resizes the components within the left panel based on the width of the login component.
   * The new width is calculated as one-third of the login component's width, with a minimum width of 300 pixels.
   * The height is set to match the height of the login component.
   * After resizing, the login component is revalidated and repainted to reflect the changes.
   */
  private void resizeComponents() {
    int newWidth = Math.max(login.getWidth() / 3, 300);
    this.setBounds(0, 0, newWidth, login.getHeight());
    login.revalidate();
    login.repaint();
  }
}
