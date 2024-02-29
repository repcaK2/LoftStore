package LoveWithLoft.LoveWithLoft.delivery;

import jakarta.transaction.Transactional;
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

	@Transactional
	public void updateStatus(Long id, String status) {
		Delivery delivery = deliveryRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Nie znaleziono dostawy z id: " + id));
		delivery.setStatus(status);
		deliveryRepository.save(delivery);
	}
}
