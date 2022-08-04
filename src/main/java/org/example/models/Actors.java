package org.example.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Actors {
    @Id
    @GeneratedValue
    private int id;
    private String first_name, last_name;
    @OneToMany(mappedBy = "actor")
    private List<Characters> charactersList = new ArrayList<Characters>();

    // Getters / Setters =======================================================
    public void addCharacter(Characters c) {
        charactersList.add(c);
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
}
