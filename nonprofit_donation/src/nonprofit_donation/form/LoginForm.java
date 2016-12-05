package nonprofit_donation.form;

import database.Query;
import nonprofit_donation.panel.LoginPanel;
import nonprofit_donation.panel.UserInfoPanel;
import nonprofit_donation.usermisc.AccountInfo;

import javax.swing.*;

/**
 * Created by mql-intelli on 11/8/16.
 */
public class LoginForm extends Form {
    UserInfoPanel userinfo_panel;

    public LoginForm() {
        userinfo_panel = new UserInfoPanel();
        acc_info = new AccountInfo();
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
    public boolean isValid(JPanel panel) {
        getAccinfo();
        System.out.println("In LoginForm --- "+acc_info.toString());
        if(acc_info.getUsername().equals("demo")) {
            acc_info.setAcc_type(-1);
            return true;
        }
        else if(acc_info.getUsername().equals("organization")) {
            acc_info.setAcc_type(1);
            return true;
        }
        else {
            System.out.println(acc_info.getUsername()+","+acc_info.getPassword());
            AccountInfo accinfo = new AccountInfo();
            userinfo_panel.getUserInput(accinfo);
            String msg = AccountInfo.isValid(accinfo);
            if(msg.length() > 0) {
                userinfo_panel.setTipLabel(msg);
            }
            else {
                if(!findUser())
                    userinfo_panel.setTipLabel("User doesn't exist.");
                else
                    return true;
            }
        }
        return false;
    }

    public boolean findUser() {
        System.out.println("Connect to Database(not implemented)....");
        return false;
    }

    @Override
    public boolean isUpateValid(JPanel panel) {
        return false;
    }

    private void getAccinfo() {
        userinfo_panel.getUserInput(acc_info);
    }

    public AccountInfo getAccountInfo() {
        return acc_info;
    }
}
