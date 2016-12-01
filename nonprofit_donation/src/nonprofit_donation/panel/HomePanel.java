package nonprofit_donation.panel;

import nonprofit_donation.controller.HomePanelController;
import nonprofit_donation.dialog.ProfileDialog;
import nonprofit_donation.mainwindow.MainWindow;
import nonprofit_donation.usermisc.Profile;

import java.awt.event.ActionEvent;

/**
 * Created by mql-intelli on 11/8/16.
 */
public class HomePanel extends AppPanel {

    HomePanelController hpc;

    public HomePanel(MainWindow mf) {
        this.mf = mf;
        constructPanel();
    }

    @Override
    void constructPanel() {
        int accType = mf.getAccInfo().getAccType();
        if(accType <= 0){
            hpc = new DonnorHomePanel(this);
            this.add(hpc.getMainPanel());
        }
        else {

        }
    }

    void createDonorHomePanel() {

    }

    void createOrgHomePanel() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Edit")){
            (new ProfileDialog(mf,true)).setVisible(true);
        }
    }
}
