package toDoList.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;


import toDoList.Entities.concretes.Task;
import toDoList.Entities.concretes.ToDoList;
import toDoList.core.utilities.results.DataResult;

import java.util.List;

public interface ToDoListDao extends JpaRepository<ToDoList, Integer> {

    List<ToDoList> getToDoListsByUserId(int id);

}
