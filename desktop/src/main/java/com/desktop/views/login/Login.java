package com.desktop.views.login;

import java.awt.Color;

import javax.swing.JPanel;

import com.desktop.AppFrame;
import com.desktop.views.login.components.left_panel.LeftPanel;

public class Login extends JPanel {
  private AppFrame frame;
  private LeftPanel leftPanel;

  public Login(AppFrame _frame) {
    frame = _frame;

    initConfig();
  }

  private void initConfig() {
    this.setBackground(Color.decode("#ffffff"));
    this.setLayout(null);
    frame.add(this);
    initComponents();
  }

  private void initComponents() {
    leftPanel = new LeftPanel(this);
  }
}
