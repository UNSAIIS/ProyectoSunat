/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genfactura;

import clases.Cabecera;
import clases.Detalle;
import clases.Leyenda;
import controlador.BolElectronica;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author obardales
 */
public class EmitirBoleta {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cabecera articuloCab = new Cabecera();
        
        // Empresa
        articuloCab.setEmpr_tipodoc("6");
        articuloCab.setEmpr_nroruc("20380456447");
        articuloCab.setEmpr_razonsocial("XDEPSILONDX S.A.C");
        articuloCab.setEmpr_nombrecomercial("XDEPSILONDX S.A.C");
        articuloCab.setEmpr_direccion("No se donde vivo");
        articuloCab.setEmpr_distrito("Arequipa");
        articuloCab.setEmpr_provincia("Arequipa");
        articuloCab.setEmpr_departamento("Arequipa");
        articuloCab.setEmpr_ubigeo("040101");
        articuloCab.setEmpr_pais("PE");
        articuloCab.setDocu_enviaws("S");
        
        articuloCab.setClie_tipodoc("1"); 
        articuloCab.setClie_numero("12345678");
        articuloCab.setClie_nombre("gabriel alex justo huayna");
        
        //documento
        // Cabecera
        articuloCab.setDocu_tipodocumento("03"); 
        articuloCab.setDocu_numero("BB01-500"); 
        articuloCab.setDocu_fecha("2017-10-28"); // formato segun sunat
        articuloCab.setDocu_gravada("18757.46");
        articuloCab.setDocu_igv("3376.34");
        articuloCab.setDocu_descuento("0.00");
        articuloCab.setDocu_exonerada("0.00");
        articuloCab.setDocu_gratuita("0.00");
        articuloCab.setDocu_inafecta("0.00");
        articuloCab.setDocu_isc("0.00");
        articuloCab.setDocu_moneda("PEN");
        articuloCab.setDocu_otroscargos("0.00");
        articuloCab.setDocu_otrostributos("0.00");
        articuloCab.setDocu_total("22133.80");
        
        //Detalle
        Detalle detdoc = new Detalle();
        List<Detalle> detdocelec = new ArrayList<>();
        
        detdoc.setItem_orden("1");
        detdoc.setItem_codproducto("12");
        detdoc.setItem_descripcion("Guantes 3d");
        detdoc.setItem_unidad("NIU");
        detdoc.setItem_cantidad("10.00");
        detdoc.setItem_moneda("PEN");
        detdoc.setItem_pventa("25.00");
        detdoc.setItem_ti_subtotal("250.00");
        detdoc.setItem_pventa_no_onerosa("0.00");
        detdoc.setItem_ti_igv("5.20");
        detdoc.setItem_afectacion("10");
                
        detdocelec.add(detdoc);
        
        detdoc = new Detalle();        
        
        detdoc.setItem_orden("2");
        detdoc.setItem_codproducto("ZZer12");
        detdoc.setItem_descripcion("Polo 3d");
        detdoc.setItem_unidad("NIU");
        detdoc.setItem_cantidad("12.00");
        detdoc.setItem_moneda("PEN");
        detdoc.setItem_pventa("50.00");
        detdoc.setItem_ti_subtotal("600.00");
        detdoc.setItem_pventa_no_onerosa("0.00");
        detdoc.setItem_ti_igv("5.32");
        detdoc.setItem_afectacion("10");
        
        detdocelec.add(detdoc);

        //Leyendas
        Leyenda leyenda = new Leyenda();
        List<Leyenda> leyendas = new ArrayList<>();
        
        leyenda.setLeyendaCodigo("1000");
        leyenda.setLeyendaTexto("VEINTIDOS MIL CIENTO TREINTITRES Y 80/100 SOLES");
        
        leyendas.add(leyenda);
        
        BolElectronica.generarXMLZipiadoBoleta(articuloCab, detdocelec, leyendas);
    }
    
}
