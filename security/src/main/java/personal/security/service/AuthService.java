package personal.security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import personal.security.entity.User;
import personal.security.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;

    public void signUp(String email, String password) {
        var user = new User(email, password);
        userRepository.save(user);
    }
}
