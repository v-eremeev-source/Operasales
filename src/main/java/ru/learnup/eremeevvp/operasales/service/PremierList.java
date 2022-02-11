package ru.learnup.eremeevvp.operasales.service;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Scanner;

@Component
public class PremierList {
    ArrayList<Premier> playbill = new ArrayList<>();

    public void addPremier() {
        Premier newPremier = new Premier();
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите название:");
        newPremier.setTitle(sc.nextLine());
        System.out.println("Введите описание:");
        newPremier.setDescription(sc.nextLine());
        System.out.println("Введите категорию:");
        newPremier.setCathegory(sc.nextLine());
        System.out.println("Введите количество мест:");
        newPremier.setPlaces(sc.nextInt());
        playbill.add(newPremier);
        System.out.println("Премьера " + newPremier.getTitle() + " успешно добавлена");
    }

    public ArrayList<Premier> removePremier() {
        String title;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите оперу,которую хотите удалить:");
        title = sc.nextLine();
        for (Premier opera : playbill) {
            if (opera.getTitle().contains(title)) {
                playbill.remove(opera);
                System.out.println("Опера удалена,текущая афиша:");
                return playbill;
            }
        }
        return null;
    }

    public ArrayList<Premier> showAllPremier() {
        System.out.println("Список всех премьер:");
        return playbill;
    }

    public Premier showOnePremier(String title) {
        for (Premier opera : playbill) {
            if (opera.getTitle().contains(title)) {
                return opera;
            }
        }
        return null;
    }
}
