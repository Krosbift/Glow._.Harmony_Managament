package imc.api.routes.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import imc.api.routes.users.models.UsersModel;
import imc.api.routes.users.sql.UsersSql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class UserService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private RowMapper<UsersModel> userRowMapper = new RowMapper<UsersModel>() {
		@Override
		public UsersModel mapRow(ResultSet rs, int rowNum) throws SQLException {
			UsersModel user = new UsersModel();
			user.setId(rs.getLong("IDUSER"));
			user.setNames(rs.getString("NAMES"));
			user.setSurnames(rs.getString("SURNAMES"));
			user.setEmail(rs.getString("EMAIL"));
			user.setPassword(rs.getString("PASSWORD"));
			user.setIdUserRol(rs.getString("IDUSERROL"));
			user.setActive(rs.getBoolean("ACTIVE"));
			return user;
		}
	};

	public List<UsersModel> findUser() {
    return jdbcTemplate.query(UsersSql.FIND_USER.getQuery(), userRowMapper);
	}

	public int createUser(UsersModel user) {
		return jdbcTemplate.update(UsersSql.CREATE_USER.getQuery(),
			user.getNames(),
			user.getSurnames(),
			user.getEmail(),
			user.getPassword(),
			user.getIdUserRol(), user.getActive());
	}

	public int updateUser(UsersModel user, long id) {
		return jdbcTemplate.update(UsersSql.UPDATE_USER.getQuery(),
			user.getId(),
			user.getNames(),
			user.getSurnames(),
			user.getEmail(), user.getPassword(),
			user.getIdUserRol(), user.getActive());
	}

	public int deleteUser(Long id) {
		return jdbcTemplate.update(UsersSql.DELETE_USER.getQuery(), id);
	}
}