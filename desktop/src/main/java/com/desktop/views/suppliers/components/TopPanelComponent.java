package com.desktop.views.suppliers.components;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import com.desktop.core.utils.interfaces.ComponentInterface;
import com.desktop.views.suppliers.SuppliersPanelController;

public class TopPanelComponent extends JPanel implements ComponentInterface {
  public String title;
  public SuppliersPanelController controller;

  public TopPanelComponent(SuppliersPanelController controller, String title) {
    this.controller = controller;
    this.title = title;
    _configureComponent();
    addChildComponents();
    _listernerSizing();
  }

  @Override
  public void _configureComponent() {
    this.setLayout(new GridBagLayout());
    this.setBackground(controller.suppliersComponent.getBackground());
    controller.suppliersComponent.add(this);
  }

  private void addChildComponents() {
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(5, 5, 5, 5);
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.anchor = GridBagConstraints.WEST;
    gbc.weightx = 1.0;
    gbc.fill = GridBagConstraints.HORIZONTAL;

    JLabel titleLabel = new JLabel(title.toUpperCase());
    titleLabel.setFont(new Font(titleLabel.getFont().getName(), Font.PLAIN, 20));
    this.add(titleLabel, gbc);

    gbc.gridx = 1;
    gbc.anchor = GridBagConstraints.EAST;
    gbc.weightx = 0;
    JPanel buttonPanel = new JPanel();
    buttonPanel.setBackground(controller.suppliersComponent.getBackground());
    JButton button2 = new JButton("Vista de datos");

    if (controller.parentController.user.getRoleTypeId() == 1) {
      JButton button1 = new JButton("Vista Completa");
      buttonPanel.add(button1);
    }

    buttonPanel.add(button2);
    this.add(buttonPanel, gbc);
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
    this.setBounds(0, 0, controller.suppliersComponent.getWidth(),
        (int) (controller.suppliersComponent.getHeight() * 0.1));
    this.revalidate();
    this.repaint();
  }
}
