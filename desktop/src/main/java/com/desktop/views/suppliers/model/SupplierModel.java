package com.desktop.views.suppliers.model;

public class SupplierModel {
  private int supplierId;
  private String name;
  private String address;
  private String phone;
  private boolean active;

  public int getSupplierId() {
    return supplierId;
  }

  public SupplierModel setSupplierId(int supplierId) {
    this.supplierId = supplierId;
    return this;
  }

  public String getName() {
    return name;
  }

  public SupplierModel setName(String name) {
    this.name = name;
    return this;
  }

  public String getAddress() {
    return address;
  }

  public SupplierModel setAddress(String address) {
    this.address = address;
    return this;
  }

  public String getPhone() {
    return phone;
  }

  public SupplierModel setPhone(String phone) {
    this.phone = phone;
    return this;
  }

  public boolean getActive() {
    return active;
  }

  public SupplierModel setActive(boolean active) {
    this.active = active;
    return this;
  }

  /**
   * Builds and returns the current instance of SupplierModel.
   *
   * @return the current instance of SupplierModel
   */
  public SupplierModel build() {
    return this;
  }
}