package com.desktop.views.login.components.rightPanel;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class ImageLabel extends JLabel {
  private RightPanel rightPanel;

  public ImageLabel(RightPanel _rightPanel) {
    rightPanel = _rightPanel;
    initConfig();
    _listenerSizing();
  }

  /**
   * Initializes the configuration for the ImageLabel component.
   * Sets the layout to BorderLayout and initializes the components.
   */
  private void initConfig() {
    this.setLayout(new BorderLayout());
    initComponents();
  }

  /**
   * Initializes the components for the ImageLabel.
   * This method is responsible for setting up and configuring
   * the UI elements and their properties.
   */
  private void initComponents() {
  }

  /**
   * Adds a component listener to the rightPanel to handle resizing events.
   * When the rightPanel is resized, the resizeImage method is called to adjust the image size.
   * The resizeImage method is also called initially to set the image size.
   */
  private void _listenerSizing() {
    rightPanel.addComponentListener(new ComponentAdapter() {
      public void componentResized(ComponentEvent evt) {
        resizeImage();
      }
    });
    resizeImage();
  }

  /**
   * Resizes the image to fit the current dimensions of the component.
   * <p>
   * This method retrieves the current size of the component and, if both width and height are greater than zero,
   * it loads the original image from the specified resource path. The image is then scaled smoothly to match the
   * component's dimensions and set as the component's icon.
   * </p>
   */
  private void resizeImage() {
    Dimension size = this.getSize();
    if (size.width > 0 && size.height > 0) {
      ImageIcon originalImage = new ImageIcon(getClass().getResource("/images/glow._.harmony.png"));
      Image scaledImage = originalImage.getImage().getScaledInstance(size.width, size.height, Image.SCALE_SMOOTH);
      this.setIcon(new ImageIcon(scaledImage));
    }
  }
}
