package nonprofit_donation.panel;

import nonprofit_donation.controller.HomePanelController;
import nonprofit_donation.dialog.ProfileDialog;
import nonprofit_donation.mainwindow.MainWindow;

import javax.swing.*;
import javax.swing.text.View;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

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
            setLayout(new GridLayout(1,2));
            setPreferredSize(new Dimension(960, 720));
            hpc = new DonnorHomePanel(this);
            createDonorHomePanel(true);
        }
        else {
            hpc = new OrgHomePanel(this);
            createOrgHomePanel();
        }
    }

    private void createDonorHomePanel(boolean initial) {
        JPanel contentPane = new JPanel(new BorderLayout(2,2));
        if(initial) {
            contentPane.add(hpc.getMainPanel(), BorderLayout.WEST);
            JPanel viewPanel = new JPanel();
            JButton btn = new JButton("Click to View");
            btn.setActionCommand("View");
            btn.addActionListener(this);
            viewPanel.add(btn);
            contentPane.add(viewPanel,BorderLayout.CENTER);
            add(contentPane);
        }
        else {
            removeAll();
            repaint();
            contentPane.add(hpc.getMainPanel(), BorderLayout.WEST);
            int width = getWidth()-hpc.getMainPanel().getWidth() - 50;
            ViewEventsPanel viewEventsPanel = new ViewEventsPanel(new Dimension(width, getHeight()));
            //ViewEventsPanel viewEventsPanel = new ViewEventsPanel(getSize());
            JScrollPane sp = new JScrollPane(viewEventsPanel,
                    ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            //sp.setPreferredSize(new Dimension(640,480));
            contentPane.add(sp, BorderLayout.CENTER);
            add(contentPane);

            invalidate();
            validate();
        }
    }

    private void createOrgHomePanel() {
        add(hpc.getMainPanel());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(mf.getAccInfo().getAccType() <= 0) {
            if (e.getActionCommand().equals("Edit")) {
                mf.editProfile();
                //(new ProfileDialog(mf,true)).setVisible(true);
            } else if (e.getActionCommand().equals("View")) {
                JDialog dialog = new JDialog(mf);
                createDonorHomePanel(false);
            }
            else if (e.getActionCommand().equals("History")) {

            }
            else if (e.getActionCommand().equals("Logout")) {
                mf.loginUser();
            }
        }
        else {
            if (e.getActionCommand().equals("Create")) {
                mf.createEvent();
            } else if (e.getActionCommand().equals("Edit")) {

            }
            else if (e.getActionCommand().equals("History")) {

            }
            else if (e.getActionCommand().equals("Logout")) {
                mf.loginUser();
            }
        }
    }
}

class ViewEventsPanel extends JPanel {
    Dimension pref_dimension;
    public ViewEventsPanel() {
        super();
    }

    public ViewEventsPanel(Dimension d) {
        pref_dimension = d;
        setBackground(Color.MAGENTA);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        createDemoUI();
    }

    public ViewEventsPanel(Dimension d, java.util.List event_list) {

    }

    private void createDemoUI() {
        for(int i = 0; i < 20; i++) {
            JPanel p = new JPanel();
            p.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
            EventPanel eventPanel = new EventPanel((int)pref_dimension.getWidth(), i);
            p.add(eventPanel);
            add(p);
        }
    }

    private void createPanel() {

    }
}

class EventPanel extends JPanel implements ActionListener {
    int id;
    private EventPanel() {
        setLayout(new GridLayout(2,3));
    }

    public EventPanel(int width, int i) {
        super();
        id = i;
        setPreferredSize(new Dimension(width, 60));
        setBackground(Color.ORANGE);
        JPanel p = new JPanel();
        JLabel lable = new JLabel("Labe " + i);
        add(lable);
        JButton btn = new JButton("View " + id);
        btn.addActionListener(this);
        add(btn);
    }

    public EventPanel(Object obj) {
        super();
        setSize(300, 50);
        setBackground(Color.WHITE);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Clicked on panel " + id);
    }
}
