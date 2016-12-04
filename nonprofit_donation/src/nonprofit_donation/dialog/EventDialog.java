package nonprofit_donation.dialog;

import nonprofit_donation.form.Form;
import nonprofit_donation.mainwindow.MainWindow;
import nonprofit_donation.panel.CreateEventPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by wwcao on 11/6/16.
 */
public class EventDialog extends JDialog implements ActionListener{
    Form eventform;
    CreateEventPanel createEvent;
    public EventDialog(MainWindow mw) {
        super(mw);
        createDialog();
        setTitle("Create Event");
        setLocationRelativeTo(mw);
    }

    private void createDialog() {
        createEvent = new CreateEventPanel(this);
        this.setContentPane(createEvent.getPanel(this));
        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Confirm")) {
            System.out.println("validate data and save");
            this.dispose();
        }
    }
}
