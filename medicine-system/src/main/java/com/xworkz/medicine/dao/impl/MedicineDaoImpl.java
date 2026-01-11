package com.xworkz.medicine.dao.impl;

import com.xworkz.medicine.dao.MedicineDao;
import com.xworkz.medicine.dto.MedicineDto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

@Repository
public class MedicineDaoImpl implements MedicineDao {
    @Override
    public boolean save(MedicineDto medicineDto) {

        Configuration configuration=new Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(MedicineDto.class);
        SessionFactory sessionFactory=configuration.buildSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction= session.beginTransaction();
        session.save(medicineDto);
        transaction.commit();

        return true;
    }
}
