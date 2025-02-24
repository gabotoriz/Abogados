package com.example.despacho.Controller;

import com.example.despacho.Switch;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import lombok.Getter;

import java.net.URL;
import java.util.ResourceBundle;

@Getter
public class MainController implements Initializable {
    @FXML
    private Button BTN_Agregar;
    @FXML
    private Button BTN_Consultar;
    @FXML
    private Button BTN_Salir;

    public void toAgregar(){
        Switch.switchTo(Views.Agregar);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}