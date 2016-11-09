package database;

/**
 * Created by weipeng on 11/9/16.
 */
public class DBManger {

    public static DBManger db_mgr;
    private String db_name;
    private String db_pwd;

    private DBManger() {
        connectDB();
    }

    DBManger getDatabaseManager() {
        if(db_mgr == null) {
            db_mgr = new DBManger();
            return db_mgr;
        }
        else {
            return db_mgr;
        }
    }

    void connectDB() {

    }

    void registerform(int acc_type, Queryable form) {

    }

    void updateForm(Queryable form) {

    }

    boolean isAccInfoExit(Queryable form) {

        return false;
    }

}
