package LoveWithLoft.LoveWithLoft.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService{

	private final UserRepository userRepository;

	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
	}
}
