package ru.learnup.eremeevvp.operasales.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.learnup.eremeevvp.operasales.entities.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
}
