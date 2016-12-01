package nonprofit_donation.dialog;

import nonprofit_donation.controller.Controller;
import nonprofit_donation.form.DonorForm;
import nonprofit_donation.form.Form;
import nonprofit_donation.form.OrgForm;
import nonprofit_donation.mainwindow.MainWindow;
import nonprofit_donation.panel.RegPanel;

import javax.swing.*;

/**
 * Created by mql-intelli on 12/1/16.
 */
public class ProfileDialog extends JDialog{
    Form profile;
    JPanel content;
    public ProfileDialog(MainWindow mw, boolean visible){
        createProfile(mw, mw.getAccInfo().getAccType());
        createUI();
    }

    public void createProfile(MainWindow mw, int type){
        if(type <= 0) {
            profile = new DonorForm();
            content = new RegPanel(mw, profile);
            profile.constructPanel(content);
        } else {
            profile = new OrgForm();
            content = new JPanel();
            profile.constructPanel(content);
        }

    }
    public void createUI(){
        setContentPane(content);
        this.pack();
    }

}
