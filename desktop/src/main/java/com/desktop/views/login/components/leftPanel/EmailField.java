package com.desktop.views.login.components.leftPanel;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Color;

public class EmailField extends JTextField {
  private JLabel emailLabel;

  public EmailField(JLabel _emailLabel) {
    this.emailLabel = _emailLabel;
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
    emailLabel();
  }

  private void emailLabel() {
    emailLabel.setText("Correo:");
    emailLabel.setHorizontalAlignment(SwingConstants.CENTER);
    emailLabel.setFont(new Font("Arial", Font.BOLD, 14));
  }
}
