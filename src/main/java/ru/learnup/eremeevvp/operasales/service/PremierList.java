package ru.learnup.eremeevvp.operasales.service;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import ru.learnup.eremeevvp.operasales.dao.PremierDao;
import ru.learnup.eremeevvp.operasales.entities.Premier;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class PremierList implements ApplicationContextAware {
    private PremierDao premierDao;
    ArrayList<Premier> playbill = new ArrayList<>();
    private ApplicationContext ctx;
    PremierDao repo = (PremierDao) premierDao;

    public PremierList(PremierDao premierDao) {
        this.premierDao = premierDao;
    }
    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        this.ctx = ctx;
    }
    public Premier addPremier() {
        Premier newPremier = new Premier();
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите название:");
        newPremier.setTitle(sc.nextLine());
        System.out.println("Введите описание:");
        newPremier.setDescription(sc.nextLine());
        System.out.println("Введите категорию:");
        newPremier.setCathegory(sc.nextLine());
        playbill.add(newPremier);
        System.out.println("Премьера " + newPremier.getTitle() + " успешно добавлена");
        repo.addPremier(newPremier);
        return newPremier;
    }

    public ArrayList<Premier> removePremier() {
        String title;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите оперу,которую хотите удалить:");
        title = sc.nextLine();
        for (Premier opera : playbill) {
            if (opera.getTitle().contains(title)) {
                playbill.remove(opera);
                repo.delitePremierByTitle(title);
                System.out.println("Опера удалена,текущая афиша:");
                return playbill;
            }
        }
        return null;
    }

    public List<Premier> showAllPremier() {
        System.out.println("Список всех премьер:");
        return repo.getAllPremiers();
    }

    public Premier showOnePremier(String title) {
        return repo.getPremierByTitle(title);
    }
}
