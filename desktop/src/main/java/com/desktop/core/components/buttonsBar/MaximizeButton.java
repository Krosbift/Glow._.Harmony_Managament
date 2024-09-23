package com.desktop.core.components.buttonsBar;

import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;

import com.desktop.AppFrame;

/**
 * The MaximizeButton class extends JButton and provides a button that toggles the maximized state of an application frame.
 * It initializes the button's configuration and adds an action listener to handle the maximize/restore functionality.
 *
 * <p>Constructor:
 * <ul>
 *   <li>{@link #MaximizeButton(AppFrame, ButtonPanel)}: Initializes the MaximizeButton with the given AppFrame and ButtonPanel.</li>
 * </ul>
 *
 * <p>Methods:
 * <ul>
 *   <li>{@link #initConfig()}: Initializes the configuration for the MaximizeButton, setting its text, colors, and properties, and adding it to the ButtonPanel.</li>
 *   <li>{@link #_listener()}: Adds an action listener to the button that toggles the maximized state of the application frame.</li>
 * </ul>
 *
 * <p>Usage example:
 * <pre>
 * {@code
 * AppFrame appFrame = new AppFrame();
 * ButtonPanel buttonPanel = new ButtonPanel();
 * MaximizeButton maximizeButton = new MaximizeButton(appFrame, buttonPanel);
 * }
 * </pre>
 *
 * @see javax.swing.JButton
 * @see java.awt.event.ActionListener
 */
public class MaximizeButton extends JButton {
  private AppFrame appFrame;
  private ButtonPanel buttonPanel;

  public MaximizeButton(AppFrame _appFrame, ButtonPanel _buttonPanel) {
    appFrame = _appFrame;
    buttonPanel = _buttonPanel;
    initConfig();
    _listener();
  }

  /**
   * Initializes the configuration for the MaximizeButton.
   * Sets the text, foreground color, background color, and various button
   * properties.
   * Adds the button to the buttonPanel with a BorderLayout.CENTER constraint.
   */
  private void initConfig() {
    this.setText("⬜");
    this.setForeground(Color.decode("#FFFFFF"));
    this.setBackground(Color.decode("#121212"));
    this.setBorderPainted(false);
    this.setFocusPainted(false);
    buttonPanel.add(this, BorderLayout.CENTER);
  }

  /**
   * Adds an action listener to the button that toggles the maximized state of the application frame.
   * When the button is clicked, if the application frame is currently maximized, it will be restored to its normal state.
   * If the application frame is in its normal state, it will be maximized.
   */
  private void _listener() {
    this.addActionListener((ActionEvent e) -> {
      if (appFrame.getExtendedState() == AppFrame.MAXIMIZED_BOTH) {
        appFrame.setExtendedState(AppFrame.NORMAL);
      } else {
        appFrame.setExtendedState(AppFrame.MAXIMIZED_BOTH);
      }
    });
  }
}
