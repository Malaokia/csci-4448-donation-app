package nonprofit_donation.usermisc;

/**
 * Created by weipeng on 11/1/16.
 */
public class AccountInfo {
    private String username;
    private String password;
    private int acc_type;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getAccType() {
        return acc_type;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAcc_type(int acc_type) {
        this.acc_type = acc_type;
    }

    public static void copyAccInfo(AccountInfo dest, AccountInfo src) {
        dest.setUsername(src.getUsername());
        //dest.setPassword(src.getPassword());
        dest.setPassword("**********");
        dest.setAcc_type(src.getAccType());
    }
    public String toString() {
        return "<" + username + ", " + password + ", " + acc_type +">";
    }

    public String accTypeToString() {
        if(acc_type == 0) return "Donor";
        if(acc_type > 0) return "Organiation";
        return "Demo";
    }

    public String prepareTitle() {
        return accTypeToString() + ": " + getUsername();
    }

    public static String isValid(AccountInfo accinfo) {
        String usrname = accinfo.getUsername();
        String pwd = accinfo.getPassword();
        if(usrname.isEmpty() | pwd.isEmpty()) return "Invalid: Empty field(s)";
        if(!usrname.matches("..*@..*\\...*"))
            return "username is invalid.";
        return "";
    }
}
