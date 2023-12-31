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
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author cduar
 */
public class GenerarReporteTransacciones {
    
    public static void GenerarReporteTransacciones(ArrayList<ArrayList<String>> tabla) throws DocumentException, HeadlessException, FileNotFoundException {

        String numeroAleatorio = generarNumeroAleatorio();

        Document documento = new Document() {};

        String ruta = System.getProperty("user.home");

        PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Downloads/Transacciones" + numeroAleatorio + ".pdf"));

        documento.open();

        PdfPTable tablaReporte = new PdfPTable(tabla.get(0).size());

        tablaReporte.addCell("Accion");
        tablaReporte.addCell("ID Usuario");
        tablaReporte.addCell("Fecha");
        tablaReporte.addCell("Hora");
        tablaReporte.addCell("Detalles");

        for (int i = 0; i < tabla.size(); i++) {
            for (int j = 0; j < tabla.get(i).size(); j++) {
                tablaReporte.addCell(tabla.get(i).get(j));
            }
        }

        documento.add(tablaReporte);

        documento.close();

        JOptionPane.showMessageDialog(null, "Reporte creado como: " + "Reporte" + numeroAleatorio+".pdf");
    }

    public static String generarNumeroAleatorio() {
        int numero = (int) (Math.random() * 900) + 100;
        String numeroCadena = String.valueOf(numero);
        return numeroCadena;
    }
  
}
