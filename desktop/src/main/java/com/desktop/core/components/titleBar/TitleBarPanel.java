package com.desktop.core.components.titleBar;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import com.desktop.AppFrame;
import com.desktop.core.components.buttonsBar.ButtonPanel;

/**
 * The TitleBarPanel class represents a custom title bar for an application frame.
 * It extends JPanel and provides functionality for displaying a title and a button panel,
 * as well as enabling the dragging of the application frame.
 * 
 * <p>Features:</p>
 * <ul>
 *   <li>Custom background color and preferred size.</li>
 *   <li>Title label with centered text and custom foreground color.</li>
 *   <li>Button panel for additional controls.</li>
 *   <li>Mouse listeners for dragging the application frame.</li>
 * </ul>
 * 
 * <p>Usage:</p>
 * <pre>
 * {@code
 * AppFrame appFrame = new AppFrame();
 * TitleBarPanel titleBarPanel = new TitleBarPanel(appFrame);
 * }
 * </pre>
 * 
 * <p>Components:</p>
 * <ul>
 *   <li>{@code appFrame}: The main application frame to which this title bar belongs.</li>
 *   <li>{@code titleLabel}: The label displaying the title text.</li>
 *   <li>{@code buttonPanel}: The panel containing buttons for additional controls.</li>
 * </ul>
 * 
 * <p>Listeners:</p>
 * <ul>
 *   <li>MouseListener: Captures the initial position of the mouse when pressed.</li>
 *   <li>MouseMotionListener: Updates the position of the application frame as the mouse is dragged.</li>
 * </ul>
 * 
 * @see JPanel
 * @see AppFrame
 * @see JLabel
 * @see ButtonPanel
 */
public class TitleBarPanel extends JPanel {
  private int pX, pY;
  
  private AppFrame appFrame;
  private JLabel titleLabel;
  private ButtonPanel buttonPanel;

  public TitleBarPanel(AppFrame _appFrame) {
    appFrame = _appFrame;
    initConfig();
    _listener();
    this.add(titleLabel, BorderLayout.CENTER);
    this.add(buttonPanel, BorderLayout.EAST);
    appFrame.add(this, BorderLayout.NORTH);
  }

  /**
   * Initializes the configuration for the TitleBarPanel.
   * Sets the background color, preferred size, and layout of the panel.
   * Also initializes and adds the components to the panel.
   */
  private void initConfig() {
    this.setBackground(Color.decode("#121212"));
    this.setPreferredSize(new Dimension(this.getWidth(), 30));
    this.setLayout(new BorderLayout());

    initComponents();
  }

  /**
   * Initializes the components of the TitleBarPanel.
   * This method sets up the title bar label and the button panel.
   */
  private void initComponents() {
    titleBarLabel();
    buttonPanel = new ButtonPanel(appFrame);
  }

  /**
   * Adds mouse listeners to the component to enable dragging functionality.
   * 
   * The method adds a MouseListener to capture the initial position of the mouse
   * when it is pressed, and a MouseMotionListener to update the position of the
   * application frame as the mouse is dragged.
   * 
   * MouseListener:
   * - mousePressed(java.awt.event.MouseEvent e): Captures the initial X and Y 
   *   coordinates of the mouse when it is pressed.
   * 
   * MouseMotionListener:
   * - mouseDragged(java.awt.event.MouseEvent e): Updates the location of the 
   *   application frame based on the current mouse position, allowing the 
   *   frame to be dragged across the screen.
   */
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

  /**
   * Initializes the title bar label with the text "Glow._.Harmony Inventory Management System".
   * Sets the text alignment to center and the foreground color to white.
   * Adds the label to the center of the title bar panel.
   */
  private void titleBarLabel() {
    titleLabel = new JLabel("Glow._.Harmony Inventory Management System", SwingConstants.CENTER);
    titleLabel.setForeground(Color.WHITE);
  }
}
