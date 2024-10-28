package com.api.routes.inventory;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.routes.inventory.dto.CreateUpdateProductDto;
import com.api.routes.inventory.dto.GetInventoryDto;
import com.api.routes.inventory.dto.GetUpdateProductDto;
import com.api.routes.inventory.dto.UpdateProductUpdateDto;
import com.api.routes.inventory.model.InventoryModel;
import com.api.routes.inventory.model.ProductStockModel;
import com.api.routes.inventory.model.UpdateProductModel;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("inventory")
@Tag(name = "Inventario", description = "Endpoints para el manejo del inventario.")
public class InventoryController {
  @Autowired
  private InventoryService inventoryService;

  @GetMapping("find-update-product")
  @Operation(summary = "Buscar productos actualizados por cualquier valor coincidiente", description = "Retorna el producto actualizado encontrado.")
  public List<UpdateProductModel> findUpdateProduct(@RequestParam(required = false) String productName,
      @RequestParam(required = false) Integer transactionTypeId,
      @RequestParam(required = false) String transactionType) {
    GetUpdateProductDto getUpdateProductDto = new GetUpdateProductDto()
        .setProductName(productName)
        .setTransactionTypeId(transactionTypeId)
        .setTransactionType(transactionType)
        .build();
    return inventoryService.findUpdateProduct(getUpdateProductDto);
  }

  @GetMapping("find-all-update-products")
  @Operation(summary = "Buscar todos los productos actualizados", description = "Retorna una lista de todos los productos actualizados encontrados.")
  public List<UpdateProductModel> findAllUpdateProducts() {
    return inventoryService.findAllUpdateProducts();
  }

  @PostMapping("create-update-product")
  @Operation(summary = "Crea un nuevo producto actualizado", description = "Crea un nuevo producto actualizado en el sistema.")
  public UpdateProductModel createUpdateProduct(@RequestBody CreateUpdateProductDto createUpdateProductDto) {
    return inventoryService.createUpdateProduct(createUpdateProductDto);
  }

  @PatchMapping("update-update-product/{updateProductId}")
  @Operation(summary = "Actualizar producto actualizado", description = "Actualiza los datos de un producto actualizado existente.")
  public UpdateProductModel updateUpdateProduct(@RequestBody UpdateProductUpdateDto updateProductUpdateDto,
      @PathVariable int updateProductId) {
    return inventoryService.updateUpdateProduct(updateProductUpdateDto, updateProductId);
  }

  @PatchMapping("activate-update-product/{productId}")
  @Operation(summary = "Activar registro de producto", description = "Activa un registro de producto existente.")
  public int activateProduct(@PathVariable int productId) {
    return inventoryService.activeUpdateProduct(productId);
  }

  @DeleteMapping("delete-update-product/{updateProductId}")
  @Operation(summary = "Eliminar producto actualizado", description = "Elimina un producto actualizado del sistema.")
  public int deleteUpdateProduct(@PathVariable int updateProductId) {
    return inventoryService.deleteUpdateProduct(updateProductId);
  }

  @GetMapping("find-inventory")
  @Operation(summary = "Buscar inventario por cualquier valor coincidiente", description = "Retorna una lista de inventario encontrado.")
  public List<ProductStockModel> findInventory(@RequestParam(required = false) String productName,
      @RequestParam(required = false) Integer categoryId,
      @RequestParam(required = false) String categoryName,
      @RequestParam(required = false) Integer supplierId,
      @RequestParam(required = false) String supplierName,
      @RequestParam(required = false) Integer transactionTypeId,
      @RequestParam(required = false) String transactionType) {
    GetInventoryDto getInventoryDto = new GetInventoryDto()
        .setProductName(productName)
        .setCategoryId(categoryId)
        .setCategoryName(categoryName)
        .setSupplierId(supplierId)
        .setSupplierName(supplierName)
        .setTransactionTypeId(transactionTypeId)
        .setTransactionType(transactionType)
        .build();
    return inventoryService.findInventory(getInventoryDto);
  }

  @GetMapping("find-all-inventory")
  @Operation(summary = "Buscar todo el inventario", description = "Retorna una lista de todo el inventario encontrado.")
  public List<InventoryModel> findAllInventory() {
    return inventoryService.findAllInventory();
  }
}
