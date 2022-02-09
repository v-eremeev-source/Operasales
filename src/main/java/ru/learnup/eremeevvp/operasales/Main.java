package ru.learnup.eremeevvp.operasales;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.learnup.eremeevvp.operasales.service.SuperService;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("myConfig.xml");
        SuperService service = context.getBean(SuperService.class);

        service.doWork();
    }
}
