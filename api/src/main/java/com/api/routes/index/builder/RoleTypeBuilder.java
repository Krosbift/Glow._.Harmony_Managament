package com.api.routes.index.builder;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.api.routes.shared.models.user.RoleTypeModel;
import com.api.routes.shared.utils.methods.HasColumns;

public class RoleTypeBuilder {
  /**
   * RowMapper implementation for mapping rows of a ResultSet to RoleTypeModel
   * objects.
   * This mapper is used to convert the ResultSet rows into RoleTypeModel instances.
   */
  public static RowMapper<RoleTypeModel> roleTypesRowMapper = new RowMapper<RoleTypeModel>() {
    @Override
    public RoleTypeModel mapRow(@SuppressWarnings("null") ResultSet rs, int rowNum) throws SQLException {
      RoleTypeModel roleType = new RoleTypeModel()
          .setRoleTypeId(rs, HasColumns.verify(rs, "ROLETYPEID"))
          .setRoleType(rs, HasColumns.verify(rs, "ROLETYPE"))
          .setDescription(rs, HasColumns.verify(rs, "DESCRIPTION"))
          .setActive(rs, HasColumns.verify(rs, "ACTIVE"))
          .build();
      return roleType;
    }
  };
}
