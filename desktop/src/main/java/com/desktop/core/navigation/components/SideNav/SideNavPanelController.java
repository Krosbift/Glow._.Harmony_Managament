package com.desktop.core.navigation.components.SideNav;

import java.util.Map;
import java.util.HashMap;
import com.desktop.core.navigation.NavigationPanelController;
import com.desktop.core.navigation.components.SideNav.components.ButtonMenuComponent;
import com.desktop.core.navigation.components.SideNav.components.LogoLabelComponent;
import com.desktop.core.navigation.components.Content.ContentPanelController;
import com.desktop.core.navigation.models.ViewsModel;
import com.desktop.core.utils.interfaces.ComponentInterface;
import com.desktop.core.utils.interfaces.ControllerInterface;

public class SideNavPanelController implements ControllerInterface {
  public NavigationPanelController parentController;
  public SideNavPanelComponent sideNavPanelComponent;
  public Map<String, ControllerInterface> childControllers;
  public Map<String, ComponentInterface> childComponents;

  public SideNavPanelController(NavigationPanelController controller) {
    this.parentController = controller;
    _initComponent();
    _initChildControllers();
    _initChildComponents();
  }

  @Override
  public void _initComponent() {
    sideNavPanelComponent = new SideNavPanelComponent(this);
  }

  @Override
  public void _initChildControllers() {
    childControllers = new HashMap<>();
  }

  public void _initChildComponents() {
    childComponents = new HashMap<>();
    childComponents.put("LogoLabelComponent", new LogoLabelComponent(this));
    findViews();
  }

  public void findViews() {
    ViewsModel[] x = parentController.navigationService.getViews();
    for (ViewsModel view : x) {
      childComponents.put(String.valueOf(view.getViewId()), new ButtonMenuComponent(this, view.getViewName(), view.getDescription(), view.getViewId()));
    }
  }

  public void onMenuItemClick(int viewId) {
    ((ContentPanelController) parentController.childControllers.get("ContentPanelController")).loadView(viewId);
  }
}
