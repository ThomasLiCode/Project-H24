import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfileManagerUI extends JFrame {
    private JComboBox<String> profileComboBox;
    private JTextField usernameField;
    private JPasswordField passwordField;

    public ProfileManagerUI() {
        createUI();
    }

    private void createUI() {
        setTitle("Profile Manager");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());


        profileComboBox = new JComboBox<>();
        add(profileComboBox);

        JButton selectProfileButton = new JButton("Select Profile");
        add(selectProfileButton);


        add(new JLabel("Username:"));
        usernameField = new JTextField(15);
        add(usernameField);

        add(new JLabel("Password:"));
        passwordField = new JPasswordField(15);
        add(passwordField);

        JButton createAccountButton = new JButton("Create Account");
        add(createAccountButton);


        selectProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedProfile = (String) profileComboBox.getSelectedItem();
                JOptionPane.showMessageDialog(ProfileManagerUI.this, "Profile Selected: " + selectedProfile);
            }
        });

        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(profileComboBox.getItemCount()>3) return;
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                User user = new User(username, password);
                profileComboBox.addItem(username);
                JOptionPane.showMessageDialog(ProfileManagerUI.this, "Account Created for: " + username);
            }
        });
    }
}
