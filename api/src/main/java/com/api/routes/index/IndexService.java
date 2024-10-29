package com.api.routes.index;

import java.util.List;
import org.springframework.stereotype.Service;
import com.api.routes.index.builder.IndexBuilder;
import com.api.routes.index.model.DocumentTypesModel;
import com.api.routes.index.model.ProductCategoriesModel;
import com.api.routes.index.model.RoleTypesModel;
import com.api.routes.index.model.TransactionTypesModel;
import com.api.routes.index.model.ViewsModel;
import com.api.routes.index.sql.IndexSql;

@Service
public class IndexService extends IndexBuilder {

  /**
   * Retrieves a list of views from the database.
   *
   * @return a list of {@link ViewsModel} representing the views.
   * @throws RuntimeException if an unexpected error occurs during the database
   *                          query.
   */
  public List<ViewsModel> findAllViews() {
    try {
      return jdbcTemplate.query(IndexSql.FIND_VIEWS.getSql(), viewsRowMapper);
    } catch (Exception error) {
      throw new RuntimeException("An unexpected error occurred: " + error.getMessage());
    }
  }

  /**
   * Retrieves a list of document types from the database.
   *
   * @return a list of {@link DocumentTypesModel} representing the document types.
   * @throws RuntimeException if an unexpected error occurs during the database
   *                          query.
   */
  public List<DocumentTypesModel> findAllDocumentTypes() {
    try {
      return jdbcTemplate.query(IndexSql.FIND_DOCUMENT_TYPES.getSql(), documentTypesRowMapper);
    } catch (Exception error) {
      throw new RuntimeException("An unexpected error occurred: " + error.getMessage());
    }
  }

  /**
   * Retrieves all product categories from the database.
   *
   * @return a list of {@link ProductCategoriesModel} containing all product
   *         categories.
   * @throws RuntimeException if an unexpected error occurs during the database
   *                          query.
   */
  public List<ProductCategoriesModel> findAllProductCategories() {
    try {
      return jdbcTemplate.query(IndexSql.FIND_PRODUCT_CATEGORIES.getSql(), productCategoriesRowMapper);
    } catch (Exception error) {
      throw new RuntimeException("An unexpected error occurred: " + error.getMessage());
    }
  }

  /**
   * Retrieves all role types from the database.
   *
   * @return a list of {@link RoleTypesModel} containing all role types.
   * @throws RuntimeException if an unexpected error occurs during the database
   *                          query.
   */
  public List<RoleTypesModel> findAllRoleTypes() {
    try {
      return jdbcTemplate.query(IndexSql.FIND_ROLE_TYPES.getSql(), roleTypesRowMapper);
    } catch (Exception error) {
      throw new RuntimeException("An unexpected error occurred: " + error.getMessage());
    }
  }

  /**
   * Retrieves all transaction types from the database.
   *
   * @return a list of {@link TransactionTypesModel} representing all transaction
   *         types.
   * @throws RuntimeException if an unexpected error occurs during the database
   *                          query.
   */
  public List<TransactionTypesModel> findAllTransactionTypes() {
    try {
      return jdbcTemplate.query(IndexSql.FIND_TRANSACTION_TYPES.getSql(), transactionTypesRowMapper);
    } catch (Exception error) {
      throw new RuntimeException("An unexpected error occurred: " + error.getMessage());
    }
  }
}
