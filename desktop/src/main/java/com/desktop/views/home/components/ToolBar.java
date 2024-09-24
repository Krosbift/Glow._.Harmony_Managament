package com.desktop.views.home.components;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.Box;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.desktop.AppFrame;
import com.desktop.views.home.Home;

public class ToolBar extends JPanel {
  private AppFrame appFrame;
  private Home home;
  private JButton logoutButton;
  private JLabel welcomeLabel;

  public ToolBar(Home _home, AppFrame _appFrame) {
    appFrame = _appFrame;
    home = _home;
    initConfig();
  }

  private void initConfig() {
    this.setVisible(true);
    this.setBounds(200, 0, appFrame.getWidth() - 200, 60);
    this.setBackground(Color.decode("#e86c7c"));
    this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

    initComponents();
  }

  private void initComponents() {
    welcomeLabel = new JLabel("Bienvenido Usuario", JLabel.CENTER);
    welcomeLabel.setForeground(Color.decode("#ffffff"));
    welcomeLabel.setAlignmentX(RIGHT_ALIGNMENT);

    logoutButton = new JButton("Cerrar Sesión");
    logoutButton.setPreferredSize(new Dimension(150, 40));
    logoutButton.setMaximumSize(new Dimension(150, 40));
    logoutButton.setAlignmentX(RIGHT_ALIGNMENT);
    logoutButton.setOpaque(true);
    logoutButton.setContentAreaFilled(false);
    logoutButton.setBorderPainted(false);
    logoutButton.setBackground(Color.decode("#ffffff"));
    logoutButton.setForeground(Color.decode("#000000"));

    logoutButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        logout();
      }
    });

    this.add(welcomeLabel);
    this.add(Box.createHorizontalGlue());
    this.add(logoutButton);
  }

  private void logout() {
    logoutButton.setVisible(false);
    this.remove(logoutButton);
    this.revalidate();
    this.repaint();
    logoutButton = null;
    home.logout();
  }

  public void setWelcomeMessage(String message) {
    welcomeLabel.setText("Bienvenid@ " + message);
  }
}
