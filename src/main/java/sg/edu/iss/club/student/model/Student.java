package sg.edu.iss.club.student.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentId;
	
	@NotEmpty
	@Size(min=3, max=10)
	private String name;
	private String title;
	private Double pocketmoney;
	private Track track;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date enrolled;
	
	public Student(String name, String title, Double pocketmoney) {
		super();
		this.name = name;
		this.title = title;
		this.pocketmoney = pocketmoney;
	}
	
	public Student(int studentId, String name, String title, Double pocketmoney, Track track, Date enrolled) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.title = title;
		this.pocketmoney = pocketmoney;
		this.track = track;
		this.enrolled = enrolled;
	}
	
}
