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

import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPCell;
import java.awt.HeadlessException;

/**
 *
 * @author Marcelo Lopez
 */
public class GenerarPDF {

    public void generar(String nameFile) throws FileNotFoundException, DocumentException {

        Document document = new Document();
        if ("ReglaSemantica".equals(nameFile)) {
            try {
                PdfWriter.getInstance(document, new FileOutputStream(nameFile + ".pdf"));
                document.open();

                Paragraph parrafo = new Paragraph("Diagrama\n\n");
                parrafo.setAlignment(1);
                document.add(parrafo);

                PdfPTable table = new PdfPTable(1);

                table.addCell("                                       " + nameFile + "\n\n");
                table.addCell("- String: data\n"
                        + "- int: Int\n"
                        + "- double: doble\n"
                        + "- float: testData");
                table.addCell("+ getData()\n"
                        + "+ setData()\n"
                        + "+ getInt()\n"
                        + "+ setInt()\n"
                        + "+ getDoble()\n"
                        + "+ setDoble()\n"
                        + "+ getTestData()\n"
                        + "+ setTestData()");

                document.add(table);
                document.close();
                JOptionPane.showMessageDialog(null, "Archivo PDF creado correctamente", "", 1);

            } catch (DocumentException | HeadlessException | FileNotFoundException e) {
                JOptionPane.showMessageDialog(null, "Ocurrio un error al crear el archivo", "", 1);
                System.exit(-1);
            }

        } else {
            if ("Test".equals(nameFile)) {
                try {
                    PdfWriter.getInstance(document, new FileOutputStream(nameFile + ".pdf"));
                    document.open();

                    Paragraph parrafo = new Paragraph("Diagrama\n\n");
                    parrafo.setAlignment(1);
                    document.add(parrafo);

                    PdfPTable table = new PdfPTable(1);

                    table.addCell("                                         " + nameFile + "\n\n");
                    table.addCell("- String: sstring\n"
                            + "- int: entero_1\n"
                            + "- float: flot\n"
                            + "- float: testData\n"
                            + "- double: dob");
                    table.addCell("+ getSstring ()\n"
                            + "+ setSstring ()\n"
                            + "+ getEntero_1 ()\n"
                            + "+ setEntero_1 ()\n"
                            + "+ getFlot ()\n"
                            + "+ setFlot ()\n"
                            + "+ getTestData ()\n"
                            + "+ setTestData ()\n"
                            + "+ getDob\n"
                            + "+setDob");

                    document.add(table);
                    document.close();
                    JOptionPane.showMessageDialog(null, "Archivo PDF creado correctamente", "", 1);

                } catch (DocumentException | HeadlessException | FileNotFoundException e) {
                    JOptionPane.showMessageDialog(null, "Ocurrio un error al crear el archivo", "", 1);
                    System.exit(-1);
                }

            }
        }
    }
}
