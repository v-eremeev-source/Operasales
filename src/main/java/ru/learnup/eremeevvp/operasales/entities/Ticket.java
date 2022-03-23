package ru.learnup.eremeevvp.operasales.entities;

import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;


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
    @JoinColumn(name = "event_id")
    @ManyToOne
    protected Premier premier;

}
