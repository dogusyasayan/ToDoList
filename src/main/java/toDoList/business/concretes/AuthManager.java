package toDoList.business.concretes;

import org.springframework.stereotype.Service;
import toDoList.business.abstracts.UserService;
import toDoList.core.utilities.globalveriables.Veriables;
import toDoList.core.utilities.results.ErrorResult;
import toDoList.core.utilities.results.Result;
import toDoList.business.abstracts.AuthService;
import toDoList.core.utilities.results.SuccessResult;
@Service
public class AuthManager implements AuthService {
    private UserService userService;

    public AuthManager(UserService userService) {
        this.userService = userService;
    }




    @Override
    public Result signIn(String username, String password) {
       var result= userService.getbyusernameandpass(username,password);
       if (result.isSuccess()){
           Veriables.user=result.getData();
           return  new SuccessResult(result.getMessage());}
      else {return  new ErrorResult("Kullanıcı Adı Veya Şifre Hatalı!");
       }
    }

    @Override
    public Result signOut() {

        Veriables.user=null;
        return new SuccessResult("Çıkış Yapıldı.");
    }
}
