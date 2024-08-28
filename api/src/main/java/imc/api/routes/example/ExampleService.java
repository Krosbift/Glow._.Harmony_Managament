package imc.api.routes.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import imc.api.routes.example.models.ExampleModel;
import imc.api.routes.example.sql.ExampleSql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class ExampleService {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  private RowMapper<ExampleModel> exampleRowMapper = new RowMapper<ExampleModel>() {
    @Override
    public ExampleModel mapRow(ResultSet rs, int rowNum) throws SQLException {
      ExampleModel example = new ExampleModel();
      example.setIdExample(rs.getLong("IDEXAMPLE"));
      example.setName(rs.getString("NAME"));
      example.setDescription(rs.getString("DESCRIPTION"));
      example.setActive(rs.getBoolean("ACTIVE"));
      return example;
    }
  };

  public List<ExampleModel> findExample(String idExample) {
    return jdbcTemplate.query(ExampleSql.FIND_EXAMPLE.getQuery(), exampleRowMapper, idExample);
  }

  public ExampleModel createExample(ExampleModel example) {
    KeyHolder keyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update(connection -> {
      PreparedStatement ps = connection.prepareStatement(ExampleSql.CREATE_EXAMPLE.getQuery(), new String[] {"IDEXAMPLE"});
      ps.setString(1, example.getName());
      ps.setString(2, example.getDescription());
      ps.setBoolean(3, example.getActive());
      return ps;
    }, keyHolder);

    Long newId = keyHolder.getKey().longValue();
    example.setIdExample(newId);
    return example;
  }

  public ExampleModel updateExample(ExampleModel example, long id) {
    jdbcTemplate.update(ExampleSql.UPDATE_EXAMPLE.getQuery(),
      example.getName(),
      example.getDescription(),
      example.getActive(),
      id);

    example.setIdExample(id);
    return example;
  }

  public int deleteExample(Long id) {
    return jdbcTemplate.update(ExampleSql.DELETE_EXAMPLE.getQuery(), id);
  }
}