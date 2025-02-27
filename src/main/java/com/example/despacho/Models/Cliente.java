package com.example.despacho.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Cliente {
    int IdCliente;
    String NombreCliente;
    String ApellidoPaterno;
    String ApellidoMaterno;
    String CURP;
    String Telefono;
    String Domicilio;
    String Correo;
    String EstadoCivil;

}
