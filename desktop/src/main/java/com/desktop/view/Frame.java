package com.desktop.view;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Dimension;

public class Frame extends JFrame {

  public Frame() {
    setTitle("Ventana Adaptada a la Pantalla");
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    setSize(screenSize.width, screenSize.height);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  }

}
