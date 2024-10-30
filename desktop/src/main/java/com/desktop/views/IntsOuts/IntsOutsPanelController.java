package com.desktop.views.IntsOuts;

import java.util.Map;
import java.util.HashMap;
import com.desktop.core.navigation.components.Content.ContentPanelController;
import com.desktop.core.utils.interfaces.ComponentInterface;
import com.desktop.core.utils.interfaces.ControllerInterface;

public class IntsOutsPanelController implements ControllerInterface {
  public ContentPanelController parentController;
  public IntsOutsPanelComponent intsOutsComponent;
  public Map<String, ControllerInterface> childControllers;
  public Map<String, ComponentInterface> childComponents;

  public IntsOutsPanelController(ContentPanelController controller) {
    this.parentController = controller;
    _initComponent();
    _initChildControllers();
  }

  @Override
  public void _initComponent() {
    intsOutsComponent = new IntsOutsPanelComponent(this);
  }

  @Override
  public void _initChildControllers() {
    childControllers = new HashMap<>();
  }
}
