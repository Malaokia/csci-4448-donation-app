package nonprofit_donation.panel;

import nonprofit_donation.controller.HomePanelController;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Created by mql-intelli on 12/3/16.
 */
public class OrgHomePanel extends HomePanelController{
    private JPanel panel1;
    private JButton viewHistoryButton;
    private JButton editProfileButton;
    private JButton logOutButton;
    private JButton createEventButton;

    public OrgHomePanel(HomePanel hp) {
        viewHistoryButton.addActionListener((ActionListener) hp);
        editProfileButton.addActionListener((ActionListener) hp);
        createEventButton.addActionListener((ActionListener) hp);
        logOutButton.addActionListener((ActionListener) hp);
        viewHistoryButton.setActionCommand("History");
        editProfileButton.setActionCommand("Edit");
        createEventButton.setActionCommand("Create");
        logOutButton.setActionCommand("Logout");

    }

    @Override
    public JPanel getMainPanel() {
        return panel1;
    }

    @Override
    public void setViewPanel(JPanel viewPanel) {

    }
}
