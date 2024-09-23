package com.desktop.views.login.components.rightPanel;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import com.desktop.views.login.Login;

public class RightPanel extends JPanel {
  private Login login;
  private ImageLabel imageLabel;

  public RightPanel(Login _login) {
    login = _login;
    initConfig();
    _listenerSizing();
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
   * This method creates an ImageLabel with the login image and adds it to the center of the panel using BorderLayout.
   */
  private void initComponents() {
    imageLabel = new ImageLabel(login);
    this.add(imageLabel);
  }

  /**
   * Adds a component listener to the login component to handle resizing events.
   * When the login component is resized, the resizeComponents method is called
   * to adjust the size of the components accordingly.
   */
  private void _listenerSizing() {
    login.addComponentListener(new ComponentAdapter() {
      @Override
      public void componentResized(ComponentEvent e) {
        resizeComponents();
      }
    });
    resizeComponents();
  }

  /**
   * Adjusts the size and position of the components within the right panel.
   * 
   * This method calculates the width of the left panel as one-third of the login
   * panel's width, with a minimum width of 300 pixels. The right panel's width is
   * then set to the remaining width of the login panel. The bounds of the right
   * panel are updated accordingly, and the login panel is revalidated and repainted
   * to reflect these changes.
   */
  private void resizeComponents() {
    int leftPanelWidth = Math.max(login.getWidth() / 3, 300);
    int rightPanelWidth = login.getWidth() - leftPanelWidth;
    this.setBounds(leftPanelWidth, 0, rightPanelWidth, login.getHeight());
    login.revalidate();
    login.repaint();
  }
}
