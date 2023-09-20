/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author cduar
 */
public class Libro {
    
    private int id_libro ;
    private String codigo_libro;
    private String titulo;
    private String autor;
    private int categoria;
    private int anio_publicacion;
    private int cant_dispo;

    public Libro(int id_libro, String codigo_libro, String titulo, String autor, int categoria, int anio_publicacion, int cant_dispo) {
        this.id_libro = id_libro;
        this.codigo_libro = codigo_libro;
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.anio_publicacion = anio_publicacion;
        this.cant_dispo = cant_dispo;
    }

    public int getId_libro() {
        return id_libro;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }

    public String getCodigo_libro() {
        return codigo_libro;
    }

    public void setCodigo_libro(String codigo_libro) {
        this.codigo_libro = codigo_libro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public int getAnio_publicacion() {
        return anio_publicacion;
    }

    public void setAnio_publicacion(int anio_publicacion) {
        this.anio_publicacion = anio_publicacion;
    }

    public int getCant_dispo() {
        return cant_dispo;
    }

    public void setCant_dispo(int cant_dispo) {
        this.cant_dispo = cant_dispo;
    }
    
    
    
}
