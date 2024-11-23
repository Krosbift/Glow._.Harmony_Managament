package com.desktop.views.minimals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.desktop.core.navigation.components.Content.ContentPanelController;
import com.desktop.core.utils.interfaces.ComponentInterface;
import com.desktop.core.utils.interfaces.ControllerInterface;
import com.desktop.views.products.components.BottomPanelComponent;
import com.desktop.views.products.model.GetProductDto;
import com.desktop.views.products.services.ProductService;
import com.desktop.views.shared.models.ViewModel;
import com.desktop.views.shared.models.product.ProductModel;

public class MinimalPanelController implements ControllerInterface {
  public ViewModel view;
  public ProductService productService = new ProductService();
  public ContentPanelController parentController;
  public MinimalPanelComponent minimalPanelComponent;
  public Map<String, ControllerInterface> childControllers;
  public Map<String, ComponentInterface> childComponents;

  public MinimalPanelController(ContentPanelController controller, ViewModel view) {
    this.parentController = controller;
    this.view = view;
    _initComponent();
    _initChildControllers();
    _initChildComponents();
  }

  @Override
  public void _initComponent() {
    minimalPanelComponent = new MinimalPanelComponent(this);
  }

  @Override
  public void _initChildControllers() {
    childControllers = new HashMap<>();
  }

  public void _initChildComponents() {
    childComponents = new HashMap<>();
  }

  public void setDataTable(GetProductDto getProductDto) {
    try {
      List<ProductModel> products = productService.getProducts(getProductDto);
      ((BottomPanelComponent) childComponents.get("BottomPanelComponent")).createTable(products);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
