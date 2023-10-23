/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reporte;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.swing.JOptionPane;

/**
 *
 * @author cduar
 */
public class GenerarReporte {
    public static void main(String[] args) {
        // Crear un nuevo documento PDF
        Document documento = new Document() {};
        try {
            // Obtener la ruta del directorio de inicio del usuario
            String ruta = System.getProperty("user.home");

            // Crear un escritor PDF que escribirá en un archivo en el escritorio del usuario
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Downloads/hola.pdf"));

            // Abrir el documento para escribir en él
            documento.open();

            // Crear una tabla con 3 columnas
            PdfPTable tabla = new PdfPTable(3);

            // Agregar encabezados a la tabla
            tabla.addCell("Código");
            tabla.addCell("Nombre del Alumno");
            tabla.addCell("Grupo");

            // Agregar datos de un estudiante a la tabla
            tabla.addCell("2320181007");
            tabla.addCell("Nicolas Duran Garces");
            tabla.addCell("Ing Software 4to Semestre");

            // Agregar la tabla al documento PDF
            documento.add(tabla);

            // Cerrar el documento PDF
            documento.close();

            // Mostrar un mensaje emergente de notificación
            JOptionPane.showMessageDialog(null, "Reporte creado.");
        } catch (DocumentException | HeadlessException | FileNotFoundException e) {
            
            // Capturar y manejar excepciones (en este caso, no se hace nada si ocurren)
        }
    }
}
