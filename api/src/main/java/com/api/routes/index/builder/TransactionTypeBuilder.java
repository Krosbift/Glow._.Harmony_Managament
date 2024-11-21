package com.api.routes.index.builder;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.api.routes.shared.utils.methods.HasColumns;
import com.api.routes.shared.models.inventory.TransactionTypeModel;

public class TransactionTypeBuilder {
  /**
   * RowMapper implementation for mapping rows of a ResultSet to TransactionTypeModel
   * objects.
   * This mapper is used to convert the ResultSet rows into TransactionTypeModel instances.
   */
  public static RowMapper<TransactionTypeModel> transactionTypesRowMapper = new RowMapper<TransactionTypeModel>() {
    @Override
    public TransactionTypeModel mapRow(@SuppressWarnings("null") ResultSet rs, int rowNum) throws SQLException {
      TransactionTypeModel transactionType = new TransactionTypeModel()
          .setTransactionTypeId(rs, HasColumns.verify(rs, "TRANSACTIONTYPEID"))
          .setTransactionType(rs, HasColumns.verify(rs, "TRANSACTIONTYPE"))
          .setDescription(rs, HasColumns.verify(rs, "DESCRIPTION"))
          .setActive(rs, HasColumns.verify(rs, "ACTIVE"))
          .build();
      return transactionType;
    }
  };
}
