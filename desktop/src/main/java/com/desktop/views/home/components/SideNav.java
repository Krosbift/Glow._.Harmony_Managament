package com.desktop.views.home.components;

import java.awt.Color;

import javax.swing.JPanel;

import com.desktop.AppFrame;
import com.desktop.views.home.Home;

public class SideNav extends JPanel {
  private AppFrame appFrame;
  @SuppressWarnings("unused") private Home home;

  public SideNav(Home _home, AppFrame _appFrame) {
    appFrame = _appFrame;
    home = _home;
    initConfig();
  }

  private void initConfig() {
    this.setVisible(true);
    this.setBounds(0, 0, 200, appFrame.getHeight());
    this.setBackground(Color.decode("#ffdffe"));

    initComponents();
  }

  private void initComponents() {

  }
}
