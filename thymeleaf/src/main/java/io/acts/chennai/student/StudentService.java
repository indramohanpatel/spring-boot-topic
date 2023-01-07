package io.acts.chennai.student;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public List<Student> getAllStudents(){
		return studentRepository.findAll();
	}
	
	public Student getAllStudents(Long id){
		Optional<Student> optional = studentRepository.findById(id);
		Student student = null;
		if(optional.isPresent()) {
			student = optional.get();
		}else {
			throw new RuntimeException("Student not found for id : " + id );
		}
		return student;
	}

	public void addStudent(Student Student) {
		studentRepository.save(Student);
	}

	public void updateStudent(Student Student, Long id) {
		studentRepository.save(Student);
	}

	public void deleteStudent(Long id) {
		studentRepository.deleteById(id);
	}
}
