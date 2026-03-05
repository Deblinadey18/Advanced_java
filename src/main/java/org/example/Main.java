package org.example;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        TaskDAO taskDAO = new TaskDAO();

        // ---------------- CREATE ----------------

        Task task1 = new Task();
        task1.setTask("Hibernate CRUD");
        task1.setDescription("Implement CRUD with 4 tables using Hibernate");
        taskDAO.create(task1);

        Task task2 = new Task();
        task2.setTask("JPQL Joins");
        task2.setDescription("Write multi-table JPQL join queries");
        taskDAO.create(task2);

        // ---------------- READ SINGLE ----------------

        System.out.println("\n--- FETCH SINGLE RECORD (ALL 4 TABLE DATA) ---");
        TaskDTO dto = taskDAO.read(1L);
        System.out.println(dto);

        // ---------------- READ ALL ----------------

        System.out.println("\n--- FETCH ALL RECORDS (JOIN DATA) ---");
        List<TaskDTO> list = taskDAO.getAllTasks();
        list.forEach(System.out::println);

        // ---------------- UPDATE ----------------

        System.out.println("\n--- UPDATE TASK ---");
        TaskDTO updated = taskDAO.update(
                1L,
                "Advanced Hibernate CRUD",
                "Full 4-table CRUD + JOIN"
        );
        System.out.println(updated);

        // ---------------- DELETE ----------------

        System.out.println("\n--- DELETE TASK ---");
        taskDAO.delete(2L);

        // ---------------- FINAL LIST ----------------

        System.out.println("\n--- FINAL DATA ---");
        taskDAO.getAllTasks().forEach(System.out::println);

        taskDAO.close();
    }
}