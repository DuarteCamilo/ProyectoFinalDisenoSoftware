/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

import ConexioDB.ConexionDB;
import Modelos.Categoria;
import interfaces.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 *
 * @author cduar
 */
public class ServiceCategoriaLibros implements DAO {

    private static ServiceCategoriaLibros INSTANCE;
    private static PreparedStatement ps;
    private static Connection conn;
    private static ResultSet rs;
    private static String sql;

    private ServiceCategoriaLibros() {
        conn = ConexionDB.getINSTANCE().getConnection();
    }

    public static ServiceCategoriaLibros getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new ServiceCategoriaLibros();
        }
        return INSTANCE;
    }

    public  ArrayList getAll() {
        ArrayList<Categoria> listaCategorias = new ArrayList();
        try {
            sql = "SELECT * FROM categorias_libros;";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id_categoria = rs.getInt("id_categoria");
                String nombre_categoria = rs.getString("nombre_categoria");
                Categoria categoria = new Categoria(id_categoria, nombre_categoria);
                listaCategorias.add(categoria);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return listaCategorias;
    }
    
    


    @Override
    public boolean agregar(Object insertion) {
        try {
            sql = "INSERT INTO categorias_libros( nombre_categoria) VALUES(?);";
            String nombre_categoria = insertion.toString();
            ps = conn.prepareStatement(sql);
            ps.setString(1, nombre_categoria);
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Categoria Agregada");
            return true;          
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }  
    }

    @Override
    public boolean eliminar(Object insertion) {    
        try {
            int id_categoria = (int) insertion;
            Categoria aux = buscar(id_categoria);  
            if(aux != null){
                sql = "DELETE from categorias_libros where id_categoria=?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, id_categoria);
                ps.executeUpdate();
                ps.close();
                JOptionPane.showMessageDialog(null, "Categoria Eliminada");
                return true;  
            }else{
                JOptionPane.showMessageDialog(null, "La categoria con el id: "+ id_categoria+" no exixte", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }          
    }

    @Override
    public boolean editar(Object insertion) {
        try {
            Categoria categoria = (Categoria) insertion;
            String nombre_categoria = categoria.getNombre_categoria();
            int id_categoria = categoria.getId_categoria();
            Categoria aux = buscar(id_categoria);  
            if(aux != null){
                sql = "UPDATE categorias_libros SET nombre_categoria=? WHERE id_categoria=?;";
                ps = conn.prepareStatement(sql);
                ps.setString(1, nombre_categoria);
                ps.setInt(2, id_categoria);
                ps.executeUpdate();
                ps.close();
                return true;  
            }else{
                JOptionPane.showMessageDialog(null, "La categoria con el id: "+ id_categoria+" no exixte", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }     
    }

    @Override
    public Categoria buscar(Object insertion)  {
        try{
            int id_categoria = (int) insertion;
            sql = "SELECT * FROM categorias_libros WHERE id_categoria=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id_categoria);
            rs = ps.executeQuery();
            if(rs.next()){
                String nombre_categoria = rs.getString("nombre_categoria");
                Categoria categoria = new Categoria(id_categoria, nombre_categoria);
                return categoria ;
            }        
        }catch( SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }  
        return null;
    }

}
