package com.desktop.controller.views.login;

// import javax.swing.JFrame;

import com.desktop.controller.views.Frame;
import com.desktop.controller.views.login.components.left_panel.LeftPanelFrame;

public class LoginFrame {
  // private JFrame mainFrame;
  private LeftPanelFrame leftPanelFrame;

  public LoginFrame(Frame mainFrame) {
    // mainFrame = AppFrame;
    leftPanelFrame = new LeftPanelFrame(mainFrame);
  }
}
