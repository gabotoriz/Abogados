package com.example.despacho.DataBases.Usuarios;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UsuariosSettings {
    String DataBase = "despacho_usuarios";
    String User = "root";
    String Password = "Gabo230105302.";
    String Driver = "com.mysql.cj.jdbc.Driver";
    String Ip = "127.0.0.1";
    String Port = "3306";
    String URL = "jdbc:mysql://" + getIp() + ":" + getPort() + "/" + getDataBase();
}
