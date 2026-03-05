//import java.sql.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
//click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
//public class Main {
//    public static void main(String[] args) throws Exception {
//
//        Connection conn= DatabaseConfig.getConnection();
//        PreparedStatement pstmt = conn.prepareStatement("INSERT INTO tasks (title, description) VALUES (?,?)");
//        pstmt.setString(1,"JDBC Testing");
//        pstmt.setString(2,"This is the jdbc Testing description");
//        pstmt.executeUpdate();
//
//        System.out.println("Task added!");
//        pstmt.close();
//        conn.close();
//
//
//    }
//}
import java.sql.*;

public class Main {
    public static void main(String[] args) throws Exception {

        Connection conn = DatabaseConfig.getConnection();

        PreparedStatement pstmt = conn.prepareStatement(
                "UPDATE tasks SET title = ?, description = ? WHERE id = ?"
        );

        pstmt.setString(1, "Updated JDBC Task");
        pstmt.setString(2, "This description is updated using JDBC");
        pstmt.setInt(3, 1);   // change id as needed

        int rows = pstmt.executeUpdate();

        if (rows > 0)
            System.out.println("Task updated successfully!");
        else
            System.out.println("No record found for update");

        pstmt.close();
        conn.close();
    }
}