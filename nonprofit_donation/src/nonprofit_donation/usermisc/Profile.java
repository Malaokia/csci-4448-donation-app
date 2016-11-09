package nonprofit_donation.usermisc;

import nonprofit_donation.panel.PanelConstructor;

import javax.swing.*;

/**
 * Created by weipeng on 11/1/16.
 */
public abstract class Profile implements PanelConstructor{
    public String address;
    public String first_name;
    public String last_name;
    public String general_phone;

    abstract boolean isValid(JPanel panel);
}
