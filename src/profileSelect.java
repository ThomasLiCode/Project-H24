import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class profileSelect extends JPanel {
    private JComboBox<String> cbProfiles;
    private JButton btnRegister;
    private JPanel profileSelect;
    private JFrame frame;

    public profileSelect(MainFrame frame){
        this.frame = frame;
        ArrayList<String> users = MainFrame.returnUsers();
        cbProfiles = new JComboBox<>(new DefaultComboBoxModel(users.toArray(new String[0])));
        cbProfiles.revalidate();
        cbProfiles.repaint();
        System.out.println(cbProfiles.getItemAt(0));

        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.showRegistrationPanel();
            }
        });
    }


    public void refreshProfiles() {
        cbProfiles.setModel(new DefaultComboBoxModel(MainFrame.returnUsers().toArray(new String[0])));
    }

    public JPanel getPanel() {
        return profileSelect;
    }
}
