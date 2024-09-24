package com.desktop;

public class AppController {
  private AppFrame appframe;

  public AppController() {
    appframe = new AppFrame(this);
    activeDB();
  }

  /**
   * Makes the application frame visible.
   * This method sets the visibility of the main application frame to true,
   * allowing the user to interact with the application's GUI.
   */
  public void start() {
    appframe.setVisible(true);
  }

  /**
   * Stops the application by hiding the main application frame.
   */
  public void stop() {
    appframe.setVisible(false);
  }

  private void activeDB() {
    try {
      new AppService();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
