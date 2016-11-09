package nonprofit_donation.panel;

import nonprofit_donation.Dialog.RegDialog;
import nonprofit_donation.form.Form;
import nonprofit_donation.mainwindow.MainWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by wwcao on 11/5/16.
 */
public class RegPanel extends AppPanel{
    Form req_form;
    int acctype;

    public RegPanel(MainWindow mf) {
        super();
        this.mf = mf;
        req_form = chooseAccType();
        constructPanel();
        JButton btn = new JButton("Conform");
        add(btn);
        mf.setContentPane(this);
    }

    Form chooseAccType() {
        RegDialog dialog = new RegDialog(this.mf, true);
        if(dialog.getAcc_type() == 0)
            return null;
        else
            return null;
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

    }

    private void updateForm() {

    }

    private void setOrganization() {

    }

    private void setDonor() {

    }

}
