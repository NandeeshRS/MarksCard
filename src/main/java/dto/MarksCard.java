package dto;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class MarksCard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	int standard;
	int mathematics;
	int science;
	int english;
	int kannada;
	int hindi;
	int socialscience;
	double percentage;
	String result;
	boolean status;
}
