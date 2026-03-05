package org.example;

import jakarta.persistence.*;
import java.util.*;

public class TaskDAO {

    private EntityManagerFactory emf;
    private EntityManager em;

    public TaskDAO(){
        this.emf = Persistence.createEntityManagerFactory("taskPU");
        this.em  = emf.createEntityManager();
    }

    // ========================= TASK CRUD =========================

    public TaskDTO create(Task task){
        try{
            em.getTransaction().begin();
            em.persist(task);
            em.getTransaction().commit();

            System.out.println("Task created with id: " + task.getId());
            return convertToDTO(task);

        } catch (Exception e){
            rollback();
            System.out.println("Error creating task: " + e.getMessage());
            return null;
        }
    }

    public TaskDTO read(Long id){
        try{
            Task task = em.find(Task.class, id);
            return task != null ? convertToDTO(task) : null;
        } catch (Exception e){
            System.out.println("Error reading task: " + e.getMessage());
            return null;
        }
    }

    public TaskDTO update(Long id, String taskName, String description){
        try{
            em.getTransaction().begin();
            Task task = em.find(Task.class, id);

            if(task != null){
                task.setTask(taskName);
                task.setDescription(description);
                em.merge(task);
                em.getTransaction().commit();
                return convertToDTO(task);
            }
            rollback();
            return null;

        } catch (Exception e){
            rollback();
            System.out.println("Error updating task: " + e.getMessage());
            return null;
        }
    }

    public boolean delete(Long id){
        try{
            em.getTransaction().begin();
            Task task = em.find(Task.class, id);

            if(task != null){
                em.remove(task);
                em.getTransaction().commit();
                return true;
            }
            rollback();
            return false;

        } catch (Exception e){
            rollback();
            System.out.println("Error deleting task: " + e.getMessage());
            return false;
        }
    }

    public List<TaskDTO> getAllTasks(){
        List<TaskDTO> list = new ArrayList<>();
        try{
            List<Task> tasks =
                    em.createQuery("SELECT t FROM Task t", Task.class)
                            .getResultList();

            for(Task t : tasks){
                list.add(convertToDTO(t));
            }
        } catch (Exception e){
            System.out.println("Error fetching tasks: " + e.getMessage());
        }
        return list;
    }

    // ========================= TEACHER CRUD =========================

    public Teacher createTeacher(Teacher teacher){
        try{
            em.getTransaction().begin();
            em.persist(teacher);
            em.getTransaction().commit();
            return teacher;
        } catch (Exception e){
            rollback();
            return null;
        }
    }

    public Teacher getTeacher(Long id){
        return em.find(Teacher.class, id);
    }

    // ========================= COURSE CRUD =========================

    public Course createCourse(Course course){
        try{
            em.getTransaction().begin();
            em.persist(course);
            em.getTransaction().commit();
            return course;
        } catch (Exception e){
            rollback();
            return null;
        }
    }

    public Course getCourse(Long id){
        return em.find(Course.class, id);
    }

    // ========================= ENROLLMENT CRUD =========================

    public Enrollment createEnrollment(Enrollment enrollment){
        try{
            em.getTransaction().begin();
            em.persist(enrollment);
            em.getTransaction().commit();
            return enrollment;
        } catch (Exception e){
            rollback();
            return null;
        }
    }

    public Enrollment getEnrollment(Long id){
        return em.find(Enrollment.class, id);
    }

    // ========================= UTILITY =========================

    private void rollback(){
        if(em.getTransaction().isActive())
            em.getTransaction().rollback();
    }

    private TaskDTO convertToDTO(Task task){
        return new TaskDTO(
                task.getId(),
                task.getTask(),
                task.getDescription()
        );
    }

    public void close(){
        if(em != null && em.isOpen()) em.close();
        if(emf != null && emf.isOpen()) emf.close();
        System.out.println("JPA resources closed");
    }
}