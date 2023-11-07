/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;


import ConexioDB.ConexionDB;
import Modelos.Libro;
import interfaces.DAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author cduar
 */
public class ServiceLibros implements DAO {
    private static ServiceLibros INSTANCE;
    private static PreparedStatement ps;
    private static Connection conn;
    private static ResultSet rs;
    private static String sql;

    
    private ServiceLibros() {   
        conn = ConexionDB.getINSTANCE().getConnection();
    }

    public static ServiceLibros getINSTANCE() {
        if(INSTANCE == null){
            INSTANCE = new ServiceLibros();
        }
        return INSTANCE;
    }

    public  ArrayList obtenerLibrosFiltro(int categoria){
        ArrayList<Libro> libros = new ArrayList<>();
        try {
            
            String sql = "SELECT id_libro,codigo_libro,titulo,autor,anio_publicacion,cant_dispo FROM libros WHERE categoria=? ;" ;
            ps = conn.prepareStatement(sql);
            ps.setInt(1, categoria );
            rs = ps.executeQuery();

            while (rs.next()) {
                int id_libro = rs.getInt("id_libro");
                String codigo_libro = rs.getString("codigo_libro");
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                int cant_dispo = rs.getInt("cant_dispo");
                int anio_publicacion = rs.getInt("anio_publicacion");
                Libro libro = new Libro(id_libro, codigo_libro, titulo, autor, categoria, anio_publicacion, cant_dispo);
                libros.add(libro);         
           }   
           return libros;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return libros;
        
    }
      
    public  ArrayList getALL(){
        ArrayList<Libro> listaLibros = new ArrayList();
        try {
            sql = "SELECT * FROM libros;" ;
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String codigo_libro = rs.getString("codigo_libro");
                int id_libro = rs.getInt("id_libro");
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                int cant_dispo = rs.getInt("cant_dispo");
                int anio_publicacion = rs.getInt("anio_publicacion");
                int categoria = rs.getInt("categoria");
                Libro libro = new Libro(id_libro, codigo_libro, titulo, autor, categoria, anio_publicacion, cant_dispo);     
                listaLibros.add(libro);  
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return listaLibros;     
    }

    @Override
    public boolean agregar(Object insertion) {
        try{ 
            Libro libro = (Libro)insertion;       
            String codigo_libro = libro.getCodigo_libro();
            String titulo = libro.getTitulo();
            String autor = libro.getAutor();
            int categoria = libro.getCategoria() ;
            int anio_publicacion = libro.getAnio_publicacion();
            int cant_dispo = libro.getCant_dispo() ;
            Libro aux = buscar(codigo_libro);

            if (aux != null) {                
                JOptionPane.showMessageDialog(null, "El libro con el codigo " + codigo_libro + " ya está registrado", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            } else {
                sql = "INSERT INTO libros(codigo_libro,titulo,autor,categoria,anio_publicacion,cant_dispo)" +  "VALUES(?,?,?,?,?,?);";
                ps = conn.prepareStatement(sql);
                ps.setString(1, codigo_libro);
                ps.setString(2, titulo);
                ps.setString(3, autor);
                ps.setInt(4, categoria);
                ps.setInt(5, anio_publicacion);
                ps.setInt(6, cant_dispo);
                ps.executeUpdate();
                ps.close();
                JOptionPane.showMessageDialog(null, "Libro agregado");
                return true;
            }
                   
        }catch( SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }   
        return false;
        
    }

    @Override
    public boolean eliminar(Object insertion) {
        try{
            String codigo_libro = (String)insertion;
            Libro aux = buscar(codigo_libro);

            if (aux != null) { 
                sql = "DELETE from libros where codigo_libro =?;";
                ps = conn.prepareStatement(sql);
                ps.setString(1, codigo_libro );
                ps.executeUpdate();
                ps.close();           
                JOptionPane.showMessageDialog(null, "Datos eliminados");
                return true;
                
            }else {
                JOptionPane.showMessageDialog(null, "El Libro con el codigo " + codigo_libro + " no está registrado", "Error", JOptionPane.ERROR_MESSAGE);                 
                return false;
            }       
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    @Override
    public boolean editar(Object insertion) {
        try {
            Libro libro = (Libro)insertion;       
            String codigo_libro = libro.getCodigo_libro();
            String titulo = libro.getTitulo();
            String autor = libro.getAutor();
            int categoria = libro.getCategoria() ;
            int anio_publicacion = libro.getAnio_publicacion();
            int cant_dispo = libro.getCant_dispo() ;
            Libro aux = buscar(codigo_libro);
            
            if(aux != null){
                sql = "UPDATE libros set titulo=?,autor=?,categoria=?,anio_publicacion=?,cant_dispo=? where codigo_libro=?;";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, titulo);
                ps.setString(2, autor);
                ps.setInt(3, categoria);
                ps.setInt(4, anio_publicacion);
                ps.setInt(5, cant_dispo);
                ps.setString(6, codigo_libro);
                ps.executeUpdate();
                ps.close();
                JOptionPane.showMessageDialog(null, "Datos actualizados");
                return true;
            }else {
                JOptionPane.showMessageDialog(null, "El Libro con el codigo " + codigo_libro + " no está registrado", "Error", JOptionPane.ERROR_MESSAGE);                 
                return false;
            }        
        }catch( SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } 
        return false;
    }

    @Override
    public Libro buscar(Object insertion) {
        try {
            String codigo_libro = (String)insertion;
            sql = "SELECT * FROM libros WHERE codigo_libro = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, codigo_libro);
            rs = ps.executeQuery();
            if(rs.next()){
                int id_libro = rs.getInt("id_libro");
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                int categoria = rs.getInt("categoria");
                int cant_dispo = rs.getInt("cant_dispo");
                int anio_publicacion = rs.getInt("anio_publicacion");
                Libro libro = new Libro(id_libro, codigo_libro, titulo, autor, categoria, anio_publicacion, cant_dispo);
                return libro;      
            }
        }catch( SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } 
        return null;
    }
}
