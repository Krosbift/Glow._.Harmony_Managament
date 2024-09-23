package com.desktop.core.components.buttonsBar;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import com.desktop.AppFrame;
import com.desktop.core.components.titleBar.TitleBarPanel;

public class ButtonPanel extends JPanel {
  private AppFrame appFrame;
  private TitleBarPanel titleBarPanel;
  private MinimizeButton minimizeButton;
  private MaximizeButton maximizeButton;
  private CloseButton closeButton;

  public ButtonPanel(AppFrame _appFrame, TitleBarPanel _titleBarPanel) {
    this.appFrame = _appFrame;
    this.titleBarPanel = _titleBarPanel;
    this.initConfig();
    titleBarPanel.add(this, BorderLayout.EAST);
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
