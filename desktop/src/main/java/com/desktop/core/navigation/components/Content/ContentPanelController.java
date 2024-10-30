package com.desktop.core.navigation.components.Content;

import java.util.Map;

import com.desktop.core.navigation.NavigationPanelController;
import com.desktop.core.utils.interfaces.ComponentInterface;
import com.desktop.core.utils.interfaces.ControllerInterface;

public class ContentPanelController implements ControllerInterface {
  public NavigationPanelController parentController;
  public ContentPanelComponent contentPanelComponent;
  public Map<String, ControllerInterface> childControllers;
  public Map<String, ComponentInterface> childComponents;

  public ContentPanelController(NavigationPanelController controller) {
    this.parentController = controller;
    _initComponent();
  }

  @Override
  public void _initComponent() {
    contentPanelComponent = new ContentPanelComponent(this);
  }

  @Override
  public void _initChildControllers() {
    childControllers = null;
  }
}
