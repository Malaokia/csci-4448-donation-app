package nonprofit_donation.panel;

import nonprofit_donation.form.Form;
import nonprofit_donation.form.LoginForm;
import nonprofit_donation.mainwindow.MainWindow;
import nonprofit_donation.usermisc.AccountInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by wwcao on 11/5/16.
 */
public class LoginPanel extends AppPanel {
    Form login_form;
    JPanel panel_userinfo;

    public LoginPanel(MainWindow mf) {
        super();
        this.mf = mf;
        login_form = new LoginForm();
        constructPanel();
    }


    @Override
    void constructPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        login_form.constructPanel(this);

        ImageIcon img = new ImageIcon("src/mlove.png");
        JLabel label = new JLabel("", img, JLabel.CENTER);
        //label.setMinimumSize(new Dimension(50,50));
        label.setMinimumSize(new Dimension(img.getIconWidth(), img.getIconHeight()));
        JPanel imgPanel = new JPanel();
        imgPanel.add(label);

        add(imgPanel);

        JPanel mp = new JPanel();
        mp.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        mp.add(panel_userinfo);

        Dimension d = new Dimension(40, 20);
        JPanel btnp = new JPanel();
        btnp.setBorder(BorderFactory.createEmptyBorder(5,5,20,5));
        JButton loginbtn = new JButton("Login");
        JButton regbtn = new JButton("Register");
        loginbtn.addActionListener(this);
        regbtn.addActionListener(this);
        loginbtn.setMinimumSize(d);
        regbtn.setMinimumSize(d);
        loginbtn.setMaximumSize(d);
        regbtn.setMaximumSize(d);
        btnp.add(loginbtn);
        btnp.add(regbtn);

        add(mp, BorderLayout.CENTER);
        add(btnp, BorderLayout.SOUTH);
        //setPreferredSize(new Dimension(300,400));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().toString().equals("Login")) {
            if(((LoginForm)login_form).isValid(this)) {
                System.out.println(((LoginForm)login_form).getAccountInfo().toString());
                mf.setAccInfo(((LoginForm) login_form).getAccountInfo());
                mf.goHome();
            }
        }
        else {
            mf.registerAcc();
        }
    }

    public void setUserinfoPanel(JPanel panel) {
        panel_userinfo = panel;
    }

}
