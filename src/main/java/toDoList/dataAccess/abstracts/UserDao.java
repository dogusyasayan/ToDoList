package toDoList.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import toDoList.Entities.concretes.User;
import toDoList.core.utilities.results.DataResult;


public interface UserDao extends JpaRepository<User, Integer> {
	 User getByUserId(int user_id);
	User getByUsernameAndPassword(String username, String password);
	User getByEmailAndUsername(String email,String username);
}
