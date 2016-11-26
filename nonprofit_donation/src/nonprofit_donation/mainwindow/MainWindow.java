package nonprofit_donation.mainwindow;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import nonprofit_donation.controller.Controller;
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
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setDefaultPanel();
        this.pack();
        this.setResizable(false);
    }

    private void setDefaultPanel() {
        // replace with Login Panel
        loginUser();
    }

    @Override
    public void registerAcc() {
        JPanel panel = new RegPanel(this);
        setPanel(panel);
    }

    @Override
    public void donate() {

    }

    @Override
    public void loginUser() {
        JPanel panel = new LoginPanel(this);
        setPanel(panel);
    }

    @Override
    public void editProfile() {

    }

    @Override
    public void createEvent() {

    }

    @Override
    public void setPanel(JPanel panel) {
        setContentPane(panel);
        pack();
    }

    @Override
    public void goHome() {
        System.out.println("In goHome()");
    }

    @Override
    public AccountInfo getAccInfo() {
        return null;
    }

}
