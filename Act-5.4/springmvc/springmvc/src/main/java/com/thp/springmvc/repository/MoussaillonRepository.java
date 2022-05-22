package com.thp.springmvc.repository;

import com.thp.springmvc.entity.Moussaillon;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

@Repository
public class MoussaillonRepository {
    public List<Moussaillon> findAll() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vintud");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            List<Moussaillon> moussaillons = entityManager.createQuery("from Moussaillon", Moussaillon.class).getResultList();
            transaction.commit();
            return moussaillons;
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
