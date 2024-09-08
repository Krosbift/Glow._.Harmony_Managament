package com.api.routes.example;

import java.sql.PreparedStatement;
import java.util.List;

import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import com.api.routes.example.adapters.ExampleAdapter;
import com.api.routes.example.models.ExampleModel;
import com.api.routes.example.sql.ExampleSql;
import com.api.routes.interfaces.Binds;

@Service
public class ExampleService extends ExampleAdapter {

  public List<ExampleModel> findExample(int idExample) {
    Binds binds = findAdapting(setterExampleModel(idExample));
    return jdbcTemplate.query(binds.getSql(), exampleRowMapper, binds.getParams());
  }

  /**
   * Creates a new example using the provided example model.
   *
   * @param example The example model to create.
   * @return The created example model.
   */
  public ExampleModel createExample(ExampleModel example) {
    Binds binds = createAdapting(example);
    KeyHolder keyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update(connection -> {
      PreparedStatement ps = connection.prepareStatement(binds.getSql(), new String[] { "IDEXAMPLE" });
      final Object[] params = binds.getParams();
      for (int i = 0; i < params.length; i++) {
        ps.setObject(i + 1, params[i]);
      }
      return ps;
    }, keyHolder);

    Long generatedId = keyHolder.getKey().longValue();
    return findExampleById(generatedId);
  }

  /**
   * Updates an example with the given ID.
   *
   * @param example The updated example model.
   * @param id The ID of the example to be updated.
   * @return The updated example model.
   */
  public ExampleModel updateExample(ExampleModel example, int id) {
    Binds binds = updateAdapting(example, id);
    jdbcTemplate.update(binds.getSql(), binds.getParams());
    return findExampleById(id);
  }

  /**
   * Deletes an example with the specified ID.
   *
   * @param id The ID of the example to delete.
   * @return The ID of the deleted example.
   */
  public int deleteExample(int id) {
    jdbcTemplate.update(ExampleSql.DELETE_EXAMPLE.getQuery(), id);
    return id;
  }

}