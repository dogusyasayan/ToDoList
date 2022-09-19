package toDoList.business.abstracts;

import java.util.List;

import toDoList.Entities.concretes.Task;
import toDoList.Entities.dtos.TaskWithStatuDto;
import toDoList.core.utilities.results.DataResult;
import toDoList.core.utilities.results.Result;

public interface TaskService {
	DataResult<List<Task>> getAll();

	Result add(Task task);

	Result delete(Task task);

	Result update(Task task);
	DataResult<List<Task>> getListId(int listId);
	DataResult<List<Task>> getUserId(int userId);
	DataResult<List<TaskWithStatuDto>> getWithStatuByUserId(int userId);
	
}
