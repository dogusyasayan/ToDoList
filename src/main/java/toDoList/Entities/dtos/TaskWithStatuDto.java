package toDoList.Entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import toDoList.Entities.concretes.Task;
import toDoList.Entities.concretes.ToDoList;

import java.util.List;

@Data

@AllArgsConstructor // Parametreli constructor getirdi - lombok
@NoArgsConstructor // Parametresiz constructor getirdi - lombok
public class TaskWithStatuDto {

       private Task task;
        private String statu;

}
