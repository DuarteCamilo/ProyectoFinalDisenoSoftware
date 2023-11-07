/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

import ConexioDB.ConexionDB;
import Modelos.Transaccion;
import interfaces.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author cduar
 */
public class ServiceTransacciones implements DAO{
    private static ServiceTransacciones INSTANCE;
    private static PreparedStatement ps;
    private static Connection conn;
    private static ResultSet rs;
    private static String sql;
    
     private ServiceTransacciones() {
        conn = ConexionDB.getINSTANCE().getConnection();
    }

    public static ServiceTransacciones getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new ServiceTransacciones();
        }
        return INSTANCE;
    }
    
   
    
    
    public ArrayList<Transaccion> consultaTransaccion() {
        ArrayList<Transaccion> listaTransacciones = new ArrayList<>();
        try {
            sql = "SELECT * FROM transacciones ; ";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String detalles = rs.getString("detalles");
                String accion = rs.getString("accion");
                String fechaString = rs.getString("fecha");
                String horaString = rs.getString("hora");
                int id_usuario = rs.getInt("id_usuario");
                LocalDate fecha = LocalDate.parse(fechaString);
                LocalTime hora = LocalTime.parse(horaString);
                Transaccion aux = new Transaccion(accion, fecha, hora, detalles, id_usuario);
                listaTransacciones.add(aux);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return listaTransacciones;
    }
    
    
    @Override
    public boolean agregar(Object insertion) {
        try {
            Transaccion transaccion = (Transaccion)insertion;
            LocalTime horaUno= transaccion.getHora();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            String hora = horaUno.format(formatter);
            sql = "INSERT INTO transacciones(accion,detalles,fecha,hora,id_usuario) VALUES (?,?,?,?,?);";
            ps = conn.prepareStatement(sql);
            ps.setString(1, transaccion.getAccion());
            ps.setString(2, transaccion.getDetalles());
            ps.setString(3, String.valueOf(transaccion.getFecha()));
            ps.setString(4, hora);
            ps.setInt(5 , transaccion.getId_usuario());
            ps.executeUpdate();
            ps.close();
            return true;
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Transaccion buscar(Object insertion) {
        try {
            int id = (int)insertion;
            sql = "SELECT * FROM transacciones WHERE id=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                String accion = rs.getString("accion");
                String detalles = rs.getString("detalles");
                int id_usuario = rs.getInt("id_usuario");
                String fechaString = rs.getString("fecha");
                String horaString = rs.getString("hora");
                LocalDate fecha = LocalDate.parse(fechaString);
                LocalTime hora = LocalTime.parse(horaString);
                Transaccion transaccion = new Transaccion(id, accion, fecha, hora, detalles, id_usuario);
                ps.close();
                return transaccion;
   
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return null;

    }
    
    
}
