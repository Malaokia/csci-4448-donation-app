package nonprofit_donation.panel;

import nonprofit_donation.usermisc.AccountInfo;

import javax.swing.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

/**
 * Created by weipeng on 11/25/16.
 */
public class UserInfoPanel {
    private JPanel panel1;
    private JTextField textUsername;
    private JTextField textPassword;
    private JLabel tipLabel;

    public UserInfoPanel() {
        textUsername.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                gainorlostFocus();
            }
        });
        textPassword.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                gainorlostFocus();
            }
        });
    }

    public JPanel getPanel() {
        return panel1;
    }

    public void getUserInput(AccountInfo accinfo) {
        accinfo.setPassword(textPassword.getText());
        accinfo.setUsername(textUsername.getText());
    }
    public void setTipLabel(String err) {
        tipLabel.setText(err);
    }

    private void gainorlostFocus() {
        if(!tipLabel.getText().isEmpty()) {
            tipLabel.setText("");
        }
    }
}
