package LoveWithLoft.LoveWithLoft.delivery;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DeliveryController {

	private final DeliveryService deliveryService;

	@GetMapping("/delivery")
	public List<Delivery> getAll(){
		return deliveryService.getAll();
	}
}
