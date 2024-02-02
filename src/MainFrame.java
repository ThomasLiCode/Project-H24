import javax.swing.*;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class MainFrame extends JFrame {
    private JPanel profileSelectionPanel;
    //    private registerForm registrationPanel;
    private JPanel registrationPanel;
    private JPanel loginPanel;

    private static ArrayList<User> users = new ArrayList<>();

    public MainFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 500);
        setTitle("Profile Manager");

        loadUsers();

        profileSelectionPanel = new profileSelect(this).getPanel();
        registrationPanel = new registerForm(this).getPanel();
        loginPanel = new LoginForm(this).getPanel();



        setContentPane(profileSelectionPanel);
        setVisible(true);
    }

    public void showRegistrationPanel() {
        setContentPane(registrationPanel);
        revalidate();
        repaint();
    }

    public JPanel getLoginPanel(){
        return loginPanel;
    }

    public void showLoginPanel() {
        setContentPane(loginPanel);
        revalidate();
        repaint();
    }

    public void loadUsers(){
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

    public static User findUser(String name){
        for(int i = 0; i < users.size(); i++){
            User curr = users.get(i);
            if(curr.getUsername().equals(name)){
                return curr;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}


