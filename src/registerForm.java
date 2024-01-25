import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

public class registerForm extends JPanel {
    private JPanel registerForm;
    private JPasswordField tfPassword;
    private JTextField tfUsername;
    private JButton btnRegister;
    private JFrame frame;

    public registerForm(MainFrame frame){
        this.frame = frame;

//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tfPassword.getText().isEmpty()){
                    JOptionPane.showMessageDialog(frame, "Password field is empty. Please enter a password.", "Empty Field", JOptionPane.WARNING_MESSAGE);
                }else if(tfUsername.getText().isEmpty()){
                    JOptionPane.showMessageDialog(frame, "Username field is empty. Please enter a username.", "Empty Field", JOptionPane.WARNING_MESSAGE);
                }else{
                    int n = 1;
                    while(!checkEmpty("src/saveFile" + n)){
                        if(n == 3){
                            JOptionPane.showMessageDialog(frame, "Cannot register account because profile max of 3 it met", "Max Profiles", JOptionPane.WARNING_MESSAGE);
                            break;
                        }
                        n++;
                    }
                    User user = new User(tfUsername.getText(), tfPassword.getText());
                    try(BufferedWriter writer = new BufferedWriter(new FileWriter("src/saveFile" + n, false))){
                        writer.write(user.getUsername());
                    }catch(Exception exception){
                        JOptionPane.showMessageDialog(frame, "Error while saving user data.", "IO Error", JOptionPane.ERROR_MESSAGE);
                    }

                }
            }
        });
    }

    public boolean checkEmpty(String filePath){
        File file = new File(filePath);
        System.out.println(file.length() == 0);
        return file.length() == 0;
    }

    public JPanel getPanel() {
        return registerForm;
    }
}
