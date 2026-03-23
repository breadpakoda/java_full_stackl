import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connector {
    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb",
                    "root",
                    "12345");
            System.out.println("Connected successfully");

             Statement st= conn.createStatement();

        st.executeUpdate("insert into details values(1,'aditya')");

        } catch (ClassNotFoundException e) {
            System.out.print("Driver not found");
        } catch (SQLException e) {
            System.out.println("Connection failed");
        }

       

    }

}
