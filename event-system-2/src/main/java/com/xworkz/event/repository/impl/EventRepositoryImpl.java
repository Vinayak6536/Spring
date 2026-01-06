package com.xworkz.event.repository.impl;

import com.xworkz.event.entity.EventEntity;
import com.xworkz.event.repository.EventRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Optional;

@Repository
public class EventRepositoryImpl implements EventRepository {
    @Override
    public boolean save(EventEntity eventEntity) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinayak-xworkz");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(eventEntity);
        entityManager.getTransaction().commit();
        entityManager.close();
        return false;
    }

    @Override
    public Optional<EventEntity> getEvent(int id) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinayak-xworkz");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        EventEntity eventEntity = entityManager.find(EventEntity.class, id);
        entityManager.getTransaction().commit();
        if (eventEntity != null) {
            return Optional.of(eventEntity);
        }
        return Optional.empty();
    }

    @Override
    public boolean updateTimeById(int id, int time) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinayak-xworkz");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        EventEntity eventEntity = entityManager.find(EventEntity.class, id);
        if (eventEntity != null) {
            eventEntity.setTime(time);
            entityManager.merge(eventEntity);
        }
        entityManager.getTransaction().commit();

        return true;
    }

    @Override
    public boolean deleteById(int id) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinayak-xworkz");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        EventEntity eventEntity = entityManager.find(EventEntity.class, id);
        if (eventEntity != null) {
            entityManager.remove(eventEntity);
        }
        entityManager.getTransaction().commit();

        return true;
    }
}
