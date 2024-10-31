package com.api.routes.index.builder;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.api.routes.index.model.DocumentTypesModel;
import com.api.routes.index.model.ProductCategoriesModel;
import com.api.routes.index.model.RoleTypesModel;
import com.api.routes.index.model.TransactionTypesModel;
import com.api.routes.index.model.ViewsModel;

public class IndexBuilder {
  @Autowired
  protected JdbcTemplate jdbcTemplate;

  /**
   * RowMapper implementation for mapping rows of a ResultSet to ViewsModel
   * instances.
   * This mapper extracts the following columns from the ResultSet:
   * 
   * The extracted values are used to populate a ViewsModel object.
   * 
   * @throws SQLException if an SQL error occurs while accessing the ResultSet
   */
  protected RowMapper<ViewsModel> viewsRowMapper = new RowMapper<ViewsModel>() {
    @SuppressWarnings("null")
    @Override
    public ViewsModel mapRow(ResultSet rs, int rowNum) throws SQLException {
      ViewsModel view = new ViewsModel()
          .setViewId(rs, hasColumn(rs, "VIEWID"))
          .setViewName(rs, hasColumn(rs, "NAME"))
          .setDescription(rs, hasColumn(rs, "DESCRIPTION"))
          .setActive(rs, hasColumn(rs, "ACTIVE"))
          .build();

      return view;
    }
  };

  /**
   * RowMapper implementation for mapping rows of a ResultSet to
   * DocumentTypesModel instances.
   * This mapper extracts the following columns from the ResultSet:
   * 
   * The extracted values are used to populate a DocumentTypesModel object.
   * 
   * @throws SQLException if an SQL error occurs while accessing the ResultSet
   */
  protected RowMapper<DocumentTypesModel> documentTypesRowMapper = new RowMapper<DocumentTypesModel>() {
    @SuppressWarnings("null")
    @Override
    public DocumentTypesModel mapRow(ResultSet rs, int rowNum) throws SQLException {
      DocumentTypesModel documentType = new DocumentTypesModel()
          .setDocumentTypeId(rs, hasColumn(rs, "DOCUMENTTYPEID"))
          .setDocumentType(rs, hasColumn(rs, "DOCUMENTTYPE"))
          .setDescription(rs, hasColumn(rs, "DESCRIPTION"))
          .setActive(rs, hasColumn(rs, "ACTIVE"))
          .build();

      return documentType;
    }
  };

  /**
   * RowMapper implementation for mapping rows of a ResultSet to
   * ProductCategoriesModel instances.
   * This mapper extracts the following columns from the ResultSet:
   * 
   * @throws SQLException if an SQL error occurs while accessing the ResultSet
   */
  protected RowMapper<ProductCategoriesModel> productCategoriesRowMapper = new RowMapper<ProductCategoriesModel>() {
    @SuppressWarnings("null")
    @Override
    public ProductCategoriesModel mapRow(ResultSet rs, int rowNum) throws SQLException {
      ProductCategoriesModel productCategory = new ProductCategoriesModel()
          .setProductCategoryId(rs, hasColumn(rs, "PRODUCTCATEGORYID"))
          .setName(rs, hasColumn(rs, "NAME"))
          .setDescription(rs, hasColumn(rs, "DESCRIPTION"))
          .setActive(rs, hasColumn(rs, "ACTIVE"))
          .build();

      return productCategory;
    }
  };

  /**
   * RowMapper implementation for mapping rows of a ResultSet to RoleTypesModel
   * instances.
   * This mapper is used to convert the result set rows into RoleTypesModel
   * objects.
   * 
   * @throws SQLException if an SQL error occurs while accessing the ResultSet
   */
  protected RowMapper<RoleTypesModel> roleTypesRowMapper = new RowMapper<RoleTypesModel>() {
    @SuppressWarnings("null")
    @Override
    public RoleTypesModel mapRow(ResultSet rs, int rowNum) throws SQLException {
      RoleTypesModel roleType = new RoleTypesModel()
          .setRoleTypeId(rs, hasColumn(rs, "ROLETYPEID"))
          .setRoleType(rs, hasColumn(rs, "ROLETYPE"))
          .setDescription(rs, hasColumn(rs, "DESCRIPTION"))
          .setActive(rs, hasColumn(rs, "ACTIVE"))
          .build();

      return roleType;
    }
  };

  /**
   * RowMapper implementation for mapping rows of a ResultSet to
   * TransactionTypesModel objects.
   * This mapper is used to convert the result set from a database query into a
   * TransactionTypesModel instance.
   * 
   * @throws SQLException if an SQL error occurs while accessing the ResultSet
   */
  protected RowMapper<TransactionTypesModel> transactionTypesRowMapper = new RowMapper<TransactionTypesModel>() {
    @SuppressWarnings("null")
    @Override
    public TransactionTypesModel mapRow(ResultSet rs, int rowNum) throws SQLException {
      TransactionTypesModel transactionType = new TransactionTypesModel()
          .setTransactionTypeId(rs, hasColumn(rs, "TRANSACTIONTYPEID"))
          .setTransactionType(rs, hasColumn(rs, "TRANSACTIONTYPE"))
          .setDescription(rs, hasColumn(rs, "DESCRIPTION"))
          .setActive(rs, hasColumn(rs, "ACTIVE"))
          .build();

      return transactionType;
    }
  };

  /**
   * Checks if the ResultSet contains the specified column.
   * 
   * @param rs     the ResultSet to check
   * @param column the name of the column to check for
   * @return true if the ResultSet contains the specified column, false otherwise
   * @throws SQLException if a database access error occurs or this method is
   *                      called on a closed result set
   */
  protected boolean hasColumn(ResultSet rs, String column) throws SQLException {
    ResultSetMetaData rsmd = rs.getMetaData();
    int columns = rsmd.getColumnCount();
    for (int x = 1; x <= columns; x++) {
      if (column.equals(rsmd.getColumnName(x))) {
        return true;
      }
    }
    return false;
  }
}
