package toDoList.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import toDoList.Entities.dtos.UserDetailDto;
import toDoList.business.abstracts.AuthService;
import toDoList.business.concretes.AuthManager;
import toDoList.business.concretes.DtosManager;
import toDoList.core.utilities.results.DataResult;
import toDoList.core.utilities.results.Result;
import toDoList.core.utilities.results.SuccessResult;

@RestController // Sen bir controlsün Restfull
@RequestMapping("/api/auth")
public class AuthController {
    private AuthService authService;
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/signIn") // toDoList/api/statu/getall diye bir istekte bulunursak bu çalışacak.
    public Result signIn(String username, String pass) {
        var result=authService.signIn(username,pass);
        return result;
    }
    @GetMapping("/signOut") // toDoList/api/statu/getall diye bir istekte bulunursak bu çalışacak.
    public Result signOut() {

        return authService.signOut();
    }

}
