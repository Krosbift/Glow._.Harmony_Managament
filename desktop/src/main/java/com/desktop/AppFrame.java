package com.desktop;

import javax.swing.JFrame;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.BorderLayout;

import com.desktop.core.components.titleBar.TitleBarPanel;
import com.desktop.views.login.Login;

public class AppFrame extends JFrame {
  private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

  @SuppressWarnings("unused") private AppController controller;
  private Login login;
  private TitleBarPanel titleBarPanel;

  public AppFrame(AppController controller) {
    this.controller = controller;
    initConfig();
  }

  private void initConfig() {
    this.setSize(screenSize.width - 300, screenSize.height - 100);
    this.setLayout(new BorderLayout());
    this.setLocationRelativeTo(null);
    this.setUndecorated(true);

    initComponents();
  }

  private void initComponents() {
    titleBarPanel = new TitleBarPanel(this);
    login = new Login(this);
    
    this.add(titleBarPanel, BorderLayout.NORTH);
    this.add(login, BorderLayout.CENTER);
  }
}
