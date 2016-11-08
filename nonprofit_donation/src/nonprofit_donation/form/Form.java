package nonprofit_donation.form;

import nonprofit_donation.accountinfo.AccountInfo;

/**
 * Created by weipeng on 11/1/16.
 */
public abstract class Form {
    private AccountInfo acc_info;
    private Integer type;

    abstract public Boolean isValid();
    abstract public void attachMsg();
    abstract public Boolean isUsername();
    abstract public Boolean isPassword();
    abstract public Boolean isUserExist();
    abstract public Boolean isUpdateValid();
}
