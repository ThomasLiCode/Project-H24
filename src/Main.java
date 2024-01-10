import javax.swing.*;
public class Main {
    public static void main(String[] args) {
        //hello
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ProfileManagerUI().setVisible(true);
            }
        });
    }
}