package nonprofit_donation.dialog;

import nonprofit_donation.mainwindow.MainWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by wwcao on 11/6/16.
 */
public class EventDialog extends JDialog implements ActionListener{
    public EventDialog(MainWindow mw) {
        super(mw);
        setTitle("Create Event");
        setLocationRelativeTo(mw);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
