package toDoList.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import toDoList.Entities.concretes.Task;
import toDoList.business.abstracts.TaskService;
import toDoList.core.utilities.results.DataResult;
import toDoList.core.utilities.results.Result;

@RestController // Sen bir controlsün Restfull
@CrossOrigin
@RequestMapping("/api/tasks")
public class TaskController {
	private TaskService taskService;

	public TaskController(TaskService taskService) {
		super();
		this.taskService = taskService;
	}

	@GetMapping("/getall") // toDoList/api/lists/getall diye bir istekte bulunursak bu çalışacak.
	public DataResult<List<Task>> getAll() {
		return this.taskService.getAll();
	}
	@GetMapping("/getbylistid") // toDoList/api/lists/getall diye bir istekte bulunursak bu çalışacak.
	public DataResult<List<Task>> getList(int listId) //list ıd yap
	{
		return this.taskService.getListId(listId);
	}

	@PostMapping("/add") // ekleme
	public Result add(@RequestBody Task task) {
		return this.taskService.add(task);
	}

	@DeleteMapping("/delete") // silme
	public Result delete(@RequestBody Task task) {
		return this.taskService.delete(task);
	}

	@PutMapping("/update") // güncelleme
	public Result update(@RequestBody Task task) {
		return this.taskService.update(task);
	}
}
