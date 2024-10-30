package com.desktop.core.navigation.models;

public class UserModel {
  private int userId;
  private String names;
  private String surNames;
  private int documentTypeId;
  private String documentType;
  private String documentNumber;
  private String email;
  private String phone;
  private int roleTypeId;
  private String roleType;
  private String address;

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

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

  public String getDocumentType() {
    return documentType;
  }

  public void setDocumentType(String documentType) {
    this.documentType = documentType;
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

  public String getRoleType() {
    return roleType;
  }

  public void setRoleType(String roleType) {
    this.roleType = roleType;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }
}
