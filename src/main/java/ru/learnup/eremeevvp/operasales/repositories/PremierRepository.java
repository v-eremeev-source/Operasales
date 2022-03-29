package ru.learnup.eremeevvp.operasales.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.learnup.eremeevvp.operasales.entities.Premier;

public interface PremierRepository extends JpaRepository<Premier, Long> {
    Premier getPremierByTitleContains(String title);

    void deleteById(Long id);

    Premier getById(Long id);
}
