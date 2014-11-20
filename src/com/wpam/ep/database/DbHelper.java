package com.wpam.ep.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.wpam.ep.R;
import com.wpam.ep.domain.Beacon;
import com.wpam.ep.domain.Profile;
import com.wpam.ep.domain.StreamProperties;

import java.sql.SQLException;

/**
 * Project: Estimote Profiler
 * User: Mateusz Filipowicz
 * Date: 2014-11-06
 * Time: 14:05
 */
@SuppressWarnings({"unchecked", "ConstantConditions"})
public final class DbHelper extends OrmLiteSqliteOpenHelper {

    private static final String LOG = DbHelper.class.getSimpleName();
    private static final String DATABASE_NAME = "EstimoteProfiler.db";
    private static final int DATABASE_VERSION = 3;

    private static final Class[] domainClasses = {Beacon.class, Profile.class, StreamProperties.class};

    private Dao<Beacon, Long> beaconDAO;
    private Dao<Profile, Long> profileDAO;
    private Dao<StreamProperties, Long> streamPropertiesDAO;

    private static final Object daoMutex = new Object();

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION, R.raw.db_config);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
            dropTables(connectionSource);
            createTables(connectionSource);
        } catch (SQLException e) {
            Log.e(LOG, "Unable to create database", e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int oldVer, int newVer) {
        try {
            dropTables(connectionSource);
            onCreate(sqLiteDatabase, connectionSource);
        } catch (SQLException e) {
            Log.e(LOG, "Unable to upgrade database from version " + oldVer + " to " + newVer, e);
        }
    }

    private void createTables(ConnectionSource connectionSource) throws SQLException {
        for (Class clss : domainClasses) {
            TableUtils.createTableIfNotExists(connectionSource, clss);
        }
    }

    private void dropTables(ConnectionSource connectionSource) throws SQLException {
        for (Class clss : domainClasses) {
            TableUtils.dropTable(connectionSource, clss, true);
        }
    }

    private Dao getDao(Dao dao, Class clss) throws SQLException {
        if (dao == null) {
            synchronized (daoMutex) {
                if (dao == null) {
                    dao = getDao(clss);
                }
            }
        }
        return dao;
    }

    public Dao<Beacon, Long> getBeaconDAO() throws SQLException {
        return getDao(beaconDAO, Beacon.class);
    }

    public Dao<Profile, Long> getProfileDAO() throws SQLException {
        return getDao(profileDAO, Profile.class);
    }

    public Dao<StreamProperties, Long> getStreamPropertiesDAO() throws SQLException {
        return getDao(streamPropertiesDAO, StreamProperties.class);
    }
}
