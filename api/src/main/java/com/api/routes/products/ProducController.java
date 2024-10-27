package com.api.routes.products;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
import com.api.routes.products.dto.CreateProductDto;
import com.api.routes.products.dto.GetProductDto;
import com.api.routes.products.dto.UpdateProductDto;
import com.api.routes.products.model.ProductModel;

@RestController
@RequestMapping("products")
@Tag(name = "Productos", description = "Endpoints para el manejo de productos.")
public class ProducController {
  @Autowired
  private ProductService productService;

  @GetMapping("find-product")
  @Operation(summary = "Buscar productos por cualquier valor coincidiente", description = "Retorna el producto encontrado.")
  public List<ProductModel> findProduct(@RequestParam(required = false) String productName,
      @RequestParam(required = false) Integer productCategoryId, @RequestParam(required = false) String productCategory,
      @RequestParam(required = false) Integer supplierId, @RequestParam(required = false) String supplierName) {
    GetProductDto getProductDto = new GetProductDto()
        .setProductName(productName)
        .setProductCategoryId(productCategoryId)
        .setProductCategory(productCategory)
        .setSupplierId(supplierId)
        .setSupplierName(supplierName)
        .build();
    return productService.findProduct(getProductDto);
  }

  @GetMapping("find-all-products")
  @Operation(summary = "Buscar todos los productos", description = "Retorna una lista de todos los productos encontrados.")
  public List<ProductModel> findAllProducts() {
    return productService.findAllProducts();
  }

  @PostMapping("create-product")
  @Operation(summary = "Crea un nuevo producto", description = "Crea un nuevo producto en el sistema.")
  public ProductModel createProduct(@RequestBody CreateProductDto createProductDto) {
    return productService.createProduct(createProductDto);
  }

  @PatchMapping("update-product/{productId}")
  @Operation(summary = "Actualizar producto", description = "Actualiza los datos de un producto existente.")
  public ProductModel updateProduct(@RequestBody UpdateProductDto updateProductDto, @PathVariable int productId) {
    return productService.updateProduct(updateProductDto, productId);
  }

  @PatchMapping("activate-product/{productId}")
  @Operation(summary = "Activar producto", description = "Activa un producto existente.")
  public int activateProduct(@PathVariable int productId) {
    return productService.activeProduct(productId);
  }

  @DeleteMapping("deactivate-product/{productId}")
  @Operation(summary = "Desactivar producto", description = "Desactiva un producto existente.")
  public int deactivateProduct(@PathVariable int productId) {
    return productService.deleteProduct(productId);
  }
}
