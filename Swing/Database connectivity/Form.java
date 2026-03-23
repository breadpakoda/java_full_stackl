import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Form {

    public static void main(String[] args) {

        JFrame main_frame = new JFrame();

        JPanel main_panel = new JPanel(new GridLayout(5, 1));
        JPanel email_panel = new JPanel(new GridLayout(1, 2));
        JPanel name_panel = new JPanel(new GridLayout(1, 2));
        JPanel dept_panel = new JPanel(new GridLayout(1, 2));

        email_panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        name_panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        dept_panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        JLabel title= new JLabel("Registration Form");

        JLabel email = new JLabel("Email");
        JLabel name = new JLabel("Name");
        JLabel dept = new JLabel("Department");

        JTextField email_t = new JTextField();
        JTextField name_t = new JTextField();
        JTextField dept_t = new JTextField();

        email_t.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        name_t.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        dept_t.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton button = new JButton("Submit");

        button.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel button_panel= new JPanel();
        button_panel.add(button);

        email.setFont(new Font("Arial",Font.BOLD,20));
        name.setFont(new Font("Arial",Font.BOLD,20));
        dept.setFont(new Font("Arial",Font.BOLD,20));
        email.setForeground(Color.RED);
        name.setForeground(Color.RED);
        dept.setForeground(Color.RED);

        title.setFont(new Font("Arial",Font.BOLD,30));

        email_panel.add(email);
        email_panel.add(email_t);
        name_panel.add(name);
        name_panel.add(name_t);
        dept_panel.add(dept);
        dept_panel.add(dept_t);
        main_panel.add(title);
        main_panel.add(email_panel);
        main_panel.add(name_panel);
        main_panel.add(dept_panel);
        main_panel.add(button_panel);

        main_frame.setSize(400, 500);
        main_frame.setVisible(true);
        main_frame.add(main_panel);

        // db connections
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/form",
                    "root",
                    "12345");
            System.out.println("Connection successfull");

            Statement st = conn.createStatement();

            button.addActionListener(e -> {

                try {

                    String db_email = email_t.getText();
                    String db_name = name_t.getText();
                    String db_dept = dept_t.getText();
                    String query = "insert into form_2 values('" + db_email + "','" + db_name + "','" + db_dept + "')";
                    st.executeUpdate(query);

                } catch (SQLException ex) {
                    System.out.println(ex);
                }
                ;
            });

        }

        catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (SQLException err) {
            System.out.println(err);
        }
        ;

    }

    

}
