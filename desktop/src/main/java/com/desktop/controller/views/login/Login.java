package com.desktop.controller.views.login;

import java.awt.Color;

import javax.swing.JPanel;

import com.desktop.controller.views.Frame;
import com.desktop.controller.views.login.components.left_panel.LeftPanel;

public class Login extends JPanel {
  private Frame frame;
  private LeftPanel leftPanel;

  public Login(Frame _frame) {
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
