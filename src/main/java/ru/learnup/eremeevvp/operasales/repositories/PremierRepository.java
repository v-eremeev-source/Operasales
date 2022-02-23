package ru.learnup.eremeevvp.operasales.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.learnup.eremeevvp.operasales.entities.Premier;

import java.util.List;

public interface PremierRepository extends JpaRepository<Premier, Integer> {

    List<Premier> getAllByTitleContains(String titleContains);
    List<Premier> getPremierByTitleContains(String title);
    Premier removePremierByTitleContains(String title);
    List<Premier> getAllByTextNotNull();
}
