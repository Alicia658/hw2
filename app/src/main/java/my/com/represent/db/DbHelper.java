package my.com.represent.db;

import android.content.Context;



import org.xutils.DbManager;
import org.xutils.x;

import java.io.File;

import my.com.represent.utils.Constants;



public class DbHelper {

    private static DbHelper helper;

    private DbHelper() {
    }

    public static DbHelper getInstance() {
        if (helper == null) {
            synchronized (DbHelper.class) {
                if (helper == null) {
                    helper = new DbHelper();
                }
            }
        }
        return helper;
    }


    public DbManager getDbManager(Context context, DbManager.DbUpgradeListener listener) {
        DbManager.DaoConfig daoConfig = new DbManager.DaoConfig()
                .setDbName(Constants.DBNAME)
                .setDbDir(new File(Constants.DBPATH))
                .setDbVersion(Constants.DBVERSION)
                .setDbUpgradeListener(listener);
        return x.getDb(daoConfig);
    }

}
