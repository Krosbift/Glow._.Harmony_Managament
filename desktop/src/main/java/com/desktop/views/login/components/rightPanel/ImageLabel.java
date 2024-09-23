package com.desktop.views.login.components.rightPanel;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import com.desktop.views.login.Login;

public class ImageLabel extends JLabel {
  private Login login;

  public ImageLabel(Login _login) {
    login = _login;
    initConfig();
    _listenerSizing();
  }

  private void initConfig() {
    this.setLayout(new BorderLayout());
    initComponents();
  }

  private void initComponents() {
  }

  private void _listenerSizing() {
    login.addComponentListener(new ComponentAdapter() {
      public void componentResized(ComponentEvent evt) {
        resizeImage();
      }
    });
    resizeImage();
  }

  private void resizeImage() {
    Dimension size = this.getSize();
    if (size.width > 0 && size.height > 0) {
      ImageIcon originalImage = new ImageIcon(getClass().getResource("/images/glow._.harmony.png"));
      this.setIcon(originalImage);
    }
  }
}
