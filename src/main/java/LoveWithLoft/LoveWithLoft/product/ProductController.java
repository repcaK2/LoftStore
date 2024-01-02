package LoveWithLoft.LoveWithLoft.product;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

	private final ProductService productService;

	@GetMapping("/product")
	public List<Product> getProducts(){
		return productService.getProduct();
	}
}
