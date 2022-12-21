package br.mentorama.Freebook.services;

import br.mentorama.Freebook.dto.NewUserRequest;
import br.mentorama.Freebook.entities.User;
import br.mentorama.Freebook.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    public User create(NewUserRequest newUserRequest) {
        User user = new User();
        user.setName(newUserRequest.getName());
        user.setEmail(newUserRequest.getEmail());

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String passwordDigest = passwordEncoder.encode(newUserRequest.getPassword());
        user.setPasswordDigest(passwordDigest);

        return usersRepository.save(user);
    }

    public User findByEmail(String email) {
        return usersRepository.findByEmail(email).get();
    }
}
