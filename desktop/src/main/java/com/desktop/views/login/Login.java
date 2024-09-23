package com.desktop.views.login;

import javax.swing.JPanel;

import java.awt.BorderLayout;

import com.desktop.AppFrame;
import com.desktop.views.login.components.leftPanel.LeftPanel;
import com.desktop.views.login.components.rightPanel.RightPanel;

public class Login extends JPanel {
  private AppFrame appFrame;
  @SuppressWarnings("unused") private LeftPanel leftPanel;
  @SuppressWarnings("unused") private RightPanel righPanel;

  public Login(AppFrame _frame) {
    appFrame = _frame;
    initConfig();
    appFrame.add(this);
  }

  private void initConfig() {
    this.setLayout(new BorderLayout());

    initComponents();
  }

  private void initComponents() {
    leftPanel = new LeftPanel(this);
    righPanel = new RightPanel(this);
  }
}
