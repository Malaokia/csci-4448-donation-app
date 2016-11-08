package nonprofit_donation.usermisc;

import javax.swing.*;

/**
 * Created by weipeng on 11/7/16.
 */
public class OrgProfile extends Profile {
    public String org_name;
    public String org_brief;
    public String db_cvn;
    public String db_num;


    @Override
    boolean isValid(JPanel panel) {
        return false;
    }

    @Override
    void disableUnameField(JPanel panel) {

    }


}
