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
        setSize(1200, 800);
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
                if(profileComboBox.getItemCount()>=3){
                    JOptionPane.showMessageDialog(ProfileManagerUI.this, "Max number of profiles already reached.");
                    return;
                }
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                if(username.isEmpty()){
                    JOptionPane.showMessageDialog(ProfileManagerUI.this, "Please enter a username");
                    return;
                }

                for(int i = 0; i < profileComboBox.getItemCount(); i++){
                    if(username.equalsIgnoreCase(profileComboBox.getItemAt(i))){
                        JOptionPane.showMessageDialog(ProfileManagerUI.this, "Username already in use");
                        return;
                    }
                }
                User user = new User(username, password);
                profileComboBox.addItem(username);
                JOptionPane.showMessageDialog(ProfileManagerUI.this, "Account Created for: " + username);
            }
        });
    }
}
