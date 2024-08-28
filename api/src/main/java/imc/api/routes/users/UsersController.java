package imc.api.routes.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import imc.api.routes.users.models.UsersModel;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

	@Autowired
	private UserService userService;

	@GetMapping
	public List<UsersModel> getAllUsers() {
		return userService.findUser();
	}

	@PostMapping
	public int createUser(@RequestBody UsersModel user) {
		return userService.createUser(user);
	}

	@PatchMapping
	public int updateUser(@RequestBody UsersModel user, @PathVariable Long id) {
		return userService.updateUser(user, id);
	}

	@DeleteMapping("/{id}")
	public int deleteUser(@PathVariable Long id) {
		return userService.deleteUser(id);
	}
}
