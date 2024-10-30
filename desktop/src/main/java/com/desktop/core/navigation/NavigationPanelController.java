package com.desktop.core.navigation;

import java.util.Map;
import java.util.HashMap;
import com.desktop.views.AppFrameController;
import com.desktop.core.navigation.components.Content.ContentPanelController;
import com.desktop.core.navigation.components.SideNav.SideNavPanelController;
import com.desktop.core.navigation.components.ToolBar.ToolBarPanelController;
import com.desktop.core.navigation.services.NavigationService;
import com.desktop.core.utils.interfaces.ComponentInterface;
import com.desktop.core.utils.interfaces.ControllerInterface;

public class NavigationPanelController implements ControllerInterface {
  public String email;
  public NavigationService navigationService = new NavigationService();
  public AppFrameController parentController;
  public NavigationPanelComponent navigationPanelComponent;
  public Map<String, ControllerInterface> childControllers;
  public Map<String, ComponentInterface> childComponents;

  public NavigationPanelController(AppFrameController controller, String email) {
    this.parentController = controller;
    this.email = email;
    _initComponent();
    _initChildControllers();
  }

  @Override
  public void _initComponent() {
    navigationPanelComponent = new NavigationPanelComponent(this);
  }

  @Override
  public void _initChildControllers() {
    childControllers = new HashMap<>();
    childControllers.put("SideNavPanelController", new SideNavPanelController(this));
    childControllers.put("ToolBarPanelController", new ToolBarPanelController(this, email));
    childControllers.put("ContentPanelController", new ContentPanelController(this));
  }

  public void logOut() {
    parentController.switchComponent(null, this);
  }
}
