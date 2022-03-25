package ru.learnup.eremeevvp.operasales.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.Collection;

@Proxy(lazy=false)
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "premier")
public class Premier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "cathegory")
    private  String cathegory;

  @Column(name = "places")
    @OneToMany(mappedBy = "premier", fetch = FetchType.EAGER)
    private Collection<Ticket> tickets;




    @Override
    public String toString() {
        return "Название: " + title + " Описание: " + description + " Категория: " + cathegory + " Билеты: " + tickets;
    }
}
