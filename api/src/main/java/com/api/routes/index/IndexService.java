package com.api.routes.index;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.api.routes.index.sql.IndexSql;
import com.api.routes.index.builder.*;
import com.api.routes.shared.models.*;
import com.api.routes.shared.models.inventory.*;
import com.api.routes.shared.models.product.*;
import com.api.routes.shared.models.user.*;

@Service
public class IndexService {
  @Autowired
  private JdbcTemplate jdbcTemplate;

  public List<ViewModel> findAllViews() {
    try {
      return jdbcTemplate.query(IndexSql.FIND_VIEWS.getSql(), ViewBuilder.viewsRowMapper);
    } catch (Exception error) {
      throw new RuntimeException("An unexpected error occurred: " + error.getMessage());
    }
  }

  public List<DocumentTypeModel> findAllDocumentTypes() {
    try {
      return jdbcTemplate.query(IndexSql.FIND_DOCUMENT_TYPES.getSql(), DocumentTypeBuilder.documentTypesRowMapper);
    } catch (Exception error) {
      throw new RuntimeException("An unexpected error occurred: " + error.getMessage());
    }
  }

  public List<ProductCategoryModel> findAllProductCategories() {
    try {
      return jdbcTemplate.query(IndexSql.FIND_PRODUCT_CATEGORIES.getSql(), ProductCategoryBuilder.productCategoriesRowMapper);
    } catch (Exception error) {
      throw new RuntimeException("An unexpected error occurred: " + error.getMessage());
    }
  }

  public List<RoleTypeModel> findAllRoleTypes() {
    try {
      return jdbcTemplate.query(IndexSql.FIND_ROLE_TYPES.getSql(), RoleTypeBuilder.roleTypesRowMapper);
    } catch (Exception error) {
      throw new RuntimeException("An unexpected error occurred: " + error.getMessage());
    }
  }

  public List<TransactionTypeModel> findAllTransactionTypes() {
    try {
      return jdbcTemplate.query(IndexSql.FIND_TRANSACTION_TYPES.getSql(), TransactionTypeBuilder.transactionTypesRowMapper);
    } catch (Exception error) {
      throw new RuntimeException("An unexpected error occurred: " + error.getMessage());
    }
  }
}
