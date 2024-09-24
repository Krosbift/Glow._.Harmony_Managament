package com.desktop.views.login.components.rightPanel;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Component;

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

  /**
   * Frees all components within the current container by setting their visibility to false,
   * removing them from the container, and then revalidating and repainting the container.
   * This method iterates through all components, making them invisible and removing them
   * from the container to ensure that the container is updated accordingly.
   */
  public void freeAllComponents() {
    for (Component component : this.getComponents()) {
      component.setVisible(false);
      this.remove(component);
      this.revalidate();
      this.repaint();
      component = null;
    }
  }
}
