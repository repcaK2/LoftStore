package LoveWithLoft.LoveWithLoft.delivery;

import LoveWithLoft.LoveWithLoft.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class DeliveryController {

	private final DeliveryService deliveryService;
	private final UserRepository userRepository;
	private final DeliveryRepository deliveryRepository;

	@GetMapping("/delivery/AllDeliveries")
	public List<Delivery> getAll(){
		return deliveryService.getAll();
	}

	@GetMapping("DeliveryForEach/user")
	ResponseEntity<List<Delivery>> getCurrentUserWithDelivery(
			Principal principal
	){
		String email = principal.getName();

		return userRepository.findByEmailWithDelivery(email)
				.map(user -> ResponseEntity.ok().body(user))
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping("/delivery/changeStatus")
	public ResponseEntity<String> ChangeStatus(
			@RequestParam("id") Long deliveryId,
			@RequestParam("status") String deliveryStatus
	){
		Delivery delivery = deliveryRepository.findById(deliveryId)
				.orElseThrow(()-> new IllegalArgumentException("Nie znaleziono zamowienia z tym id"));
		delivery.setStatus(deliveryStatus);
		deliveryRepository.save(delivery);
		return ResponseEntity.ok("Status został zaktualizowany");
	}
}