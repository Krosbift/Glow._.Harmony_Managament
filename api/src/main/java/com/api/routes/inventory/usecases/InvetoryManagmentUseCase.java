package com.api.routes.inventory.usecases;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import com.api.routes.inventory.model.InventoryModel;
import com.api.routes.inventory.model.ProductStockModel;

public class InvetoryManagmentUseCase {

  /**
   * Calculates the stock levels for a list of inventory updates.
   *
   * @param updates A list of {@link InventoryModel} objects representing
   *                inventory updates.
   *                Each update contains information about the product,
   *                transaction type, and update amount.
   * @return A list of {@link ProductStockModel} objects representing the updated
   *         stock levels for each product.
   *         Each product's stock level is adjusted based on the transaction type:
   *         - Transaction type 1: Adds the update amount to the current stock.
   *         - Transaction type 2: Subtracts the update amount from the current
   *         stock.
   *         - Transaction type 3: Sets the stock to the update amount.
   */
  public List<ProductStockModel> calculateStock(List<InventoryModel> updates) {
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

  /**
   * Determines if a product can be sold based on the current stock and the amount
   * to sell.
   *
   * @param product      The product stock model containing the current stock
   *                     information.
   * @param amountToSell The amount of the product to be sold.
   * @return true if the current stock is greater than or equal to the amount to
   *         sell, false otherwise.
   */
  public boolean canSellProduct(ProductStockModel product, int amountToSell) {
    int currentStock = product.getStock();
    return currentStock <= amountToSell;
  }

}