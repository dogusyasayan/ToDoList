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
@Table(name = "status")
@AllArgsConstructor // Parametreli constructor getirdi - lombok
@NoArgsConstructor // Parametresiz constructor getirdi - lombok
public class Statu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Birer birer artacak demek
	@Column(name = "id")
	private int statuId;
	@Column(name = "statu_text")
	private String statu_text;

}
