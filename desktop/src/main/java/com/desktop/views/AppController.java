package com.desktop.views;

public class AppController {
  private AppFrame mainFrame;

  public AppController() {
    mainFrame = new AppFrame(this);
  }

  public void start() {
    mainFrame.setVisible(true);
  }

  public void stop() {
    mainFrame.setVisible(false);
  }
}
