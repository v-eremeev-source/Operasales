package ru.learnup.eremeevvp.operasales.repositories;


import ru.learnup.eremeevvp.operasales.model.User;

public interface UserRepository {
    User findByLogin(String login);
}
