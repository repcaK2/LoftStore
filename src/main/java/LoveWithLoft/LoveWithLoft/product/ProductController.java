package LoveWithLoft.LoveWithLoft.product;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/produkty")
public class ProductController {

	private final ProductService productService;

	@GetMapping("/all")
	public List<Product> getAll(){
		return productService.getProducts();
	}

	@PostMapping("product")
	public ResponseEntity<Product> getProductById(
			@RequestBody Long id
	) {
		return productService.getProductById(id)
				.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}
}