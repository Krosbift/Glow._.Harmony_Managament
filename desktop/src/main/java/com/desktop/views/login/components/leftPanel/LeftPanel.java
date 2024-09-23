package com.desktop.views.login.components.leftPanel;

import javax.swing.JPanel;

import java.awt.Color;

public class LeftPanel extends JPanel {
  private SubPanel subPanel;

  public LeftPanel() {
    initConfig();
  }

  /**
   * Initializes the configuration for the panel.
   * Sets the background color to white and the layout to null.
   * Calls the method to initialize the components.
   */
  private void initConfig() {
    this.setBackground(Color.decode("#ffffff"));
    this.setLayout(null);

    initComponents();
  }

  /**
   * Initializes the components for the left panel.
   * This method creates a new instance of SubPanel and adds it to the current panel.
   */
  private void initComponents() {
    subPanel = new SubPanel(this);
    this.add(subPanel);
  }
}
