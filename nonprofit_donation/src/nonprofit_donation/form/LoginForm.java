package nonprofit_donation.form;

import database.Query;
import nonprofit_donation.panel.AppPanel;
import nonprofit_donation.panel.LoginPanel;
import nonprofit_donation.panel.UserInfoPanel;

import javax.swing.*;

/**
 * Created by mql-intelli on 11/8/16.
 */
public class LoginForm extends Form {
    UserInfoPanel userinfo_panel;

    public LoginForm() {
        userinfo_panel = new UserInfoPanel();
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

    @Override
    public void constructPanel(JPanel panel) {
        ((LoginPanel)panel).setUserinfoPanel(userinfo_panel.getPanel());
    }

    @Override
    boolean isValid(JPanel panel) {
        return false;
    }

    @Override
    boolean isUpateValid(JPanel panel) {
        return false;
    }
}
