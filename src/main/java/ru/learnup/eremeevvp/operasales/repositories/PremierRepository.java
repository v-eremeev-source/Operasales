package ru.learnup.eremeevvp.operasales.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.learnup.eremeevvp.operasales.entities.Premier;

import java.util.List;

public interface PremierRepository extends JpaRepository<Premier, Long> {
    Premier getPremierByTitleContains(String title);
    void deleteById(Long id);

    Premier getById(Long id);
}
