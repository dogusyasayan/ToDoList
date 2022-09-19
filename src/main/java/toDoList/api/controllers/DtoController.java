package toDoList.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import toDoList.Entities.dtos.UserDetailDto;
import toDoList.core.utilities.results.DataResult;
import toDoList.business.concretes.DtosManager;


@RestController // Sen bir controlsün Restfull
@RequestMapping("/api/userdetails")

public class DtoController

{
    private DtosManager dtosManager;

    public DtoController(DtosManager dtosManager) {
        this.dtosManager = dtosManager;
    }

    @GetMapping("/getbyuserid") // toDoList/api/statu/getall diye bir istekte bulunursak bu çalışacak.
    public DataResult<UserDetailDto> getUserDetail(int userId) {
        var result=dtosManager.getUserDetail(userId);
        return result;
    }

}
