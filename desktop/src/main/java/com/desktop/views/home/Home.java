package com.desktop.views.home;

import java.awt.Color;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.concurrent.ExecutionException;

import javax.swing.JPanel;

import com.desktop.views.AppFrameComponent;
import com.desktop.views.home.components.Content;
import com.desktop.views.home.components.SideNav;
import com.desktop.views.home.components.ToolBar;
import com.desktop.views.home.models.UserModel;
import com.desktop.views.home.services.HomeService;

public class Home extends JPanel {
  private String userEmail;

  private AppFrameComponent appFrame;
  private ToolBar toolBar;
  private SideNav sideNav;
  private Content contentPanel;

  private HomeService homeService = new HomeService();

  public Home(AppFrameComponent _appFrame, String _email) throws ExecutionException {
    userEmail = _email;
    appFrame = _appFrame;
    initConfig();
    _listenerSizing();
  }

  private void initConfig() throws ExecutionException {
    this.setLayout(null);
    this.setBackground(Color.decode("#f5f5f5"));
    this.setBounds(0, 0, appFrame.getWidth(), appFrame.getHeight());

    initComponents();
  }

  private void initComponents() throws ExecutionException {
    toolBar = new ToolBar(this, appFrame);
    sideNav = new SideNav(this, appFrame);
    contentPanel = new Content(this, appFrame);

    UserModel user = homeService.getUser(userEmail);
    System.out.println(user);
    toolBar.setWelcomeMessage(user.getNames() + user.getSurNames());

    this.add(sideNav);
    this.add(toolBar);
    this.add(contentPanel);
  }

  private void _listenerSizing() {
    appFrame.addComponentListener(new ComponentAdapter() {
      @Override
      public void componentResized(ComponentEvent evt) {
        resizeComponents();
      }
    });
    resizeComponents();
  }

  private void resizeComponents() {
    int sideNavWidth = Math.max(appFrame.getWidth() / 5, 200);
    sideNav.setBounds(0, 0, sideNavWidth, appFrame.getHeight());
    toolBar.setBounds(sideNavWidth, 0, appFrame.getWidth() - sideNavWidth, 60);
    contentPanel.setBounds(sideNavWidth, 60, appFrame.getWidth() - sideNavWidth, appFrame.getHeight() - 60);

    this.revalidate();
    this.repaint();
  }

  public void logout() {
    this.removeAll();
    this.revalidate();
    this.repaint();
    toolBar = null;
    sideNav = null;
    contentPanel = null;
    // appFrame.showLogin();
  }
}
