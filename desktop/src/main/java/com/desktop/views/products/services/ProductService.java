package com.desktop.views.products.services;

import com.desktop.core.database.service.HttpClientService;
import com.desktop.views.products.model.GetProductDto;
import com.desktop.views.products.model.ProductModel;

public class ProductService {
  private final HttpClientService httpClientService = new HttpClientService();

  public ProductModel getProducts(GetProductDto getDto) {
    httpClientService.endpoint = "/products";
    StringBuilder url = new StringBuilder("find-product");
    boolean firstParam = true;

    if (getDto.getProductName() != null) {
      url.append("?productName=").append(getDto.getProductName());
      firstParam = false;
    }

    if (getDto.getProductCategoryId() != null) {
      url.append(firstParam ? "?" : "&").append("productCategoryId=").append(getDto.getProductCategoryId());
      firstParam = false;
    }

    if (getDto.getProductCategory() != null) {
      url.append(firstParam ? "?" : "&").append("productCategory=").append(getDto.getProductCategory());
      firstParam = false;
    }

    if (getDto.getSupplierId() != null) {
      url.append(firstParam ? "?" : "&").append("supplierId=").append(getDto.getSupplierId());
      firstParam = false;
    }

    if (getDto.getSupplierName() != null) {
      url.append(firstParam ? "?" : "&").append("supplierName=").append(getDto.getSupplierName());
    }

    try {
      return httpClientService.get(url.toString(), ProductModel.class);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public ProductModel getAllProducts() {
    httpClientService.endpoint = "/products";
    StringBuilder url = new StringBuilder("find-all-products");
    try {
      return httpClientService.get(url.toString(), ProductModel.class);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public ProductModel createProduct(ProductModel productModel) {
    httpClientService.endpoint = "/products";
    try {
      return httpClientService.post("create-product", productModel, ProductModel.class);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public ProductModel updateProduct(ProductModel productModel, int productId) {
    httpClientService.endpoint = "/products";
    try {
      return httpClientService.patch("update-product/" + productId, productModel, ProductModel.class);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public Integer activateProduct(int productId) {
    httpClientService.endpoint = "/products";
    try {
      return httpClientService.patch("activate-product/" + productId, productId, Integer.class);
    } catch (Exception e) {
      e.printStackTrace();
      return 0;
    }
  }

  public Integer deleteProduct(int productId) {
    httpClientService.endpoint = "/products";
    try {
      return httpClientService.delete("delete-product/" + productId, Integer.class);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }
}
