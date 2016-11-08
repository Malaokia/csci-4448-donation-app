package nonprofit_donation.app;

import nonprofit_donation.mainwindow.MainWindow;

public class NonprofitDonation {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                createWindow();
            }

        });

    }

    public static void createWindow() {
        MainWindow mw = MainWindow.getMainWindow("NonProfit Donate");
        mw.setVisible(true);
    }

}
