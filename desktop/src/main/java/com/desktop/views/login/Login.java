package com.desktop.views.login;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;

import com.desktop.AppFrame;
import com.desktop.views.login.components.leftPanel.LeftPanel;

public class Login extends JPanel {
  private AppFrame appFrame;
  @SuppressWarnings("unused") private LeftPanel leftPanel;

  public Login(AppFrame _frame) {
    appFrame = _frame;
    initConfig();
    appFrame.add(this);
  }

  private void initConfig() {
    this.setBackground(Color.decode("#f3f3f3"));
    this.setLayout(new BorderLayout());

    initComponents();
  }

  private void initComponents() {
    leftPanel = new LeftPanel(this);
  }
}
