package toDoList.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import toDoList.Entities.concretes.User;
import toDoList.business.abstracts.UserService;
import toDoList.core.utilities.results.DataResult;
import toDoList.core.utilities.results.Result;

@RestController // Restfull
@RequestMapping("/api/users")
public class UserController {
	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping("/getall") // toDoList/api/users/getall diye bir istekte bulunursak bu çalışacak.
	public DataResult<List<User>> getAll() {
		return this.userService.getAll();
	}
	
	@GetMapping("/getbyid") // toDoList/api/users/getall diye bir istekte bulunursak bu çalışacak.
	public DataResult<User> getbyid(int id) {
		return this.userService.getbyid(id);
	}

	@PostMapping("/add") // ekleme
	public Result add(@RequestBody User user) {
		return this.userService.add(user);
	}

	@DeleteMapping("/delete") // silme
	public Result delete(@RequestBody User user) {
		return this.userService.delete(user);
	}

	@PutMapping("/update") // güncelleme
	public Result update(@RequestBody User user) {
		return this.userService.update(user);
	}


}
