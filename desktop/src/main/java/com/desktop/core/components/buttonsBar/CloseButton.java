package com.desktop.core.components.buttonsBar;

import javax.swing.JButton;

/**
 * The CloseButton class extends JButton and represents a button that, when clicked,
 * will close the application. It is designed to be added to a ButtonPanel.
 * 
 * <p>Features:
 * <ul>
 *   <li>Custom text, foreground color, and background color.</li>
 *   <li>Button properties such as border and focus painting are disabled.</li>
 *   <li>Positioned on the EAST side of the ButtonPanel layout.</li>
 *   <li>Exits the application when clicked.</li>
 * </ul>
 * 
 * <p>Usage:
 * <pre>
 * {@code
 * ButtonPanel panel = new ButtonPanel();
 * CloseButton closeButton = new CloseButton(panel);
 * }
 * </pre>
 * 
 * @see javax.swing.JButton
 * @see java.awt.BorderLayout
 * @see java.awt.event.ActionListener
 */
public class CloseButton extends JButton {
  private ButtonPanel buttonPanel;

  public CloseButton(ButtonPanel _buttonPanel) {
    this.buttonPanel = _buttonPanel;
    initConfig();
    _listener();
  }

  /**
   * Initializes the configuration for the CloseButton.
   * Sets the text, foreground color, background color, and various button properties.
   * Adds the button to the buttonPanel with a specified layout position.
   */
  private void initConfig() {
    this.setText("X");
    this.setForeground(java.awt.Color.decode("#FFFFFF"));
    this.setBackground(java.awt.Color.decode("#121212"));
    this.setBorderPainted(false);
    this.setFocusPainted(false);
    buttonPanel.add(this, java.awt.BorderLayout.EAST);
  }

  /**
   * Adds an action listener to the button that exits the application when the button is clicked.
   */
  private void _listener() {
    this.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent e) {
        System.exit(0);
      }
    });
  }
}
