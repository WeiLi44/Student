package sg.edu.iss.club.student.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.club.student.model.Student;
import sg.edu.iss.club.student.repo.StudentRepository;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentRepository srp;
	
	@RequestMapping("/all")
	public String findAllStudents(Model model) {
		ArrayList<Student> all = new ArrayList<Student>();
		all.addAll(srp.findAll());
		model.addAttribute("students", all); // first one maps to View
		return "List";
	}
	
	@RequestMapping("/load")
	public String loadStudentForm(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "form";
	}
	
	// validation for new data - add @Valid tag together with BindingResult
	@PostMapping("/addstudent")
	public String addStudent(@ModelAttribute("student") @Valid Student student, BindingResult br) {
		if(br.hasErrors()) {
			return "form";
		}
		srp.saveAndFlush(student);
		return "forward:/student/all";
	}
	
	@RequestMapping("/editload/{id}")
	public String loadEditStudentForm(@PathVariable("id") Integer id, Model model) {
		Student s = srp.findById(id).get();
		model.addAttribute("student", s);
		return "form";
	}
	
	@RequestMapping("/deletestudent/{id}")
	public String deleteStudent(@PathVariable("id") Integer id, Model model) {
		Student s =  srp.findById(id).get();
		srp.delete(s);
		return "forward:/student/all";
	}
}
