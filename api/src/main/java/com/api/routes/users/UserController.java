package com.api.routes.users;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.api.routes.users.dto.LoginUserDto;
import com.api.routes.users.dto.RegisterUserDto;
import com.api.routes.users.dto.UpdateUserDto;

@RestController
@RequestMapping("user")
@Tag(name = "Usuarios", description = "Endpoint para el manejo de usuarios")
public class UserController {
  @Autowired
  private UserService userService;

  @GetMapping("find-user")
  @Operation(summary = "Buscar usuario por email", description = "Retorna un usuario con base en el email ingresado.")
  public ResponseEntity<?> findUser(@RequestParam String userEmail) throws Exception  {
    return userService.findUser(userEmail);
  }

  @GetMapping("find-all-users")
  @Operation(summary = "Buscar todos los usuarios", description = "Retorna una lista de todos los usuarios encontrados.")
  public ResponseEntity<?> findAllUsers() throws Exception  {
    return userService.findAllUsers();
  }

  @PostMapping("login")
  @Operation(summary = "Login de usuario", description = "Autentica un usuario com base en los datos ingresados.")
  public ResponseEntity<?> loginUser(@RequestBody LoginUserDto loginData) throws Exception {
    return userService.findLoginUser(loginData);
  }

  @PostMapping("register")
  @Operation(summary = "Registrar usuario", description = "Registra un nuevo usuario al sistema.")
  public ResponseEntity<?> registerUser(@RequestBody RegisterUserDto registerData) throws Exception {
    return userService.registerUser(registerData);
  }

  @PatchMapping("user-update/{userId}")
  @Operation(summary = "Actualizar usuario", description = "Actualiza los datos de un usuario existente.")
  public ResponseEntity<?> updateUser(@RequestBody UpdateUserDto registerData, @PathVariable int userId) throws Exception {
    return userService.updateUser(registerData, userId);
  }

  @PatchMapping("user-activate/{userId}")
  @Operation(summary = "Activar usuario", description = "Activa un usuario existente.")
  public ResponseEntity<?> activateUser(@PathVariable int userId) throws Exception {
    return userService.activateUser(userId);
  }

  @DeleteMapping("user-delete/{userId}")
  @Operation(summary = "Desactivar usuario", description = "Desactiva un usuario existente.")
  public ResponseEntity<?> deleteUser(@PathVariable int userId) throws Exception {
    return userService.deleteUser(userId);
  }
}
