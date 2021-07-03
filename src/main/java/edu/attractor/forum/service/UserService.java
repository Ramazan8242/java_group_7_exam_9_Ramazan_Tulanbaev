package edu.attractor.forum.service;

import edu.attractor.forum.dto.UserResponseDTO;
import edu.attractor.forum.exeption.UserAlreadyRegisteredException;
import edu.attractor.forum.exeption.UserNotFoundException;
import edu.attractor.forum.exeption.UserRegisterForm;
import edu.attractor.forum.model.User;
import edu.attractor.forum.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final PasswordEncoder encoder;

    public UserResponseDTO register(UserRegisterForm form) {
        if (repository.existsByEmail(form.getEmail())) {
            throw new UserAlreadyRegisteredException();
        }

        var user = User.builder()
                .email(form.getEmail())
                .username(form.getName())
                .password(encoder.encode(form.getPassword()))
                .build();

        repository.save(user);

        return UserResponseDTO.from(user);
    }

    public User getByEmail(String email) {
        return repository.findByEmail(email).orElseThrow(UserNotFoundException::new);
    }
}
