package com.desktop.views.inventory.components;

import javax.swing.JPanel;
import com.desktop.core.utils.interfaces.ComponentInterface;
import com.desktop.views.inventory.InventoryPanelController;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.desktop.views.inventory.model.ProductStockModel;

public class BottomPanelComponent extends JPanel implements ComponentInterface {
  public InventoryPanelController controller;

  public BottomPanelComponent(InventoryPanelController inventoryPanelController) {
    this.controller = inventoryPanelController;
    _configureComponent();
    _listernerSizing();
  }

  @Override
  public void _configureComponent() {
    this.setLayout(new BorderLayout());
    this.setBounds(0, (int) (controller.inventoryComponent.getHeight() * 0.1), controller.inventoryComponent.getWidth(),
        (int) (controller.inventoryComponent.getHeight() * 0.9));
    this.setBackground(controller.inventoryComponent.getBackground());
    controller.inventoryComponent.add(this);
  }

  private void _listernerSizing() {
    controller.parentController.contentPanelComponent.addComponentListener(new ComponentAdapter() {
      @Override
      public void componentResized(ComponentEvent e) {
        resizeComponents();
      }
    });
    resizeComponents();
  }

  private void resizeComponents() {
    this.setBounds(0, (int) (controller.inventoryComponent.getHeight() * 0.1), controller.inventoryComponent.getWidth(),
        (int) (controller.inventoryComponent.getHeight() * 0.9));
    this.revalidate();
    this.repaint();
  }

  public void createTable(List<ProductStockModel> products) {
    this.removeAll();

    if (products == null || products.isEmpty()) {
      JLabel noDataLabel = new JLabel("No hay existencias de productos");
      noDataLabel.setHorizontalAlignment(JLabel.CENTER);
      this.add(noDataLabel, BorderLayout.CENTER);
      return;
    }

    String[] columnNames = { "ID", "Nombre Producto", "Categoria", "Precio Unitario", "Proveedor", "Stock" };
    DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0) {
      @Override
      public boolean isCellEditable(int row, int column) {
        return false;
      }
    };

    for (ProductStockModel product : products) {
      Object[] rowData = {
          product.getProductId(),
          product.getProductName(),
          product.getProductCategory(),
          product.getProductPrice(),
          product.getSupplierName(),
          product.getStock()
      };
      tableModel.addRow(rowData);
    }

    JTable table = new JTable(tableModel);
    table.setRowHeight(40);
    table.setBackground(controller.inventoryComponent.getBackground());
    table.getTableHeader().setBackground(controller.inventoryComponent.getBackground());

    table.getColumnModel().getColumn(0).setMinWidth(0);
    table.getColumnModel().getColumn(0).setMaxWidth(0);
    table.getColumnModel().getColumn(0).setWidth(0);

    JScrollPane scrollPane = new JScrollPane(table);
    scrollPane.setPreferredSize(new Dimension(this.getWidth() - 40, this.getHeight() - 80));
    scrollPane.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
    this.add(scrollPane, BorderLayout.CENTER);

    this.revalidate();
    this.repaint();
  }
}
