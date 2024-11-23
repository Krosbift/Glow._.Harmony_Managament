package com.desktop.views.IntsOuts;

import java.util.Map;
import java.util.HashMap;
import java.util.List;

import com.desktop.core.navigation.components.Content.ContentPanelController;
import com.desktop.core.utils.interfaces.ComponentInterface;
import com.desktop.core.utils.interfaces.ControllerInterface;
import com.desktop.views.IntsOuts.components.BottomPanelComponent;
import com.desktop.views.IntsOuts.components.TopPanelComponent;
import com.desktop.views.IntsOuts.model.CreateUpdateProductDto;
import com.desktop.views.IntsOuts.model.GetUpdateProductDto;
import com.desktop.views.IntsOuts.model.IntsOutsModel;
import com.desktop.views.IntsOuts.model.TransactionTypesModel;
import com.desktop.views.IntsOuts.model.UpdateProductUpdateDto;
import com.desktop.views.IntsOuts.services.IntsOutsService;
import com.desktop.views.products.model.ProductModel;
import com.desktop.views.shared.models.ViewModel;

public class IntsOutsPanelController implements ControllerInterface {
  public ViewModel view;
  public IntsOutsService intsOutsService = new IntsOutsService();
  public ContentPanelController parentController;
  public IntsOutsPanelComponent intsOutsComponent;
  public Map<String, ControllerInterface> childControllers;
  public Map<String, ComponentInterface> childComponents;
  public List<ProductModel> productNames;
  public List<TransactionTypesModel> transactionTypes;

  public IntsOutsPanelController(ContentPanelController controller, ViewModel view) {
    this.parentController = controller;
    this.view = view;
    productNames = getProducts();
    transactionTypes = getTransactionTypes();
    _initComponent();
    _initChildControllers();
    _initChildComponents();
  }

  @Override
  public void _initComponent() {
    intsOutsComponent = new IntsOutsPanelComponent(this);
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

  public void setDataTable(GetUpdateProductDto getUpdateProductDto) {
    try {
      List<IntsOutsModel> intsOuts = intsOutsService.getIntsOuts(getUpdateProductDto);
      ((BottomPanelComponent) childComponents.get("BottomPanelComponent")).createTable(intsOuts);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public IntsOutsModel createIntsOut(CreateUpdateProductDto createUpdateProductDto) {
    return intsOutsService.createIntsOuts(createUpdateProductDto);
  }

  public IntsOutsModel updateIntsOut(UpdateProductUpdateDto updateProductUpdateDto, int intsOutsId) {
    return intsOutsService.updateIntsOuts(updateProductUpdateDto, intsOutsId);
  }

  public Integer deleteIntsOut(int intsOutId) {
    return intsOutsService.deleteIntsOuts(intsOutId);
  }

  public List<ProductModel> getProducts() {
    return intsOutsService.getProducts();
  }

  public List<TransactionTypesModel> getTransactionTypes() {
    return intsOutsService.getTransactionTypes();
  }
}
