package com.desktop;

import javax.swing.JFrame;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.concurrent.ExecutionException;
import java.awt.BorderLayout;
import java.awt.Component;

import com.desktop.core.components.titleBar.TitleBarPanel;
import com.desktop.views.login.Login;
import com.desktop.views.home.Home;

public class AppFrame extends JFrame {
  private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

  @SuppressWarnings("unused") private AppController controller;
  private Login login;
  private Home home;
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

  public void showHome(String email) throws ExecutionException {
    freeComponent(login);
    home = new Home(this, email);
    this.add(home, BorderLayout.CENTER);
    this.revalidate();
    this.repaint();
  }

  public void showLogin() {
    freeComponent(home);
    login = new Login(this);
    this.add(login, BorderLayout.CENTER);
    this.revalidate();
    this.repaint();
  }

  public void freeComponent(Component component) {
    component.setVisible(false);
    this.remove(component);
    this.revalidate();
    this.repaint();
    component = null;
  }
}
