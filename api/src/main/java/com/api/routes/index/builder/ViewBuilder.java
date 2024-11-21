package com.api.routes.index.builder;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.api.routes.shared.models.ViewModel;
import com.api.routes.shared.utils.methods.HasColumns;

public class ViewBuilder {
  /**
   * RowMapper implementation for mapping rows of a ResultSet to ViewModel
   * objects.
   * This mapper is used to convert the ResultSet rows into ViewModel instances.
   */
  public static RowMapper<ViewModel> viewsRowMapper = new RowMapper<ViewModel>() {
    @Override
    public ViewModel mapRow(@SuppressWarnings("null") ResultSet rs, int rowNum) throws SQLException {
      ViewModel view = new ViewModel()
          .setViewId(rs, HasColumns.verify(rs, "VIEWID"))
          .setViewName(rs, HasColumns.verify(rs, "NAME"))
          .setDescription(rs, HasColumns.verify(rs, "DESCRIPTION"))
          .setActive(rs, HasColumns.verify(rs, "ACTIVE"))
          .build();
      return view;
    }
  };
}
