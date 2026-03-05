package org.example;

import jakarta.persistence.*;
import org.example.Task1;

import java.util.List;

public class Task1DAO {

    private final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("taskPU");

    public void save(Task1 task) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(task);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public Task1 findById(Long id) {
        EntityManager em = emf.createEntityManager();
        Task1 task = em.find(Task1.class, id);
        em.close();
        return task;
    }

    public List<Task1> findAll() {
        EntityManager em = emf.createEntityManager();
        List<Task1> list =
                em.createQuery("FROM Task1", Task1.class).getResultList();
        em.close();
        return list;
    }

    public List<Task1> findByUserId(long userId) {
        EntityManager em = emf.createEntityManager();

        List<Task1> list =
                em.createQuery(
                                "FROM Task1 t WHERE t.user.id = :uid", Task1.class)
                        .setParameter("uid", userId)
                        .getResultList();

        em.close();
        return list;
    }

    public void delete(Long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Task1 task = em.find(Task1.class, id);
            if (task != null) {
                em.remove(task);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }
}
