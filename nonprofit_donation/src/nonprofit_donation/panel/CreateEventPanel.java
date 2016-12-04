package nonprofit_donation.panel;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Created by weipeng on 12/3/16.
 */
public class CreateEventPanel {
    private JPanel panel1;
    private JTextField title;
    private JTextArea description;
    private JButton CONFIRMButton;

    public JPanel getPanel(ActionListener al) {
        CONFIRMButton.addActionListener(al);
        return panel1;
    }
}
