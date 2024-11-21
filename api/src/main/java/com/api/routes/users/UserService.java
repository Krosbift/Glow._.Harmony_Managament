package com.api.routes.users;

import java.util.List;
import java.sql.PreparedStatement;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import com.api.routes.shared.utils.query.Binds;
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
   * @param email the email address of the user to find
   * @return the UserModel object representing the found user
   * @throws RuntimeException if an unexpected error occurs during the query
   */
  public UserModel findUser(String email) {
    UserModel user = new UserModel()
        .setEmail(email)
        .build();

    Binds binds = buildFindUser(user);
    try {
      List<UserModel> userFound = jdbcTemplate.query(binds.getSql(), userRowMapper, binds.getParams());
      return userFound.get(0);
    } catch (Exception error) {
      throw new RuntimeException("An unexpected error occurred: " + error.getMessage());
    }
  }

  /**
   * Retrieves a list of all users from the database.
   *
   * @return a list of UserModel objects representing all users.
   * @throws RuntimeException if an unexpected error occurs during the database
   *                          query.
   */
  public List<UserModel> findAllUsers() {
    try {
      List<UserModel> users = jdbcTemplate.query(UserSql.FIND_ALL_USERS.getQuery(), userRowMapper);
      return users;
    } catch (Exception error) {
      throw new RuntimeException("An unexpected error occurred: " + error.getMessage());
    }
  }

  /**
   * Finds and verifies the login credentials of a user.
   *
   * @param loginData the login data transfer object containing the user's email
   *                  and password.
   * @return true if the user is found and the password matches; false otherwise.
   * @throws RuntimeException if an unexpected error occurs during the database
   *                          query.
   */
  public boolean findLoginUser(LoginUserDto loginData) {
    UserModel user = new UserModel()
      .setEmail(loginData.getEmail())
      .build();

    Binds binds = buildFindLoginUser(user);
    try {
      List<UserModel> userFound = jdbcTemplate.query(binds.getSql(), userRowMapper, binds.getParams());

      if (userFound.isEmpty()) {
        return false;
      }

      if (!userFound.get(0).getPassword().equals(loginData.getPassword())) {
        return false;
      }

      return true;
    } catch (Exception error) {
      throw new RuntimeException("An unexpected error occurred: " + error.getMessage());
    }
  }

  /**
   * Registers a new user in the system.
   *
   * @param registerData the data transfer object containing the user's
   *                     registration information
   * @return the registered UserModel with the generated ID
   * @throws RuntimeException if an unexpected error occurs during the
   *                          registration process
   */
  public UserModel registerUser(RegisterUserDto registerData) {
    UserModel user = new UserModel()
        .setNames(registerData.getNames())
        .setSurNames(registerData.getSurNames())
        .setDocumentTypeId(registerData.getDocumentTypeId())
        .setDocumentNumber(registerData.getDocumentNumber())
        .setEmail(registerData.getEmail())
        .setPassword(registerData.getPassword())
        .setPhone(registerData.getPhone())
        .setRoleTypeId(registerData.getRoleTypeId())
        .setAddress(registerData.getAddress())
        .build();

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

      @SuppressWarnings("null")
      int generatedId = keyHolder.getKey().intValue();
      return findUserById(generatedId);
    } catch (Exception error) {
      throw new RuntimeException("An unexpected error occurred: " + error.getMessage());
    }
  }

  /**
   * Updates the user information for the specified user ID.
   *
   * @param updateData the data transfer object containing the updated user
   *                   information
   * @param userId     the ID of the user to be updated
   * @return the updated UserModel object
   * @throws RuntimeException if an unexpected error occurs during the update
   *                          process
   */
  public UserModel updateUser(RegisterUserDto updateData, int userId) {
    UserModel user = new UserModel()
        .setUserId(userId)
        .setNames(updateData.getNames())
        .setSurNames(updateData.getSurNames())
        .setDocumentTypeId(updateData.getDocumentTypeId())
        .setDocumentNumber(updateData.getDocumentNumber())
        .setEmail(updateData.getEmail())
        .setPassword(updateData.getPassword())
        .setPhone(updateData.getPhone())
        .setRoleTypeId(updateData.getRoleTypeId())
        .setAddress(updateData.getAddress())
        .build();

    Binds binds = buildUpdateUser(user, userId);
    try {
      jdbcTemplate.update(binds.getSql(), binds.getParams());
      return findUserById(userId);
    } catch (Exception error) {
      throw new RuntimeException("An unexpected error occurred: " + error.getMessage());
    }
  }

  /**
   * Activates a user by updating their status in the database.
   *
   * @param userId the ID of the user to be activated
   * @return the ID of the activated user
   * @throws RuntimeException if an unexpected error occurs during the update
   */
  public int activateUser(int userId) {
    try {
      jdbcTemplate.update(UserSql.ACTIVE_USER.getQuery(), userId);
      return userId;
    } catch (Exception error) {
      throw new RuntimeException("An unexpected error occurred: " + error.getMessage());
    }
  }

  /**
   * Deletes a user from the database based on the provided user ID.
   *
   * @param userId the ID of the user to be deleted
   * @return the ID of the deleted user
   * @throws RuntimeException if an unexpected error occurs during the deletion
   *                          process
   */
  public int deleteUser(int userId) {
    try {
      jdbcTemplate.update(UserSql.DELETE_USER.getQuery(), userId);
      return userId;
    } catch (Exception error) {
      throw new RuntimeException("An unexpected error occurred: " + error.getMessage());
    }
  }
}
