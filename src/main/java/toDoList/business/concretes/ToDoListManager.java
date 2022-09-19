package toDoList.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import toDoList.Entities.concretes.ToDoList;
import toDoList.business.abstracts.ToDoListService;
import toDoList.business.abstracts.UserService;
import toDoList.core.utilities.results.DataResult;
import toDoList.core.utilities.results.ErrorResult;
import toDoList.core.utilities.results.Result;
import toDoList.core.utilities.results.SuccessDataResult;
import toDoList.core.utilities.results.SuccessResult;
import toDoList.dataAccess.abstracts.ToDoListDao;

@Service
public class ToDoListManager implements ToDoListService {

	private ToDoListDao doListDao;
	private UserService userService;
	

	@Autowired
	public ToDoListManager(ToDoListDao doListDao,UserService userService) {
		super();
		this.doListDao = doListDao;
		this.userService=userService;
		
	}

	@Override
	public DataResult<List<ToDoList>> getAll() {
		return new SuccessDataResult<List<ToDoList>>(this.doListDao.findAll(), "Data listelendi");
	}

	@Override
	public Result add(ToDoList list) {
		
		if(userService.getbyid(list.getUserId())!=null)
		{
		this.doListDao.save(list);
		return new SuccessResult("Liste Kaydedildi");
		}
		
		
		
		return new ErrorResult("Liste Kaydedilirken Bir Hata Meydana Geldi ");
		
		
	}

	@Override
	public Result delete(ToDoList list) {
		this.doListDao.delete(list);
		return new SuccessResult("Ürün silindi");
	}

	@Override
	public Result update(ToDoList list) {
		this.doListDao.save(list);
		return new SuccessResult("Ürün güncellendi");
	}

	@Override
	public DataResult<List<ToDoList>> getListsByUserId(int userId) {
		 return  new SuccessDataResult(this.doListDao.getToDoListsByUserId(userId));
	}


}
