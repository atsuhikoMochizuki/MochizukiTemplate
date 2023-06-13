package fr.diginamic.database;

import fr.diginamic.mochizukiTools.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Database {
    public static Connection connect(){
        String URL, USER, PWD, msg = null;
        Connection db = null;

        ResourceBundle db_conf = ResourceBundle.getBundle ("project");
        URL = db_conf.getString ("database.url");
        USER = db_conf.getString ("database.user");
        PWD = db_conf.getString ("database.pwd");

        msg = String.format ("Connection à la base de données %s",URL);
        Utils.msgInfo (msg);

        try{
            db = DriverManager.getConnection (URL,USER,PWD);
        }
        catch (SQLException e) {
            System.err.println (e.getMessage ());
        }
        Utils.msgResult ("OK");
        return db;
    }
}