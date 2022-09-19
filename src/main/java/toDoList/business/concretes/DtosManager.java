package toDoList.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import toDoList.Entities.dtos.TaskWithStatuDto;
import toDoList.Entities.dtos.UserDetailDto;
import toDoList.core.utilities.results.DataResult;
import toDoList.core.utilities.results.ErrorDataResult;
import toDoList.core.utilities.results.SuccessDataResult;
import toDoList.business.abstracts.StatuService;
import toDoList.business.abstracts.TaskService;
import toDoList.business.abstracts.ToDoListService;
import toDoList.business.abstracts.UserService;


@Service // Sen Servissin
public class DtosManager {

    private ToDoListService todoListService;
    private UserService userService;
    private TaskService taskService;
    private StatuService statuService;
    @Autowired
    public DtosManager(ToDoListService todoListService, UserService userService, TaskService taskService, StatuService statuService) {
        super();
        this.todoListService = todoListService;
        this.userService = userService;
        this.taskService = taskService;
        this.statuService = statuService;
    }

   public DataResult<UserDetailDto> getUserDetail(int userId) {

       try {
           var user= userService.getbyid(userId);
           var lists=todoListService.getListsByUserId(userId);
        var tasks=taskService.getUserId(userId);

           UserDetailDto userDetailDto= new UserDetailDto();
           userDetailDto.setUserName(user.getData().getUsername());
           userDetailDto.setEmail(user.getData().getEmail());
           userDetailDto.setId(user.getData().getUserId());
           userDetailDto.setLists(lists.getData());
           userDetailDto.setTasks(tasks.getData());

           return new SuccessDataResult<UserDetailDto>(userDetailDto);
       }
       catch(Exception e) {
           return new ErrorDataResult(e,"Kullanıcı Bulunamadı!");
       }



    }





}
