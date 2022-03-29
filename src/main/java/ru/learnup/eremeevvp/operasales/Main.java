package ru.learnup.eremeevvp.operasales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication

public class Main {
    public static void main(String[] args) {
        final ConfigurableApplicationContext ctx = SpringApplication.run(Main.class,args);

    }

}
