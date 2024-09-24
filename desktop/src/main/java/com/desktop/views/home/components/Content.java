package com.desktop.views.home.components;

import java.awt.Color;

import javax.swing.JPanel;

import com.desktop.AppFrame;
import com.desktop.views.home.Home;

public class Content extends JPanel {
  private AppFrame appFrame;
  private Home home;

  public Content(Home _home, AppFrame _appFrame) {
    appFrame = _appFrame;
    home = _home;
    initConfig();
  }

  private void initConfig() {
    this.setVisible(true);
    this.setBounds(200, 60, appFrame.getWidth() - 200, appFrame.getHeight() - 60);
    this.setBackground(Color.decode("#f3f3f3"));

    initComponents();
  }

  private void initComponents() {

  }
}
