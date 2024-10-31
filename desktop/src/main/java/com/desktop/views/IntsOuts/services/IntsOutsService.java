package com.desktop.views.IntsOuts.services;

import java.util.List;

import com.desktop.core.database.service.HttpClientService;
import com.desktop.views.IntsOuts.model.CreateUpdateProductDto;
import com.desktop.views.IntsOuts.model.GetUpdateProductDto;
import com.desktop.views.IntsOuts.model.IntsOutsModel;
import com.desktop.views.IntsOuts.model.TransactionTypesModel;
import com.desktop.views.IntsOuts.model.UpdateProductUpdateDto;
import com.desktop.views.products.model.ProductModel;

public class IntsOutsService {
  private final HttpClientService httpClientService = new HttpClientService();

  public List<IntsOutsModel> getIntsOuts(GetUpdateProductDto getDto) {
    httpClientService.endpoint = "/inventory";
    StringBuilder url = new StringBuilder("/find-update-product");
    boolean firstParam = true;

    if (getDto.getProductId() != null) {
      url.append("?productId=").append(getDto.getProductId());
      firstParam = false;
    }

    if (getDto.getTransactionTypeId() != null) {
      url.append(firstParam ? "?" : "&").append("transactionTypeId=").append(getDto.getTransactionTypeId());
    }

    System.out.println(url.toString());
    try {
      return httpClientService.getList(url.toString(), IntsOutsModel.class);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public List<IntsOutsModel> findAllInstOuts() {
    httpClientService.endpoint = "/inventory";
    try {
      return httpClientService.getList("/find-all-update-products", IntsOutsModel.class);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public IntsOutsModel createIntsOuts(CreateUpdateProductDto intsOutsModel) {
    httpClientService.endpoint = "/inventory";
    try {
      return httpClientService.post("/create-update-product", intsOutsModel, IntsOutsModel.class);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public IntsOutsModel updateIntsOuts(UpdateProductUpdateDto intsOutsModel, int updateProductId) {
    httpClientService.endpoint = "/inventory";
    try {
      return httpClientService.patch("/update-update-product/" + updateProductId, intsOutsModel,
          IntsOutsModel.class);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public Integer activateIntsOuts(int updateProductId) {
    httpClientService.endpoint = "/inventory";
    try {
      return httpClientService.patch("/activate-update-product/" + updateProductId, null, Integer.class);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public Integer deleteIntsOuts(int updateProductId) {
    httpClientService.endpoint = "/inventory";
    try {
      return httpClientService.delete("/delete-update-product/" + updateProductId, Integer.class);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public List<ProductModel> getProducts() {
    httpClientService.endpoint = "/products";
    StringBuilder url = new StringBuilder("/find-product");
    try {
      return (List<ProductModel>) httpClientService.getList(url.toString(), ProductModel.class);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public List<TransactionTypesModel> getTransactionTypes() {
    httpClientService.endpoint = "/index";
    try {
      return httpClientService.getList("/find-transactionTypes", TransactionTypesModel.class);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }
}
