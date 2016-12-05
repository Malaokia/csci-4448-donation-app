package nonprofit_donation.panel;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Created by mql-intelli on 12/1/16.
 */
public class RegOrgProfilePanel {
    private JPanel panel1;
    private JTextField textOrgName;
    private JTextField textAddrLn1;
    private JTextField textAddrLn2;
    private JButton CONFIRMButton;
    private JTextField textPhone;
    private JTextField textName;
    private JTextField textEmAddr;
    private JTextArea textAreaDescription;
    private JButton cancelButton;

    public JPanel getPanel(ActionListener al) {
        CONFIRMButton.addActionListener(al);
        cancelButton.addActionListener(al);
        return panel1;
    }
}
