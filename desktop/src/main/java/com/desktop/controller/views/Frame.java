package com.desktop.controller.views;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import com.desktop.controller.AppController;
import com.desktop.controller.views.login.LoginFrame;

public class Frame extends JFrame {
  // private AppController controller;
  private LoginFrame loginFrame;

  public Frame(AppController controller) {
    // this.controller = controller;
    initConfig();
    initComponents();
  }
  /**
   * Configures the initial settings for the window.
   */
  private void initConfig() {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    this.setSize(screenSize.width, screenSize.height);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("Glow._.Harmony Inventory Management System");
    this.getContentPane().setBackground(Color.decode("#fdddff"));
    this.setLayout(null);
  }

  private void initComponents() {
    loginFrame = new LoginFrame(this);
  }
}
