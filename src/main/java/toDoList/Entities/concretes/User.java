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
@Entity // Sen Entity sin
@Table(name = "users")
@AllArgsConstructor // Parametreli constructor getirdi - lombok
@NoArgsConstructor // Parametresiz constructor getirdi - lombok
public class User {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY) // Birer birer artacak demek
		@Column(name = "id")
		private int userId;
		@Column(name = "email")
		private String email;
		@Column(name = "username")
		private String username;
		@Column(name = "password")
		private String password;	
	}

