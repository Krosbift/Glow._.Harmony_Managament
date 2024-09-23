package com.desktop.views.login.components.leftPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class SubPanel extends JPanel {
  private JPanel leftPanel;
  private JLabel logoLabel;
  private JLabel emailLabel;
  private JTextField emailField;
  private JLabel passwordLabel;
  private JPasswordField passwordField;
  private JButton loginButton;

  public SubPanel(JPanel _leftPanel) {
    this.leftPanel = _leftPanel;
    initConfig();
    _listenerSizing(this);
    _listenerSizing(leftPanel);
  }

  private void initConfig() {
    this.setBackground(Color.decode("#ffdffe"));
    this.setLayout(null);
    initComponents();
  }

  private void initComponents() {
    logoLabel = new LogoLabel();
    emailLabel = new JLabel();
    emailField = new EmailField(emailLabel);
    passwordLabel = new JLabel();
    passwordField = new PasswodField(passwordLabel);
    loginButton = new LogInButton();

    this.add(logoLabel);
    this.add(emailLabel);
    this.add(emailField);
    this.add(passwordLabel);
    this.add(passwordField);
    this.add(loginButton);
  }

  private void _listenerSizing(Component component) {
    component.addComponentListener(new ComponentAdapter() {
      @Override
      public void componentResized(ComponentEvent e) {
        resizeComponents();
      }
    });
  }

  private void resizeComponents() {
    int subPanelWidth = leftPanel.getWidth() - 50;
    int subPanelHeight = leftPanel.getHeight() - 50;

    this.setBounds(25, 25, subPanelWidth, subPanelHeight);

    int centerX = subPanelWidth / 2;
    int centerY = subPanelHeight / 2;

    logoLabel.setBounds(centerX - 100, centerY - 250, 200, 200);
    emailLabel.setBounds(centerX - 100, centerY, 200, 30);
    emailField.setBounds(centerX - 100, centerY + 30, 200, 30);
    passwordLabel.setBounds(centerX - 100, centerY + 70, 200, 30);
    passwordField.setBounds(centerX - 100, centerY + 100, 200, 30);
    loginButton.setBounds(centerX - 90, centerY + 160, 180, 30);

    leftPanel.revalidate();
    leftPanel.repaint();
  }
}
