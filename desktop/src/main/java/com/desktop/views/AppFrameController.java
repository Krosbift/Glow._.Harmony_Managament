package com.desktop.views;

import java.util.Map;
import java.util.HashMap;

import com.desktop.core.utils.interfaces.ComponentInterface;
import com.desktop.core.utils.interfaces.ControllerInterface;
import com.desktop.views.components.ButtonsPanelComponent;
import com.desktop.views.components.CloseButton;
import com.desktop.views.components.MaximizeButton;
import com.desktop.views.components.MinimizeButton;
import com.desktop.views.components.TitleTopBarPanelComponent;
import com.desktop.views.components.TopBarPanelComponent;
import com.desktop.views.login.LoginPanelController;
import com.desktop.views.service.AppService;

public class AppFrameController implements ControllerInterface {
  public AppFrameComponent appframe;
  public AppService appService;
  public Map<String, ControllerInterface> childControllers;
  public Map<String, ComponentInterface> childComponents;

  public AppFrameController() {
    _activeDB();
    _initComponent();
    _initChildComponents();
    _initChildControllers();
  }

  @Override
  public void _initComponent() {
    appframe = new AppFrameComponent(this);
  }

  @Override
  public void _initChildControllers() {
    childControllers = new HashMap<>();
    childControllers.put("LoginPanelController", new LoginPanelController(this));
  }

  public void _initChildComponents() {
    childComponents = new HashMap<>();
    childComponents.put("TopBarPanelComponent", new TopBarPanelComponent(this));
    childComponents.put("TitleTopBarPanelComponent", new TitleTopBarPanelComponent(this));
    childComponents.put("ButtonsPanelComponent", new ButtonsPanelComponent(this));
    childComponents.put("MinimizeButton", new MinimizeButton(this));
    childComponents.put("MaximizeButton", new MaximizeButton(this));
    childComponents.put("CloseButton", new CloseButton(this));
  }

  public void start() {
    appframe.setVisible(true);
  }

  /**
   * Initializes the AppService and activates the database.
   */
  private void _activeDB() {
    // appService = new AppService();
    // appService.activeDatabase();
  }
}
