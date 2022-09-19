package toDoList.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import toDoList.Entities.concretes.Task;

import toDoList.Entities.dtos.TaskWithStatuDto;
import toDoList.business.abstracts.StatuService;
import toDoList.business.abstracts.TaskService;
import toDoList.business.abstracts.ToDoListService;
import toDoList.core.utilities.results.DataResult;
import toDoList.core.utilities.results.Result;
import toDoList.core.utilities.results.SuccessDataResult;
import toDoList.core.utilities.results.SuccessResult;
import toDoList.dataAccess.abstracts.TaskDao;
@Service // Sen Servissin
public class TaskManager implements TaskService {

	private TaskDao taskDao;
	private ToDoListService todoListService;
	private StatuService statuService;

	@Autowired
	public TaskManager(TaskDao taskDao, ToDoListService todoListService, StatuService statuService) {
		super();
		this.taskDao = taskDao;
		this.todoListService=todoListService;
		this.statuService = statuService;
	}

	@Override
	public DataResult<List<Task>> getAll() {
		return new SuccessDataResult<List<Task>>(this.taskDao.findAll(), "Data listelendi");
	}

	@Override
	public Result add(Task task) {
		
		//if() {}
		this.taskDao.save(task);
		return new SuccessResult("Ürün eklendi");
	}

	@Override
	public Result delete(Task task) {
		this.taskDao.delete(task);
		return new SuccessResult("Ürün silindi");
	}

	@Override
	public Result update(Task task) {
		this.taskDao.save(task);
		return new SuccessResult("Ürün güncellendi");
	}

	@Override
	public DataResult<List<Task>> getListId(int listId) {
		DataResult<List<Task>> result=new SuccessDataResult<>(this.taskDao.getByToDoListId(listId),"");
		return result;
	}

	@Override
	public DataResult<List<Task>> getUserId(int userId) {
		DataResult<List<Task>> result=new SuccessDataResult<>(this.taskDao.getByUserId(userId),"");
		return result;
	}

	@Override
	public DataResult<List<TaskWithStatuDto>> getWithStatuByUserId(int userId) {
		List<TaskWithStatuDto>  taskWith=new ArrayList<>();
		var tasks= this.taskDao.getByUserId(userId);

		for (Task task : tasks) {
				var taskw=new TaskWithStatuDto();
				taskw.setTask(task);
				var statuId=task.getStatu_id();
				taskw.setStatu(statuService.getStatuId(statuId).getData().getStatu_text());
				taskWith.add(taskw);
		}



		DataResult<List<TaskWithStatuDto>> result=new SuccessDataResult<>(taskWith,"");
		return result;
	}


}
