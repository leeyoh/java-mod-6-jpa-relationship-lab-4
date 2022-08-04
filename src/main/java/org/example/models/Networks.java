package org.example.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Networks {

    @Id
    @GeneratedValue
    private int id;

    private String call_letters;
    private int channel;

    @OneToMany(mappedBy = "network")
    private List<Shows> showList = new ArrayList<>();

    public Networks(String call_letters,int channel){
        this.call_letters = call_letters;
        this.channel = channel;
    }
    public Networks(){};

    // Getters / Setters =======================================================
    public void addShowList(Shows s) {
        this.showList.add(s);
    }

    public String getCall_letters() {
        return call_letters;
    }

    public void setCall_letters(String call_letters) {
        this.call_letters = call_letters;
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }
}
