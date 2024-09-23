package com.desktop.views.login.components.leftPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.concurrent.ExecutionException;

public class SubPanel extends JPanel {
  private LeftPanel leftPanel;
  private JLabel logoLabel;
  private JLabel emailLabel;
  private JTextField emailField;
  private JLabel passwordLabel;
  private JPasswordField passwordField;
  private JButton loginButton;
  private JLabel errorMessage;

  public SubPanel(LeftPanel _leftPanel) {
    this.leftPanel = _leftPanel;
    initConfig();
    _listenerSizing(this);
    _listenerSizing(leftPanel);
    _listenerTextFields();
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
    errorMessage = new JLabel();
    loginButton = new LogInButton(errorMessage);

    this.add(logoLabel);
    this.add(emailLabel);
    this.add(emailField);
    this.add(passwordLabel);
    this.add(passwordField);
    this.add(loginButton);
    this.add(errorMessage);
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
    errorMessage.setBounds(centerX - 115, centerY + 200, 300, 30);

    leftPanel.revalidate();
    leftPanel.repaint();
  }

  private void _listenerTextFields() {
    loginButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());
        try {
          leftPanel.passedToLogin(email, password);
        } catch (ExecutionException e1) {
          e1.printStackTrace();
        }
      }
    });
  }

  public void stateLogin(boolean state) {
    if (state) {
      errorMessage.setText("¡Inicio de sesión exitoso!");
      errorMessage.setForeground(Color.decode("#00ff00"));
      emailLabel.setForeground(Color.decode("#000000"));
      emailField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
      passwordLabel.setForeground(Color.decode("#000000"));
      passwordField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
    } else {
      errorMessage.setText("Correo o contraseña incorrecta.");
      errorMessage.setForeground(Color.decode("#ff0000"));
      errorMessage.setVisible(true);
      emailLabel.setForeground(Color.decode("#ff0000"));
      emailField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode("#ff0000")));
      passwordLabel.setForeground(Color.decode("#ff0000"));
      passwordField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode("#ff0000")));
    }
  }
}
