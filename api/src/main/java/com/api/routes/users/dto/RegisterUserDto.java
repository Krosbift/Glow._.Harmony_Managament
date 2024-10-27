package com.api.routes.users.dto;

public class RegisterUserDto {
  private String names;
  private String surNames;
  private int documentTypeId;
  private String documentNumber;
  private String email;
  private String password;
  private String phone;
  private int roleTypeId;
  private String address;

  public String getNames() {
    return names;
  }

  public void setNames(String names) {
    this.names = names;
  }

  public String getSurNames() {
    return surNames;
  }

  public void setSurNames(String surNames) {
    this.surNames = surNames;
  }

  public int getDocumentTypeId() {
    return documentTypeId;
  }

  public void setDocumentTypeId(int documentTypeId) {
    this.documentTypeId = documentTypeId;
  }

  public String getDocumentNumber() {
    return documentNumber;
  }

  public void setDocumentNumber(String documentNumber) {
    this.documentNumber = documentNumber;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public int getRoleTypeId() {
    return roleTypeId;
  }

  public void setRoleTypeId(int roleTypeId) {
    this.roleTypeId = roleTypeId;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }
}
