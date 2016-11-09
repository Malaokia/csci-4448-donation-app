package nonprofit_donation.panel;

import nonprofit_donation.mainwindow.MainWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by wwcao on 11/5/16.
 */
public abstract class AppPanel extends JPanel implements ActionListener{
    MainWindow mf;
    /*
    @Override
    public abstract void actionPerformed(ActionEvent actionEvent);
    */
    abstract void constructPanel();

}
