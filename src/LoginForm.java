import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JPanel {
    private JTextField tfUsername;
    private JPasswordField pfPassword;
    private JButton btnLogin;
    private JPanel loginForm;

    private String selectedProfile;
    private JFrame frame;

    public LoginForm(MainFrame frame){
        this.frame = frame;

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               User foundUser = MainFrame.findUser;
               if(foundUser==null){
                   JOptionPane.showMessageDialog(frame, "Username Incorrect", "Login Failed", JOptionPane.WARNING_MESSAGE);
               }
               if(foundUser!=null){
                   if(foundUser.getUsername().equals(pfPassword.getText())){

                   }else{
                       JOptionPane.showMessageDialog(frame, "Password Incorrect", "Login Failed", JOptionPane.WARNING_MESSAGE);
                   }
               }

            }
        });
    }

    public void setSelectedProfile(String selectedProfile){
        this.selectedProfile = selectedProfile;
    }

    public JPanel getPanel(){
        return loginForm;
    }
}
