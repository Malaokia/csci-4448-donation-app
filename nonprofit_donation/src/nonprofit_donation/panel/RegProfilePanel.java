package nonprofit_donation.panel;

import nonprofit_donation.usermisc.DonorProfile;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Created by wwcao on 11/10/16.
 */
public class RegProfilePanel {
    private JPanel panel;
    private JTextField lastname;
    private JTextField address;
    private JTextField phone;
    private JTextField cc_num;
    private JTextField exp_date;
    private JTextField firstname;
    private JButton btn_confirm;
    private JPasswordField ccv_num;

    public JPanel getPanel(ActionListener al) {
        btn_confirm.addActionListener(al);
        return panel;
    }

    public void setData(DonorProfile data) {
    }

    public void getData(DonorProfile data) {
    }

    public boolean isModified(DonorProfile data) {
        return false;
    }
}
