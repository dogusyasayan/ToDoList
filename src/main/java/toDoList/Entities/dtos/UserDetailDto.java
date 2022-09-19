package toDoList.Entities.dtos;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import toDoList.Entities.concretes.Task;
import toDoList.Entities.concretes.ToDoList;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;


@Data

@AllArgsConstructor // Parametreli constructor getirdi - lombok
@NoArgsConstructor // Parametresiz constructor getirdi - lombok

public class UserDetailDto {

    private int id;
    private String email;
    private String userName;
    private List<ToDoList> lists;
    private List<Task> tasks;



}
