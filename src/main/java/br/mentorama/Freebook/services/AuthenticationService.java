package br.mentorama.Freebook.services;

import br.mentorama.Freebook.entities.User;
import br.mentorama.Freebook.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService implements UserDetailsService {
    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> maybeUser = usersRepository.findByEmail(email);

        if (maybeUser.isPresent())
            return maybeUser.get();

        throw new UsernameNotFoundException("User not found");
    }
}
