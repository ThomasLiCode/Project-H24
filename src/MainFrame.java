import javax.swing.*;
import java.io.FileReader;
import java.util.Scanner;
import java.util.ArrayList;

public class MainFrame extends JFrame {
    private JPanel profileSelectionPanel;
    //    private registerForm registrationPanel;
    private JPanel registrationPanel;

    private static ArrayList<String> users = new ArrayList<>();

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
                Scanner save = new Scanner(new FileReader("src/saveFile" + i));
                if (save.hasNext()) {
                    String name = save.next();
                    users.add(name);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<String> returnUsers() {
        return users;
    }

    public static void main(String[] args) {
        new MainFrame();


    }
}


