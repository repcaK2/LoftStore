package LoveWithLoft.LoveWithLoft.cart;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartService {

	private final CartItemRepository cartItemRepository;

}
