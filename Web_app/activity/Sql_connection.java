package activity;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Sql_connection {

 

    public static void create_conntection(String db_name, String user, String password, String query){

         try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+ db_name,
                    user,
                    password);
            // System.out.println("Connected successfully");

             Statement st= conn.createStatement();

             

        st.executeUpdate(query);
        // System.out.println("Inserted successfully");

        } catch (ClassNotFoundException e) {
            // System.out.print("Driver not found");
        } catch (SQLException e) {
            // System.out.println("Insertion failed");
        }

        

    }

    
    
}
