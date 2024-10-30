package com.desktop.views.IntsOuts.services;

import com.desktop.core.database.service.HttpClientService;
import com.desktop.views.IntsOuts.model.CreateUpdateProductDto;
import com.desktop.views.IntsOuts.model.GetUpdateProductDto;
import com.desktop.views.IntsOuts.model.IntsOutsModel;
import com.desktop.views.IntsOuts.model.UpdateProductUpdateDto;

public class IntsOutsService {
  private final HttpClientService httpClientService = new HttpClientService();

  public IntsOutsModel getIntsOuts(GetUpdateProductDto getDto) {
    httpClientService.endpoint = "/inventory";
    StringBuilder url = new StringBuilder("find-update-product");
    boolean firstParam = true;

    if (getDto.getProductId() != null) {
      url.append("?productId=").append(getDto.getProductId());
    }

    if (getDto.getProductName() != null) {
      url.append(firstParam ? "?" : "&").append("?productName=").append(getDto.getProductName());
    }

    if (getDto.getTransactionTypeId() != null) {
      url.append(firstParam ? "?" : "&").append("?transactionTypeId=").append(getDto.getTransactionTypeId());
    }

    if (getDto.getTransactionType() != null) {
      url.append(firstParam ? "?" : "&").append("?transactionType=").append(getDto.getTransactionType());
    }

    try {
      return httpClientService.get(url.toString(), IntsOutsModel.class);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public IntsOutsModel findAllInstOuts() {
    httpClientService.endpoint = "/inventory";
    try {
      return httpClientService.get("find-all-update-products", IntsOutsModel.class);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public IntsOutsModel createIntsOuts(CreateUpdateProductDto intsOutsModel) {
    httpClientService.endpoint = "/inventory";
    try {
      return httpClientService.post("create-update-product", intsOutsModel, IntsOutsModel.class);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public IntsOutsModel updateIntsOuts(UpdateProductUpdateDto intsOutsModel, int updateProductId) {
    httpClientService.endpoint = "/inventory";
    try {
      return httpClientService.patch("update-update-product/" + updateProductId, intsOutsModel,
          IntsOutsModel.class);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public Integer activateIntsOuts(int updateProductId) {
    httpClientService.endpoint = "/inventory";
    try {
      return httpClientService.patch("activate-update-product/" + updateProductId, null, Integer.class);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public Integer deleteIntsOuts(int updateProductId) {
    httpClientService.endpoint = "/inventory";
    try {
      return httpClientService.delete("delete-update-product/" + updateProductId, Integer.class);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }
}
