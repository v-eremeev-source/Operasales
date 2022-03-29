package ru.learnup.eremeevvp.operasales.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.learnup.eremeevvp.operasales.controllers.dto.PremierDto;
import ru.learnup.eremeevvp.operasales.controllers.dto.TicketDto;
import ru.learnup.eremeevvp.operasales.entities.Premier;
import ru.learnup.eremeevvp.operasales.entities.Ticket;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TicketMapper {
    TicketMapper MAPPER = Mappers.getMapper(TicketMapper.class);

    TicketDto toDto(Ticket ticket);

    Ticket toEntity(TicketDto ticketDto);

    List<TicketDto> toDtoAll(List<Ticket> tickets);
}
