package org.example.models;

import javax.persistence.*;
import java.util.Arrays;

@Entity
public class Characters {

    public Characters(String name, String catchphrase){
       this.name = name;
       this.catchphrase = catchphrase;
    }
    public Characters(){};
    @Id
    @GeneratedValue
    private int id;

    private String name, catchphrase;

    @ManyToOne
    private Actors actor;

    @ManyToOne
    private Shows show;

    // Getters / Setters =======================================================
    public Shows getShow() {
        return show;
    }

    public void setShow(Shows show) {
        this.show = show;
    }

    public Actors getActor() {
        return actor;
    }

    public void setActor(Actors actor) {
        this.actor = actor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCatchphrase() {
        return catchphrase;
    }

    public void setCatchphrase(String catchphrase) {
        this.catchphrase = catchphrase;
    }
}
