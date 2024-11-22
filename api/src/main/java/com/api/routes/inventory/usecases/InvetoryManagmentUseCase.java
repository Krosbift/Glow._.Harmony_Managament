package com.api.routes.inventory.usecases;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import com.api.routes.inventory.model.InventoryModel;
import com.api.routes.inventory.model.ProductStockModel;

public class InvetoryManagmentUseCase {

  public static List<ProductStockModel> calculateStock(List<InventoryModel> updates) {
    Map<Integer, ProductStockModel> productMap = new HashMap<>();

    for (InventoryModel update : updates) {
      int productId = update.getProductId();
      int transactionTypeId = update.getTransactionTypeId();
      int updateAmount = update.getUpdateAmount();

      if (!productMap.containsKey(productId)) {
        ProductStockModel productDetails = new ProductStockModel()
            .setProductId(productId)
            .setProductName(update.getProductName())
            .setProductCategoryId(update.getCategoryId())
            .setProductCategory(update.getCategoryName())
            .setSupplierId(update.getSupplierId())
            .setSupplierName(update.getSupplierName())
            .setProductPrice(update.getUnitPrice())
            .setStock(0)
            .setActive(update.getActive());
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