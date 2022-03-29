package ru.learnup.eremeevvp.operasales.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.learnup.eremeevvp.operasales.controllers.dto.PremierDto;
import ru.learnup.eremeevvp.operasales.entities.Premier;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PremierMapper {
    PremierMapper MAPPER = Mappers.getMapper(PremierMapper.class);
    PremierDto toDto(Premier premier);
    Premier toEntity(PremierDto premierDto);

    List<PremierDto> toDtoAll(List<Premier> premiers);
}