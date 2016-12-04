package nonprofit_donation.panel;

import nonprofit_donation.controller.HomePanelController;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Created by weipeng on 11/27/16.
 */
public class DonnorHomePanel extends HomePanelController{
    private JPanel panel_main;
    private JButton viewHistoryButton;
    private JButton editProfileButton;
    private JButton logoutButton;

    public DonnorHomePanel(HomePanel hp) {
        viewHistoryButton.addActionListener((ActionListener) hp);
        editProfileButton.addActionListener((ActionListener) hp);
        logoutButton.addActionListener((ActionListener) hp);
        editProfileButton.setActionCommand("Edit");
        viewHistoryButton.setActionCommand("History");
        logoutButton.setActionCommand("Logout");
    }

    private void setAppLogo() {

    }

    @Override
    public JPanel getMainPanel() {
        return panel_main;
    }

    @Override
    public void setViewPanel(JPanel viewPanel) {
    }
}
