package toDoList.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import toDoList.Entities.concretes.Task;

import toDoList.core.utilities.results.DataResult;

import java.util.List;

public interface TaskDao extends JpaRepository<Task, Integer> {
	List<Task> getByToDoListId(int id);
	List<Task> getByUserId(int id);

}
