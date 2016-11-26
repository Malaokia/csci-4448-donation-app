package nonprofit_donation.panel;

import com.sun.javafx.font.FontFactory;
import nonprofit_donation.form.Form;
import nonprofit_donation.form.LoginForm;
import nonprofit_donation.mainwindow.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        this.setLayout(new BorderLayout(5,5));
        login_form.constructPanel(this);
        JPanel mp = new JPanel();
        mp.setBorder(BorderFactory.createEmptyBorder(200,5,5,5));
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
        btnp.add(loginbtn);
        btnp.add(regbtn);

        this.add(mp, BorderLayout.CENTER);
        this.add(btnp, BorderLayout.SOUTH);
        setPreferredSize(new Dimension(300,400));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().toString().equals("Login")) {
            mf.goHome();
        }
        else {
            mf.registerAcc();
        }
    }

    public void setUserinfoPanel(JPanel panel) {
        panel_userinfo = panel;
    }


}
