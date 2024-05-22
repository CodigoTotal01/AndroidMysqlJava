package com.example.masterpiece.utils.connectiondb;

import android.os.StrictMode;

import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionDB {
    private static ConnectionDB instance=null;
    private static Connection con;
    private static final String URL="jdbc:mysql://roundhouse.proxy.rlwy.net:12317/railway";
    private static final String DRIVER="com.mysql.jdbc.Driver";
    private static final String USER="root";
    private static final String PASS="ROyoxSBlyZVLoRNzHkwceAOaLVJNPJYE";

    private final String TAG="SQL_Connection";

    private  ConnectionDB(){
        try {
            StrictMode.setThreadPolicy(policy());
            Class.forName(DRIVER).newInstance();
            con = DriverManager.getConnection(URL,USER,PASS);
            Log.i(TAG,"Conectado");

        }catch (Exception ex){
            Log.e(TAG,"Error al conectar :"+ ex.getMessage());
            ex.printStackTrace();
        }

    }
    public synchronized  static ConnectionDB getInstance(){

        if(instance==null){
            instance = new ConnectionDB();
        }
        return instance;
    }
    public Connection getConnection(){
        return  con;
    }
    public void close(){
        instance=null;
    }

    private StrictMode.ThreadPolicy policy(){

        StrictMode.ThreadPolicy policy = new StrictMode.
                ThreadPolicy.
                Builder().
                permitAll()
                .build();
        return  policy;

    }


}
