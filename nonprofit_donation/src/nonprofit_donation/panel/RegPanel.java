package nonprofit_donation.panel;

import nonprofit_donation.dialog.RegDialog;
import nonprofit_donation.form.DonorForm;
import nonprofit_donation.form.Form;
import nonprofit_donation.form.OrgForm;
import nonprofit_donation.mainwindow.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by wwcao on 11/5/16.
 */
public class RegPanel extends AppPanel{
    boolean isReg;
    Form req_form;
    JPanel panel_userinfo;
    JPanel panel_profile;
    int acc_type;
    JDialog editdialog;

    public RegPanel(MainWindow mf) {
        super();
        isReg = true;
        this.mf = mf;
        chooseAccType();
        constructPanel();
    }

    public RegPanel(MainWindow mf, Form form, JDialog dialog) {
        isReg = false;
        this.mf = mf;
        //chooseAccType();
        req_form = form;
        editdialog = dialog;
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
        if(actionEvent.getActionCommand().equals("CONFORM"))
            clickConfirm();
        else
            clickCancel();
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
        if(isReg) {
            mf.loginUser();
        }
        else {
            editdialog.dispose();
        }
    }

    public void clickCancel() {
        if(isReg) {
            mf.loginUser();
        }
        else {
            editdialog.dispose();
        }
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
