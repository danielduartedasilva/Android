package com.daniel.aula10;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DBGateway {
    private static DBGateway gateway;
    private SQLiteDatabase sqLiteDatabase;

    private DBGateway (Context context){
        DBHelper helper = new DBHelper(context);
        sqLiteDatabase = helper.getWritableDatabase();
    }
    public static DBGateway getInstance(Context context){
        if (gateway == null){
            gateway = new DBGateway(context);
        }
        return gateway;
    }
    public SQLiteDatabase getDatabase(){
        return this.sqLiteDatabase;
    }
}
