package com.api.routes.inventory;

import java.util.List;
import java.sql.PreparedStatement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import com.api.routes.inventory.builder.CreateMovementBuilder;
import com.api.routes.inventory.builder.FindMovementBuilder;
import com.api.routes.inventory.builder.InventoryBuilder;
import com.api.routes.inventory.builder.UpdateMovementBuilder;
import com.api.routes.inventory.dto.CreateProductMovementDto;
import com.api.routes.inventory.dto.GetInventoryDto;
import com.api.routes.inventory.dto.GetProductMovementDto;
import com.api.routes.inventory.dto.UpdateProductMovementDto;
import com.api.routes.inventory.model.InventoryModel;
import com.api.routes.inventory.model.ProductStockModel;
import com.api.routes.inventory.sql.InventorySql;
import com.api.routes.inventory.usecases.InvetoryManagmentUseCase;
import com.api.routes.inventory.usecases.ValidateModifyUseCase;
import com.api.routes.shared.mappers.inventory.ProductMovementMapper;
import com.api.routes.shared.models.inventory.ProductMovementModel;
import com.api.routes.shared.utils.query.Binds;

@Service
public class InventoryService extends InventoryBuilder {
  @Autowired
  private JdbcTemplate jdbcTemplate;

  private ProductMovementModel findProductMovementById(int updateProductId) {
    return jdbcTemplate
        .query(InventorySql.FIND_UPDATEPRODUCT_BY_ID.getQuery(), ProductMovementMapper.updateProductRowMapper,
            updateProductId)
        .get(0);
  }

  public List<ProductMovementModel> findAllUpdateProducts() {
    try {
      return jdbcTemplate.query(InventorySql.FIND_ALL_UPDATEPRODUCT.getQuery(),
          ProductMovementMapper.updateProductRowMapper);
    } catch (Exception error) {
      throw new RuntimeException("An unexpected error occurred: " + error.getMessage());
    }
  }

  public List<ProductMovementModel> findUpdateProduct(GetProductMovementDto getProductMovementDto) {
    Binds binds = FindMovementBuilder.buildFindUpdateProduct(getProductMovementDto);
    try {
      return jdbcTemplate.query(binds.getSql(), ProductMovementMapper.updateProductRowMapper, binds.getParams());
    } catch (Exception error) {
      throw new RuntimeException("An unexpected error occurred: " + error.getMessage());
    }
  }

  public ProductMovementModel createUpdateProduct(CreateProductMovementDto updateProductMovementDto) {
    try {
      if (ValidateModifyUseCase.validateStockInCreate(
          findInventory(new GetInventoryDto().setProductId(updateProductMovementDto.getProductId())).get(0).getStock(),
          updateProductMovementDto.getUpdateAmount(), updateProductMovementDto.getTransactionTypeId() == 2)) {
        throw new RuntimeException("The product stock is insufficient for the sale.");
      }
      Binds binds = CreateMovementBuilder.buildCreateUpdateProduct(updateProductMovementDto);
      KeyHolder keyHolder = new GeneratedKeyHolder();
      jdbcTemplate.update(connection -> {
        PreparedStatement statement = connection.prepareStatement(binds.getSql(), new String[] { "id" });
        for (int i = 0; i < binds.getParams().length; i++) {
          statement.setObject(i + 1, binds.getParams()[i]);
        }
        return statement;
      }, keyHolder);
      @SuppressWarnings("null")
      int generatedId = keyHolder.getKey().intValue();
      return findProductMovementById(generatedId);
    } catch (Exception error) {
      throw new RuntimeException("An unexpected error occurred: " + error.getMessage());
    }
  }

  public ProductMovementModel updateUpdateProduct(UpdateProductMovementDto updateProductMovementDto,
      int updateProductId) {
    try {
      ProductMovementModel updateProductModel = findProductMovementById(updateProductId);
      if (ValidateModifyUseCase.validateStockInModify(
          updateProductMovementDto,
          updateProductModel,
          findInventory(new GetInventoryDto().setProductId(updateProductModel.getProductModel().getProductId())).get(0)
              .getStock())) {
        throw new RuntimeException("The product stock is insufficient for the sale.");
      }
      Binds binds = UpdateMovementBuilder.buildUpdateUpdateProducts(updateProductMovementDto, updateProductId);
      jdbcTemplate.update(binds.getSql(), binds.getParams());
      return findProductMovementById(updateProductId);
    } catch (Exception error) {
      throw new RuntimeException("An unexpected error occurred: " + error.getMessage());
    }
  }

  public int activeUpdateProduct(int updateProductId) {
    try {
      return jdbcTemplate.update(InventorySql.ACTIVE_UPDATEPRODUCT.getQuery(), updateProductId);
    } catch (Exception error) {
      throw new RuntimeException("An unexpected error occurred: " + error.getMessage());
    }
  }

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
        .setProductId(getInventoryDto.getProductId())
        .setCategoryId(getInventoryDto.getCategoryId())
        .setSupplierId(getInventoryDto.getSupplierId())
        .build();

    Binds binds = buildFindInventory(inventory);
    try {
      List<InventoryModel> result = jdbcTemplate.query(binds.getSql(), inventoryRowMapper, binds.getParams());
      return InvetoryManagmentUseCase.calculateStock(result);
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
