package toDoList.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import toDoList.Entities.concretes.Statu;
import toDoList.business.abstracts.StatuService;
import toDoList.core.utilities.results.DataResult;
import toDoList.core.utilities.results.Result;

@RestController // Sen bir controlsün Restfull
@RequestMapping("/api/status")
public class StatuController {
	private StatuService statuService;

	@Autowired
	public StatuController(StatuService statuService) {
		super();
		this.statuService = statuService;
	}

	@GetMapping("/getall") // toDoList/api/statu/getall diye bir istekte bulunursak bu çalışacak.
	public DataResult<List<Statu>> getAll() {
		return this.statuService.getAll();
	}
	@GetMapping("/getbyid") // toDoList/api/statu/getall diye bir istekte bulunursak bu çalışacak.
	public DataResult<Statu> getByStatuId(int statuId) {
		return this.statuService.getStatuId(statuId);
	}

	@PostMapping("/add") // ekleme
	public Result add(@RequestBody Statu statu) {
		return this.statuService.add(statu);
	}

	@DeleteMapping("/delete") // silme
	public Result delete(@RequestBody Statu statu) {
		return this.statuService.delete(statu);
	}

	@PutMapping("/update") // güncelleme
	public Result update(@RequestBody Statu statu) {
		return this.statuService.update(statu);
	}

}
