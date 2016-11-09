package nonprofit_donation.controller;

import nonprofit_donation.usermisc.AccountInfo;

import javax.swing.*;

public interface Controller {
    void registerAcc();
    void donate();
    void loginUser();
    void editProfile();
    void createEvent();
    void setPanel(JPanel panel);
    AccountInfo getAccInfo();
    void goHome();

}
