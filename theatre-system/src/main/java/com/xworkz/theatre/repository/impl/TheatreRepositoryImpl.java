package com.xworkz.theatre.repository.impl;

import com.xworkz.theatre.entity.TheatreEntity;
import com.xworkz.theatre.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Repository

public class TheatreRepositoryImpl implements TheatreRepository {
    @Autowired
    private EntityManagerFactory factory;

    @Override
    public boolean save(TheatreEntity theatreEntity) {
        EntityManager entityManager=factory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(theatreEntity);
        entityManager.getTransaction().commit();
        return true;
    }

    @Override
    public List<TheatreEntity> viewTheatres() {
        List<TheatreEntity> viewTheatres = factory.createEntityManager().createNamedQuery("viewTheatres").getResultList();
      //  System.out.println(viewTheatres);
        return viewTheatres;
    }

    @Override
    public Optional<TheatreEntity> editTheatre(int id) {
        TheatreEntity theatreEntity = factory.createEntityManager().find(TheatreEntity.class, id);
      //  System.out.println(theatreEntity);
        return Optional.of(theatreEntity);
    }

    @Override
    public boolean updateTheatre(TheatreEntity theatreEntity) {
        EntityManager entityManager=factory.createEntityManager();
        entityManager.getTransaction().begin();
        Query query=entityManager.createNamedQuery("updateTheatre");
        query.setParameter("name",theatreEntity.getTheatreName());
        query.setParameter("loc",theatreEntity.getLocation());
        query.setParameter("city",theatreEntity.getCity());
        query.setParameter("ts",theatreEntity.getTotalScreens());
        query.setParameter("owner",theatreEntity.getOwnerName());
        query.setParameter("available",theatreEntity.isAcAvailable());
        query.setParameter("price",theatreEntity.getTicketPrice());
        query.setParameter("number",theatreEntity.getContactNumber());
        query.setParameter("id",theatreEntity.getTheatreId());

        int updated= query.executeUpdate();
        entityManager.getTransaction().commit();
        if (updated > 0){
            System.out.println("Updated Successfully");
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteTheatre(int id) {
        EntityManager entityManager=factory.createEntityManager();
        entityManager.getTransaction().begin();
        TheatreEntity theatreEntity = entityManager.find(TheatreEntity.class, id);
        if (theatreEntity != null){
            entityManager.remove(theatreEntity);
            entityManager.getTransaction().commit();
            System.out.println("Successfully Deleted");
            return true;
        }
        return false;
    }
}
