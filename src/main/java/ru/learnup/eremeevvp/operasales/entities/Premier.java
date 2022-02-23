package ru.learnup.eremeevvp.operasales.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

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

    @OneToMany(mappedBy = "places", cascade = CascadeType.ALL)
    @JoinColumn
    protected List<Ticket> places;

    public Premier(String title, String description, String cathegory, List<Ticket> places) {
        this.title = title;
        this.description = description;
        this.cathegory = cathegory;
        this.places = places;
    }

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

    public List<Ticket> getPlaces() {
        return places;
    }

    public void setPlaces(List<Ticket> places) {
        this.places = places;
    }

    @Override
    public String toString() {
        return "Название: " + title + " Описание: " + description + " Категория: " + cathegory + " Количество мест: " + places;
    }
}
