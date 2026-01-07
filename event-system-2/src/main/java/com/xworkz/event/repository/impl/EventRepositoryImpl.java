package com.xworkz.event.repository.impl;

import com.xworkz.event.entity.EventEntity;
import com.xworkz.event.repository.EventRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Repository
public class EventRepositoryImpl implements EventRepository {
    EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinayak-xworkz");
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

    @Override
    public EventEntity getEventByName(String eventName) {

        EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinayak-xworkz");
        EntityManager entityManager= entityManagerFactory.createEntityManager();
        Query query=entityManager.createQuery("select getname from EventEntity getname where getname.eventName= :ename");
        query.setParameter("ename",eventName);
        EventEntity eventEntity= (EventEntity) query.getSingleResult();

        return eventEntity;
    }

    @Override
    public List<EventEntity> getEventByTime(int time) {

        return (List<EventEntity>) entityManagerFactory.createEntityManager().createQuery("select bytime from EventEntity bytime where bytime.time= :etime").setParameter("etime",time).getResultList();
    }

    @Override
    public Object[] getEventManagerAndLocationByName(String name) {

          EntityManager manager = entityManagerFactory.createEntityManager();
        Object[] getName=(Object[])  manager.createQuery("select name.eventManager,name.location from EventEntity name where name.eventName= :ename").setParameter("ename",name).getSingleResult();
        manager.close();
        return getName;

    }

    @Override
    public List<EventEntity> getAllEventlist() {
        List<EventEntity> list=entityManagerFactory.createEntityManager().createQuery("from EventEntity").getResultList();
        return list;
    }

    @Override
    public Object getLocationByTime(int time) {
        return (Object) entityManagerFactory.createEntityManager().createQuery("select times.location from EventEntity times where times.time= :etime").setParameter("etime",time).getResultList();
    }

    @Override
    public String getEventNameByManager(String manager) {

        return (String) entityManagerFactory.createEntityManager().createQuery("select managers.eventName from EventEntity managers where managers.eventManager= :manage").setParameter("manage",manager).getSingleResult();
    }

    @Override
    public List<String> getAllManagerName() {
        List<String> strings=entityManagerFactory.createEntityManager().createQuery("select managers.eventManager from EventEntity managers").getResultList();
        return strings;
    }
}
