package com.desktop.views.login.components.left_panel.sub_panel;

import javax.swing.*;

import com.desktop.views.login.Login;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class SubPanel extends JPanel {
  private Login login;
  private JPanel leftPanel;
  private JTextField usernameField;
  private JPasswordField passwordField;
  private JButton loginButton;
  private JLabel usernameLabel;
  private JLabel passwordLabel;
  private JLabel logoLabel;

  public SubPanel(Login _frame, JPanel _leftPanel) {
    this.login = _frame;
    this.leftPanel = _leftPanel;
    initConfig();
  }

  private void initConfig() {
    this.setBackground(Color.decode("#fdddff"));
    this.setLayout(null);
    leftPanel.add(this);

    createLogoImage();
    createLoginForm();
    listenerSizing();
  }

  private void createLogoImage() {
    ImageIcon logoImage = new ImageIcon(getClass().getResource("/images/glow._.harmony_logo.png"));
    logoLabel = new JLabel(logoImage);
    logoLabel.setIcon(logoImage);
    this.add(logoLabel);
  }

  private void createLoginForm() {
    usernameLabel = new JLabel("Correo:");
    usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
    usernameLabel.setFont(new Font("Arial", Font.BOLD, 14));
    this.add(usernameLabel);

    usernameField = new JTextField();
    usernameField.setFont(new Font("Arial", Font.PLAIN, 14));
    usernameField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
    this.add(usernameField);

    passwordLabel = new JLabel("Contraseña:");
    passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
    passwordLabel.setFont(new Font("Arial", Font.BOLD, 14));
    this.add(passwordLabel);

    passwordField = new JPasswordField();
    passwordField.setFont(new Font("Arial", Font.PLAIN, 14));
    passwordField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
    this.add(passwordField);

    loginButton = new JButton("Iniciar Sesión");
    loginButton.setFont(new Font("Arial", Font.BOLD, 14));
    loginButton.setBackground(Color.decode("#4CAF50"));
    loginButton.setForeground(Color.WHITE);
    loginButton.setFocusPainted(false);
    loginButton.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
    this.add(loginButton);

    resizeComponents();
  }

  private void listenerSizing() {
    leftPanel.addComponentListener(new ComponentAdapter() {
      @Override
      public void componentResized(ComponentEvent e) {
        resizeComponents();
      }
    });

    this.addComponentListener(new ComponentAdapter() {
      @Override
      public void componentResized(ComponentEvent e) {
        resizeComponents();
      }
    });

    resizeComponents();
  }

  private void resizeComponents() {
    int subPanelWidth = leftPanel.getWidth() - 50;
    int subPanelHeight = leftPanel.getHeight() - 50;

    this.setBounds(25, 25, subPanelWidth, subPanelHeight);

    int centerX = subPanelWidth / 2;
    int centerY = subPanelHeight / 2;

    logoLabel.setBounds(centerX - 100, centerY - 250, 200, 200);
    usernameLabel.setBounds(centerX - 100, centerY, 200, 30);
    usernameField.setBounds(centerX - 100, centerY + 30, 200, 30);
    passwordLabel.setBounds(centerX - 100, centerY + 70, 200, 30);
    passwordField.setBounds(centerX - 100, centerY + 100, 200, 30);
    loginButton.setBounds(centerX - 90, centerY + 160, 180, 30);

    leftPanel.revalidate();
    leftPanel.repaint();
  }
}
