import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class registerForm extends JPanel {
    private JPanel registerForm;
    private JPasswordField tfPassword;
    private JTextField tfUsername;
    private JButton btnRegister;
    private JFrame frame;

    public registerForm(MainFrame frame){
        this.frame = frame;

//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public JPanel getPanel() {
        return registerForm;
    }
}
