package kodlama.io.devs.homework.entities.concretes;


import java.util.List;

import javax.persistence.*;

import lombok.*;


@Table(name="Languages")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Language {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@OneToMany(mappedBy="language")
	private List<Technology> technologies;

}
