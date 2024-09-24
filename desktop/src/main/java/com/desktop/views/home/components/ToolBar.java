package com.desktop.views.home.components;

import javax.swing.JPanel;

import java.awt.Color;

import com.desktop.AppFrame;
import com.desktop.views.home.Home;


public class ToolBar extends JPanel {
  private AppFrame appFrame;
  private Home home;

  public ToolBar(Home _home, AppFrame _appFrame) {
    appFrame = _appFrame;
    home = _home;
    initConfig();
  }

  private void initConfig() {
    this.setBounds(200, 0, appFrame.getWidth() - 200, 60);
    this.setBackground(Color.decode("#ff0000"));

    initComponents();
  }

  private void initComponents() {
  
  }
}
