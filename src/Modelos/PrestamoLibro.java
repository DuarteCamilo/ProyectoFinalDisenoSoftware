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
    private int  cedula; // Sceduuponemos que tienes una clase User para representar usuarios
    private String codigo_libro;
    private LocalDate fechaPrestamo;
    private LocalDate fechaVencimiento;
    private LocalDate fechaDevolucion;
    // Otros atributos y métodos necesarios
    
    // Constructor para la solicitud de préstamo
    public PrestamoLibro( int cedula, String codigo_libro, LocalDate fechaPrestamo, LocalDate fechaVencimiento) {
        
        this.cedula = cedula;
        this.codigo_libro = codigo_libro;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaVencimiento = fechaVencimiento;
    }
    
     public PrestamoLibro(int id_prestamo, int cedula, String codigo_libro, LocalDate fechaPrestamo, LocalDate fechaVencimiento) {
        this.id_prestamo = id_prestamo;
        this.cedula = cedula;
        this.codigo_libro = codigo_libro;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaVencimiento = fechaVencimiento;
    }
    
    // Constructor para registrar la devolución
    public PrestamoLibro(int id_prestamo, LocalDate fechaDevolucion) {
        this.id_prestamo = id_prestamo;
        this.fechaDevolucion = fechaDevolucion;
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

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
    
    

}
