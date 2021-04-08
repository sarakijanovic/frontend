package rva.ctrls;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import rva.jpa.Smer;
import rva.repository.SmerRepository;

@RestController
public class SmerRestController {
	
	@Autowired
	private SmerRepository smerRepository; 
	
	
	//vracamo sve smerove - dakle kolekcija ti treba
	@GetMapping("smer")
	public Collection<Smer> getSmerovi () {
		
		return smerRepository.findAll();
	}
	
	//preko id-ja
	@GetMapping("smer/{id}")
	public Smer getSmer(@PathVariable ("id") Integer id) {
		
		return smerRepository.getOne(id);
	}
	
	//izlistava one koji imaju ovaj string u svom nazivu
	
	@GetMapping("smerNaziv/{naziv}")
	public Collection<Smer> getSmerByNaziv (@PathVariable ("naziv") String naziv) {
		
		return smerRepository.findByNazivContainingIgnoreCase(naziv);
	}

}
