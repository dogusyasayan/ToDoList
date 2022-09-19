package toDoList.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import toDoList.Entities.concretes.Statu;
import toDoList.Entities.concretes.Task;

import java.util.List;

public interface StatuDao extends JpaRepository<Statu, Integer> {
    Statu getByStatuId(int id);
}
