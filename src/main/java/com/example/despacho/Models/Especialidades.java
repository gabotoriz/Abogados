package com.example.despacho.Models;

import com.example.despacho.DataBases.Despacho.DespachoConnect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Especialidades {
    int IdEspecialidad;
    String Especialidad;
    static Especialidades especialidades_instance;

    public ObservableList<Especialidades> getEspecialidades() {
        DespachoConnect despachoConnect = DespachoConnect.getInstance();
        Connection connection = despachoConnect.getConnection();
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        ObservableList<Especialidades> especialidades = FXCollections.observableArrayList();
        String sql = "SELECT * FROM especialidades";
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                especialidades.add(new Especialidades(resultSet.getInt("IdEspecialidad"), resultSet.getString("Especialidad")));
            }
            return especialidades;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Especialidades getInstance() {
        if (especialidades_instance == null) {
            especialidades_instance = new Especialidades();
        }
        return especialidades_instance;
    }
}
