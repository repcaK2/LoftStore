package LoveWithLoft.LoveWithLoft.cart;

import LoveWithLoft.LoveWithLoft.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
public class CartItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long productId; // ID produktu z innej tabeli
	private String name;    // Nazwa produktu
	private Long price;     // Cena produktu

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	@ToString.Exclude
	@JsonIgnore
	private User user; // Referencja wsteczna do User
}
