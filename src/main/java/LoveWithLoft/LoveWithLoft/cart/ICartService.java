package LoveWithLoft.LoveWithLoft.cart;

import java.util.Optional;

public interface ICartService{

	Optional<CartItem> deleteCartItemById(Long id);
}
