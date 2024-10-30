package com.desktop.views.inventory;

import java.util.Map;
import java.util.HashMap;
import com.desktop.core.navigation.components.Content.ContentPanelController;
import com.desktop.core.utils.interfaces.ComponentInterface;
import com.desktop.core.utils.interfaces.ControllerInterface;

public class InventoryPanelController implements ControllerInterface {
  public ContentPanelController parentController;
  public InventoryPanelComponent inventoryComponent;
  public Map<String, ControllerInterface> childControllers;
  public Map<String, ComponentInterface> childComponents;

  public InventoryPanelController(ContentPanelController controller) {
    this.parentController = controller;
    _initComponent();
    _initChildControllers();
  }

  @Override
  public void _initComponent() {
    inventoryComponent = new InventoryPanelComponent(this);
  }

  @Override
  public void _initChildControllers() {
    childControllers = new HashMap<>();
  }
}
