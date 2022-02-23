package ru.learnup.eremeevvp.operasales.dao.interfaces;

import ru.learnup.eremeevvp.operasales.entities.Premier;

import java.util.List;

public interface PremierDaoInterface {
    Premier getPremierById(Integer id);
    List<Premier> getAllPremiers();
    Premier addPremier(Premier premier);
    Premier updatePremier(Premier premier);
    boolean deletePremierById(Integer id);
    Premier delitePremierByTitle(String title);
    Premier getPremierByTitle(String title);
}
