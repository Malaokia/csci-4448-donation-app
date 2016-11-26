package nonprofit_donation.form;


import database.Query;
import nonprofit_donation.panel.RegPanel;
import nonprofit_donation.panel.UserInfoPanel;
import nonprofit_donation.usermisc.AccountInfo;
import nonprofit_donation.usermisc.DonorProfile;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by weipeng on 11/7/16.
 */

public class DonorForm extends Form {
    DonorProfile profile;
    //AccountInfo accinfo;
    UserInfoPanel userinfo_panel;

    public DonorForm() {
        profile = new DonorProfile();
        userinfo_panel = new UserInfoPanel();
    }

    @Override
    public void constructPanel(JPanel panel) {
        ((RegPanel)panel).setUserInfopanel(userinfo_panel.getPanel());
        profile.constructPanel(panel);
    }

    @Override
    boolean isValid(JPanel panel) {
        return false;
    }

    @Override
    boolean isUpateValid(JPanel panel) {
        return false;
    }

    void attachMsg() {
    }

    @Override
    public Query getSearchQuery() {
        return null;
    }

    @Override
    public Query getInsertQuery() {
        return null;
    }

    @Override
    public Query getUpdateQuery() {
        return null;
    }
}
