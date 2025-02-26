package com.example.despacho.DataBases.Usuarios;

import java.sql.Connection;
import java.sql.DriverManager;

public class UsuariosConnect {
    static UsuariosSettings settings = new UsuariosSettings();
    static Connection connection;
    static UsuariosConnect instance;

    public Connection getConnection() {
        try{
            Class.forName(settings.getDriver());
            connection = DriverManager.getConnection(settings.getURL(), settings.getUser(), settings.getPassword());
            return connection;
        }catch(Exception e){
            throw new RuntimeException(e);

        }
    }

    public void dropConnection() {
        try {
            getConnection().close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static UsuariosConnect getInstance() {
        if (instance == null) {
            instance = new UsuariosConnect();
        }
        return instance;
    }
}
