package com.desktop.views.login.components.leftPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

public class PasswodField extends JPasswordField {
  private JLabel passwordLabel;

  public PasswodField(JLabel _passwordLabel) {
    this.passwordLabel = _passwordLabel;
    initConfig();
  }

  private void initConfig() {
    this.setFont(new Font("Arial", Font.PLAIN, 14));
    this.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
    this.setBackground(Color.WHITE);
    this.setOpaque(true);

    JPanel panel = new JPanel(new BorderLayout());
    panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    panel.add(this, BorderLayout.CENTER);
    panel.setBackground(Color.WHITE);
    panel.setOpaque(true);

    initComponents();
  }

  private void initComponents() {
    passwordLabel();
  }

  private void passwordLabel() {
    passwordLabel.setText("Contraseña:");
    passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
    passwordLabel.setFont(new Font("Arial", Font.BOLD, 14));
  }
}
