package nonprofit_donation.panel;

import nonprofit_donation.mainwindow.MainWindow;
import nonprofit_donation.usermisc.Profile;

/**
 * Created by mql-intelli on 11/8/16.
 */
public class HomePanel extends AppPanel{
    Profile profile;
    public HomePanel(MainWindow mf){
        super();
        this.mf = mf;

    }
}
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
