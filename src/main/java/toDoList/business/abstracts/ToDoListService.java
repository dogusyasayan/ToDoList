package toDoList.business.abstracts;



import java.util.List;


import toDoList.Entities.concretes.Task;
import toDoList.Entities.concretes.ToDoList;
import toDoList.core.utilities.results.DataResult;
import toDoList.core.utilities.results.Result;

public interface ToDoListService {
	DataResult<List<ToDoList>> getAll();

	Result add(ToDoList list);

	Result delete(ToDoList list);

	Result update(ToDoList list);
	DataResult<List<ToDoList>> getListsByUserId(int userId);
	
}