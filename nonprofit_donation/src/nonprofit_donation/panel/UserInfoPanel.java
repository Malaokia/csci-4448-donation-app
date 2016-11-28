package nonprofit_donation.panel;

import nonprofit_donation.usermisc.AccountInfo;

import javax.swing.*;

/**
 * Created by weipeng on 11/25/16.
 */
public class UserInfoPanel {
    private JPanel panel1;
    private JTextField textUsername;
    private JTextField textPassword;

    public JPanel getPanel() {
        return panel1;
    }

    public void getUserInput(AccountInfo accinfo) {
        accinfo.setPassword(textPassword.getText());
        accinfo.setUsername(textUsername.getText());
    }
}
