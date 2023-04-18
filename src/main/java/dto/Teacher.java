package dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;


@Entity
@Data
public class Teacher {
	@Id
	@GeneratedValue(generator="employeeid")
	@SequenceGenerator(initialValue=450101,allocationSize=1,name="employeeid",sequenceName="employeeid")
	int employeeid;
	String  name;
	String subject;
	@Column(nullable=false,unique=true)
	String email;
	@Column(nullable=false,unique=true)
	long p_no;
	String password;
}
