package nonprofit_donation.accountinfo;

/**
 * Created by mql-intelli on 11/8/16.
 */
public class AccountInfo {
    private String username;
    private String password;
    private Integer acctype;

    public AccountInfo(String usr, String pwd, Integer acct){
        username = usr;
        password = pwd;
        acctype = acct;
    }
    public int getAccType(){
        return acctype;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
}
