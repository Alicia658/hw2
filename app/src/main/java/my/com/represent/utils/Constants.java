package my.com.represent.utils;

import android.os.Environment;

import java.io.File;


public class Constants {
    public static final String DBPATH  = Environment.getExternalStorageDirectory().getAbsolutePath()+ File.separator + "Represent/Db";

    public static final String DBNAME = "Represent.db";

    public static final int DBVERSION = 4;
}
