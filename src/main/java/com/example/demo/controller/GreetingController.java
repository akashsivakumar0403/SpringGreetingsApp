package com.example.demo.controller;
import com.example.demo.model.Greeting;
import com.example.demo.service.GreetingService;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
@RestController
@RequestMapping("/Greeting")
public class GreetingController {
	
	@Autowired
	private GreetingService greetingService;
	@GetMapping("/hello")
	public Greeting getSimpleGreeting() {
	    return greetingService.getSimpleGreeting();
	}

    @GetMapping
	public Greeting getgreeting() {
		return new Greeting(1, "Hello from GET(via Service)");
	}

	@PutMapping
	public Greeting putgreeting() {
		return new Greeting(3, "Hello from PUT(via Service)");
	}

	@PostMapping
	public Greeting postgreeting() {
		return new Greeting(2, "Hello from POST(via Service)");
	}

	@DeleteMapping
	public Greeting deletegreeting() {
		return new Greeting(4, "Hello from DELETE(via Service)");
	}

	@GetMapping("/custom")
	public Greeting getCustomGreeting(@RequestParam(required = false) String firstName,
	                                  @RequestParam(required = false) String lastName) {
	    return greetingService.getPersonalizedGreeting(firstName, lastName);
	}

	@PostMapping("/save")
	public Greeting saveGreeting(@RequestBody Greeting greeting) {
	    return greetingService.saveGreeting(greeting);
	}
	
	@GetMapping("/{id}")
	public Greeting getGreetingById(@PathVariable long id) {
	    return greetingService.findById(id);
	}
	@GetMapping("/all")
	public List<Greeting> getAllGreetings() {
	    return greetingService.getAllGreetings();
	}
	@PutMapping("/{id}")
	public Greeting updateGreeting(@PathVariable long id, @RequestBody Greeting updatedGreeting) {
	    return greetingService.updateGreeting(id, updatedGreeting);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteGreeting(@PathVariable long id) {
	    greetingService.deleteGreeting(id);
	    return ResponseEntity.ok("Greeting deleted successfully.");
	}
}
