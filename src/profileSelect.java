import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class profileSelect extends JPanel {
    private JComboBox<String> cbProfiles;
    private JButton btnRegister;
    private JPanel profileSelect;
    private JButton btnLogin;
    private String selectProfile;
    private JFrame frame;

    public profileSelect(MainFrame frame){
        this.frame = frame;

        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.showRegistrationPanel();
            }
        });
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                selectProfile = (String)cbProfiles.getSelectedItem();
                frame.getLoginPanel().setSelectedProfile(selectProfile);
            }
        });
    }

    public String returnSelected(){
        return selectProfile;
    }


    public void refreshProfiles() {
        cbProfiles.setModel(new DefaultComboBoxModel(MainFrame.returnUsers().toArray(new String[0])));
    }

    public JPanel getPanel() {
        return profileSelect;
    }

    public String returnProfile(){
        return selectProfile;
    }

    private void createUIComponents() {
        List<String> users = MainFrame.returnUsers();
        cbProfiles = new JComboBox<>(users.toArray(new String[0]));
    }
}
