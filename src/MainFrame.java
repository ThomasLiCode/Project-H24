import javax.swing.*;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class MainFrame extends JFrame {
    private JPanel profileSelectionPanel;
    //    private registerForm registrationPanel;
    private JPanel registrationPanel;

    private static ArrayList<User> users = new ArrayList<>();

    public MainFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 500);
        setTitle("Profile Manager");

        loadUser();

        profileSelectionPanel = new profileSelect(this).getPanel();
        registrationPanel = new registerForm(this).getPanel();



        setContentPane(profileSelectionPanel);
        setVisible(true);
    }

    public void showRegistrationPanel() {
        setContentPane(registrationPanel);
        revalidate();
        repaint();
    }

    public void loadUser(){
        try {
            for (int i = 1; i <= 3; i++) {
                User newUser = User.loadFromFile("src/saveFile" + i);
                users.add(newUser);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static List<String> returnUsers() {
        return users.stream().map(User::getUsername).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        new MainFrame();


    }
}


