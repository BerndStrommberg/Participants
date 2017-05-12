package application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/participants")
public class ParticipantController {

	
	@Autowired //get Bean called userRepository
	private ParticipantRepository participantRepository;
	
	
	
	
	//ResponseBody ggf nicht nötig
	@GetMapping(path="/add")
	public @ResponseBody String addNewParticipant(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email) {
		Participant n = new Participant();
		n.setFirstName(firstName);
		n.setLastname(lastName);
		n.setEmail(email);
		participantRepository.save(n);		
		return "Added";
	}
	
	
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Participant> getAllParticipant() {
		return participantRepository.findAll();
	}
	
	
	
	

}
