package ru.learnup.eremeevvp.operasales.service;


import org.mapstruct.Mapper;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.learnup.eremeevvp.operasales.controllers.dto.PremierDto;
import ru.learnup.eremeevvp.operasales.entities.Premier;
import ru.learnup.eremeevvp.operasales.mappers.PremierMapper;
import ru.learnup.eremeevvp.operasales.repositories.PremierRepository;

import javax.persistence.LockModeType;
import java.io.IOException;
import java.util.List;

@Service
public class PremierList implements ApplicationContextAware {
    private ApplicationContext ctx;
    private PremierRepository repo;
    private final PremierMapper mapper = PremierMapper.MAPPER;

    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        this.ctx = ctx;
    }

    @Autowired
    public PremierList(PremierRepository repo) {
        this.repo = repo;
    }

    public PremierDto addPremier(PremierDto dto) {
        Premier p = mapper.toEntity(dto);
        repo.save(p);
        return mapper.toDto(p);
    }

    @Lock(value = LockModeType.PESSIMISTIC_WRITE)
    public PremierDto getPremierById(Long id) {
        try {
            return mapper.toDto(repo.getById(id));
        } catch (Exception err) {
            System.err.println(err.getMessage());
        }

        return null;
    }

    @Transactional(propagation = Propagation.REQUIRED,
            isolation = Isolation.DEFAULT,
            timeout = 3,
            rollbackFor = {IOException.class},
            noRollbackFor = {RuntimeException.class}
    )
    public PremierDto editPremier(PremierDto dto) {
        try {
            Premier premier = mapper.toEntity(dto);
            repo.save(premier);
            return mapper.toDto(premier);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    public void deletePremier(Long id) {
        repo.deleteById(id);
    }

    public List<PremierDto> getAll() {
        return mapper.toDtoAll(repo.findAll());
    }


}
