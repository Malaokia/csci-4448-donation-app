package nonprofit_donation.Dialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by wwcao on 11/6/16.
 */
public class RegDialog extends JDialog implements ActionListener{

    private int acc_type;
    public RegDialog(JFrame f, boolean visible) {
        super(f, visible);
        acc_type = 0;
        this.setTitle("Choose Account Type:");
        createPanel();
    }

    private void createPanel(){
        GridBagConstraints c = new GridBagConstraints();
        JLabel label = new JLabel("<html><body><p>Choose the account type you want to create</p><br>(Default: Donor)</html></body>");
        JButton donor = new JButton("Donor");
        JButton org = new JButton("Organization");
        JPanel but_panel = new JPanel(new GridLayout(1, 6));
        JPanel layoutPanel = new JPanel(new BorderLayout(5, 5));
        layoutPanel.add(label, BorderLayout.CENTER);
        donor.setActionCommand("D");
        org.setActionCommand("O");
        donor.addActionListener(this);
        org.addActionListener(this);

        but_panel.add(donor);
        but_panel.add(org);

        layoutPanel.add(but_panel, BorderLayout.PAGE_END);
        setContentPane(layoutPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getActionCommand().equals("D")) acc_type = 0;
        else
            acc_type = 1;
        dispose();
    }

    public int getAcc_type() {
        return acc_type;
    }
}
