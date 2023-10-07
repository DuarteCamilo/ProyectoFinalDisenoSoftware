/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.time.LocalDate;


/**
 *
 * @author cduar
 */
public class PrestamoLibro {
    private int id_prestamo;
    private int  cedula; 
    private String codigo_libro;
    private LocalDate fecha_prestamo;
    private LocalDate fecha_vencimiento;
    private LocalDate fecha_devolucion;
    
    // Constructor para  préstamo
    public PrestamoLibro( int cedula, String codigo_libro, LocalDate fecha_prestamo, LocalDate fecha_vencimiento) {
        
        this.cedula = cedula;
        this.codigo_libro = codigo_libro;
        this.fecha_prestamo = fecha_prestamo;
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public PrestamoLibro(int id_prestamo, int cedula, String codigo_libro, LocalDate fecha_prestamo, LocalDate fecha_vencimiento, LocalDate fecha_devolucion) {
        this.id_prestamo = id_prestamo;
        this.cedula = cedula;
        this.codigo_libro = codigo_libro;
        this.fecha_prestamo = fecha_prestamo;
        this.fecha_vencimiento = fecha_vencimiento;
        this.fecha_devolucion = fecha_devolucion;
    }
    
    
    
    // Constructor para  la devolución
    public PrestamoLibro(int id_prestamo, LocalDate fecha_devolucion) {
        this.id_prestamo = id_prestamo;
        this.fecha_devolucion = fecha_devolucion;
    }

    public int getId_prestamo() {
        return id_prestamo;
    }

    public void setId_prestamo(int id_prestamo) {
        this.id_prestamo = id_prestamo;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getCodigo_libro() {
        return codigo_libro;
    }

    public void setCodigo_libro(String codigo_libro) {
        this.codigo_libro = codigo_libro;
    }

    public LocalDate getFecha_prestamo() {
        return fecha_prestamo;
    }

    public void setFecha_prestamo(LocalDate fecha_prestamo) {
        this.fecha_prestamo = fecha_prestamo;
    }

    public LocalDate getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(LocalDate fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public LocalDate getFecha_devolucion() {
        return fecha_devolucion;
    }

    public void setFecha_devolucion(LocalDate fecha_devolucion) {
        this.fecha_devolucion = fecha_devolucion;
    }
    
    

}
