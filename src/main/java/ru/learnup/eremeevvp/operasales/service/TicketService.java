package ru.learnup.eremeevvp.operasales.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import ru.learnup.eremeevvp.operasales.annotations.Notifierable;
import ru.learnup.eremeevvp.operasales.entities.Premier;
import ru.learnup.eremeevvp.operasales.entities.Ticket;
import ru.learnup.eremeevvp.operasales.repositories.TicketRepository;

import java.util.Scanner;

@Service
public class TicketService {
    private String success;
    private PremierList list;
    ApplicationContext ctx;
    TicketRepository repository;

    @Autowired
    public TicketService(PremierList list) {
        this.list = list;
    }

    @Notifierable
    public void buyTicket(Ticket t) {
        repository.save(t);
    }

    @Notifierable
    public void returnTicket(Integer id) {
        repository.deleteById(id);
    }
}
