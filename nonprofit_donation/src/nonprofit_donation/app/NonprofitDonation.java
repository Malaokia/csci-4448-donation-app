package nonprofit_donation.app;
import nonprofit_donation.Dialog.RegDialog;
import nonprofit_donation.mainwindow.MainWindow;
import nonprofit_donation.accountinfo.AccountInfo;

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
        /*return acctype, username and password, so
        that i can stored it in AccountInfo*/
        testAccountInfo();
	}
	public static void testAccountInfo(){
		String usr = "spiderman";
		String pwd = "spiderman";
		Integer acc = 1;
		AccountInfo acc_info = new AccountInfo(usr,pwd,acc);
		System.out.println("Username:"+acc_info.getUsername()+"\n");
		System.out.println("Password:"+acc_info.getPassword()+"\n");
		System.out.println("Account Type:"+acc_info.getAccType()+"\n");1
	}
	public static void testDialog() {
		RegDialog dialog = new RegDialog(mw, true);
		if(dialog.getAcc_type() == 0)
			System.out.println("Select Account Type: Donor");
		else
			System.out.println("Select Acctout Type: Organization");
	}
}
