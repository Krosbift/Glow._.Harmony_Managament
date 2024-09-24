package com.desktop.views.home.components;

import java.awt.Color;

import javax.swing.JPanel;

import com.desktop.AppFrame;
import com.desktop.views.home.Home;

public class SideNav extends JPanel {
  private AppFrame appFrame;
  private Home home;

  public SideNav(Home _home, AppFrame _appFrame) {
    appFrame = _appFrame;
    home = _home;
    initConfig();
  }

  private void initConfig() {
    this.setBounds(0, 0, 200, appFrame.getHeight());
    this.setBackground(Color.decode("#0000ff"));

    initComponents();
  }

  private void initComponents() {

  }
}
