package com.desktop.views.login.components.leftPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

public class LogInButton extends JButton {
  public LogInButton() {
    initConfig();
  }

  private void initConfig() {
    this.setText("Iniciar Sesión");
    this.setFont(new Font("Arial", Font.BOLD, 14));
    this.setBackground(Color.decode("#4CAF50"));
    this.setForeground(Color.WHITE);
    this.setFocusPainted(false);
    this.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(Color.decode("#4CAF50"), 2),
        BorderFactory.createEmptyBorder(5, 15, 5, 15)
    ));
    this.setMargin(new Insets(10, 20, 10, 20));
    this.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    UIManager.put("Button.select", new ColorUIResource(Color.decode("#388E3C")));

    initComponents();
  }

  private void initComponents() {
  }
}
