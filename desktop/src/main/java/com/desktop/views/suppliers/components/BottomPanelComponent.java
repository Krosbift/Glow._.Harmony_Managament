package com.desktop.views.suppliers.components;

import javax.swing.JPanel;
import com.desktop.core.utils.interfaces.ComponentInterface;
import com.desktop.views.suppliers.SuppliersPanelController;

public class BottomPanelComponent extends JPanel implements ComponentInterface {
  public SuppliersPanelController controller;

  public BottomPanelComponent(SuppliersPanelController suppliersPanelController) {
    this.controller = suppliersPanelController;
    _configureComponent();
  }

  @Override
  public void _configureComponent() {
    this.setLayout(null);
    this.setBounds(0, (int) (controller.suppliersComponent.getHeight() * 0.1), controller.suppliersComponent.getWidth(),
        (int) (controller.suppliersComponent.getHeight() * 0.9));
    this.setBackground(controller.suppliersComponent.getBackground());
    controller.suppliersComponent.add(this);
  }

}
