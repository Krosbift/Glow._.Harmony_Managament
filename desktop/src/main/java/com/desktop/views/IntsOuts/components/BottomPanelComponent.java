package com.desktop.views.IntsOuts.components;

import javax.swing.JPanel;
import com.desktop.core.utils.interfaces.ComponentInterface;
import com.desktop.views.IntsOuts.IntsOutsPanelController;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import com.desktop.views.IntsOuts.model.IntsOutsModel;
import com.desktop.views.IntsOuts.model.TransactionTypesModel;
import com.desktop.views.IntsOuts.model.UpdateProductUpdateDto;
import com.desktop.views.products.model.ProductModel;
import com.desktop.views.IntsOuts.model.CreateUpdateProductDto;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class BottomPanelComponent extends JPanel implements ComponentInterface {
  public IntsOutsPanelController controller;
  public List<IntsOutsModel> originalIntsOuts;
  private JDialog intsOutsDialog;

  public BottomPanelComponent(IntsOutsPanelController controller) {
    this.controller = controller;
    _configureComponent();
    _listenerSizing();
  }

  @Override
  public void _configureComponent() {
    this.setLayout(new BorderLayout());
    this.setBounds(0, (int) (controller.intsOutsComponent.getHeight() * 0.1), controller.intsOutsComponent.getWidth(),
        (int) (controller.intsOutsComponent.getHeight() * 0.9));
    this.setBackground(controller.intsOutsComponent.getBackground());
    controller.intsOutsComponent.add(this);
  }

  /**
   * Adds a component listener to the content panel component of the parent controller.
   * The listener triggers the resizeComponents method whenever the component is resized.
   * Additionally, it calls resizeComponents initially to ensure proper sizing.
   */
  private void _listenerSizing() {
    controller.parentController.contentPanelComponent.addComponentListener(new ComponentAdapter() {
      @Override
      public void componentResized(ComponentEvent e) {
        resizeComponents();
      }
    });
    resizeComponents();
  }

  /**
   * Resizes the components of the BottomPanelComponent.
   * 
   * This method sets the bounds of the BottomPanelComponent based on the dimensions
   * of the intsOutsComponent from the controller. It positions the BottomPanelComponent
   * at the bottom 90% of the intsOutsComponent, starting from 10% of its height.
   * After setting the bounds, it revalidates and repaints the component to reflect
   * the changes.
   */
  private void resizeComponents() {
    this.setBounds(0, (int) (controller.intsOutsComponent.getHeight() * 0.1), controller.intsOutsComponent.getWidth(),
        (int) (controller.intsOutsComponent.getHeight() * 0.9));
    this.revalidate();
    this.repaint();
  }

  /**
   * Creates and displays a table with the provided list of IntsOutsModel objects.
   * If the list is null or empty, a label indicating no data is displayed.
   * 
   * @param intsOuts the list of IntsOutsModel objects to be displayed in the table
   * 
   * 
   * The table rows are not editable. The table's background color is set to match
   * the background color of the intsOutsComponent. The first column (ID) is hidden.
   * 
   * If the user has a role type ID of 1, a mouse listener is added to the table
   * to handle row clicks, which will show a dialog with details of the selected
   * IntsOutsModel object. Additionally, a create button row is added.
   * 
   * The table is wrapped in a JScrollPane with custom dimensions and no border.
   * The panel is revalidated and repainted after adding the table.
   */
  public void createTable(List<IntsOutsModel> intsOuts) {
    this.removeAll();
    this.originalIntsOuts = intsOuts;

    if (intsOuts == null || intsOuts.isEmpty()) {
      JLabel noDataLabel = new JLabel("No hay existencias de entradas/salidas");
      noDataLabel.setHorizontalAlignment(JLabel.CENTER);
      this.add(noDataLabel, BorderLayout.CENTER);
      return;
    }

    String[] columnNames = { "ID", "Producto", "Razón", "Fecha", "Cantidad", "Tipo de Transacción",
        "Fecha de expiración" };
    DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0) {
      @Override
      public boolean isCellEditable(int row, int column) {
        return false;
      }
    };

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    for (IntsOutsModel intsOut : intsOuts) {
      String formattedUpdateDate = dateFormat.format(intsOut.getUpdateDate());
      String formattedExpirationDate = intsOut.getExpirationDate() != null
          ? dateFormat.format(intsOut.getExpirationDate())
          : "";

      Object[] rowData = {
          intsOut.getUpdateProductId(),
          intsOut.getProductName(),
          intsOut.getReason(),
          formattedUpdateDate,
          intsOut.getUpdateAmount(),
          intsOut.getTransactionType(),
          formattedExpirationDate
      };
      tableModel.addRow(rowData);
    }

    JTable table = new JTable(tableModel);
    table.setRowHeight(40);
    table.setBackground(controller.intsOutsComponent.getBackground());
    table.getTableHeader().setBackground(controller.intsOutsComponent.getBackground());

    table.getColumnModel().getColumn(0).setMinWidth(0);
    table.getColumnModel().getColumn(0).setMaxWidth(0);
    table.getColumnModel().getColumn(0).setWidth(0);
    table.getColumnModel().getColumn(2).setPreferredWidth(200);

    if (controller.parentController.user.getRoleTypeId() == 1) {
      table.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
          int row = table.getSelectedRow();
          if (row != -1) {
            int updateProductId = (int) table.getValueAt(row, 0);
            IntsOutsModel selectedIntsOut = originalIntsOuts.stream()
                .filter(p -> p.getUpdateProductId() == updateProductId)
                .findFirst().get();
            showIntsOutsDialog(selectedIntsOut);
          }
        }
      });
    }

    JScrollPane scrollPane = new JScrollPane(table);
    scrollPane.setPreferredSize(new Dimension(this.getWidth() - 40, this.getHeight() - 80));
    scrollPane.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
    this.add(scrollPane, BorderLayout.CENTER);

    if (controller.parentController.user.getRoleTypeId() == 1) {
      addCreateButtonRow();
    }

    this.revalidate();
    this.repaint();
  }

  /**
   * Displays a dialog for viewing and editing the details of an IntsOutsModel.
   * 
   * @param intsOut The IntsOutsModel object containing the details to be displayed and edited.
   * 
   * This method creates a JDialog with fields for editing the product name, reason, amount, 
   * transaction type, and expiration date. It also provides buttons for editing and deleting 
   * the IntsOutsModel. The dialog is disposed of when closed.
   * 
   * The dialog includes:
   * - A JComboBox for selecting the product name.
   * - A JTextField for entering the reason.
   * - A JTextField for entering the amount.
   * - A JComboBox for selecting the transaction type.
   * - A JDatePickerImpl for selecting the expiration date.
   * 
   * The edit button updates the IntsOutsModel with the new values and refreshes the table.
   * The delete button confirms the deletion and removes the IntsOutsModel from the list and table.
   * 
   * The dialog is centered relative to the parent component and is disposed of when closed.
   */
  private void showIntsOutsDialog(IntsOutsModel intsOut) {
    if (intsOutsDialog != null) {
      intsOutsDialog.dispose();
    }

    intsOutsDialog = new JDialog();
    intsOutsDialog.setTitle("Detalles de la entrada/salida");
    intsOutsDialog.setLayout(new BorderLayout());
    intsOutsDialog.setSize(400, 300);
    intsOutsDialog.setLocationRelativeTo(this);

    JPanel fieldsPanel = new JPanel(new GridLayout(5, 2, 10, 10));
    fieldsPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
    fieldsPanel.setBackground(controller.intsOutsComponent.getBackground());

    fieldsPanel.add(new JLabel("Producto:"));
    JComboBox<String> productNameComboBox = new JComboBox<>();
    for (ProductModel product : controller.productNames) {
      productNameComboBox.addItem(product.getProductName());
    }
    productNameComboBox.setSelectedItem(intsOut.getProductName());
    fieldsPanel.add(productNameComboBox);

    fieldsPanel.add(new JLabel("Razón:"));
    JTextField reasonField = new JTextField(intsOut.getReason());
    fieldsPanel.add(reasonField);

    fieldsPanel.add(new JLabel("Cantidad:"));
    JTextField amountField = new JTextField(String.valueOf(intsOut.getUpdateAmount()));
    fieldsPanel.add(amountField);

    fieldsPanel.add(new JLabel("Tipo de Transacción:"));
    JComboBox<String> transactionTypeComboBox = new JComboBox<>();
    for (TransactionTypesModel transactionType : controller.transactionTypes) {
      transactionTypeComboBox.addItem(transactionType.getTransactionType());
    }
    transactionTypeComboBox.setSelectedItem(intsOut.getTransactionType());
    fieldsPanel.add(transactionTypeComboBox);

    fieldsPanel.add(new JLabel("Fecha de Expiración:"));
    UtilDateModel model = new UtilDateModel();
    if (intsOut.getExpirationDate() == null) {
      model.setValue(new java.util.Date());
    }
    if (intsOut.getExpirationDate() != null) {
      model.setValue(intsOut.getExpirationDate());
    }
    Properties p = new Properties();
    p.put("text.today", "Today");
    p.put("text.month", "Month");
    p.put("text.year", "Year");
    JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
    JDatePickerImpl expirationDatePicker = new JDatePickerImpl(datePanel, null);
    fieldsPanel.add(expirationDatePicker);

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    expirationDatePicker.addActionListener(e -> {
      Date selectedDate = (Date) expirationDatePicker.getModel().getValue();
      if (selectedDate != null) {
        String formattedDate = dateFormat.format(selectedDate);
        expirationDatePicker.getJFormattedTextField().setText(formattedDate);
      }
    });

    intsOutsDialog.add(fieldsPanel, BorderLayout.CENTER);

    JPanel buttonsPanel = new JPanel();
    buttonsPanel.setBackground(controller.intsOutsComponent.getBackground());
    JButton editButton = new JButton("Editar");
    JButton deleteButton = new JButton("Eliminar");

    editButton.addActionListener(e -> {
      Calendar calendar = Calendar.getInstance();
      Date expirationDate = (Date) expirationDatePicker.getModel().getValue();
      if (expirationDate != null) {
        calendar.setTime(expirationDate);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
      }
      Date newExpirationDate = expirationDate != null ? calendar.getTime() : null;
      UpdateProductUpdateDto updatedIntsOut = (UpdateProductUpdateDto) new UpdateProductUpdateDto()
          .setProductId(controller.productNames.get(productNameComboBox.getSelectedIndex()).getProductId())
          .setReason(reasonField.getText())
          .setUpdateAmount(Integer.parseInt(amountField.getText()))
          .setTransactionTypeId(
              controller.transactionTypes.get(transactionTypeComboBox.getSelectedIndex()).getTransactionTypeId())
          .setExpirationDate(newExpirationDate)
          .build();

      IntsOutsModel updatedModel = controller.updateIntsOut(updatedIntsOut, intsOut.getUpdateProductId());
      if (updatedModel != null) {
        originalIntsOuts.set(originalIntsOuts.indexOf(intsOut), updatedModel);
        updateTable(null);
      }
      intsOutsDialog.dispose();
    });

    deleteButton.addActionListener(e -> {
      int result = JOptionPane.showConfirmDialog(this, "¿Estás seguro de eliminar esta entrada/salida?",
          "Eliminar Entrada/Salida",
          JOptionPane.YES_NO_OPTION);
      if (result == JOptionPane.YES_OPTION) {
        Integer deletedIntsOutId = controller.deleteIntsOut(intsOut.getUpdateProductId());
        if (deletedIntsOutId != null) {
          originalIntsOuts.remove(intsOut);
          updateTable(null);
        }
      }
      intsOutsDialog.dispose();
    });

    buttonsPanel.add(editButton);
    buttonsPanel.add(deleteButton);
    intsOutsDialog.add(buttonsPanel, BorderLayout.SOUTH);

    intsOutsDialog.addWindowListener(new java.awt.event.WindowAdapter() {
      @Override
      public void windowClosing(java.awt.event.WindowEvent windowEvent) {
        intsOutsDialog = null;
      }
    });

    intsOutsDialog.setVisible(true);
  }

  /**
   * Displays a dialog for creating a new "entrada/salida" (input/output) record.
   * The dialog contains fields for selecting a product, specifying a reason, 
   * entering an amount, choosing a transaction type, and picking an expiration date.
   * 
   * The dialog includes "Guardar" (Save) and "Cancelar" (Cancel) buttons.
   * When the "Guardar" button is clicked, the input fields are validated, 
   * and if valid, a new record is created and added to the table.
   * 
   * Fields:
   * - Producto: A JComboBox for selecting a product from the list of products.
   * - Razón: A JTextField for entering the reason for the transaction.
   * - Cantidad: A JTextField for entering the amount of the transaction.
   * - Tipo de Transacción: A JComboBox for selecting the type of transaction.
   * - Fecha de Expiración: A JDatePickerImpl for selecting the expiration date.
   * 
   * Buttons:
   * - Guardar: Validates the input fields and creates a new record if valid.
   * - Cancelar: Closes the dialog without saving.
   */
  private void showCreateIntsOutsDialog() {
    JDialog createDialog = new JDialog();
    createDialog.setTitle("Crear nueva entrada/salida");
    createDialog.setLayout(new BorderLayout());
    createDialog.setSize(400, 300);
    createDialog.setLocationRelativeTo(this);

    JPanel fieldsPanel = new JPanel(new GridLayout(5, 2, 10, 10));
    fieldsPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
    fieldsPanel.setBackground(controller.intsOutsComponent.getBackground());

    fieldsPanel.add(new JLabel("Producto:"));
    JComboBox<String> productNameComboBox = new JComboBox<>();
    for (ProductModel product : controller.productNames) {
      productNameComboBox.addItem(product.getProductName());
    }
    fieldsPanel.add(productNameComboBox);

    fieldsPanel.add(new JLabel("Razón:"));
    JTextField reasonField = new JTextField();
    fieldsPanel.add(reasonField);

    fieldsPanel.add(new JLabel("Cantidad:"));
    JTextField amountField = new JTextField();
    fieldsPanel.add(amountField);

    fieldsPanel.add(new JLabel("Tipo de Transacción:"));
    JComboBox<String> transactionTypeComboBox = new JComboBox<>();
    for (TransactionTypesModel transactionType : controller.transactionTypes) {
      transactionTypeComboBox.addItem(transactionType.getTransactionType());
    }
    fieldsPanel.add(transactionTypeComboBox);

    fieldsPanel.add(new JLabel("Fecha de Expiración:"));
    UtilDateModel model = new UtilDateModel();
    Properties p = new Properties();
    p.put("text.today", "Today");
    p.put("text.month", "Month");
    p.put("text.year", "Year");
    JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
    JDatePickerImpl expirationDatePicker = new JDatePickerImpl(datePanel, null);
    fieldsPanel.add(expirationDatePicker);

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    expirationDatePicker.addActionListener(e -> {
      Date selectedDate = (Date) expirationDatePicker.getModel().getValue();
      if (selectedDate != null) {
        String formattedDate = dateFormat.format(selectedDate);
        expirationDatePicker.getJFormattedTextField().setText(formattedDate);
      }
    });

    createDialog.add(fieldsPanel, BorderLayout.CENTER);

    JPanel buttonsPanel = new JPanel();
    buttonsPanel.setBackground(controller.intsOutsComponent.getBackground());
    JButton saveButton = new JButton("Guardar");
    JButton cancelButton = new JButton("Cancelar");

    saveButton.addActionListener(e -> {
      if (validateCreateIntsOutsFields(reasonField, amountField)) {
        Calendar calendar = Calendar.getInstance();
        Date expirationDate = (Date) expirationDatePicker.getModel().getValue();
        if (expirationDate != null) {
          calendar.setTime(expirationDate);
          calendar.add(Calendar.DAY_OF_MONTH, 1);
        }
        Date newExpirationDate = expirationDate != null ? calendar.getTime() : null;
        CreateUpdateProductDto newIntsOut = new CreateUpdateProductDto()
            .setProductId(controller.productNames.get(productNameComboBox.getSelectedIndex()).getProductId())
            .setReason(reasonField.getText())
            .setUpdateAmount(Integer.parseInt(amountField.getText()))
            .setTransactionTypeId(
                controller.transactionTypes.get(transactionTypeComboBox.getSelectedIndex()).getTransactionTypeId())
            .setExpirationDate(newExpirationDate)
            .build();

        IntsOutsModel createdIntsOut = controller.createIntsOut(newIntsOut);
        if (createdIntsOut != null) {
          updateTable(createdIntsOut);
        }
        createDialog.dispose();
      }
    });

    cancelButton.addActionListener(e -> createDialog.dispose());

    buttonsPanel.add(saveButton);
    buttonsPanel.add(cancelButton);
    createDialog.add(buttonsPanel, BorderLayout.SOUTH);

    createDialog.setVisible(true);
  }

  /**
   * Adds a row containing a "Create" button to the panel.
   * The button is labeled "Añadir nueva entrada/salida" and, when clicked,
   * it triggers the showCreateIntsOutsDialog() method.
   */
  public void addCreateButtonRow() {
    JButton createButton = new JButton("Añadir nueva entrada/salida");
    createButton.addActionListener(e -> showCreateIntsOutsDialog());

    JPanel buttonPanel = new JPanel(new BorderLayout());
    buttonPanel.add(createButton, BorderLayout.CENTER);
    this.add(buttonPanel, BorderLayout.NORTH);
  }

  /**
   * Validates the input fields for creating IntsOuts.
   *
   * @param reasonField the JTextField containing the reason for the IntsOuts
   * @param amountField the JTextField containing the amount for the IntsOuts
   * @return true if both fields are valid, false otherwise
   * 
   * The method performs the following validations:
   * - Checks if the reason field is not empty. If it is empty, shows an error message dialog.
   * - Checks if the amount field is not empty. If it is empty, shows an error message dialog.
   * - Checks if the amount field contains a valid integer. If it does not, shows an error message dialog.
   */
  private boolean validateCreateIntsOutsFields(JTextField reasonField, JTextField amountField) {
    if (reasonField.getText().trim().isEmpty()) {
      JOptionPane.showMessageDialog(this, "La razón no debe estar vacía", "Error",
          JOptionPane.ERROR_MESSAGE);
      return false;
    }
    if (amountField.getText().trim().isEmpty()) {
      JOptionPane.showMessageDialog(this, "La cantidad debe ser especificada", "Error", JOptionPane.ERROR_MESSAGE);
      return false;
    }
    try {
      Integer.parseInt(amountField.getText().trim());
    } catch (NumberFormatException e) {
      JOptionPane.showMessageDialog(this, "La cantidad debe ser un número entero", "Error",
          JOptionPane.ERROR_MESSAGE);
      return false;
    }
    return true;
  }

  /**
   * Updates the table with a new IntsOutsModel entry.
   * If the provided IntsOutsModel is not null, it adds it to the original list
   * and then recreates the table with the updated list.
   *
   * @param newIntsOut the new IntsOutsModel to be added to the table. If null, the table is not updated.
   */
  public void updateTable(IntsOutsModel newIntsOut) {
    if (newIntsOut != null) {
      originalIntsOuts.add(newIntsOut);
    }
    createTable(originalIntsOuts);
  }
}
