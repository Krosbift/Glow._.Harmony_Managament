package com.api.routes.index.builder;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.api.routes.shared.models.user.DocumentTypeModel;
import com.api.routes.shared.utils.methods.HasColumns;

public class DocumentTypeBuilder {
  /**
   * RowMapper implementation for mapping rows of a ResultSet to DocumentTypeModel
   * objects.
   * This mapper is used to convert the ResultSet rows into DocumentTypeModel instances.
   */
  public static RowMapper<DocumentTypeModel> documentTypesRowMapper = new RowMapper<DocumentTypeModel>() {
    @Override
    public DocumentTypeModel mapRow(@SuppressWarnings("null") ResultSet rs, int rowNum) throws SQLException {
      DocumentTypeModel documentType = new DocumentTypeModel()
          .setDocumentTypeId(rs, HasColumns.verify(rs, "DOCUMENTTYPEID"))
          .setDocumentType(rs, HasColumns.verify(rs, "DOCUMENTTYPE"))
          .setDescription(rs, HasColumns.verify(rs, "DESCRIPTION"))
          .setActive(rs, HasColumns.verify(rs, "ACTIVE"))
          .build();
      return documentType;
    }
  };
}
