package com.desktop.core.components.titleBar;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import com.desktop.AppFrame;
import com.desktop.core.components.buttonsBar.ButtonPanel;

public class TitleBarPanel extends JPanel {
  private int pX, pY;
  
  private AppFrame appFrame;
  private JLabel titleLabel;
  private ButtonPanel buttonPanel;

  public TitleBarPanel(AppFrame _appFrame) {
    appFrame = _appFrame;
    initConfig();
    _listener();
  }

  private void initConfig() {
    this.setBackground(Color.decode("#121212"));
    this.setPreferredSize(new Dimension(this.getWidth(), 30));
    this.setLayout(new BorderLayout());

    initComponents();
  }

  private void initComponents() {
    titleBarLabel();
    buttonPanel = new ButtonPanel(appFrame);
    this.add(buttonPanel, BorderLayout.EAST);
  }

  private void _listener() {
    this.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mousePressed(java.awt.event.MouseEvent e) {
        pX = e.getX();
        pY = e.getY();
      }
    });

    this.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
      public void mouseDragged(java.awt.event.MouseEvent e) {
        appFrame.setLocation(e.getXOnScreen() - pX, e.getYOnScreen() - pY);
      }
    });
  }

  private void titleBarLabel() {
    titleLabel = new JLabel("Glow._.Harmony Inventory Management System", SwingConstants.CENTER);
    titleLabel.setForeground(Color.WHITE);
    this.add(titleLabel, BorderLayout.CENTER);
  }
}
