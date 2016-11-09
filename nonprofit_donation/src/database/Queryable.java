package database;

/**
 * Created by weipeng on 11/9/16.
 */
public interface Queryable {
    Query getSearchQuery();
    Query getInsertQuery();
    Query getUpdateQuery();
}
