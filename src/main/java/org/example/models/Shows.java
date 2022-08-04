package org.example.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Shows {
    public Shows(String name, String season, String genere, String day){
        this.name = name;
        this.season = season;
        this.genre = genere;
        this.day = day;
    };
    public Shows(){};
    @Id
    @GeneratedValue
    private int id;
    //can't name showDay as 'day' search for look around later.
    private String name, season, genre;

    @Column(name = "`day`")
    private String day;

    @OneToMany(mappedBy = "show")
    private List<Characters> charactersList = new ArrayList<Characters>();

    @ManyToOne
    private Networks network;

    // Getters / Setters =======================================================
    public Networks getNetwork() {
        return network;
    }

    public void setNetwork(Networks network) {
        this.network = network;
    }

    public List<Characters> getCharactersList() {
        return charactersList;
    }

    public void addCharacter(Characters c) {
        this.charactersList.add(c);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String showDay) {
        this.day = showDay;
    }
}