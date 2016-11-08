package nonprofit_donation.profile;

/**
 * Created by mql-intelli on 11/8/16.
 */
public class DonorProfile extends Profile{
    public String don_cvn;
    public String don_num;
    public String don_exp;

    @Override
    public Boolean isValid() {
        return null;
    }

    @Override
    public void disableUsername() {
        /*do something to disable the username.*/
    }
}
