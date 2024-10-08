package org.example;

import Entities.Event;
import Entities.EventType;
import dao.EventsDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("w14d2");

    public static void main(String[] args) {
        System.out.println("Hello World!");

        EntityManager em = emf.createEntityManager();
        EventsDAO sd = new EventsDAO(em);
        Event concerto = new Event("Olivia Rodrigo", LocalDate.now().minusDays(12), "evento musicale", 932432, EventType.PRIVATO);
        sd.save(concerto);
        Event festa = new Event("TS", LocalDate.now().minusDays(2), "evento musicale", 12, EventType.PRIVATO);
        sd.save(festa);
        Event concerto1 = new Event("Sabrina Carpenter", LocalDate.now().plusDays(122), "evento musicale", 123434, EventType.PUBBLICO);
        sd.save(concerto1);
        Event abba = new Event("Abba", LocalDate.now().plusWeeks(12), "evento musicale", 94535, EventType.PRIVATO);
        sd.save(abba);
        Event concerto2 = new Event("Gracie Abrams", LocalDate.now().plusYears(1), "evento musicale", 435353, EventType.PUBBLICO);
        sd.save(concerto2);
        try {
            Event fromDb = sd.findById(1);
            System.out.println(fromDb);
            sd.findByIdAndDelete(4);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        em.close();
        emf.close();
    }
}
