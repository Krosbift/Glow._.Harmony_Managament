package com.desktop.controller.views.login.components.left_panel;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import com.desktop.controller.views.Frame;
import com.desktop.controller.views.login.components.left_panel.sub_panel.SubPanelFrame;

public class LeftPanelFrame extends JPanel {
  private Frame mainFrame;

  public LeftPanelFrame(Frame mainFrame) {
    this.mainFrame = mainFrame;
    initConfig();
    new SubPanelFrame(mainFrame, this);
  }

  private void initConfig() {
    this.setBackground(Color.decode("#fdddff"));
    this.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.BLACK));
    mainFrame.add(this);
    listenerSizing();
  }

  private void listenerSizing() {
    mainFrame.addComponentListener(new ComponentAdapter() {
      @Override
      public void componentResized(ComponentEvent e) {
        resizeComponents();
      }
    });
    resizeComponents();
  }

  private void resizeComponents() {
    if (mainFrame.getWidth() / 3 >= 300) {
      this.setBounds(0, 0, mainFrame.getWidth() / 3, mainFrame.getHeight());
    } else {
      this.setBounds(0, 0, 300, mainFrame.getHeight());
    }
    mainFrame.revalidate();
    mainFrame.repaint();
  }
}
