import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class Data_testing {

    public static void main(String[] args) {

        JFrame parent_frame = new JFrame("Visitor Form");
        parent_frame.setSize(600, 900);
        parent_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel parent_panel = new JPanel(new GridLayout(8, 1));
        parent_panel.setBorder(BorderFactory.createEmptyBorder(0, 30, 20, 30));

        JLabel title1 = new JLabel("Identity Panel");

        String[] govt_id_type_item = { "Aadhar Card", "Pan Card", "Passport", "Voter ID", "Ration Card" };
        String[] visitor_card_item = { "Student", "Professor", "Research Student", "Vendor", "VIP Guest" };
        String[] department_item = { "SOET", "SOP", "SOM", "SOS", "SOAG", "SOSM" };
        String[] access_level_item = { "level-1", "level-2", "level-3" };
        String[] biometric_item = { "verified", "unverified" };
        String[] escort_item = { "Yes", "No" };

        // Identity panel
        JPanel Identity_panel = new JPanel(new GridLayout(5, 2));

        JLabel name = new JLabel("Full Name");
        JLabel govt_id_type = new JLabel("Government ID Type");
        JLabel govt_id = new JLabel("Government ID");
        JLabel contact = new JLabel("Contact Number");
        JLabel visitor_card = new JLabel("Visitor Card");

        JTextField name_t = new JTextField();
        JComboBox<String> govt_id_type_t = new JComboBox<>(govt_id_type_item);
        JTextField govt_id_t = new JTextField();
        JTextField contact_t = new JTextField();
        JComboBox<String> visitor_card_t = new JComboBox<>(visitor_card_item);

        Identity_panel.add(name);
        Identity_panel.add(name_t);
        Identity_panel.add(govt_id_type);
        Identity_panel.add(govt_id_type_t);
        Identity_panel.add(govt_id);
        Identity_panel.add(govt_id_t);
        Identity_panel.add(contact);
        Identity_panel.add(contact_t);
        Identity_panel.add(visitor_card);
        Identity_panel.add(visitor_card_t);

        // Authentication panel
        JLabel title2 = new JLabel("Authentication Panel");

        JPanel Visitor_Authentication = new JPanel(new GridLayout(4, 2));

        JLabel purpose = new JLabel("Purpose");
        JLabel department = new JLabel("Department");
        JLabel Entry_time = new JLabel("Entry Time");
        JLabel Exit_time = new JLabel("Exit Time");

        JTextField purpose_t = new JTextField();
        JComboBox<String> department_t = new JComboBox<>(department_item);
        JTextField Entry_time_t = new JTextField();
        JTextField Exit_time_t = new JTextField();

        Visitor_Authentication.add(purpose);
        Visitor_Authentication.add(purpose_t);
        Visitor_Authentication.add(department);
        Visitor_Authentication.add(department_t);
        Visitor_Authentication.add(Entry_time);
        Visitor_Authentication.add(Entry_time_t);
        Visitor_Authentication.add(Exit_time);
        Visitor_Authentication.add(Exit_time_t);

        // Security panel
        JLabel title3 = new JLabel("Security Panel");

        JPanel Security_clearance = new JPanel(new GridLayout(3, 2));

        JLabel access_level = new JLabel("Access Level");
        JLabel biometric = new JLabel("Biometric Verified");
        JLabel escort = new JLabel("Escort Required");

        JComboBox<String> access_level_t = new JComboBox<>(access_level_item);
        JComboBox<String> biometric_t = new JComboBox<>(biometric_item);
        JComboBox<String> escort_t = new JComboBox<>(escort_item);

        Security_clearance.add(access_level);
        Security_clearance.add(access_level_t);
        Security_clearance.add(biometric);
        Security_clearance.add(biometric_t);
        Security_clearance.add(escort);
        Security_clearance.add(escort_t);

        // Control panel
        JLabel title4 = new JLabel("Control Panel");

        JPanel control_panel = new JPanel(new GridLayout(1, 4));

        JButton generate_pass = new JButton("Generate Pass");
        JButton reset = new JButton("Reset");
        JButton emergency_contact = new JButton("Emergency Contact");
        JButton exit = new JButton("Exit");

        control_panel.add(generate_pass);
        control_panel.add(reset);
        control_panel.add(emergency_contact);
        control_panel.add(exit);

        title1.setFont(new Font("Arial", Font.BOLD, 30));
        title2.setFont(new Font("Arial", Font.BOLD, 30));
        title3.setFont(new Font("Arial", Font.BOLD, 30));
        title4.setFont(new Font("Arial", Font.BOLD, 30));

        title1.setForeground(Color.RED);
        title2.setForeground(Color.RED);
        title3.setForeground(Color.RED);
        title4.setForeground(Color.RED);

        parent_panel.add(title1);
        parent_panel.add(Identity_panel);
        parent_panel.add(title2);
        parent_panel.add(Visitor_Authentication);
        parent_panel.add(title3);
        parent_panel.add(Security_clearance);
        parent_panel.add(title4);
        parent_panel.add(control_panel);

        parent_frame.add(parent_panel);
        parent_frame.setVisible(true);

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/form",
                    "root",
                    "12345");

            Statement st = conn.createStatement();

            generate_pass.addActionListener(e -> {

                try {

                    String db_name = name_t.getText();
                    String db_gvt_id_type = (String) govt_id_type_t.getSelectedItem();
                    String db_govt_id = govt_id_t.getText();
                    String db_contact = contact_t.getText();
                    String db_visitor_id = (String) visitor_card_t.getSelectedItem();
                    String db_purpose = purpose_t.getText();
                    String db_dept = (String) department_t.getSelectedItem();
                    String db_entry_time = Entry_time_t.getText();
                    String db_exit_time = Exit_time_t.getText();
                    String db_access_level = (String) access_level_t.getSelectedItem();
                    String db_b_verification = (String) biometric_t.getSelectedItem();
                    String db_escort = (String) escort_t.getSelectedItem();

                    String query = "insert into authentication_form values('" + db_name + "','" +
                            db_gvt_id_type + "','" +
                            db_govt_id + "','" +
                            db_contact + "','" +
                            db_visitor_id + "','" +     
                            db_purpose + "','" +
                            db_dept + "','" +
                            db_entry_time + "','" +
                            db_exit_time + "','" +
                            db_access_level + "','" +
                            db_b_verification + "','" +
                            db_escort + "')";

                    st.executeUpdate(query);

                    System.out.println("Data inserted");

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            });

        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found");
        } catch (SQLException e) {
            System.out.println("Connection failed");
        }

        reset.addActionListener(e -> {
            name_t.setText("");
            govt_id_t.setText("");
            contact_t.setText("");
            purpose_t.setText("");
            Entry_time_t.setText("");
            Exit_time_t.setText("");
        });

        emergency_contact.addActionListener(e -> System.out.println("Emergency contact"));

        exit.addActionListener(e -> System.exit(0));
    }
}