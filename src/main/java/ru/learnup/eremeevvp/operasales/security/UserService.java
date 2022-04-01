package ru.learnup.eremeevvp.operasales.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.learnup.eremeevvp.operasales.repositories.UserRepository;
import ru.learnup.eremeevvp.operasales.model.User;

public class UserService implements UserDetailsService {

    private UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User byLogin = repository.findByLogin(username);
        if(byLogin == null){
            throw new UsernameNotFoundException("Пользователь" + username+ "Не найден");
        }

        return byLogin;
    }
}
