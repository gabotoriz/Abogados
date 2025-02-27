package com.example.despacho.DataBases.Clientes;

import com.example.despacho.DataBases.Despacho.DespachoConnect;
import com.example.despacho.DataBases.Despacho.DespachoSettings;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ClientesConnect {
    static ClientesSettings clientesSettings = new ClientesSettings();
    static Connection connection;
    static DespachoConnect despachoConnect;

    public Connection getConnection() {
        try {
            Class.forName(clientesSettings.getDriver());
            connection = DriverManager.getConnection(clientesSettings.getURL(), clientesSettings.getUser(), clientesSettings.getPassword());
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
