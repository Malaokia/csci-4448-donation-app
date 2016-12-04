package nonprofit_donation.dialog;

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
    Form form;
    JPanel conPanel;
    public ProfileDialog(MainWindow mw, boolean visible){
        createProfile(mw, mw.getAccInfo().getAccType());
        createUI();
        setLocationRelativeTo(mw);
    }


    public void createProfile(MainWindow mw, int type){
        if(type <= 0) {
            form = new DonorForm();
            conPanel = new RegPanel(mw, form, this);
        } else {
            form = new OrgForm();
            conPanel = new JPanel();
        }
        form.constructPanel(conPanel);
    }
    public void createUI(){
        setContentPane(conPanel);
        this.pack();
    }

}
