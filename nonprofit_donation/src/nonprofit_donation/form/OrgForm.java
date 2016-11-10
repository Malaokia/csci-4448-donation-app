package nonprofit_donation.form;

import database.Query;
import nonprofit_donation.usermisc.Profile;

import javax.swing.*;

/**
 * Created by weipeng on 11/7/16.
 */

public class OrgForm extends Form {
    Profile profile;

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

    void attachMsg() {
    }

    @Override
    public Query getSearchQuery() {
        return null;
    }

    @Override
    public Query getInsertQuery() {
        return null;
    }

    @Override
    public Query getUpdateQuery() {
        return null;
    }
}
