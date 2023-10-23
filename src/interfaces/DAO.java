/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;
import java.sql.ResultSet;
import java.util.ArrayList;


/**
 *
 * @author cduar
 */
public interface DAO {
    boolean agregar(Object insertion)  ;
    boolean eliminar(Object insertion)   ;
    boolean editar(Object insertion)    ;
    ResultSet buscar(Object insertion)   ;
}
