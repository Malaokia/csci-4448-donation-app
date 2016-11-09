package nonprofit_donation.form;

import nonprofit_donation.panel.PanelConstructor;
import nonprofit_donation.usermisc.AccountInfo;

import javax.swing.*;


/**
 * Created by weipeng on 11/1/16.
 */

public abstract class Form implements PanelConstructor{
    AccountInfo acc_info;
    Integer type;

    abstract boolean isValid(JPanel panel);
    abstract boolean isUpateValid(JPanel panel);
    abstract void attachMsg();
}
