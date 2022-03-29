package ru.learnup.eremeevvp.operasales.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.learnup.eremeevvp.operasales.controllers.dto.PremierDto;
import ru.learnup.eremeevvp.operasales.mappers.PremierMapper;
import ru.learnup.eremeevvp.operasales.service.PremierList;
import ru.learnup.eremeevvp.operasales.service.TicketService;

import java.util.Collection;

@RestController
@RequestMapping("/premiers")
public class PremierController {
    private PremierList premierList;


    @Autowired
    public PremierController(PremierList premierList) {

        this.premierList = premierList;

    }

    @GetMapping("/list")
    public Collection<PremierDto> getPremiers() {
        return premierList.getAll();
    }

    @GetMapping("/{id}")
    public PremierDto get(@PathVariable("id") long id) {
        return premierList.getPremierById(id);
    }

    @PostMapping("/new")
    public PremierDto create(@RequestBody PremierDto premierDto) {
        return premierList.addPremier(premierDto);
    }

    @PutMapping("/{id}")
    public PremierDto update(@PathVariable("id") Long id, @RequestBody PremierDto premierDto) {
        return premierList.editPremier(premierDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        premierList.deletePremier(id);
    }

}
