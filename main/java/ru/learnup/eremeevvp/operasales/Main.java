package ru.learnup.eremeevvp.operasales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import ru.learnup.eremeevvp.operasales.dao.PremierDao;
import ru.learnup.eremeevvp.operasales.repositories.PremierRepository;
import ru.learnup.eremeevvp.operasales.repositories.TicketRepository;
import ru.learnup.eremeevvp.operasales.service.PremierList;
import ru.learnup.eremeevvp.operasales.service.TicketService;

@SpringBootApplication

public class Main {
    public static void main(String[] args) {
        final ConfigurableApplicationContext ctx = SpringApplication.run(Main.class,args);
        ctx.getBean(PremierList.class).addPremier();
        ctx.getBean(PremierList.class).addPremier();
        System.out.println(ctx.getBean(PremierList.class).removePremier());
        System.out.println(ctx.getBean(PremierList.class).showAllPremier());
        System.out.println(ctx.getBean(PremierList.class).showOnePremier("Опера2"));
//        System.out.println(ctx.getBean(TicketService.class).buyTicket("Опера2", "2 ряд 1 место"));
//        System.out.println(ctx.getBean(TicketService.class).returnTicket("Опера2", "2 ряд 1 место"));
    }
    @Bean
    public PremierDao PremierDaoData(TicketRepository ticketRepository, PremierRepository premierRepository) {
        return new PremierDao(premierRepository, ticketRepository);
    }
}
