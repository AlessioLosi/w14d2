package dao;

import Entities.Event;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;


public class EventsDAO {
    private final EntityManager entityManager;

    public EventsDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Event newEvent) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newEvent);
        transaction.commit();
        System.out.println("l'evento " + newEvent.titolo() + " è stato salvato correttamente nel db");
    }

    public Event findById(long eventId) throws Exception {
        Event found = entityManager.find(Event.class, eventId);
        if (found == null) throw new Exception(String.valueOf(eventId));
        return found;
    }

    public void findByIdAndDelete(long eventId) throws Exception {
        Event found = this.findById(eventId);
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(found);
        transaction.commit();
        System.out.println("L'evento" + eventId + " è stato rimosso dal DB!");
    }
}
