package LoveWithLoft.LoveWithLoft.demo;

import LoveWithLoft.LoveWithLoft.user.User;
import LoveWithLoft.LoveWithLoft.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/demo-controller")
@RequiredArgsConstructor
public class DemoRestController {

	private final UserRepository userRepository;

	@GetMapping("/secure")
	public ResponseEntity<String> sayHello(){
		return ResponseEntity.ok("Hello form secured endpoint");
	}

	@GetMapping("/info")
	public String getInfo(Principal principal){
		return principal.toString();
	}

	@GetMapping("/me")
	public ResponseEntity<User> getCurrentUserWithCart(Principal principal){
		String email = principal.getName();

		return userRepository.findByEmailWithCartItems(email)
				.map(user -> ResponseEntity.ok().body(user))
				.orElseGet(() -> ResponseEntity.notFound().build());
	}
}
