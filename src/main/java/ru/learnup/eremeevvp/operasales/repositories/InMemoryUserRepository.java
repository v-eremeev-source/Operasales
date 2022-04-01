package ru.learnup.eremeevvp.operasales.repositories;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import ru.learnup.eremeevvp.operasales.model.User;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Repository
@Slf4j
public class InMemoryUserRepository implements UserRepository {

    private Map<String, User> indb = new HashMap<>();

    private PasswordEncoder passwordEncoder;

    @Autowired
    public InMemoryUserRepository(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void init(){
        indb.put("user", new User("user", passwordEncoder.encode("user"), "ROLE_USER"));
        indb.put("admin", new User("admin", passwordEncoder.encode("admin"), "ROLE_ADMIN"));
    }

    @Override
    public User findByLogin(String login) {
        return indb.get(login);
    }
}
