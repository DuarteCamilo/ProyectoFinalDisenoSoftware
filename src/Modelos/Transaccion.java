/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author cduar
 */
public class Transaccion {
    private int id;
    private String accion;
    private LocalDate fecha;
    private LocalTime hora;
    private String detalles;
    private int id_usuario;

    public Transaccion(String accion, LocalDate fecha, LocalTime hora, String detalles, int id_usuario) {
        this.accion = accion;
        this.fecha = fecha;
        this.hora = hora;
        this.detalles = detalles;
        this.id_usuario = id_usuario;
    }
    
    public Transaccion(int id ,String accion, LocalDate fecha, LocalTime hora, String detalles, int id_usuario) {
        this.id = id;
        this.accion = accion;
        this.fecha = fecha;
        this.hora = hora;
        this.detalles = detalles;
        this.id_usuario = id_usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    
    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    
    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }
    
    
    
}
