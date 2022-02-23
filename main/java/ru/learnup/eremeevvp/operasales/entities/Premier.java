package ru.learnup.eremeevvp.operasales.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "premier")
public class Premier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    @Column
    protected String title;
    @Column
    protected String description;
    @Column
    protected String cathegory;

  @Column
    protected String places;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getPlaces() {
        return places;
    }

    public void setPlaces(String places) {
        this.places = places;
    }

    @Override
    public String toString() {
        return "Название: " + title + " Описание: " + description + " Категория: " + cathegory + " Количество мест: " + places;
    }
}
