
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import javafx.scene.effect.BlurType;
import javax.swing.JOptionPane;
import static javax.swing.text.StyleConstants.FontFamily;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jarco
 */
public class Pruebas extends javax.swing.JFrame {

   conectar cc = new conectar();
     Connection cn = cc.conexion();
    Integer area=1234;
    public Pruebas() {
        initComponents();
    }
    public void prueba (){
      
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("jButton2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(jButton2)))
                .addContainerGap(116, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(33, 33, 33)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(83, 83, 83))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//     try{
//         String path="src\\Reporte1.jasper";
//         JasperReport reporte = (JasperReport) JRLoader.loadObject("src\\Reporte1.jasper");
//         Map parametro= new HashMap();
//         parametro.put("area", area);
//         JasperPrint j= JasperFillManager.fillReport(reporte, parametro,cc.conexion());
//         JasperViewer jv= new JasperViewer(j,false);
//         jv.setTitle("Pruebas");
//         jv.setVisible(true);
//     }  catch (JRException ex) {
//           JOptionPane.showMessageDialog(null, "Error al mostrar el reporte " +ex);
//           System.out.println(ex);
//        } 

Document Documento = new Document();
     try{
         int valor=1234;
         String valor2="Casa Faro1246";
        //Ruta donde será guradado el reporte 
        String ruta = System.getProperty("user.home");
        PdfWriter.getInstance(Documento, new FileOutputStream(ruta+"/Desktop/Reporte.pdf"));
        Documento.open();
        
        //Asignar cabecera
        Image header = Image.getInstance("src/ImagenReporte/Header1.jpg"); 
        header.scaleToFit(180,500);
        header.setAlignment(Chunk.ALIGN_LEFT);
        //Parrafo de la direccion del cliente y del proyecto
        Paragraph cliente_d = new Paragraph();
        Paragraph proyecto_d = new Paragraph();
        Paragraph parrafo1 = new Paragraph();
        Paragraph audio_d = new Paragraph();
        
                
        //Texto debajo de la imagen 
        parrafo1.add("Office: (624) 130-7327 | License: C10, C7, 859630 | CEDIA Certified | Insured");
        parrafo1.setAlignment(Paragraph.ANNOTATION);
        parrafo1.setFont(FontFactory.getFont("Arial",10, Font.NORMAL, BaseColor.BLACK));
        //Texto direccion de Audio Impact
        audio_d.add("Audio Impact Cabo \n" +
                    "Valerio Gonzalez S/N Local 2, Plaza Tamarindo\n" +
                    "Col. Primero de Mayo, San Jose del Cabo\n" +
                    "\n"+"info@audioimpactcabo.com | audioimpactcabo.com");
        audio_d.setAlignment(Paragraph.ALIGN_RIGHT);
        audio_d.setFont(FontFactory.getFont("Arial",12, Font.BOLD, BaseColor.BLACK));
           
        try{
           String sql="SELECT clientes.CLI_ID, clientes.CLI_Nombre, clientes.CLI_ApellidoPat, clientes.CLI_ApellidoMat, clientes.CLI_Telefono, clientes.CLI_Correo, "
                   + "clientes.CLI_Estatus, direccion_c.CLI_Calle, direccion_c.CLI_Colonia, direccion_c.CLI_Num_Interior, direccion_c.CLI_Num_Exterior, direccion_c.CLI_C_Postal, "
                   + "direccion_c.CLI_Estado FROM clientes INNER JOIN direccion_c ON clientes.CLI_ID=direccion_c.CLI_ID WHERE clientes.CLI_ID=1246";
            
           String sql2="SELECT proyecto.PRO_ID, proyecto.PRO_Nombre, proyecto.PR_Ciudad, proyecto.PRO_Estado, direccion_p.PRO_Calle, direccion_p.PRO_Colonia, "
                   + "direccion_p.PRO_C_Postal FROM proyecto INNER JOIN direccion_p ON proyecto.PRO_ID=direccion_p.PRO_ID WHERE proyecto.PRO_ID=1269";
           
           Statement st = cn.createStatement();
           Statement st2 = cn.createStatement();
           ResultSet rs = st.executeQuery(sql);
           ResultSet rs2 = st2.executeQuery(sql2); 
            if(rs.next()){
                
                //Dirección del cliente
                if(rs2.next()){
                 cliente_d.add("\n"+rs.getString("CLI_Nombre")+" "+rs.getString("CLI_ApellidoPat")+" "+rs.getString("CLI_ApellidoMat") +"            "   +rs.getString("CLI_Nombre")+" "+rs.getString("CLI_ApellidoPat")+" "+rs.getString("CLI_ApellidoMat")+
                        "\n"+rs.getString("CLI_Calle")+" "+rs.getString("CLI_C_Postal")+"                    "+rs2.getString("PRO_Calle")+" "+rs2.getString("PRO_C_Postal")+
                        "\n"+rs.getString("CLI_Colonia")+"                           "+rs2.getString("PRO_Colonia")+
                        "\n"+rs.getString("CLI_Estado")+"\t"+"\t");
                    System.out.println("asasf");
                cliente_d.setAlignment(Paragraph.ALIGN_LEFT);
                cliente_d.setFont(FontFactory.getFont("Arial",12, Font.NORMAL, BaseColor.BLACK));    
                    System.out.println("\n"+rs.getString("CLI_Nombre")+" "+rs.getString("CLI_ApellidoPat")+" "+rs.getString("CLI_ApellidoMat") +"            "   +rs.getString("CLI_Nombre")+" "+rs.getString("CLI_ApellidoPat")+" "+rs.getString("CLI_ApellidoMat")+
                        "\n"+rs.getString("CLI_Calle")+" "+rs.getString("CLI_C_Postal")+"                    "+rs2.getString("PRO_Calle")+" "+rs2.getString("PRO_C_Postal")+
                        "\n"+rs.getString("CLI_Colonia")+"                           "+rs2.getString("PRO_Colonia")+
                        "\n"+rs.getString("CLI_Estado")+"\t"+"\t");
                }
            }
            PdfPTable tabla_cot = new PdfPTable(6);
            //tabla_cot.addCell("ROW"); tabla_cot.addCell("QTY."); tabla_cot.addCell("Merchant #"); tabla_cot.addCell("PRODUCT DESCRIPTION"); tabla_cot.addCell("EACH"); tabla_cot.addCell("TOTAL");
            float[] columnWidths = {1, 1, 2, 5, 2, 2};
            PdfPTable table = new PdfPTable(columnWidths);
            table.setWidthPercentage(100);
            table.getDefaultCell().setUseAscender(true);
            table.getDefaultCell().setUseDescender(true);
            
            Paragraph d = new Paragraph();
            d.add("This is a header");
            d.setFont(FontFactory.getFont("Arial",12, Font.NORMAL, BaseColor.WHITE)); 
            
            PdfPCell cell = new PdfPCell(d);
            cell.setBackgroundColor(GrayColor.GRAYBLACK);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setColspan(6);
            table.addCell(cell);
            table.getDefaultCell().setBackgroundColor(new GrayColor(0.75f));
            
//            for (int i = 0; i < 1; i++) {
                table.addCell("Row");
                table.addCell("QTY.");
                table.addCell("MERCHANT");
                table.addCell("PRODUCT DESCRIPTION");
                table.addCell("EACH");
                table.addCell("TOTAL");
//            }
            table.setHeaderRows(3);
            table.setFooterRows(1);
            table.getDefaultCell().setBackgroundColor(GrayColor.GRAYWHITE);
            table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            for (int counter = 1; counter < 101; counter++) {
                table.addCell(String.valueOf(counter));
                table.addCell("key ");
                table.addCell("value1" );
                table.addCell("value2" );
                table.addCell("value3" );
                table.addCell("value4" );
            }
            //terminos y condiciones
            float[] columnWidths2 = {8 };
            PdfPTable table2 = new PdfPTable(columnWidths2);
            table2.setWidthPercentage(100);
            table2.getDefaultCell().setUseAscender(true);
            table2.getDefaultCell().setUseDescender(true);
            
            Paragraph c = new Paragraph();
            c.add("This is a header");
            c.setFont(FontFactory.getFont("Arial",12, Font.NORMAL, BaseColor.WHITE)); 
            
            PdfPCell cell2 = new PdfPCell(c);
            cell2.setBackgroundColor(GrayColor.GRAYBLACK);
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell2.setColspan(3);
            table2.addCell(cell2);
            table2.getDefaultCell().setBackgroundColor(new GrayColor(0.75f));
            
//            for (int i = 0; i < 1; i++) {
                table2.addCell(" ");
                
//            }
            table2.setHeaderRows(1);
//            table2.setFooterRows(1);
            table2.getDefaultCell().setBackgroundColor(GrayColor.GRAYWHITE);
            table2.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
              for (int counter = 1; counter < 2; counter++) {
                
table2.addCell("Proposal is valid for 10 days from date printed above. \n"+
"All products subject to manufacture warrantiesDrywall repair must be done \n"+
"by third party that you provide (we will gladly recommend someone)\n" +
"Painting to be done by third party that you provide Please note that \n "+
"wireless products functionality and reliability cannot be guaranteed, \n"+
"due to the nature of wireless and the environment always changing.\n" +
"ALL DRAWN AND WRITTEN INFORMATION APPEARING HEREIN SHALL NOT BE DUPLICATED, \n"+
"DISCLOSED, OR OTHERWISE USED WITHOUT WRITTEN CONSENT FROM AUDIO IMPACT, INC.\n" +
"All products listed above are property of Audio Impact, Inc until invoice is \n"+
"paid in full Audio Impact, Inc's Labor warranty is for one year from date of \n"+
"completed installation.\n" +
"Audio Impact cannot guarantee 100% compatibility / integration with customer \n"+
"supplied components. Payment cannot be with held due to third party service \n"+
"provides such as, but not limited to; Time Warner, Direct TV, Dish Network, \n"+
"Rhapsody, Pandora, Radio Time Road Runner, Internet services At&T or any other \n"+
"service provides Audio Impact cannot guarantee or warranty performance and \n"+
"function on customer supplied equipment and speakers Service calls for issues \n"+
"relating to cable box's, satellite box's or customer supplied components will \n"+
"not be covered by Audio Impact. There for a service call of $155 for the \n"+
"first hour and $98 for the additional hours will be billed.\n" +
"TERMS AND CONDITIONS\n" +
"ALL DRAWN AND WRITTEN INFORMATION APPEARING HEREIN SHALL NOT BE DUPLICATED,\n"+
"DISCLOSED, OR OTHERWISE USED WITHOUT WRITTEN CONSENT FROM AUDIO IMPACT, INC. \n"+
"All sales are final All products subject to manufacturer warranties \n" +
"Drywall repair must be done by third party that you provide (we will gladly \n"+
"recommend someone)Painting to be done by third party that you provide\n" +
"Please note that wireless products' functionality and reliability cannot be \n"+
"guaranteed, due to the nature of wireless and changing environments.\n" +
"All products listed above are property of Audio Impact, Inc until invoice \n"+
"is paid in full. Any third party work on system will void Audio Impact labor \n"+
"and prewire warranty Audio Impact prewire warranty void if a third party \n"+
"terminates, connects to, or otherwise interferes with Audio Impact wiring" );
              
            }                                         
                Documento.add(header); 
                Documento.add(audio_d);
                Documento.add(parrafo1);
                Documento.add(cliente_d);
//           Documento.add(tabla_cot);
//                  Documento.add(table);
                Documento.add(table2);
                Documento.add(cell2);
                Documento.close();
                JOptionPane.showMessageDialog(rootPane, "Documento creado");
        }catch(SQLException e){
            System.out.println(e);
        }
     }catch(DocumentException | FileNotFoundException e){
         
     } catch (IOException ex) {
           Logger.getLogger(Pruebas.class.getName()).log(Level.SEVERE, null, ex);
       }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Pruebas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pruebas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pruebas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pruebas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pruebas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
