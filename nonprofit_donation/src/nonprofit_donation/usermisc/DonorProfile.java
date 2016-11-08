package nonprofit_donation.usermisc;

import javax.swing.*;

/**
 * Created by weipeng on 11/7/16.
 */
public class DonorProfile extends Profile {
    public String cc_cvn;
    public String cc_num;
    public String cc_exp;

    @Override
    boolean isValid(JPanel panel) {
        return false;
    }

    @Override
    public void disableUnameField(JPanel panel) {

    }
}
