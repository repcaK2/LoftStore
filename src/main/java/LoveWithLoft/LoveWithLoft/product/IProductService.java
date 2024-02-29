package LoveWithLoft.LoveWithLoft.product;

import java.util.List;
import java.util.Optional;

public interface IProductService {

	List<Product> getProducts();
	Optional<Product> getProductById(Long id);
}