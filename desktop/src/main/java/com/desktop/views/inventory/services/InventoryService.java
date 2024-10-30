package com.desktop.views.inventory.services;

import com.desktop.core.database.service.HttpClientService;
import com.desktop.views.inventory.model.GetInventoryDto;
import com.desktop.views.inventory.model.ProductStockModel;

public class InventoryService {
  private final HttpClientService httpClientService = new HttpClientService();

  public ProductStockModel getInventory(GetInventoryDto getDto) {
    httpClientService.endpoint = "/inventory";
    StringBuilder url = new StringBuilder("find-inventory");
    boolean firstParam = true;

    if (getDto.getProductName() != null) {
      url.append("?productName=").append(getDto.getProductName());
      firstParam = false;
    }

    if (getDto.getCategoryId() != null) {
      url.append(firstParam ? "?" : "&").append("categoryId=").append(getDto.getCategoryId());
      firstParam = false;
    }

    if (getDto.getCategoryName() != null) {
      url.append(firstParam ? "?" : "&").append("categoryName=").append(getDto.getCategoryName());
      firstParam = false;
    }

    if (getDto.getSupplierId() != null) {
      url.append(firstParam ? "?" : "&").append("supplierId=").append(getDto.getSupplierId());
      firstParam = false;
    }

    if (getDto.getSupplierName() != null) {
      url.append(firstParam ? "?" : "&").append("supplierName=").append(getDto.getSupplierName());
    }

    if (getDto.getTransactionTypeId() != null) {
      url.append(firstParam ? "?" : "&").append("transactionTypeId=").append(getDto.getTransactionTypeId());
      firstParam = false;
    }

    if (getDto.getTransactionType() != null) {
      url.append(firstParam ? "?" : "&").append("transactionType=").append(getDto.getTransactionType());
    }

    try {
      return httpClientService.get(url.toString(), ProductStockModel.class);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public ProductStockModel getAllInventory() {
    httpClientService.endpoint = "/inventory";
    StringBuilder url = new StringBuilder("find-all-inventory");
    try {
      return httpClientService.get(url.toString(), ProductStockModel.class);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }
}
