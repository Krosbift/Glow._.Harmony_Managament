package com.desktop.core.components.buttonsBar;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import com.desktop.AppFrame;

public class ButtonPanel extends JPanel {
  private AppFrame appFrame;
  private MinimizeButton minimizeButton;
  private MaximizeButton maximizeButton;
  private CloseButton closeButton;

  public ButtonPanel(AppFrame _appFrame) {
    this.appFrame = _appFrame;
    this.initConfig();
  }

  private void initConfig() {
    this.setBackground(Color.decode("#121212"));
    this.setLayout(new BorderLayout());

    initComponents();
  }

  private void initComponents() {
    minimizeButton = new MinimizeButton(appFrame);
    maximizeButton = new MaximizeButton(appFrame);
    closeButton = new CloseButton();

    this.add(minimizeButton, BorderLayout.WEST);
    this.add(maximizeButton, BorderLayout.CENTER);
    this.add(closeButton, BorderLayout.EAST);
  }
}
