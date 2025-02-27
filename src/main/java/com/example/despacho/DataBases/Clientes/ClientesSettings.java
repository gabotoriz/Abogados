package com.example.despacho.DataBases.Clientes;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ClientesSettings {
    String DataBase = "DESPACHO_CLIENTES";
    String User = "root";
    String Password = "Gabo230105302.";
    String Driver = "com.mysql.cj.jdbc.Driver";
    String Ip = "127.0.0.1";
    String Port = "3306";
    String URL = "jdbc:mysql://" + getIp() + ":" + getPort() + "/" + getDataBase();
}
