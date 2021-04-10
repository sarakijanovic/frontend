package rva.ctrls;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import rva.jpa.Student;
import rva.repository.StudentRepository;

@RestController
public class StudentRestController {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@GetMapping("student")
	public Collection<Student> getStudenti() {
		return studentRepository.findAll();
	}

	@GetMapping("student/{id}")
	public Student getStudent(@PathVariable("id") Integer id) {

		return studentRepository.getOne(id);
	}

	@GetMapping("studentBrInd/{brojIndeksa}")
	public Collection<Student> getStudentiByBrInd(@PathVariable("brojIndeksa") String brojIndeksa) {

		return studentRepository.findByBrojIndeksaContainingIgnoreCase(brojIndeksa);
	}

	@PostMapping("student")
	public ResponseEntity<Student> insertStudent(@RequestBody Student student) {

		if (!studentRepository.existsById(student.getId())) {

			studentRepository.save(student);
			return new ResponseEntity<Student>(HttpStatus.OK);
		}

		return new ResponseEntity<Student>(HttpStatus.CONFLICT);
	}

	@PutMapping("student")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student) {

		if (studentRepository.existsById(student.getId())) {

			studentRepository.save(student);
			return new ResponseEntity<Student>(HttpStatus.OK);
		}
		return new ResponseEntity<Student>(HttpStatus.CONFLICT);

	}

	@DeleteMapping("student/{id}")
	public ResponseEntity<Student> deleteStudent(@PathVariable("id") Integer id) {

		if (!studentRepository.existsById(id))
			return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);

		studentRepository.deleteById(id);

		if (id == -100) {
			jdbcTemplate.execute(
					"INSERT INTO \"student\"(\"id\", \"ime\", \"prezime\", \"broj_indeksa\", \"grupa\", \"projekat\") "
							+ "VALUES (-100, 'test', 'test', 'test', 1, 1)");

		}

		return new ResponseEntity<Student>(HttpStatus.OK);
	}

}
