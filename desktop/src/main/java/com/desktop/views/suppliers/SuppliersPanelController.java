package com.desktop.views.suppliers;

import java.util.Map;
import java.util.HashMap;
import com.desktop.core.navigation.components.Content.ContentPanelController;
import com.desktop.core.utils.interfaces.ComponentInterface;
import com.desktop.core.utils.interfaces.ControllerInterface;

public class SuppliersPanelController implements ControllerInterface {
  public ContentPanelController parentController;
  public SuppliersPanelComponent suppliersComponent;
  public Map<String, ControllerInterface> childControllers;
  public Map<String, ComponentInterface> childComponents;

  public SuppliersPanelController(ContentPanelController controller) {
    this.parentController = controller;
    _initComponent();
    _initChildControllers();
  }

  @Override
  public void _initComponent() {
    suppliersComponent = new SuppliersPanelComponent(this);
  }

  @Override
  public void _initChildControllers() {
    childControllers = new HashMap<>();
  }

}
