package nonprofit_donation.form;

import database.Queryable;
import nonprofit_donation.panel.PanelConstructor;
import nonprofit_donation.usermisc.AccountInfo;

import javax.swing.*;


/**
 * Created by weipeng on 11/1/16.
 */

public abstract class Form implements PanelConstructor, Queryable {
    protected AccountInfo acc_info;
    protected Integer type;

    abstract boolean isValid(JPanel panel);
    abstract boolean isUpateValid(JPanel panel);
}
