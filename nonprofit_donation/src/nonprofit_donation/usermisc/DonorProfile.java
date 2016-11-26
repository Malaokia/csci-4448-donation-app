package nonprofit_donation.usermisc;

import nonprofit_donation.panel.RegDonorProfilePanel;
import nonprofit_donation.panel.RegPanel;

import javax.swing.*;
import javax.swing.text.Document;
import java.awt.event.ActionListener;

/**
 * Created by weipeng on 11/7/16.
 */
public class DonorProfile extends Profile {
    public String cc_cvn;
    public String cc_num;
    public String cc_exp;
    RegDonorProfilePanel rp_panel;

    public DonorProfile() {
        rp_panel = new RegDonorProfilePanel();
    }

    public DonorProfile(Document doc) {

    }

    @Override
    boolean isValid(JPanel panel) {
        return false;
    }

    @Override
    public void constructPanel(JPanel panel) {
        ((RegPanel)panel).setProfilePanel(rp_panel.getPanel(((ActionListener) panel)));
    }
}
