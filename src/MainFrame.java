import javax.swing.*;

public class MainFrame extends JFrame {
    private JPanel profileSelectionPanel;
//    private registerForm registrationPanel;
    private JPanel registrationPanel;

    public MainFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 500);
        setTitle("Profile Manager");

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

    public static void main(String[] args) {
        new MainFrame();
    }
}

