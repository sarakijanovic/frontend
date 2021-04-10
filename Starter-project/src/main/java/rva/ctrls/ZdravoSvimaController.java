package rva.ctrls;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ZdravoSvimaController {
	
	@RequestMapping("/")
	public String zdravoSvima() {
		return "Zdravo svima i šta imaaaaaa?";
	}

}
