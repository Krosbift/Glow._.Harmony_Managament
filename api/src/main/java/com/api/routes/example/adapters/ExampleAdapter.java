package com.api.routes.example.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.api.routes.example.models.ExampleModel;
import com.api.routes.example.sql.ExampleSql;
import com.api.routes.shared.interfaces.Binds;

public class ExampleAdapter {

  @Autowired
  protected JdbcTemplate jdbcTemplate;

  /**
   * RowMapper implementation for mapping a ResultSet to an ExampleModel object.
   * 
   * @param rs     The ResultSet containing the data to be mapped.
   * @param rowNum The current row number.
   * @return An ExampleModel object mapped from the ResultSet.
   * @throws SQLException If an error occurs while accessing the ResultSet.
   */
  protected RowMapper<ExampleModel> exampleRowMapper = new RowMapper<ExampleModel>() {
    @Override
    public ExampleModel mapRow(@SuppressWarnings("null") ResultSet rs, int rowNum) throws SQLException {
      ExampleModel example = new ExampleModel();
      example.setIdExample(rs.getLong("IDEXAMPLE"));
      example.setName(rs.getString("NAME"));
      example.setDescription(rs.getString("DESCRIPTION"));
      return example;
    }
  };

  /**
   * Sets the ID of the ExampleModel object.
   *
   * @param idExample The ID of the ExampleModel.
   * @return The ExampleModel object with the ID set.
   */
  protected ExampleModel setterExampleModel(long idExample) {
    ExampleModel example = new ExampleModel();
    example.setIdExample(idExample);
    return example;
  }
  
  /**
   * Finds an example by its ID.
   *
   * @param id The ID of the example to find.
   * @return The example model with the specified ID.
   */
  protected ExampleModel findExampleById(long id) {
    return jdbcTemplate.queryForObject(ExampleSql.FIND_EXAMPLE_BY_ID.getQuery(), exampleRowMapper, id);
  }
  
  /**
   * Finds the adapting binds for the given ExampleModel.
   *
   * @param example The ExampleModel object to find the adapting binds for.
   * @return The Binds object containing the SQL query and parameters.
   */
  protected Binds findAdapting(ExampleModel example) {
    StringBuilder sql = new StringBuilder(
      "SELECT IDEXAMPLE, NAME, DESCRIPTION, ACTIVE " +
      "FROM TB_com_EXAMPLES " +
      "WHERE ACTIVE = 1"
    );
    List<Object> params = new ArrayList<>();

    if (example.getIdExample() != null) {
      sql.append(" AND IDEXAMPLE = ?");
      params.add(example.getIdExample());
    }

    if (example.getName() != null) {
      sql.append(" AND NAME = ?");
      params.add(example.getName());
    }

    if (example.getDescription() != null) {
      sql.append(" AND DESCRIPTION = ?");
      params.add(example.getDescription());
    }

    return new Binds(sql.toString(), params.toArray());
  }

  /**
   * Creates a Binds object for adapting an ExampleModel instance into an SQL INSERT statement.
   * 
   * @param example The ExampleModel instance to be adapted.
   * @return A Binds object containing the SQL statement and the corresponding parameters.
   */
  protected Binds createAdapting(ExampleModel example) {
    StringBuilder sql = new StringBuilder("INSERT INTO TB_com_EXAMPLES (");
    StringBuilder valuesSql = new StringBuilder("VALUES (");
    List<Object> params = new ArrayList<>();

    if (example.getName() != null) {
      sql.append("NAME, ");
      valuesSql.append("?, ");
      params.add(example.getName());
    }
    if (example.getDescription() != null) {
      sql.append("DESCRIPTION, ");
      valuesSql.append("?, ");
      params.add(example.getDescription());
    }

    if (sql.charAt(sql.length() - 2) == ',') {
      sql.setLength(sql.length() - 2);
      valuesSql.setLength(valuesSql.length() - 2);
    }

    sql.append(") ");
    valuesSql.append(")");

    sql.append(valuesSql);

    return new Binds(sql.toString(), params.toArray());
  }

  /**
   * Updates the ExampleAdapter by adapting the provided ExampleModel and the given ID.
   * 
   * @param example The ExampleModel object containing the updated data.
   * @param id The ID of the ExampleModel to be updated.
   * @return A Binds object representing the SQL query and its parameters for the update operation.
   */
  protected Binds updateAdapting(ExampleModel example, long id) {
    StringBuilder sql = new StringBuilder("UPDATE TB_com_EXAMPLES SET ");
    List<Object> params = new ArrayList<>();

    if (example.getName() != null) {
      sql.append("NAME = ?, ");
      params.add(example.getName());
    }
    if (example.getDescription() != null) {
      sql.append("DESCRIPTION = ?, ");
      params.add(example.getDescription());
    }

    sql.setLength(sql.length() - 2);

    sql.append(" WHERE IDEXAMPLE = ?");
    params.add(id);

    return new Binds(sql.toString(), params.toArray());
  }

}
