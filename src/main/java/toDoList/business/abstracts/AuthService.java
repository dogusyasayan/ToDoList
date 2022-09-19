package toDoList.business.abstracts;

import toDoList.Entities.concretes.Statu;
import toDoList.core.utilities.results.Result;

public interface AuthService {

    Result signIn(String username,String password);

    Result signOut();
}
