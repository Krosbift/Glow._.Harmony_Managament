package com.desktop.controller;

import com.desktop.controller.views.Frame;

public class AppController {
  private Frame mainFrame;

  public AppController() {
    mainFrame = new Frame(this);
  }

  public void start() {
    mainFrame.setVisible(true);
  }

  public void stop() {
    mainFrame.setVisible(false);
  }
}
