package ru.learnup.eremeevvp.operasales.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    protected Integer price;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    protected Premier place;

    public Ticket() {
        this.price = price;
        this.place = place;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Premier getPlace() {
        return place;
    }

    public void setPlace(Premier place) {
        this.place = place;
    }
}
