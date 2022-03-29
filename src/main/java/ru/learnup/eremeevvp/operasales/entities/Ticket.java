package ru.learnup.eremeevvp.operasales.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;

@Proxy(lazy = false)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "price")
    protected Integer price;
    @JoinColumn(name = "premier_id")
    @ManyToOne
    protected Premier premier;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}




