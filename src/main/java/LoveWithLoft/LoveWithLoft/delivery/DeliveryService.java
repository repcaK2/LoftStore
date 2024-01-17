package LoveWithLoft.LoveWithLoft.delivery;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeliveryService implements IDeliveryService {

	private final DeliveryRepository deliveryRepository;

	@Override
	public List<Delivery> getAll() {
		return deliveryRepository.findAll();
	}
}
