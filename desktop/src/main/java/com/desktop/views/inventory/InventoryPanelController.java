package com.desktop.views.inventory;

import java.util.Map;
import java.util.HashMap;
import com.desktop.core.navigation.components.Content.ContentPanelController;
import com.desktop.core.navigation.models.ViewsModel;
import com.desktop.core.utils.interfaces.ComponentInterface;
import com.desktop.core.utils.interfaces.ControllerInterface;
import com.desktop.views.inventory.components.BottomPanelComponent;
import com.desktop.views.inventory.components.TopPanelComponent;

public class InventoryPanelController implements ControllerInterface {
  public ViewsModel view;
  public ContentPanelController parentController;
  public InventoryPanelComponent inventoryComponent;
  public Map<String, ControllerInterface> childControllers;
  public Map<String, ComponentInterface> childComponents;

  public InventoryPanelController(ContentPanelController controller, ViewsModel view) {
    this.parentController = controller;
    this.view = view;
    _initComponent();
    _initChildControllers();
    _initChildComponents();
  }

  @Override
  public void _initComponent() {
    inventoryComponent = new InventoryPanelComponent(this);
  }

  @Override
  public void _initChildControllers() {
    childControllers = new HashMap<>();
  }

  public void _initChildComponents() {
    childComponents = new HashMap<>();
    childComponents.put("TopPanelComponent", new TopPanelComponent(this, view.getViewName()));
    childComponents.put("BottomPanelComponent", new BottomPanelComponent(this));
  }
}
