package nonprofit_donation.panel;

import nonprofit_donation.Dialog.RegDialog;
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
    Form req_form;
    int acc_type;

    public RegPanel(MainWindow mf) {
        super();
        this.mf = mf;
        chooseAccType();
        constructPanel();
        mf.setContentPane(this);
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
        req_form.constructPanel(this);
    }


    public void clickConfirm() {
        System.out.println("Confirm is clicked");
    }

    private void updateForm() {

    }

    private void setOrganization() {

    }

    private void setDonor() {

    }

}
