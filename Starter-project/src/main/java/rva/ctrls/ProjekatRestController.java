package rva.ctrls;

import java.util.Collection;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import rva.jpa.Projekat;
import rva.repository.ProjekatRepository;

@RestController
public class ProjekatRestController {

	@Autowired
	public ProjekatRepository projekatRepository;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@GetMapping("projekat")
	public Collection<Projekat> getProjekti() {

		return projekatRepository.findAll();
	}

	@GetMapping("projekat/{id}")
	public Projekat getProjekat(@PathVariable("id") Integer id) {

		return projekatRepository.getOne(id);
	}

	@GetMapping("projekatNaziv/{naziv}")
	public Collection<Projekat> getProjektiByNaziv(@PathVariable("naziv") String naziv) {

		return projekatRepository.findByNazivContainingIgnoreCase(naziv);

	}

	@PostMapping("projekat")
	public ResponseEntity<Projekat> insertProjekat(@RequestBody Projekat projekat) {

		if (!projekatRepository.existsById(projekat.getId())) {
			projekatRepository.save(projekat);
			return new ResponseEntity<Projekat>(HttpStatus.OK);
		}

		return new ResponseEntity<Projekat>(HttpStatus.CONFLICT);
	}

	@PutMapping("projekat")
	public ResponseEntity<Projekat> updateProjekat(@RequestBody Projekat projekat) {

		if (!projekatRepository.existsById(projekat.getId()))
			return new ResponseEntity<Projekat>(HttpStatus.CONFLICT);

		projekatRepository.save(projekat);
		return new ResponseEntity<Projekat>(HttpStatus.OK);

	}
	
	@DeleteMapping("projekat/{id}")
	public ResponseEntity<Projekat> deleteProjekat (@PathVariable ("id") Integer id) {
		
		if(!projekatRepository.existsById(id)) {
			
			return new ResponseEntity<Projekat>(HttpStatus.NO_CONTENT);
		}
		
		projekatRepository.deleteById(id); 
		
		if(id==-100)
		{
			jdbcTemplate.execute("INSERT INTO \"projekat\" (\"id\", \"naziv\", \"oznaka\", \"opis\") "
					+ "VALUES(-100, 'test', 'test','test')");
		}
		return new ResponseEntity<Projekat>(HttpStatus.OK);
	}

	
	
	
	
	
	
	
	
}
