package toDoList.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import toDoList.Entities.concretes.User;
import toDoList.business.abstracts.UserService;
import toDoList.core.utilities.globalveriables.Veriables;
import toDoList.core.utilities.results.*;
import toDoList.dataAccess.abstracts.UserDao;

@Service // Sen Servissin
public class UserManager implements UserService {
	private UserDao userDao;

	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public DataResult<List<User>> getAll() {
		if(Veriables.user!=null){return new SuccessDataResult<List<User>>(this.userDao.findAll(), "Data listelendi");}
		else {
			return new ErrorDataResult("Yetkilendirme Hatası! Lütfen Giriş Yapınız!");
		}

	}

	@Override
	public Result add(User user) {

		var check=this.userDao.getByEmailAndUsername(user.getEmail(),user.getUsername());
		if(check==null){this.userDao.save(user);

			return new SuccessResult("Kullanıcı Kaydedildi");}

		else {return new ErrorResult("Bu mail ya da kullanıcı adı kullanılmaktadır!");}

	}

	@Override
	public Result delete(User user) {
		this.userDao.delete(user);
		return new SuccessResult("Kullanıcı Silindi");
	}

	@Override
	public Result update(User user) {
		this.userDao.save(user);
		return new SuccessResult("Kullanıcı Güncellendi");
	}

	@Override
	public DataResult<User> getbyid(int user_id) {
		DataResult<User> result=new SuccessDataResult<User>(this.userDao.getByUserId(user_id),"Kullanıcı Bulundu!");
		return result;
	}

	@Override
	public DataResult<User> getbyusernameandpass(String username, String pass) {
		var result=userDao.getByUsernameAndPassword(username,pass);
		if(result!=null){return new SuccessDataResult<User>(result,"Giriş Yapıldı");}
		else{return  new ErrorDataResult<User>("Giriş Başarısız");}

	}

}
