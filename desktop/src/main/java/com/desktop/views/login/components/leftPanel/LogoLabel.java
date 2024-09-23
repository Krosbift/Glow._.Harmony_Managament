package com.desktop.views.login.components.leftPanel;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class LogoLabel extends JLabel {
  
  public LogoLabel() {
    initConfig();
    initComponents();
  }

  private void initConfig() {
    ImageIcon logoImage = new ImageIcon(getClass().getResource("/images/glow._.harmony_logo.png"));
    this.setIcon(logoImage);
  }

  private void initComponents() {

  }
}
