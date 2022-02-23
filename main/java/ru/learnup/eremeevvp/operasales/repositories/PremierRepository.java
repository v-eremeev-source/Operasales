package ru.learnup.eremeevvp.operasales.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.learnup.eremeevvp.operasales.entities.Premier;

import java.util.List;

public interface PremierRepository extends JpaRepository<Premier, Integer> {
    Premier save(Premier premier);
    Premier getPremierByTitleContains(String title);
    Premier removePremierByTitleContains(String title);

}
