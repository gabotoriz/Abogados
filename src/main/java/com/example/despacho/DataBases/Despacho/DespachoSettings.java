package com.example.despacho.DataBases.Despacho;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(makeFinal = true, level = AccessLevel.PACKAGE)
public class DespachoSettings {
    String DataBase = "despacho";
    String User = "root";
    String Password = "Gabo230105302.";
    String Driver = "com.mysql.cj.jdbc.Driver";
    String Ip = "127.0.0.1";
    String Port = "3306";
    String URL = "jdbc:mysql://" + getIp() + ":" + getPort() + "/" + getDataBase();
}
