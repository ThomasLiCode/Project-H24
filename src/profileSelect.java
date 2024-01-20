import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class profileSelect extends JPanel {
    private JComboBox cbProfiles;
    private JButton btnRegister;
    private JPanel profileSelect;
    private JFrame frame;

    public profileSelect(MainFrame frame){
        this.frame = frame;

        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.showRegistrationPanel();
            }
        });
    }

    public JPanel getPanel() {
        return profileSelect;
    }
}
