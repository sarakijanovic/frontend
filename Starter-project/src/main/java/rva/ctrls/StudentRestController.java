package rva.ctrls;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import rva.jpa.Student;
import rva.repository.StudentRepository;

@RestController
public class StudentRestController {
	//MOGLA BI DA DODAS DA AKO SE OBRISE PROJEKAT DA SE OBRISE I STUDENT NA TOM PROJEKTU 
	
	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping("student")
	public Collection<Student> getStudenti() {
		return studentRepository.findAll();
	}
	
	@GetMapping("student/{id}")
	public Student getStudent(@PathVariable ("id") Integer id) {
		
		return studentRepository.getOne(id);
	}
	
	@GetMapping("studentBrInd/{brojIndeksa}")
	public Collection <Student> getStudentiByBrInd(@PathVariable ("brojIndeksa") String brojIndeksa) {
		
		return studentRepository.findByBrojIndeksaContainingIgnoreCase(brojIndeksa);
	}
	
}
