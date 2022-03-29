package ru.learnup.eremeevvp.operasales.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.learnup.eremeevvp.operasales.controllers.dto.TicketDto;
import ru.learnup.eremeevvp.operasales.mappers.TicketMapper;
import ru.learnup.eremeevvp.operasales.service.TicketService;

import java.util.Collection;


@RestController
@RequestMapping("/tickets")
public class TicketController {
    private TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping
    public Collection<TicketDto> tickets() {
        return ticketService.getAll();
    }

    @GetMapping("/{id}")
    public TicketDto getTicket(@PathVariable long id) {
        return ticketService.getTicketById(id);
    }

    @GetMapping("/{id}/sell")
    public TicketDto sellTicket(@PathVariable long id) {
        return ticketService.returnTicket(id);
    }

}
