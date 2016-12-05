package nonprofit_donation.usermisc;

import nonprofit_donation.panel.RegOrgProfilePanel;
import nonprofit_donation.panel.RegPanel;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Created by weipeng on 11/7/16.
 */
public class OrgProfile extends Profile {
    public String org_name;
    public String org_brief;
    public String db_cvn;
    public String db_num;
    RegOrgProfilePanel rp_panel;

    public OrgProfile() {
        rp_panel = new RegOrgProfilePanel();
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
