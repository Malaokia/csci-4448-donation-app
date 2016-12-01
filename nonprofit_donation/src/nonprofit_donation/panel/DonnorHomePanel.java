package nonprofit_donation.panel;

import nonprofit_donation.controller.HomePanelController;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Created by weipeng on 11/27/16.
 */
public class DonnorHomePanel extends HomePanelController{
    private JPanel panel_main;
    private JPanel panel_view;
    private JButton viewHistoryButton;
    private JButton editProfileButton;
    private JButton logoutButton;
    private JButton clickToViewEventsButton;
    private JPanel panel_viewbutton;

    public DonnorHomePanel(HomePanel hp) {
        viewHistoryButton.addActionListener((ActionListener) hp);
        editProfileButton.addActionListener((ActionListener) hp);
        logoutButton.addActionListener((ActionListener) hp);
        clickToViewEventsButton.setActionCommand("Show");
        editProfileButton.setActionCommand("Edit");
        clickToViewEventsButton.addActionListener((ActionListener) hp);
    }

    private void setAppLogo() {

    }

    @Override
    public JPanel getMainPanel() {
        return panel_main;
    }

    @Override
    public void setViewPanel(JPanel viewPanel) {
        panel_viewbutton.setVisible(false);
        panel_view.add(viewPanel);
    }
}
