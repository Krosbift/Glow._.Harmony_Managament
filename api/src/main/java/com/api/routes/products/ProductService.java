package com.api.routes.products;

import java.util.List;
import java.sql.PreparedStatement;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;
import com.api.routes.products.builder.ProductBuilder;
import com.api.routes.products.sql.ProducSql;
import com.api.routes.shared.utils.query.Binds;
import com.api.routes.products.dto.CreateProductDto;
import com.api.routes.products.dto.GetProductDto;
import com.api.routes.products.dto.UpdateProductDto;
import com.api.routes.products.model.ProductModel;

@Service
public class ProductService extends ProductBuilder {

  /**
   * Finds a product based on the provided product details.
   *
   * @param getProductDto the DTO containing the product details to search for
   * @return the found ProductModel
   * @throws RuntimeException if an unexpected error occurs during the query
   */
  public List<ProductModel> findProduct(GetProductDto getProductDto) {
    ProductModel product = new ProductModel()
        .setProductId(getProductDto.getProductId())
        .setProductCategoryId(getProductDto.getProductCategoryId())
        .setSupplierId(getProductDto.getSupplierId())
        .build();

    Binds binds = buildFindProduct(product);
    try {
      List<ProductModel> productFound = jdbcTemplate.query(binds.getSql(), productRowMapper, binds.getParams());
      return productFound;
    } catch (Exception error) {
      throw new RuntimeException("An unexpected error occurred: " + error.getMessage());
    }
  }

  /**
   * Retrieves a list of all products from the database.
   *
   * @return a list of {@link ProductModel} objects representing all products.
   * @throws RuntimeException if an unexpected error occurs during the database
   *                          query.
   */
  public List<ProductModel> findAllProducts() {
    try {
      List<ProductModel> products = jdbcTemplate.query(ProducSql.FIND_ALL_PRODUCTS.getQuery(), productRowMapper);
      return products;
    } catch (Exception error) {
      throw new RuntimeException("An unexpected error occurred: " + error.getMessage());
    }
  }

  /**
   * Creates a new product in the database.
   *
   * @param createProductDto the data transfer object containing the details of
   *                         the product to be created
   * @return the created ProductModel with the generated ID
   * @throws RuntimeException if an unexpected error occurs during the creation
   *                          process
   */
  public ProductModel createProduct(CreateProductDto createProductDto) {
    ProductModel product = new ProductModel()
        .setProductName(createProductDto.getProductName())
        .setProductCategoryId(createProductDto.getProductCategoryId())
        .setProductPrice(createProductDto.getProductPrice())
        .setSupplierId(createProductDto.getSupplierId())
        .build();

    Binds binds = buildCreateProduct(product);
    try {
      KeyHolder keyHolder = new GeneratedKeyHolder();
      jdbcTemplate.update(connection -> {
        PreparedStatement statement = connection.prepareStatement(binds.getSql(), new String[] { "product_id" });
        for (int i = 0; i < binds.getParams().length; i++) {
          statement.setObject(i + 1, binds.getParams()[i]);
        }
        return statement;
      }, keyHolder);

      @SuppressWarnings("null")
      int generatedId = keyHolder.getKey().intValue();
      return findProductById(generatedId);
    } catch (Exception error) {
      throw new RuntimeException("An unexpected error occurred: " + error.getMessage());
    }
  }

  /**
   * Updates an existing product with the provided details.
   *
   * @param updateProductDto the data transfer object containing the updated
   *                         product details
   * @param productId        the ID of the product to be updated
   * @return the updated ProductModel
   * @throws RuntimeException if an unexpected error occurs during the update
   *                          process
   */
  public ProductModel updateProduct(UpdateProductDto updateProductDto, int productId) {
    ProductModel product = new ProductModel()
        .setProductName(updateProductDto.getProductName())
        .setProductCategoryId(updateProductDto.getProductCategoryId())
        .setProductPrice(updateProductDto.getProductPrice())
        .setSupplierId(updateProductDto.getSupplierId())
        .build();

    Binds binds = buildUpdateProduc(product, productId);
    try {
      jdbcTemplate.update(binds.getSql(), binds.getParams());
      return findProductById(productId);
    } catch (Exception error) {
      throw new RuntimeException("An unexpected error occurred: " + error.getMessage());
    }
  }

  /**
   * Activates a product by its ID.
   *
   * @param productId the ID of the product to activate
   * @return the ID of the activated product
   * @throws RuntimeException if an unexpected error occurs during the activation
   *                          process
   */
  public int activeProduct(int productId) {
    try {
      jdbcTemplate.update(ProducSql.ACTIVE_PRODUCT.getQuery(), productId);
      return productId;
    } catch (Exception error) {
      throw new RuntimeException("An unexpected error occurred: " + error.getMessage());
    }
  }

  /**
   * Deletes a product from the database.
   *
   * @param productId the ID of the product to be deleted
   * @return the ID of the deleted product
   * @throws RuntimeException if an unexpected error occurs during the deletion
   *                          process
   */
  public int deleteProduct(int productId) {
    try {
      jdbcTemplate.update(ProducSql.DELETE_PRODUCT.getQuery(), productId);
      return productId;
    } catch (Exception error) {
      throw new RuntimeException("An unexpected error occurred: " + error.getMessage());
    }
  }
}
