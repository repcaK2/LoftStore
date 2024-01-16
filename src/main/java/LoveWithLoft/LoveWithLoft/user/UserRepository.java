package LoveWithLoft.LoveWithLoft.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByEmail(String email);

	@Query("SELECT u FROM User u LEFT JOIN FETCH u.cartItems WHERE u.email = :email")
	Optional<User> findByEmailWithCartItems(String email);
}