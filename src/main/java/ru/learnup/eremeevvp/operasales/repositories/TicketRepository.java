package ru.learnup.eremeevvp.operasales.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.learnup.eremeevvp.operasales.entities.Ticket;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    public List<Ticket> getTicketByPremier_Id(Long id);

    public Ticket getTicketById(Long id);
}
