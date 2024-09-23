package com.desktop.views.login.components.leftPanel;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import com.desktop.views.login.Login;
import com.desktop.views.login.components.left_panel.sub_panel.SubPanel;

import java.awt.Color;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class LeftPanel extends JPanel {
  private Login login;
  @SuppressWarnings("unused") private SubPanel subPanel;

  public LeftPanel(Login _login) {
    this.login = _login;
    initConfig();
  }

  private void initConfig() {
    this.setBackground(Color.decode("#fff0d8"));
    this.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.BLACK));
    this.setLayout(null);
    login.add(this);
    listenerSizing();
    initComponents();
  }

  private void initComponents() {
    subPanel = new SubPanel(login, this);
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
    int newWidth = Math.max(login.getWidth() / 3, 300);
    this.setBounds(0, 0, newWidth, login.getHeight());
    login.revalidate();
    login.repaint();
  }
}
