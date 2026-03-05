package org.example;

import org.example.Task1DAO;
import org.example.UserDAO;

import java.util.List;

public class Main1 {

    public static void main(String[] args) {

        UserDAO userDAO = new UserDAO();
        Task1DAO taskDAO = new Task1DAO();

        String email = "Deblina@gmail.com";

        // 1️⃣ Check if user already exists
        User user = userDAO.findByEmail(email);

        if (user == null) {
            user = new User("Deblina", email);
            userDAO.save(user);
            System.out.println("New user created: " + user);
        } else {
            System.out.println("Existing user found: " + user);
        }

        // 2️⃣ Create & Save Tasks
        Task1 t1 = new Task1("Learn Hibernate", user);
        Task1 t2 = new Task1("Practice DSA", user);

        taskDAO.save(t1);
        taskDAO.save(t2);

        System.out.println("Tasks saved successfully");

        // 3️⃣ Fetch All Tasks
        List<Task1> allTasks = taskDAO.findAll();
        System.out.println("All Tasks:");
        allTasks.forEach(t ->
                System.out.println(t.getId() + " -> " + t.getTask1())
        );

        // 4️⃣ Fetch Tasks By User ID
        System.out.println("Tasks of user " + user.getId() + ":");
        taskDAO.findByUserId(user.getId())
                .forEach(t -> System.out.println(t.getTask1()));

        System.out.println("Program finished successfully ");
    }
}