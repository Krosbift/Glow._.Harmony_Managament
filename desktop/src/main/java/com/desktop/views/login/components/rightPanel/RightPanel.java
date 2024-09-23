package com.desktop.views.login.components.rightPanel;

import javax.swing.JPanel;

import java.awt.BorderLayout;

public class RightPanel extends JPanel {
  private ImageLabel imageLabel;

  public RightPanel() {
    initConfig();
  }

  /**
   * Initializes the configuration for the panel.
   * Sets the layout to BorderLayout and initializes the components.
   */
  private void initConfig() {
    this.setLayout(new BorderLayout());

    initComponents();
  }

  /**
   * Initializes the components for the right panel.
   * This method creates an instance of ImageLabel and adds it to the panel.
   */
  private void initComponents() {
    imageLabel = new ImageLabel(this);
    this.add(imageLabel);
  }
}
