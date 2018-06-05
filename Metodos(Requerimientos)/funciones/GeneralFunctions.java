/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funciones;

import clases.Cabecera;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class GeneralFunctions {



    //Generar archivo XML
    public static String crearZip(Cabecera articulos, String ruta, File nmArch) {
        String resultado = "";
        try {
            //Mandar a zip
            String inputFile = nmArch.toString();
            FileInputStream in = new FileInputStream(inputFile);
            FileOutputStream out = new FileOutputStream(ruta + articulos.getEmpr_nroruc() + "-" + articulos.getDocu_tipodocumento() + "-" + articulos.getDocu_numero() + ".zip");
           /* FileOutputStream out1 = new FileOutputStream("D:\\sunat_archivos\\sfs\\FIRMA");*/
            byte b[] = new byte[2048];
            try (ZipOutputStream zipOut = new ZipOutputStream(out)) {
                ZipEntry entry2 = new ZipEntry(articulos.getEmpr_nroruc() + "-" + articulos.getDocu_tipodocumento() + "-" + articulos.getDocu_numero() + ".xml");
                zipOut.putNextEntry(entry2);
                System.out.println( articulos.getEmpr_nroruc() + "-" + articulos.getDocu_tipodocumento() + "-" + articulos.getDocu_numero() + ".zip CREADO");
                int len = 0;
                while ((len = in.read(b)) != -1) {
                    zipOut.write(b, 0, len);
                }
                zipOut.closeEntry();
            }
            out.close();
            in.close();

        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return resultado;
    }
}
