package org.example;


import org.example.models.Actors;
import org.example.models.Characters;
import org.example.models.Networks;
import org.example.models.Shows;

import javax.persistence.Persistence;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // create EntityManager
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        // access transaction object
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Actors actor = new Actors();
        actor.setFirst_name("Sab");
        actor.setLast_name("Chow");
        entityManager.persist(actor);

        Networks network = new Networks("Discovery", 40);
        entityManager.persist(network);

        List<Characters> charactersList = new ArrayList<>(){{
            Characters c = new Characters();
            c.setName("Joey");
            c.setCatchphrase("How you doing");
            add(c);
            add(new Characters("Bob","Yes I can"));
            add(new Characters("Ted","Excellent"));
        }};
        List<Shows> showsList = new ArrayList<>(){{
            add(new Shows("Friends","2","Comedy","Fri"));
            add(new Shows("Bill and Ted","5","Adventure","Sat"));
        }};
        showsList.forEach(s -> {
            network.addShowList(s);
            s.setNetwork(network);
            entityManager.persist(s);
        });
        charactersList.forEach(c -> {
            entityManager.persist(c);
            actor.addCharacter(c);
            c.setActor(actor);
        });

        charactersList.get(0).setShow(showsList.get(0));
        charactersList.get(1).setShow(showsList.get(1));
        charactersList.get(2).setShow(showsList.get(1));
        showsList.get(0).addCharacter(charactersList.get(0));
        showsList.get(1).addCharacter(charactersList.get(1));
        showsList.get(1).addCharacter(charactersList.get(2));
        transaction.commit();
        // close entity manager
        entityManager.close();
        entityManagerFactory.close();
    }
}