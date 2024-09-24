package com.desktop.views.home;

import java.awt.Color;
import javax.swing.JPanel;

import com.desktop.AppFrame;
import com.desktop.views.home.components.Content;
import com.desktop.views.home.components.SideNav;
import com.desktop.views.home.components.ToolBar;

public class Home extends JPanel {
  private AppFrame appFrame;
  private ToolBar toolBar;
  private SideNav sideNav;
  private Content contentPanel;

  public Home(AppFrame _appFrame) {
    appFrame = _appFrame;
    initConfig();
  }

  private void initConfig() {
    this.setLayout(null);
    this.setBackground(Color.decode("#f5f5f5"));
    this.setBounds(0, 0, appFrame.getWidth(), appFrame.getHeight());

    initComponents();
  }

  private void initComponents() {
    toolBar = new ToolBar(this, appFrame);
    sideNav = new SideNav(this, appFrame);
    contentPanel = new Content(this, appFrame);

    this.add(sideNav);
    this.add(toolBar);
    this.add(contentPanel);
  }
}
