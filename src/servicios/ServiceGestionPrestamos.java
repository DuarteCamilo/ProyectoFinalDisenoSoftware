/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

/**
 *
 * @author cduar
 */
import ConexioDB.ConexionDB;

import Modelos.PrestamoLibro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ServiceGestionPrestamos  {
    private static ServiceGestionPrestamos  INSTANCE ;
    
    private static Connection conn ;
    
    private ServiceGestionPrestamos () {
        conn = ConexionDB.getINSTANCE().getConnection();
    }
    
    public static ServiceGestionPrestamos getINSTANCE() {
        if(INSTANCE == null){
            INSTANCE = new ServiceGestionPrestamos();
        }
        return INSTANCE;
    }
    
    
    public ResultSet getRs(){
        
        try {
            String sql = "SELECT L.codigo_libro, L.titulo, L.autor, C.nombre_categoria, L.anio_publicacion, L.cant_dispo FROM libros AS L INNER JOIN categorias_libros AS C ON L.categoria = C.id_categoria;";                    
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            return rs;
            
        } catch (Exception ex) {
            Logger.getLogger(ServiceCategoriaLibros.class.getName()).log(Level.SEVERE, null, ex);

        }
        return null;
    }

    

    public boolean registrarPrestamo(int cedula, String codigo_libro, String fecha_prestamo, String fecha_vencimiento) {
        try {
            String verificarLibrosSql = "SELECT cant_dispo FROM libros WHERE codigo_libro = ?";
            PreparedStatement verificarLibrosStatement = conn.prepareStatement(verificarLibrosSql);
            verificarLibrosStatement.setString(1, codigo_libro);
            ResultSet librosResult = verificarLibrosStatement.executeQuery();

            if (librosResult.next()) {
                int cantidadDisponible = librosResult.getInt("cant_dispo");
                if (cantidadDisponible > 0) {
                    String restarLibroSql = "UPDATE libros SET cant_dispo = ? WHERE codigo_libro = ?";
                    PreparedStatement restarLibroStatement = conn.prepareStatement(restarLibroSql);
                    restarLibroStatement.setInt(1, cantidadDisponible - 1);
                    restarLibroStatement.setString(2, codigo_libro);
                    restarLibroStatement.executeUpdate();
                    restarLibroStatement.close();

                    String insertarPrestamoSql = "INSERT INTO prestamos (cedula, codigo_libro, fecha_prestamo, fecha_vencimiento) VALUES (?, ?, ?, ?)";
                    PreparedStatement insertarPrestamoStatement = conn.prepareStatement(insertarPrestamoSql);
                    insertarPrestamoStatement.setInt(1, cedula); 
                    insertarPrestamoStatement.setString(2, codigo_libro); 
                    insertarPrestamoStatement.setString(3, fecha_prestamo);
                    insertarPrestamoStatement.setString(4, fecha_vencimiento);
                    insertarPrestamoStatement.executeUpdate();
                    insertarPrestamoStatement.close();

                    JOptionPane.showMessageDialog(null, "Préstamo registrado exitosamente.");
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "No hay suficientes libros disponibles.", "Error", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            } else {
                JOptionPane.showMessageDialog(null, "El libro no existe.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al registrar el préstamo.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }



    public boolean registrarDevolucion(int prestamo_id ,String fecha_devolucion) {
        try {
            String obtenerCodigolibro = "SELECT codigo_libro FROM prestamos WHERE prestamo_id = ?";
            PreparedStatement obtenerCodigolibro1 = conn.prepareStatement(obtenerCodigolibro);
            obtenerCodigolibro1.setInt(1, prestamo_id);
            ResultSet rs = obtenerCodigolibro1.executeQuery();
            if(rs.next()){
                String codigo_libro = rs.getString("codigo_libro");
                String actualizarFechaDevolucionSql = "UPDATE prestamos SET fecha_devolucion = ? WHERE prestamo_id = ?";
                PreparedStatement actualizarFechaDevolucionStatement = conn.prepareStatement(actualizarFechaDevolucionSql);
                actualizarFechaDevolucionStatement.setString(1, fecha_devolucion);
                actualizarFechaDevolucionStatement.setInt(2, prestamo_id);
                actualizarFechaDevolucionStatement.executeUpdate();
                actualizarFechaDevolucionStatement.close();

                String incrementarCantidadSql = "UPDATE libros SET cant_dispo = cant_dispo + 1 WHERE codigo_libro = ?";
                PreparedStatement incrementarCantidadStatement = conn.prepareStatement(incrementarCantidadSql);
                incrementarCantidadStatement.setString(1, codigo_libro);
                incrementarCantidadStatement.executeUpdate();
                incrementarCantidadStatement.close();
                JOptionPane.showMessageDialog(null, "Devolución registrada exitosamente.");
                return true;
            }
            obtenerCodigolibro1.close();
  
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public ArrayList<PrestamoLibro> buscarPrestamosActivosPorUsuario(int cedula ) {
        ArrayList<PrestamoLibro> prestamosActivos = new ArrayList<>();
        String sql = "SELECT * FROM prestamos WHERE cedula = ?  ";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, cedula);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id_prestamo = resultSet.getInt("prestamo_id");
                String codigo_libro = resultSet.getString("codigo_libro");
                String fechaPrestamoString = resultSet.getString("fecha_prestamo");
                String fechaVencimientoString = resultSet.getString("fecha_vencimiento");
                String fechaDevolucionString = resultSet.getString("fecha_devolucion");
                if(fechaDevolucionString.equals("")){
                    LocalDate fecha_devolucion = null;
                    LocalDate fecha_prestamo = LocalDate.parse(fechaPrestamoString);
                    LocalDate fecha_vencimiento = LocalDate.parse(fechaVencimientoString);
                    PrestamoLibro prestamo = new PrestamoLibro(id_prestamo, cedula, codigo_libro, fecha_prestamo, fecha_vencimiento , fecha_devolucion);
                    prestamosActivos.add(prestamo);
                    
                }else{
                    LocalDate fecha_devolucion = LocalDate.parse(fechaDevolucionString);
                    LocalDate fecha_prestamo = LocalDate.parse(fechaPrestamoString);
                    LocalDate fecha_vencimiento = LocalDate.parse(fechaVencimientoString);
                    PrestamoLibro prestamo = new PrestamoLibro(id_prestamo, cedula, codigo_libro, fecha_prestamo, fecha_vencimiento , fecha_devolucion);
                    prestamosActivos.add(prestamo);
                    
                }
            }
            statement.close();
            return prestamosActivos;
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return prestamosActivos;
    }
    
    
}
