package nonprofit_donation.mainwindow;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import nonprofit_donation.controller.Controller;
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
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(600, 350));
        setContentPane(panel);
    }

    @Override
    public void registerAcc() {

    }

    @Override
    public void donate() {

    }

    @Override
    public void loginUser() {

    }

    @Override
    public void editProfile() {

    }

    @Override
    public void createEvent() {

    }

    @Override
    public void setPanel(JPanel panel) {

    }
    @Override
    public void goHome() {

    }

    @Override
    public AccountInfo getAccInfo() {
        return null;
    }

}
