package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TaskDAO2 {
    private EntityManagerFactory emf;
    private EntityManager em;

    public TaskDAO2(){
        this.emf = Persistence.createEntityManagerFactory("taskPU");
        this.em  = emf.createEntityManager();
    }
    public Task1DTO create(Long userId , Task1 task){
        try{
            User user = em.find(User.class,userId);
            if(user== null){
                System.out.println("User not found with id: " + userId);
                return null;
            }
            em.getTransaction().begin();
            task.setUser(user);
            em.persist(task);
            em.getTransaction().commit();
            System.out.println("Task created : " + user.getName()+ "Task id: "+ task.getId());

            return convertToDTO(task);
        } catch (Exception e) {
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            System.out.println("Error");
            return null;
        }
    }

}