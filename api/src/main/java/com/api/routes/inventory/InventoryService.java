package com.api.routes.inventory;

import java.util.List;
import java.util.Objects;
import java.sql.PreparedStatement;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;
import com.api.routes.inventory.builder.InventoryBuilder;
import com.api.routes.inventory.dto.CreateUpdateProductDto;
import com.api.routes.inventory.dto.GetInventoryDto;
import com.api.routes.inventory.dto.GetUpdateProductDto;
import com.api.routes.inventory.dto.UpdateProductUpdateDto;
import com.api.routes.inventory.model.InventoryModel;
import com.api.routes.inventory.model.ProductStockModel;
import com.api.routes.inventory.model.UpdateProductModel;
import com.api.routes.inventory.sql.InventorySql;
import com.api.routes.inventory.usecases.InvetoryManagmentUseCase;
import com.api.routes.utils.interfaces.Binds;

@Service
public class InventoryService extends InventoryBuilder {
  private InvetoryManagmentUseCase invetoryManagmentUseCase = new InvetoryManagmentUseCase();

  /**
   * Finds and retrieves a list of products based on the provided update product
   * details.
   *
   * @param getUpdateProductDto the DTO containing the details for the product
   *                            update search.
   * @return a list of {@link UpdateProductModel} objects that match the search
   *         criteria.
   * @throws RuntimeException if an unexpected error occurs during the query
   *                          execution.
   */
  public List<UpdateProductModel> findUpdateProduct(GetUpdateProductDto getUpdateProductDto) {
    UpdateProductModel product = new UpdateProductModel()
        .setProductId(getUpdateProductDto.getProductId())
        .setTransactionTypeId(getUpdateProductDto.getTransactionTypeId())
        .build();

    Binds binds = buildFindUpdateProduct(product);
    try {
      List<UpdateProductModel> updatesProducts = jdbcTemplate.query(binds.getSql(), updateProductRowMapper,
          binds.getParams());
      return updatesProducts;
    } catch (Exception error) {
      throw new RuntimeException("An unexpected error occurred: " + error.getMessage());
    }
  }

  /**
   * Retrieves a list of all products.
   *
   * @return a list of {@link UpdateProductModel} representing all products.
   * @throws RuntimeException if an unexpected error occurs during the retrieval
   *                          process.
   */
  public List<UpdateProductModel> findAllUpdateProducts() {
    try {
      List<UpdateProductModel> products = jdbcTemplate.query(InventorySql.FIND_ALL_UPDATEPRODUCT.getQuery(),
          updateProductRowMapper);
      return products;
    } catch (Exception error) {
      throw new RuntimeException("An unexpected error occurred: " + error.getMessage());
    }
  }

  /**
   * Creates a new update product entry in the inventory.
   *
   * @param getUpdateProductDto the DTO containing the details for the update
   *                            product.
   * @return the created UpdateProductModel with the generated ID.
   * @throws RuntimeException if an unexpected error occurs during the creation
   *                          process.
   */
  public UpdateProductModel createUpdateProduct(CreateUpdateProductDto getUpdateProductDto) {
    CreateUpdateProductDto product = new CreateUpdateProductDto()
        .setReason(getUpdateProductDto.getReason())
        .setProductId(getUpdateProductDto.getProductId())
        .setTransactionTypeId(getUpdateProductDto.getTransactionTypeId())
        .setUpdateAmount(getUpdateProductDto.getUpdateAmount())
        .setExpirationDate(getUpdateProductDto.getExpirationDate())
        .build();
    try {
      if (getUpdateProductDto.getTransactionTypeId() == 2) {
        GetInventoryDto getInventoryDto = new GetInventoryDto()
            .setProductId(getUpdateProductDto.getProductId())
            .build();

        List<ProductStockModel> result = findInventory(getInventoryDto);

        if (invetoryManagmentUseCase.canSellProduct(result.get(0), getUpdateProductDto.getUpdateAmount())) {
          throw new RuntimeException("The product stock is insufficient for the sale.");
        }
      }

      Binds binds = buildCreateUpdateProduct(product);
      KeyHolder keyHolder = new GeneratedKeyHolder();
      jdbcTemplate.update(connection -> {
        PreparedStatement statement = connection.prepareStatement(binds.getSql(), new String[] { "id" });
        for (int i = 0; i < binds.getParams().length; i++) {
          statement.setObject(i + 1, binds.getParams()[i]);
        }
        return statement;
      }, keyHolder);

      int generatedId = keyHolder.getKey().intValue();
      return findUpdateProductById(generatedId);
    } catch (Exception error) {
      throw new RuntimeException("An unexpected error occurred: " + error.getMessage());
    }
  }

