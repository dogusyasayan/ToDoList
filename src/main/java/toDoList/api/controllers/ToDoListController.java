package toDoList.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import toDoList.Entities.concretes.ToDoList;
import toDoList.business.abstracts.ToDoListService;
import toDoList.core.utilities.results.DataResult;
import toDoList.core.utilities.results.Result;

@RestController // Sen bir controlsün Restfull
@RequestMapping("/api/lists")
public class ToDoListController {
	private ToDoListService listService;

	public ToDoListController(ToDoListService listService) {
		super();
		this.listService = listService;
	}
	@GetMapping("/getall") // toDoList/api/toDoList/getall diye bir istekte bulunursak bu çalışacak.
	public DataResult<List<ToDoList>> getAll() {
		return this.listService.getAll();
	}

	@GetMapping("/getbyuserid") // toDoList/api/toDoList/getall diye bir istekte bulunursak bu çalışacak.
	public DataResult<List<ToDoList>> getByUserId(int userId) {
		return this.listService.getListsByUserId(userId);
	}

	@PostMapping("/add") // ekleme
	public Result add(@RequestBody ToDoList list) {
		return this.listService.add(list);
	}

	@DeleteMapping("/delete") // silme
	public Result delete(@RequestBody ToDoList list) {
		return this.listService.delete(list);
	}

	@PutMapping("/update") // güncelleme
	public Result update(@RequestBody ToDoList list) {
		return this.listService.update(list);
	}
}
