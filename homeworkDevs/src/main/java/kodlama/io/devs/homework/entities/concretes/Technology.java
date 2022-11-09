package kodlama.io.devs.homework.entities.concretes;

import javax.persistence.*;
import lombok.*;


@Table(name="technologies")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Technology {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "languageId")
	private Language language;

}
