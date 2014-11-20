package com.wpam.ep.database;

import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Database helper class used to manage the creation and upgrading of your database. This class also usually provides
 * the DAOs used by the other classes.
 */
public class DbConfigUtil extends OrmLiteConfigUtil {

    private static final String DB_CONFIG_FILENAME = "db_config.conf";

    public static void main(String[] args) throws SQLException, IOException {
        writeConfigFile(DB_CONFIG_FILENAME);
    }

}
