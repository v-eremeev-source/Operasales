package ru.learnup.eremeevvp.operasales.service;

public class Premier {
    protected String title;
    protected String description;
    protected String cathegory;
    protected Integer places;

    public Premier() {
        this.title = title;
        this.description = description;
        this.cathegory = cathegory;
        this.places = places;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCathegory() {
        return cathegory;
    }

    public void setCathegory(String cathegory) {
        this.cathegory = cathegory;
    }

    public Integer getPlaces() {
        return places;
    }

    public void setPlaces(Integer places) {
        this.places = places;
    }

    @Override
    public String toString() {
        return "Название: " + title + " Описание: " + description + " Категория: " + cathegory + " Количество мест: " + places;
    }
}
