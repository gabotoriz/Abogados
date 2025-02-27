package com.example.despacho.Models;

import com.example.despacho.DataBases.Despacho.DespachoConnect;
import com.example.despacho.DataBases.Usuarios.UsuariosConnect;
import javafx.scene.control.Alert;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Abogado {
    int IdAbogado;
    String Nombre;
    String ApellidoPaterno;
    String ApellidoMaterno;
    int Especialidad;
    static Abogado abogado_instance;

    public void insertToAbogado(String Nombre, String ApellidoPaterno, String ApellidoMaterno, String Usuario, int Especialidad) {
        DespachoConnect despachoConnect = DespachoConnect.getInstance();
        Connection connection = despachoConnect.getConnection();
        PreparedStatement preparedStatement;
        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
        Alert error = new Alert(Alert.AlertType.ERROR);
        String sql = "INSERT INTO abogados(Nombre, ApePat, ApeMat,Usuario, Especialidad) VALUES(?,?, ?, ?, ?)";
        try {
            if (connection != null) {
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, Nombre);
                preparedStatement.setString(2, ApellidoPaterno);
                preparedStatement.setString(3, ApellidoMaterno);
                preparedStatement.setString(4, Usuario);
                preparedStatement.setInt(5, Especialidad);
                preparedStatement.executeUpdate();
                confirm.setTitle("Uusario registrado con exito");
                confirm.setContentText("El usuario ha sido registrado con exito");
                confirm.show();
            } else {
                error.setTitle("Conexion fallida");
                error.setContentText("No se ha podido conectar a la base de datos");
                error.show();

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertToUsuario(String Usuario, String Password, String Rol) {
        UsuariosConnect usuariosConnect = UsuariosConnect.getInstance();
        Connection connection = usuariosConnect.getConnection();
        PreparedStatement preparedStatement;
        String sql = "INSERT INTO usuarios(usuario,password,rol) VALUES(?, ?, ?)";
        try {
            if (connection != null) {
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, Usuario);
                preparedStatement.setString(2, Password);
                preparedStatement.setString(3, Rol);
                preparedStatement.executeUpdate();
            } else {
                System.out.println("No se ha podido conectar a la base de datos");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void InicioSesion(String Usuario, String Password) {
        UsuariosConnect usuariosConnect = UsuariosConnect.getInstance();
        Connection connection = usuariosConnect.getConnection();
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        String sql = "SELECT * FROM usuarios WHERE usuario = ? AND password = ?";
        try {
            if (connection != null) {
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, Usuario);
                preparedStatement.setString(2, Encriptar(Password));
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    System.out.println("Bienvenido");
                } else {
                    System.out.println("Usuario o contraseña incorrectos");
                }

            } else {
                System.out.println("No se ha podido conectar a la base de datos");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String Encriptar(String Password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(Password.getBytes());
            byte[] digest = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b));
            }
            System.out.println("Encriptación MD5: " + sb);
            return String.valueOf(sb);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

    }

    public static Abogado getInstance() {
        if (abogado_instance == null) {
            abogado_instance = new Abogado();
        }
        return abogado_instance;
    }
}