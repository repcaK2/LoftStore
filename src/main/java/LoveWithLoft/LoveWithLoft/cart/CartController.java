package LoveWithLoft.LoveWithLoft.cart;

import LoveWithLoft.LoveWithLoft.product.Product;
import LoveWithLoft.LoveWithLoft.product.ProductRepository;
import LoveWithLoft.LoveWithLoft.user.User;
import LoveWithLoft.LoveWithLoft.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/profile")
public class CartController {

	private final UserRepository userRepository;
	private final ProductRepository productRepository;
	private final CartItemRepository cartItemRepository;

	@GetMapping("/cart")
	public ResponseEntity<List<CartItem>> getCurrentUserWithCart(Principal principal){
		String email = principal.getName();

		return userRepository.findByEmailWithCartItems(email)
				.map(user -> ResponseEntity.ok().body(user))
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping("/addProductToCart")
	public ResponseEntity<String> addProductToCart(
			@RequestBody Long productId,
			Principal principal
	){
		String email = principal.getName();

		User user = userRepository.findByEmail(email)
				.orElseThrow(() -> new RuntimeException("Użytkownik nie znaleziony"));

		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new RuntimeException("Produkt nie znaleziony"));

		CartItem cartItem = new CartItem();
		cartItem.setProduct(product);
		cartItem.setUser(user);

		user.getCartItems().add(cartItem);
		userRepository.save(user);

		return ResponseEntity.ok("Product dodany do koszyka");
	}

	@PostMapping("/delete")
	public ResponseEntity<String> deteleCartProductById(
			@RequestBody Long id
	){
		cartItemRepository.deleteById(id);
		return ResponseEntity.ok("Produkt został usunięty z koszyka");
	}
}