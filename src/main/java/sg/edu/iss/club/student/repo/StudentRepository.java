package sg.edu.iss.club.student.repo;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sg.edu.iss.club.student.model.Student;


public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	@Query(value = "SELECT s from Student s")
	List<Student>findAllStudents(Sort sort);

}
