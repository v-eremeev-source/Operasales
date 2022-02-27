package ru.learnup.eremeevvp.operasales.dao;


import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import ru.learnup.eremeevvp.operasales.dao.interfaces.PremierDaoInterface;
import ru.learnup.eremeevvp.operasales.entities.Premier;
import ru.learnup.eremeevvp.operasales.repositories.PremierRepository;
import ru.learnup.eremeevvp.operasales.repositories.TicketRepository;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
public class PremierDao implements PremierDaoInterface {
    private final PremierRepository premierRepository;
    private final TicketRepository ticketRepository;

    public PremierDao(PremierRepository premierRepository, TicketRepository ticketRepository) {
        this.premierRepository = premierRepository;
        this.ticketRepository = ticketRepository;
    }
    @Override
    public Premier getPremierById(Long id) {
        return premierRepository.getOne(id);
    }
    @Override
    public List<Premier> getAllPremiers(){
        return premierRepository.findAll();
    }
    @Override
    public Premier addPremier(Premier premier){
        return premierRepository.save(premier);
    }
    @Override
    public Premier updatePremier(Premier premier){
        return addPremier(premier);
    }
    @Override
    public boolean deletePremierById(Long id){
        premierRepository.deleteById(id);
        return true;
    }
    @Override
    public Premier getPremierByTitle(String title){

        return premierRepository.getPremierByTitleContains(title);
    }
}
