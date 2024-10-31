package com.desktop.views.inventory.components;

import javax.swing.JPanel;
import com.desktop.core.utils.interfaces.ComponentInterface;
import com.desktop.views.inventory.InventoryPanelController;

public class BottomPanelComponent extends JPanel implements ComponentInterface {
  public InventoryPanelController controller;

  public BottomPanelComponent(InventoryPanelController inventoryPanelController) {
    this.controller = inventoryPanelController;
    _configureComponent();
  }

  @Override
  public void _configureComponent() {
    this.setLayout(null);
    this.setBounds(0, (int) (controller.inventoryComponent.getHeight() * 0.1), controller.inventoryComponent.getWidth(),
        (int) (controller.inventoryComponent.getHeight() * 0.9));
    this.setBackground(controller.inventoryComponent.getBackground());
    controller.inventoryComponent.add(this);
  }

}
