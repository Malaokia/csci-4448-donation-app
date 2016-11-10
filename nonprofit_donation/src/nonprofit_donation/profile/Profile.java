package nonprofit_donation.profile;

/**
 * Created by mql-intelli on 11/8/16.
 */
abstract class Profile {
    protected String address;
    protected String first_name;
    protected String last_name;
    protected String general_phone;
    abstract public Boolean isValid();
    abstract public void disableUsername();
}
