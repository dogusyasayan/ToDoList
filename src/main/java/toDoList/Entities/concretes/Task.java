package toDoList.Entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "tasks")
@AllArgsConstructor // Parametreli constructor getirdi - lombok
@NoArgsConstructor // Parametresiz constructor getirdi - lombok
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Birer birer artacak demek
	@Column(name = "id")
	private int task_id;
	@Column(name = "list_id")
	private int toDoListId;
	@Column(name = "user_id")
	private int userId;
	@Column(name = "statu_id")
	private int statu_id;
	@Column(name = "description")
	private String description;
}
