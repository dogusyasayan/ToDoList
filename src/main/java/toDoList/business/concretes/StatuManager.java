package toDoList.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import toDoList.Entities.concretes.Statu;
import toDoList.business.abstracts.StatuService;
import toDoList.core.utilities.results.DataResult;
import toDoList.core.utilities.results.Result;
import toDoList.core.utilities.results.SuccessDataResult;
import toDoList.core.utilities.results.SuccessResult;
import toDoList.dataAccess.abstracts.StatuDao;
@Service // Sen Servissin
public class StatuManager implements StatuService {

	private StatuDao statuDao;

	@Autowired
	public StatuManager(StatuDao statuDao) {
		super();
		this.statuDao = statuDao;
	}

	@Override
	public DataResult<List<Statu>> getAll() {
		return new SuccessDataResult<List<Statu>>(this.statuDao.findAll(), "Data Listelendi");
	}

	@Override
	public Result add(Statu statu) {
		this.statuDao.save(statu);
		return new SuccessResult("Ürün eklendi");
	}

	@Override
	public Result delete(Statu statu) {
		this.statuDao.delete(statu);
		return new SuccessResult("Ürün silindi");
	}

	@Override
	public Result update(Statu statu) {
		this.statuDao.save(statu);
		return new SuccessResult("Ürün güncellendi");
	}

	@Override
	public DataResult<Statu> getStatuId(int statuId) {
		return new SuccessDataResult<Statu>(statuDao.getByStatuId(statuId));
	}

}
