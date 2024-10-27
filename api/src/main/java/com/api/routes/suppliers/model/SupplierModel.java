package com.api.routes.suppliers.model;

import java.sql.ResultSet;
import java.sql.SQLException;

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

  public SupplierModel setSupplierId(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.supplierId = rs.getInt("SUPPLIERID");
    return this;
  }

  public String getName() {
    return name;
  }

  public SupplierModel setName(String name) {
    this.name = name;
    return this;
  }

  public SupplierModel setName(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.name = rs.getString("NAME");
    return this;
  }

  public String getAddress() {
    return address;
  }

  public SupplierModel setAddress(String address) {
    this.address = address;
    return this;
  }

  public SupplierModel setAddress(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.address = rs.getString("ADDRESS");
    return this;
  }

  public String getPhone() {
    return phone;
  }

  public SupplierModel setPhone(String phone) {
    this.phone = phone;
    return this;
  }

  public SupplierModel setPhone(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.phone = rs.getString("PHONENUMBER");
    return this;
  }

  public boolean getActive() {
    return active;
  }

  public SupplierModel setActive(boolean active) {
    this.active = active;
    return this;
  }

  public SupplierModel setActive(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.active = rs.getBoolean("ACTIVE");
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
