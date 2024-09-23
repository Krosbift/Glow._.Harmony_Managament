package com.desktop.controller.views.login.components.left_panel.sub_panel;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class SubPanelFrame extends JPanel {
  private JFrame mainFrame;
  private JPanel leftPanel;

  public SubPanelFrame(JFrame mainFrame, JPanel leftPanel) {
    this.mainFrame = mainFrame;
    this.leftPanel = leftPanel;
    initConfig();
    addResizeListener();
  }

  private void initConfig() {
    leftPanel.add(this);
  }

  private void addResizeListener() {
    leftPanel.addComponentListener(new ComponentAdapter() {
      @Override
      public void componentResized(ComponentEvent e) {
        int leftPanelWidth = leftPanel.getWidth();
        int leftPanelHeight = leftPanel.getHeight();
        int subPanelWidth = getWidth();
        int subPanelHeight = getHeight();

        int x = (leftPanelWidth - subPanelWidth) / 2;
        int y = (leftPanelHeight - subPanelHeight) / 2;

        setBounds(x, y, subPanelWidth, subPanelHeight);
      }
    });
  }
}
