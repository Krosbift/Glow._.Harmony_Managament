package com.api.routes.users;

import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.util.List;

import com.api.routes.shared.interfaces.Binds;
import com.api.routes.users.builder.UserBuilder;
import com.api.routes.users.dto.LoginUserDto;
import com.api.routes.users.dto.RegisterUserDto;
import com.api.routes.users.model.UserModel;
import com.api.routes.users.sql.UserSql;

@Service
public class UserService extends UserBuilder {
  /**
   * Finds a user by their email address.
   *
   * @param email the email address of the user to be found.
   * @return a ResponseEntity containing the user if found, or an appropriate error message if not.
   */
  public ResponseEntity<?> findUser(String email) {
    UserModel user = new UserModel();
    user.setEmail(email);

    Binds binds = buildFindUser(user);
    try {
      List<UserModel> userFound = jdbcTemplate.query(binds.getSql(), userRowMapper, binds.getParams());

      if (userFound.isEmpty()) {
        return ResponseEntity.status(404).body("User not found");
      }

      return ResponseEntity.ok(userFound);
    } catch (Exception error) {
      return ResponseEntity.status(500).body("An unexpected error occurred: " + error.getMessage());
    }
  }
  /**
   * Finds all users in the database.
   *
   * @return a ResponseEntity containing a list of all users if successful,
   *         or an appropriate error message if an error occurs.
   */
  public ResponseEntity<?> findAllUsers() {
    try {
      List<UserModel> users = jdbcTemplate.query(UserSql.FIND_ALL_USERS.getQuery(), userRowMapper);
      return ResponseEntity.ok(users);
    } catch (Exception error) {
      return ResponseEntity.status(500).body("An unexpected error occurred: " + error.getMessage());
    }
  }
  /**
   * Finds and authenticates a user based on the provided login data.
   *
   * @param loginData the login data containing the user's email and password.
   * @return a ResponseEntity containing the authenticated user if successful,
   *         or an appropriate error message if authentication fails or an error occurs.
   */
  public ResponseEntity<?> findLoginUser(LoginUserDto loginData) {
    UserModel user = new UserModel();
    user.setEmail(loginData.getEmail());

    Binds binds = buildFindLoginUser(user);
    try {
      List<UserModel> userFound = jdbcTemplate.query(binds.getSql(), userRowMapper, binds.getParams());

      if (userFound.isEmpty()) {
        return ResponseEntity.status(404).body("User not found");
      }
      
      if (!userFound.get(0).getPassword().equals(loginData.getPassword())) {
        return ResponseEntity.status(401).body("Invalid credentials");
      }
      
      return ResponseEntity.ok(true);
    } catch (Exception error) {
      return ResponseEntity.status(500).body("An unexpected error occurred: " + error.getMessage());
    }
  }
  /**
   * Registers a new user based on the provided registration data.
   *
   * @param registerData the registration data containing the user's details.
   * @return a ResponseEntity containing the registered user if successful,
   *         or an appropriate error message if registration fails or an error occurs.
   */
  public ResponseEntity<?> registerUser(RegisterUserDto registerData) {
    UserModel user = new UserModel();
    user.setNames(registerData.getNames());
    user.setSurNames(registerData.getSurNames());
    user.setDocumentTypeId(registerData.getDocumentTypeId());
    user.setDocumentNumber(registerData.getDocumentNumber());
    user.setEmail(registerData.getEmail());
    user.setPassword(registerData.getPassword());
    user.setPhone(registerData.getPhone());
    user.setRoleTypeId(registerData.getRoleTypeId());
    user.setAddress(registerData.getAddress());

    Binds binds = buildRegisterUser(user);
    KeyHolder keyHolder = new GeneratedKeyHolder();
    try {
      jdbcTemplate.update(connection -> {
        PreparedStatement ps = connection.prepareStatement(binds.getSql(), new String[] { "USERID" });
        final Object[] params = binds.getParams();
        for (int i = 0; i < params.length; i++) {
          ps.setObject(i + 1, params[i]);
        }
        return ps;
      }, keyHolder);

      int generatedId = keyHolder.getKey().intValue();
      return ResponseEntity.ok(findUserById(generatedId));
    } catch (Exception error) {
      return ResponseEntity.status(500).body("An unexpected error occurred: " + error.getMessage());
    }
  }
  /**
   * Updates an existing user based on the provided user ID and updated data.
   *
   * @param updateData the updated user data.
   * @param userId the unique identifier of the user to be updated.
   * @return a ResponseEntity containing the updated user if successful,
   *         or an appropriate error message if the update fails or an error occurs.
   */
  public ResponseEntity<?> updateUser(RegisterUserDto updateData, int userId) {
    UserModel user = new UserModel();
    user.setNames(updateData.getNames());
    user.setSurNames(updateData.getSurNames());
    user.setDocumentTypeId(updateData.getDocumentTypeId());
    user.setDocumentNumber(updateData.getDocumentNumber());
    user.setEmail(updateData.getEmail());
    user.setPassword(updateData.getPassword());
    user.setPhone(updateData.getPhone());
    user.setRoleTypeId(updateData.getRoleTypeId());
    user.setAddress(updateData.getAddress());

    Binds binds = buildUpdateUser(user, userId);
    try {
      jdbcTemplate.update(binds.getSql(), binds.getParams());
      return ResponseEntity.ok(findUserById(userId));
    } catch (Exception error) {
      return ResponseEntity.status(500).body("An unexpected error occurred: " + error.getMessage());
    }
  }
  /**
   * Activates a user based on the provided user ID.
   *
   * @param userId the unique identifier of the user to be activated.
   * @return a ResponseEntity containing the activated user if successful,
   *         or an appropriate error message if activation fails or an error occurs.
   */
  public ResponseEntity<?> activateUser(int userId) {
    try {
      jdbcTemplate.update(UserSql.ACTIVE_USER.getQuery(), userId);
      return ResponseEntity.ok(findUserById(userId));
    } catch (Exception error) {
      return ResponseEntity.status(500).body("An unexpected error occurred: " + error.getMessage());
    }
  }
  /**
   * Deactivates a user based on the provided user ID.
   *
   * @param userId the unique identifier of the user to be deactivated.
   * @return a ResponseEntity containing the deactivated user if successful,
   *         or an appropriate error message if deactivation fails or an error occurs.
   */
  public ResponseEntity<?> deleteUser(int userId) {
    try {
      jdbcTemplate.update(UserSql.DELETE_USER.getQuery(), userId);
      return ResponseEntity.ok(userId);
    } catch (Exception error) {
      return ResponseEntity.status(500).body("An unexpected error occurred: " + error.getMessage());
    }
  }
}
