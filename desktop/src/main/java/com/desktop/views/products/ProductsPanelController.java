package com.desktop.views.products;

import java.util.Map;
import java.util.HashMap;
import com.desktop.core.navigation.components.Content.ContentPanelController;
import com.desktop.core.utils.interfaces.ComponentInterface;
import com.desktop.core.utils.interfaces.ControllerInterface;

public class ProductsPanelController implements ControllerInterface {
  public ContentPanelController parentController;
  public ProductsPanelComponent productsComponent;
  public Map<String, ControllerInterface> childControllers;
  public Map<String, ComponentInterface> childComponents;

  public ProductsPanelController(ContentPanelController controller) {
    this.parentController = controller;
    _initComponent();
    _initChildControllers();
  }

  @Override
  public void _initComponent() {
    productsComponent = new ProductsPanelComponent(this);
  }

  @Override
  public void _initChildControllers() {
    childControllers = new HashMap<>();
  }

}
