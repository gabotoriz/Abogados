package com.example.despacho.Controller;

import com.example.despacho.Models.Abogado;
import com.example.despacho.Switch;
import com.example.despacho.Views;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.net.URL;
import java.util.ResourceBundle;

@Getter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class MainController implements Initializable {
    @FXML
    TextField JTF_Usuario;
    @FXML
    PasswordField JPF_Password;
    @FXML
    Button BTN_Ingresar;
    @FXML
    Pane P_Buffet;

    public void Iniciar(String Usuario, String Password) {
        Abogado abogado = Abogado.getInstance();
        abogado.InicioSesion(Usuario, Password);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        BTN_Ingresar.setOnAction(e -> {
            Iniciar(JTF_Usuario.getText(), JPF_Password.getText());
        });
    }
}