package com.example.despacho;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public enum Views {
    Agregar("agregar-view.fxml"),
    Inicio("main-view.fxml");
    String FileName;
}
