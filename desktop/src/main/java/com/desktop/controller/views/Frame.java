package com.desktop.controller.views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import com.desktop.controller.AppController;
import com.desktop.controller.views.login.Login;

public class Frame extends JFrame {
  private AppController controller;
  private Login login;
  private int pX, pY;

  public Frame(AppController controller) {
    this.controller = controller;
    initConfig();
  }

  private void initConfig() {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    this.setSize(screenSize.width - 300, screenSize.height - 100);
    this.setUndecorated(true);
    this.setTitle("Glow._.Harmony Inventory Management System");
    this.setLocationRelativeTo(null);
    this.setLayout(new BorderLayout());

    initTitleBar();
    initComponents();
    
    this.addComponentListener(new ComponentAdapter() {
      @Override
      public void componentResized(ComponentEvent e) {

      }
    });
  }

  private void initTitleBar() {
    JPanel titleBar = new JPanel();
    titleBar.setBackground(Color.BLACK);
    titleBar.setPreferredSize(new Dimension(this.getWidth(), 30));
    titleBar.setLayout(new BorderLayout());

    JLabel titleLabel = new JLabel("Glow._.Harmony Inventory Management System", SwingConstants.CENTER);
    titleLabel.setForeground(Color.WHITE);
    titleBar.add(titleLabel, BorderLayout.CENTER);

    JPanel buttonPanel = new JPanel();
    buttonPanel.setBackground(Color.BLACK);
    buttonPanel.setLayout(new BorderLayout());

    JButton minimizeButton = new JButton("_");
    minimizeButton.setForeground(Color.WHITE);
    minimizeButton.setBackground(Color.BLACK);
    minimizeButton.setBorderPainted(false);
    minimizeButton.setFocusPainted(false);
    minimizeButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        setState(JFrame.ICONIFIED);
      }
    });
    buttonPanel.add(minimizeButton, BorderLayout.WEST);

    JButton maximizeButton = new JButton("⬜");
    maximizeButton.setForeground(Color.WHITE);
    maximizeButton.setBackground(Color.BLACK);
    maximizeButton.setBorderPainted(false);
    maximizeButton.setFocusPainted(false);
    maximizeButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (getExtendedState() == JFrame.MAXIMIZED_BOTH) {
          setExtendedState(JFrame.NORMAL);
        } else {
          setExtendedState(JFrame.MAXIMIZED_BOTH);
        }
      }
    });
    buttonPanel.add(maximizeButton, BorderLayout.CENTER);

    JButton closeButton = new JButton("X");
    closeButton.setForeground(Color.WHITE);
    closeButton.setBackground(Color.BLACK);
    closeButton.setBorderPainted(false);
    closeButton.setFocusPainted(false);
    closeButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    });
    buttonPanel.add(closeButton, BorderLayout.EAST);

    titleBar.add(buttonPanel, BorderLayout.EAST);

    titleBar.addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent e) {
        pX = e.getX();
        pY = e.getY();
      }
    });

    titleBar.addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseDragged(MouseEvent e) {
        setLocation(getLocation().x + e.getX() - pX, getLocation().y + e.getY() - pY);
      }
    });

    this.add(titleBar, BorderLayout.NORTH);
  }

  private void initComponents() {
    login = new Login(this);
  }
}
