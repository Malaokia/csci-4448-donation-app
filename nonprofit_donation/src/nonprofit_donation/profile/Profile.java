package nonprofit_donation.profile;

/**
 * Created by mql-intelli on 11/8/16.
 */
abstract class Profile {
    public String address;
    public String first_name;
    public String last_name;
    public String general_phone;
    abstract public Boolean isValid();
    abstract public void disableUsername();
}