  /**
   * Updates a product in the inventory.
   *
   * @param getUpdateProductDto the DTO containing the updated product information
   * @param updateProductId     the ID of the product to be updated
   * @return the updated product model
   * @throws RuntimeException if an unexpected error occurs during the update
   *                          process
   */
  public UpdateProductModel updateUpdateProduct(UpdateProductUpdateDto getUpdateProductDto, int updateProductId) {
    UpdateProductModel updateProduct = new UpdateProductModel()
        .setReason(getUpdateProductDto.getReason())
        .setProductId(getUpdateProductDto.getProductId())
        .setTransactionTypeId(getUpdateProductDto.getTransactionTypeId())
        .setUpdateAmount(getUpdateProductDto.getUpdateAmount())
        .setExpirationDate(getUpdateProductDto.getExpirationDate())
        .build();

    try {
      if (Objects.equals(getUpdateProductDto.getTransactionTypeId(), 2)) {
        UpdateProductModel updateProductModel = findUpdateProductById(updateProductId);

        if (updateProductModel.getTransactionTypeId() == 1) {
          GetInventoryDto getInventoryDto = new GetInventoryDto()
              .setProductId(updateProductModel.getProductId())
              .build();

          List<ProductStockModel> result = findInventory(getInventoryDto);
          int stock = result.get(0).getStock();
          int updateAmount = getUpdateProductDto.getUpdateAmount() != null
              ? getUpdateProductDto.getUpdateAmount()
              : updateProductModel.getUpdateAmount();

          if (stock - updateAmount * 2 < 0) {
            throw new RuntimeException("The product stock is insufficient for the sale.");
          }
        }
      }

      Binds binds = buildUpdateUpdateProducts(updateProduct, updateProductId);
      jdbcTemplate.update(binds.getSql(), binds.getParams());
      return findUpdateProductById(updateProductId);
    } catch (Exception error) {
      throw new RuntimeException("An unexpected error occurred: " + error.getMessage());
    }
  }

  /**
   * Updates the status of a product to active in the inventory.
   *
   * @param updateProductId the ID of the product to be updated.
   * @return the number of rows affected by the update.
   * @throws RuntimeException if an unexpected error occurs during the update.
   */
  public int activeUpdateProduct(int updateProductId) {
    try {
      return jdbcTemplate.update(InventorySql.ACTIVE_UPDATEPRODUCT.getQuery(), updateProductId);
    } catch (Exception error) {
      throw new RuntimeException("An unexpected error occurred: " + error.getMessage());
    }
  }

  /**
   * Deletes an update product from the inventory.
   *
   * @param updateProductId the ID of the update product to be deleted
   * @return the number of rows affected by the delete operation
   * @throws RuntimeException if an unexpected error occurs during the delete
   *                          operation
   */
  public int deleteUpdateProduct(int updateProductId) {
    try {
      return jdbcTemplate.update(InventorySql.DELETE_UPDATEPRODUCT.getQuery(), updateProductId);
    } catch (Exception error) {
      throw new RuntimeException("An unexpected error occurred: " + error.getMessage());
    }
  }

  /**
   * Finds the inventory based on the provided criteria.
   *
   * @param getInventoryDto the DTO containing the criteria for fetching the
   *                        inventory
   * @return a list of ProductStockModel representing the inventory stock
   * @throws RuntimeException if an unexpected error occurs during the query
   *                          execution
   */
  public List<ProductStockModel> findInventory(GetInventoryDto getInventoryDto) {
    InventoryModel inventory = new InventoryModel()
        .setProductName(getInventoryDto.getProductName())
        .setCategoryId(getInventoryDto.getCategoryId())
        .setCategoryName(getInventoryDto.getCategoryName())
        .setSupplierId(getInventoryDto.getSupplierId())
        .setSupplierName(getInventoryDto.getSupplierName())
        .setTransactionTypeId(getInventoryDto.getTransactionTypeId())
        .setTransactionType(getInventoryDto.getTransactionType())
        .build();

    Binds binds = buildFindInventory(inventory);
    try {
      List<InventoryModel> result = jdbcTemplate.query(binds.getSql(), inventoryRowMapper, binds.getParams());
      return invetoryManagmentUseCase.calculateStock(result);
    } catch (Exception error) {
      throw new RuntimeException("An unexpected error occurred: " + error.getMessage());
    }
  }

  /**
   * Retrieves all inventory items from the database.
   *
   * @return a list of {@link InventoryModel} objects representing the inventory
   *         items.
   * @throws RuntimeException if an unexpected error occurs during the database
   *                          query.
   */
  public List<InventoryModel> findAllInventory() {
    try {
      List<InventoryModel> inventory = jdbcTemplate.query(InventorySql.FIND_ALL_INVENTORY.getQuery(),
          inventoryRowMapper);
      return inventory;
    } catch (Exception error) {
      throw new RuntimeException("An unexpected error occurred: " + error.getMessage());
    }
  }
}
