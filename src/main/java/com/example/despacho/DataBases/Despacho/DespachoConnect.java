package com.example.despacho.DataBases.Despacho;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DespachoConnect {
    static DespachoSettings despachoSettings = new DespachoSettings();
    static Connection connection;
    static DespachoConnect despachoConnect;

    public Connection getConnection() {
        try {
            Class.forName(despachoSettings.getDriver());
            connection = DriverManager.getConnection(despachoSettings.getURL(), despachoSettings.getUser(), despachoSettings.getPassword());
            return connection;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void dropConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static DespachoConnect getInstance() {
        if (despachoConnect == null) {
            despachoConnect = new DespachoConnect();
        }
        return despachoConnect;
    }

}
