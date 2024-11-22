package com.api.routes.inventory.usecases;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import com.api.routes.inventory.model.ProductStockModel;
import com.api.routes.shared.models.inventory.InventoryModel;

public class InvetoryManagmentUseCase {

  public static List<ProductStockModel> calculateStock(List<InventoryModel> updates) {
    Map<Integer, ProductStockModel> productMap = new HashMap<>();

    for (InventoryModel update : updates) {
      int productId = update.getProductModel().getProductId();
      int transactionTypeId = update.getTransactionTypeModel().getTransactionTypeId();
      int updateAmount = update.getProductMovementModel().getUpdateAmount();

      if (!productMap.containsKey(productId)) {
        ProductStockModel productDetails = new ProductStockModel()
            .setProductId(productId)
            .setProductName(update.getProductModel().getProductName())
            .setProductCategoryId(update.getProductCategoryModel().getProductCategoryId())
            .setProductCategory(update.getProductCategoryModel().getProductCategory())
            .setSupplierId(update.getSupplierModel().getSupplierId())
            .setSupplierName(update.getSupplierModel().getName())
            .setProductPrice(update.getProductModel().getProductPrice())
            .setStock(0)
            .setActive(update.getProductMovementModel().getActive());
        productMap.put(productId, productDetails);
      }

      ProductStockModel productDetails = productMap.get(productId);
      int currentStock = productDetails.getStock();

      if (transactionTypeId == 3) {
        productDetails.setStock(updateAmount);
      } else if (transactionTypeId == 1) {
        productDetails.setStock(currentStock + updateAmount);
      } else if (transactionTypeId == 2) {
        productDetails.setStock(currentStock - updateAmount);
      }
    }

    return productMap.values().stream().collect(Collectors.toList());
  }
}