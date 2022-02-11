package ru.learnup.eremeevvp.operasales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.learnup.eremeevvp.operasales.service.PremierList;
import ru.learnup.eremeevvp.operasales.service.TicketService;

@SpringBootApplication(scanBasePackages = {"ru.learnup.eremeevvp.operasales.service"})

public class Main {
    public static void main(String[] args) {
        final ConfigurableApplicationContext ctx = SpringApplication.run(Main.class);
        ctx.getBean(PremierList.class).addPremier();
        ctx.getBean(PremierList.class).addPremier();
        System.out.println(ctx.getBean(PremierList.class).removePremier());
        System.out.println(ctx.getBean(PremierList.class).showAllPremier());
        System.out.println(ctx.getBean(PremierList.class).showOnePremier("Опера2"));
        System.out.println(ctx.getBean(TicketService.class).buyTicket("Опера2", "2 ряд 1 место"));
        System.out.println(ctx.getBean(TicketService.class).returnTicket("Опера2", "2 ряд 1 место"));
    }
}
