package nonprofit_donation.profile;

/**
 * Created by mql-intelli on 11/8/16.
 */
public class OrgProfile extends Profile{
    public String org_name;
    public String org_brief;
    public String org_cvn;
    public String org_num;

    @Override
    public Boolean isValid() {
        return null;
    }

    @Override
    public void disableUsername() {
        /* do something*/
    }
}
