package nonprofit_donation.mainwindow;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import nonprofit_donation.controller.Controller;
import nonprofit_donation.dialog.EventDialog;
import nonprofit_donation.dialog.ProfileDialog;
import nonprofit_donation.panel.HomePanel;
import nonprofit_donation.panel.LoginPanel;
import nonprofit_donation.panel.RegPanel;
import nonprofit_donation.usermisc.AccountInfo;

public class MainWindow extends JFrame implements Controller {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public static MainWindow mw = null;
    private AccountInfo accinfo;

    private MainWindow(String title) {
        super(title);
        createDefaultWindow(title);

    }

    public static MainWindow getMainWindow(String title) {
        if (mw == null) {
            mw = new MainWindow(title);
        }
        return mw;
    }

    public static MainWindow getMainWindow() {
        return mw;
    }

    private void createDefaultWindow(String title) {
        this.setTitle(title);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setDefaultPanel();
        this.pack();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    private void setDefaultPanel() {
        // replace with Login Panel
        loginUser();
    }

    @Override
    public void loginUser() {
        accinfo = new AccountInfo();
        JPanel panel = new LoginPanel(this);
        setTitle("NonProfit App");
        setPanel(panel);
    }

    @Override
    public void registerAcc() {
        JPanel panel = new RegPanel(this);
        setTitle("NonProfit App");
        setPanel(panel);
    }

    @Override
    public void goHome() {
        System.out.println("In goHome()");
        JPanel panel = new HomePanel(this);
        setTitle(accinfo.prepareTitle());
        setPanel(panel);
    }
    @Override
    public void donate() {

    }

    @Override
    public void editProfile() {
        (new ProfileDialog(this)).setVisible(true);
    }

    @Override
    public void createEvent() {
        (new EventDialog(this)).setVisible(true);
    }

    @Override
    public void setPanel(JPanel panel) {
        setContentPane(panel);
        pack();
    }

    @Override
    public AccountInfo getAccInfo() {
        return accinfo;
    }

    public void setAccInfo(AccountInfo accinfo) {
        AccountInfo.copyAccInfo(this.accinfo, accinfo);
    }

}
