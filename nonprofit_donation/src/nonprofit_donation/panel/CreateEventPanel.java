package nonprofit_donation.panel;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by weipeng on 12/3/16.
 */
public class CreateEventPanel {
    private JPanel panel1;
    private JTextField title;
    private JTextArea description;
    private JButton CONFIRMButton;
    private JLabel tipLabel;

    public CreateEventPanel(ActionListener al) {
        CONFIRMButton.addActionListener(al);
        CONFIRMButton.setActionCommand("Confirm");
    }

    public JPanel getPanel(ActionListener al) {
        return panel1;
    }
}
