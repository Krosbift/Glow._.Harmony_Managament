package com.desktop.views.products.services;

import java.util.List;
import com.desktop.core.database.service.HttpClientService;
import com.desktop.views.products.model.CreateProductDto;
import com.desktop.views.products.model.GetProductDto;
import com.desktop.views.products.model.ProductCategoriesModel;
import com.desktop.views.products.model.ProductModel;
import com.desktop.views.products.model.SupplierModel;
import com.desktop.views.products.model.UpdateProductDto;

public class ProductService {
  private final HttpClientService httpClientService = new HttpClientService();

  public List<ProductModel> getProducts(GetProductDto getDto) {
    httpClientService.endpoint = "/products";
    StringBuilder url = new StringBuilder("/find-product");
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
      return (List<ProductModel>) httpClientService.getList(url.toString(), ProductModel.class);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public List<ProductModel> getAllProducts() {
    httpClientService.endpoint = "/products";
    StringBuilder url = new StringBuilder("/find-all-products");
    try {
      return (List<ProductModel>) httpClientService.getList(url.toString(), ProductModel.class);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public ProductModel createProduct(CreateProductDto createProductDto) {
    httpClientService.endpoint = "/products";
    try {
      return httpClientService.post("/create-product", createProductDto, ProductModel.class);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public ProductModel updateProduct(UpdateProductDto updateProductDto, Integer productId) {
    httpClientService.endpoint = "/products";
    try {
      return httpClientService.patch("/update-product/" + productId, updateProductDto, ProductModel.class);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public Integer activateProduct(Integer productId) {
    httpClientService.endpoint = "/products";
    try {
      return httpClientService.patch("/activate-product/" + productId, productId, Integer.class);
    } catch (Exception e) {
      e.printStackTrace();
      return 0;
    }
  }

  public Integer deleteProduct(Integer productId) {
    httpClientService.endpoint = "/products";
    try {
      return httpClientService.delete("/deactivate-product/" + productId, Integer.class);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public List<ProductCategoriesModel> getAllProductCategories() {
    httpClientService.endpoint = "/index";
    StringBuilder url = new StringBuilder("/find-productCategories");
    try {
      return (List<ProductCategoriesModel>) httpClientService.getList(url.toString(), ProductCategoriesModel.class);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public List<SupplierModel> getAllSuppliers() {
    httpClientService.endpoint = "/suppliers";
    StringBuilder url = new StringBuilder("/find-supplier");
    try {
      return (List<SupplierModel>) httpClientService.getList(url.toString(), SupplierModel.class);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }
}
