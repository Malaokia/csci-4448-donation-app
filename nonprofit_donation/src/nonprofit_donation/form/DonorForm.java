package nonprofit_donation.form;


import database.Query;
import nonprofit_donation.usermisc.DonorProfile;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by weipeng on 11/7/16.
 */

public class DonorForm extends Form {
    DonorProfile profile;
    private JTextField tf_usrname;
    private JPasswordField pf_passwd;

    public DonorForm() {
        profile = new DonorProfile();
    }

    @Override
    public void constructPanel(JPanel panel) {

        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JButton conform = new JButton("Conform");
        conform.addActionListener((ActionListener) panel);


        JLabel label_usrname = new JLabel("Username");
        JLabel label_passwd = new JLabel("Password");
        tf_usrname = new JTextField();
        tf_usrname.setPreferredSize(new Dimension(200, 25));
        tf_usrname.setDocument(new PlainDocument() {
            public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
                if (str == null)
                    return;

                if ((getLength() + str.length()) < 15) {
                    super.insertString(offset, str, attr);
                }
            }
        });
        pf_passwd = new JPasswordField();
        pf_passwd.setPreferredSize(new Dimension(200, 25));
        pf_passwd.setDocument(new PlainDocument() {
            public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
                if (str == null)
                    return;

                if ((getLength() + str.length()) < 15) {
                    super.insertString(offset, str, attr);
                }
            }
        });

        JPanel p_usrname = new JPanel();
        p_usrname.add(label_usrname);
        p_usrname.add(tf_usrname);
        JPanel p_passwd = new JPanel();
        p_passwd.add(label_passwd);
        p_passwd.add(pf_passwd);

        JButton btn_conform = new JButton("Conform");
        btn_conform.addActionListener((ActionListener) panel);

        panel.add(p_usrname);
        panel.add(p_passwd);

        profile.constructPanel(panel);
    }

    @Override
    boolean isValid(JPanel panel) {
        return false;
    }

    @Override
    boolean isUpateValid(JPanel panel) {
        return false;
    }

    void attachMsg() {
    }

    @Override
    public Query getSearchQuery() {
        return null;
    }

    @Override
    public Query getInsertQuery() {
        return null;
    }

    @Override
    public Query getUpdateQuery() {
        return null;
    }
}
