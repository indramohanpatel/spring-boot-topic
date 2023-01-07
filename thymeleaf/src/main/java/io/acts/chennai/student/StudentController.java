package io.acts.chennai.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("message", "Hello World");
		return "helloworld";
	}
	
	@RequestMapping("/")
	public String getAllStudents(Model model){
		model.addAttribute("allStudentsList", studentService.getAllStudents());
        return "index";
	}
	
	@RequestMapping("/student/{id}")
	public Student getAllStudents(@PathVariable("id") Long id){
		return studentService.getAllStudents(id);
	}
	
//	@RequestMapping(method=RequestMethod.POST,value="/Students")
//	OR
//	@PostMapping("/Student")
	
	@PostMapping("/addStudent")
	public void addStudent(@RequestBody Student Student){
		studentService.addStudent(Student);
	}
	
	@PutMapping("/updateStudent/{id}")
	public void updateStudent(@RequestBody Student Student,@PathVariable("id") Long id){
		studentService.updateStudent(Student,id);
	}
	
	@DeleteMapping("/deleteStudent/{id}")
	public void deleteStudent(@PathVariable("id") Long id)
	{
		studentService.deleteStudent(id);
	}
	
	
}
