package toDoList.business.abstracts;

import java.util.List;

import toDoList.Entities.concretes.Statu;
import toDoList.Entities.concretes.Task;
import toDoList.core.utilities.results.DataResult;
import toDoList.core.utilities.results.Result;

public interface StatuService {
	DataResult<List<Statu>> getAll();

	Result add(Statu statu);

	Result delete(Statu statu);

	Result update(Statu statu);
	DataResult<Statu> getStatuId(int statuId);
}
