package com.desktop.views.login.components.rightPanel;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import com.desktop.views.login.Login;

public class RightPanel extends JPanel {
  private Login login;
  private JLabel imageLabel;

  public RightPanel(Login _login) {
    login = _login;
    initConfig();
    listenerSizing();
  }

  private void initConfig() {
    this.setBackground(Color.decode("#f3f3f3"));
    this.setLayout(new BorderLayout());
    login.add(this, BorderLayout.EAST);
    initComponents();
  }

  private void initComponents() {
    imagenLabel();
    this.addComponentListener(new ComponentAdapter() {
      @Override
      public void componentResized(ComponentEvent e) {
        resizeImage();
      }
    });
  }

  private void imagenLabel() {
    imageLabel = new JLabel();
    this.add(imageLabel, BorderLayout.CENTER);
    resizeImage();
  }

  private void resizeImage() {
    Dimension size = this.getSize();
    if (size.width > 0 && size.height > 0) {
      ImageIcon originalImage = new ImageIcon(getClass().getResource("/images/fondo_login.jpg"));
      Image image = originalImage.getImage();
      Image scaledImage = image.getScaledInstance(size.width, size.height, Image.SCALE_SMOOTH);
      imageLabel.setIcon(new ImageIcon(scaledImage));
    }
  }

  private void listenerSizing() {
    login.addComponentListener(new ComponentAdapter() {
      @Override
      public void componentResized(ComponentEvent e) {
        resizeComponents();
      }
    });
    resizeComponents();
  }

  private void resizeComponents() {
    int leftPanelWidth = Math.max(login.getWidth() / 3, 300);
    int rightPanelWidth = login.getWidth() - leftPanelWidth;
    this.setBounds(leftPanelWidth, 0, rightPanelWidth, login.getHeight());
    login.revalidate();
    login.repaint();
  }
}