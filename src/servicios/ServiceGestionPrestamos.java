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
import interfaces.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ServiceGestionPrestamos  implements DAO{
    private static ServiceGestionPrestamos  INSTANCE ;
    private static PreparedStatement ps;
    private static Connection conn;
    private static ResultSet rs;
    private static String sql;
    
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
            sql = "SELECT L.codigo_libro, L.titulo, L.autor, C.nombre_categoria, L.anio_publicacion, L.cant_dispo FROM libros AS L INNER JOIN categorias_libros AS C ON L.categoria = C.id_categoria;";                    
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            return rs;
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }


    public ArrayList<PrestamoLibro> buscarPrestamosActivosPorUsuario(int cedula ) {
        ArrayList<PrestamoLibro> prestamosActivos = new ArrayList<>();
        
        try {
            sql = "SELECT * FROM prestamos WHERE cedula = ?  ";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, cedula);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id_prestamo = rs.getInt("prestamo_id");
                String codigo_libro = rs.getString("codigo_libro");
                String fechaPrestamoString = rs.getString("fecha_prestamo");
                String fechaVencimientoString = rs.getString("fecha_vencimiento");
                String fechaDevolucionString = rs.getString("fecha_devolucion");
                if(fechaDevolucionString.equals(" ")){
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
            ps.close();
            return prestamosActivos;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);            
        }
        return prestamosActivos;
    }
    

    public ArrayList getAll(){
        ArrayList<PrestamoLibro> prestamos = new ArrayList<>();
        try {
            sql = "SELECT * FROM prestamos;";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id_prestamo = rs.getInt("prestamo_id");
                String codigo_libro = rs.getString("codigo_libro");
                String fechaPrestamoString = rs.getString("fecha_prestamo");
                String fechaVencimientoString = rs.getString("fecha_vencimiento");
                String fechaDevolucionString = rs.getString("fecha_devolucion");
                int cedula = rs.getInt("cedula");

                if(fechaDevolucionString.equals(" ")){
                    LocalDate fecha_devolucion = null;
                    LocalDate fecha_prestamo = LocalDate.parse(fechaPrestamoString);
                    LocalDate fecha_vencimiento = LocalDate.parse(fechaVencimientoString);
                    PrestamoLibro prestamo = new PrestamoLibro(id_prestamo, cedula, codigo_libro, fecha_prestamo, fecha_vencimiento , fecha_devolucion);
                    prestamos.add(prestamo);
                    
                }else{
                    LocalDate fecha_devolucion = LocalDate.parse(fechaDevolucionString);
                    LocalDate fecha_prestamo = LocalDate.parse(fechaPrestamoString);
                    LocalDate fecha_vencimiento = LocalDate.parse(fechaVencimientoString);
                    PrestamoLibro prestamo = new PrestamoLibro(id_prestamo, cedula, codigo_libro, fecha_prestamo, fecha_vencimiento , fecha_devolucion);
                    prestamos.add(prestamo);                   
                }
            }
            ps.close();
            return prestamos;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return prestamos;
    }
    


    @Override
    public boolean agregar(Object insertion) {
        Object[] values = (Object[])insertion;
        int cedula = Integer.parseInt( values[0].toString());
        String codigo_libro = values[1].toString();
        String fecha_prestamo = values[2].toString();
        String fecha_vencimiento = values[3].toString();
        try {
            sql = "SELECT cant_dispo FROM libros WHERE codigo_libro = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, codigo_libro);
            rs = ps.executeQuery();

            if (rs.next()) {
                int cantidadDisponible = rs.getInt("cant_dispo");
                if (cantidadDisponible > 0) {
                    sql = "UPDATE libros SET cant_dispo = ? WHERE codigo_libro = ?";
                    ps = conn.prepareStatement(sql);
                    ps.setInt(1, cantidadDisponible - 1);
                    ps.setString(2, codigo_libro);
                    ps.executeUpdate();
                    ps.close();

                    sql = "INSERT INTO prestamos (cedula, codigo_libro, fecha_prestamo, fecha_vencimiento, fecha_devolucion) VALUES (?, ?, ?, ?, ?)";
                    ps = conn.prepareStatement(sql);
                    ps.setInt(1, cedula); 
                    ps.setString(2, codigo_libro); 
                    ps.setString(3, fecha_prestamo);
                    ps.setString(4, fecha_vencimiento);
                    ps.setString(5, " ");
                    ps.executeUpdate();
                    ps.close();
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
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    @Override
    public boolean eliminar(Object insertion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean editar(Object insertion) {
        try {
            Object[] values = (Object[])insertion;
            int prestamo_id = Integer.parseInt(values[0].toString());
            String fecha_devolucion = values[1].toString();
            sql = "SELECT codigo_libro FROM prestamos WHERE prestamo_id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, prestamo_id);
            rs = ps.executeQuery();
            if(rs.next()){
                String codigo_libro = rs.getString("codigo_libro");
                sql = "UPDATE prestamos SET fecha_devolucion = ? WHERE prestamo_id = ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, fecha_devolucion);
                ps.setInt(2, prestamo_id);
                ps.executeUpdate();
                ps.close();

                sql = "UPDATE libros SET cant_dispo = cant_dispo + 1 WHERE codigo_libro = ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, codigo_libro);
                ps.executeUpdate();
                ps.close();
                JOptionPane.showMessageDialog(null, "Devolución registrada exitosamente.");
                return true;
            }
            ps.close();
  
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    @Override
    public ResultSet buscar(Object insertion) {
        try {
            int prestamo_id = (int)insertion;
            sql = "SELECT * FROM prestamos WHERE prestamo_id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, prestamo_id);
            rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            
        }
        return null;
    }
    
    
}
