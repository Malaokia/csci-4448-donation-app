package nonprofit_donation.panel;

import nonprofit_donation.Dialog.RegDialog;
import nonprofit_donation.form.DonorForm;
import nonprofit_donation.form.Form;
import nonprofit_donation.form.OrgForm;
import nonprofit_donation.mainwindow.MainWindow;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by wwcao on 11/5/16.
 */
public class RegPanel extends AppPanel{
    Form req_form;
    JPanel panel_userinfo;
    JPanel panel_profile;
    int acc_type;

    public RegPanel(MainWindow mf) {
        super();
        this.mf = mf;
        chooseAccType();
        constructPanel();
    }

    void chooseAccType() {
        RegDialog dialog = new RegDialog(this.mf, true);
        if(dialog.getAcc_type() == 0)
            req_form = new DonorForm();
        else
            req_form = new OrgForm();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
       clickConfirm();
    }

    @Override
    public void constructPanel() {
        JPanel p = new JPanel();
        setLayout(new BorderLayout());
        req_form.constructPanel(this);
        p.setBorder(BorderFactory.createEmptyBorder(20, 0, 0,0));
        p.add(panel_userinfo);
        this.add(p, BorderLayout.CENTER);
        this.add(panel_profile, BorderLayout.SOUTH);
    }


    public void clickConfirm() {
        mf.loginUser();
    }

    private void updateForm() {

    }

    public JPanel getUserinfoPanel() {
        return panel_userinfo;
    }

    public void setUserInfopanel(JPanel p) {
        panel_userinfo = p;
    }

    public JPanel getProfilePanel() {
        return panel_profile;
    }

    public void setProfilePanel(JPanel p) {
        panel_profile = p;
    }
}
