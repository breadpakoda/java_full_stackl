import javax.swing.*;
import java.awt.*;

class Gamification {
    public static void main(String[] args) {
        JFrame parent_frame = new JFrame();
        JPanel parent_panel = new JPanel();
        parent_panel.setLayout(new GridLayout(8, 1));
        JLabel title1 = new JLabel("Identity Panel");
        parent_frame.setSize(600, 900);

        String[] govt_id_type_item = { "Aadhar Card", "Pan Card", "Pasport", "Voter ID", "Ration Card" };
        String[] visitor_card_item = { "Student", "Professor", "Research Student", "Vendor", "VIP Guest" };
        String[] department_item = { "SOET", "SOP", "SOM", "SOS", "SOAG", "SOSM" };
        String[] access_level_item = { "level-1", "level-2", "level-3" };
        String[] biometric_item = { "verified", "unverified" };
        String[] escort_item = { "Yes", "No" };

        // Identity Panel
        JPanel Identity_panel = new JPanel();

        Identity_panel.setLayout(new GridLayout(5, 2));
        JLabel name = new JLabel("Full Name ");
        JLabel govt_id_type = new JLabel("Government ID Type");
        JLabel govt_id = new JLabel("Government ID");
        JLabel contact = new JLabel("Contact Number");
        JLabel visitor_card = new JLabel("Visitor Card");

        JTextField name_t = new JTextField();
        JComboBox govt_id_type_t = new JComboBox(govt_id_type_item);
        JTextField govt_id_t = new JTextField();
        JTextField contact_t = new JTextField();
        JComboBox visitor_card_t = new JComboBox(visitor_card_item);

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

        // Visitor Authentuacation
        JLabel title2 = new JLabel("Authentication Panle");

        JPanel Visitor_Authentication = new JPanel();
        Visitor_Authentication.setLayout(new GridLayout(4, 2));
        JLabel purpose = new JLabel("Purpose ");
        JLabel department = new JLabel("Department ");
        JLabel Entry_time = new JLabel("Entry Time");
        JLabel Exit_time = new JLabel("Exit Time");

        JTextField purpose_t = new JTextField();
        JComboBox department_t = new JComboBox(department_item);
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

        // security panel

        JPanel Security_clearance = new JPanel();
        Security_clearance.setLayout(new GridLayout(3, 2));

        JLabel title3 = new JLabel("Security Panel");

        JLabel access_level = new JLabel("Access Level");
        JLabel biometiric = new JLabel("Biometric Verifeid");
        JLabel escort = new JLabel("Escort Required");

        JComboBox access_level_t = new JComboBox(access_level_item);
        JComboBox biometric_t = new JComboBox(biometric_item);
        JComboBox escort_t = new JComboBox(escort_item);

        Security_clearance.add(access_level);
        Security_clearance.add(access_level_t);
        Security_clearance.add(biometiric);
        Security_clearance.add(biometric_t);
        Security_clearance.add(escort);
        Security_clearance.add(escort_t);

        JPanel Control_panel = new JPanel();

        title1.setFont(new Font("Arial", Font.BOLD, 30));
        title2.setFont(new Font("Arial", Font.BOLD, 30));
        title3.setFont(new Font("Arial", Font.BOLD, 30));
        title1.setForeground(Color.RED);
        title2.setForeground(Color.RED);
        title3.setForeground(Color.RED);


        // control panel

        // JPanel control_panel = new JPanel();
        // control_panel.setLayout(new GridLayout(1,4));
        // JButoon generate_p

        parent_panel.setBorder(BorderFactory.createEmptyBorder(0, 30, 20, 30));

        parent_frame.add(parent_panel);
        parent_panel.add(title1);
        parent_panel.add(Identity_panel);
        parent_panel.add(title2);
        parent_panel.add(Visitor_Authentication);
        parent_panel.add(title3);
        parent_panel.add(Security_clearance);
        parent_panel.add(Control_panel);
        parent_frame.setVisible(true);

    }
}