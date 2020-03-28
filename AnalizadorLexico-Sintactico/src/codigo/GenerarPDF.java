package codigo;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Marcelo Lopez
 */
public class GenerarPDF {

    public void generar(String name) throws FileNotFoundException, DocumentException {

        FileOutputStream archivo = new FileOutputStream(name + ".pdf");
        Document documento = new Document();
        PdfWriter.getInstance(documento, archivo);
        documento.open();

        Paragraph parrafo = new Paragraph("Datos");
        parrafo.setAlignment(1);
        documento.add(parrafo);

        documento.add(new Paragraph("Nombre: " + "Prueba"));
        documento.add(new Paragraph("Apellidos: " + "Cruz"));
        documento.add(new Paragraph("Edad: " + 19));
        documento.add(new Paragraph("Hola: " + "Perraaa"));
        documento.close();

        JOptionPane.showMessageDialog(null, "Archivo PDF creado correctamente", "Información", 1);

    }

    public static void main(String[] args) throws FileNotFoundException {
        GenerarPDF gp = new GenerarPDF();

        try {
            gp.generar("Semantico");   // Es el nombre del Archivo
        } catch (DocumentException ex) {
            Logger.getLogger(GenerarPDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
