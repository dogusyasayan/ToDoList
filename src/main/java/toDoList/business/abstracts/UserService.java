package toDoList.business.abstracts;

import java.util.List;

import toDoList.Entities.concretes.User;
import toDoList.core.utilities.results.DataResult;
import toDoList.core.utilities.results.Result;

public interface UserService {
	DataResult<List<User>> getAll();

	Result add(User user);

	Result delete(User user);

	Result update(User user);
	DataResult<User> getbyid(int user_id);
	DataResult<User> getbyusernameandpass(String username,String pass);
}
