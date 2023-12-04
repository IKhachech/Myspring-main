package com.imen.tennis.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Stats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStat;
    
    @Column(name = "name_player")
    private String namePlayer;
    private String nationality;
    private int ranking;
    private int titlesWon;

    @OneToMany(mappedBy = "stats")
    @JsonIgnore
    private List<WTA_Tour> wta_Tour;
    // Getters and setters for the fields

    public Long getIdStat() {
        return idStat;
    }

    public void setIdStat(Long idStat) {
        this.idStat = idStat;
    }

    public String getNamePlayer() {
        return namePlayer;
    }

    public void setNamePlayer(String namePlayer) {
        this.namePlayer = namePlayer;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public int getTitlesWon() {
        return titlesWon;
    }

    public void setTitlesWon(int titlesWon) {
        this.titlesWon = titlesWon;
    }

}
