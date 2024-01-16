package LoveWithLoft.LoveWithLoft.auth;

import LoveWithLoft.LoveWithLoft.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin
@RequiredArgsConstructor
public class AuthenticationController {

	private final AuthenticationService service;
	private final UserService userService;

	@PostMapping("/register")
	public ResponseEntity<AuthenticationResponse> register(
			@RequestBody RegisterRequest request
	) {

		return ResponseEntity.ok(service.register(request));
	}

	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationResponse> authenticate(
			@RequestBody AuthenticationRequest request
	) {
		// Autentykacja i otrzymanie obiektu AuthenticationResponse
		return ResponseEntity.ok(service.authenticate(request));
	}
}