package com.desktop;

public class AppController {
  private AppFrame appframe;

  public AppController() {
    appframe = new AppFrame(this);
  }

  public void start() {
    appframe.setVisible(true);
  }

  public void stop() {
    appframe.setVisible(false);
  }
}
