package nonprofit_donation.app;

import nonprofit_donation.Dialog.RegDialog;
import nonprofit_donation.mainwindow.MainWindow;

public class NonprofitDonation {
	static MainWindow mw;
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				createWindow();
			}
			
		});
	}
	
	public static void createWindow() {
		mw = MainWindow.getMainWindow("NonProfit Donate");
		mw.setVisible(true);
		testDialog();
	}

	public static void testDialog() {
		RegDialog dialog = new RegDialog(mw, true);

		if(dialog.getAcc_type() == 0)
			System.out.println("Select Account Type: Donor");
		else
			System.out.println("Select Acctout Type: Organization");
	}
}
