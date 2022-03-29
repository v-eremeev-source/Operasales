package ru.learnup.eremeevvp.operasales.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.mapstruct.Mapper;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import ru.learnup.eremeevvp.operasales.controllers.dto.TicketDto;
import ru.learnup.eremeevvp.operasales.entities.Ticket;
import ru.learnup.eremeevvp.operasales.mappers.PremierMapper;
import ru.learnup.eremeevvp.operasales.mappers.TicketMapper;
import ru.learnup.eremeevvp.operasales.repositories.TicketRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Data
@AllArgsConstructor
public class TicketService implements ApplicationContextAware {
    ApplicationContext ctx;
    TicketRepository repo;
    private final TicketMapper mapper = TicketMapper.MAPPER;

    public TicketDto buyTicket(Ticket t) {
        repo.save(t);
        return mapper.toDto(t);
    }

    public TicketDto returnTicket(Long id) {
        Ticket soldTicket = repo.getTicketById(id);
        return mapper.toDto(soldTicket);
    }

    public List<TicketDto> getTickets(Long id) {
        List<Ticket> list = repo.getTicketByPremier_Id(id);
        return mapper.toDtoAll(list);
    }

    public List<TicketDto> getAll() {
        return mapper.toDtoAll(repo.findAll());
    }

    public TicketDto getTicketById(Long id) {
        try {
            return mapper.toDto(repo.getTicketById(id));
        } catch (Exception err) {
            System.err.println(err.getMessage());
        }
        return null;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx = applicationContext;
    }
}
