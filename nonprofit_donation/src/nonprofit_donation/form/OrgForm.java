package nonprofit_donation.form;

import javax.swing.*;

/**
 * Created by weipeng on 11/7/16.
 */

public class OrgForm extends Form {

    @Override
    public void constructPanel(JPanel panel) {

    }

    @Override
    boolean isValid(JPanel panel) {
        return false;
    }

    @Override
    boolean isUpateValid(JPanel panel) {
        return false;
    }

    @Override
    boolean isPassword() {
        return false;
    }

    @Override
    boolean isUsername() {
        return false;
    }

    @Override
    boolean isUpdateExist() {
        return false;
    }

    @Override
    void attachMsg() {
    }
}
