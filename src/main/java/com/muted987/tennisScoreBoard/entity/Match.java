package com.muted987.tennisScoreBoard.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="MATCHES", schema="TENNISSCOREBOARD")
public class Match {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="player1_id")
    private Player player1;

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="player2_id")
    private Player player2;

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="playerWinner_id")
    private Player winner;

}
