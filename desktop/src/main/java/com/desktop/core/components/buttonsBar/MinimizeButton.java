package com.desktop.core.components.buttonsBar;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;

import com.desktop.AppFrame;

/**
 * The MinimizeButton class extends JButton and provides a button that, when clicked,
 * minimizes the application window. It is configured with specific text, colors, and
 * properties, and is added to a specified ButtonPanel.
 * 
 * <p>Constructor:
 * <ul>
 *   <li>{@link #MinimizeButton(AppFrame, ButtonPanel)}: Initializes the button with the given AppFrame and ButtonPanel.</li>
 * </ul>
 * 
 * <p>Private Methods:
 * <ul>
 *   <li>{@link #initConfig()}: Initializes the configuration for the minimize button, including text, colors, and properties.</li>
 *   <li>{@link #_listener()}: Adds an ActionListener to the button that minimizes the application window when clicked.</li>
 * </ul>
 * 
 * <p>Fields:
 * <ul>
 *   <li>{@link #appFrame}: The application frame that will be minimized when the button is clicked.</li>
 *   <li>{@link #buttonPanel}: The panel to which the button will be added.</li>
 * </ul>
 */
public class MinimizeButton extends JButton {
  private AppFrame appFrame;
  private ButtonPanel buttonPanel;

  public MinimizeButton(AppFrame _appFrame, ButtonPanel _buttonPanel) {
    this.appFrame = _appFrame;
    this.buttonPanel = _buttonPanel;
    initConfig();
    _listener();
  }

  /**
   * Initializes the configuration for the minimize button.
   * Sets the text, foreground color, background color, and various button
   * properties.
   * Adds the button to the button panel aligned to the east.
   */
  private void initConfig() {
    this.setText("_");
    this.setForeground(Color.decode("#FFFFFF"));
    this.setBackground(Color.decode("#121212"));
    this.setBorderPainted(false);
    this.setFocusPainted(false);
  }

  /**
   * Adds an ActionListener to the button that minimizes the application window
   * when the button is clicked.
   */
  private void _listener() {
    this.addActionListener((ActionEvent e) -> {
      appFrame.setState(JFrame.ICONIFIED);
    });
  }
}
