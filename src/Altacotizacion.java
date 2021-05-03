
import Atxy2k.CustomTextField.RestrictedTextField;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
//import com.sun.javafx.font.FontFactory;
import java.io.FileOutputStream;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.pdf.PdfPCell;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
        
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Charlie Rivera
 */
public class Altacotizacion extends javax.swing.JFrame {
    
    int cont_combo=0,dia,mes,año;
    double total,swt,cantidad,IVA=.16,cant_pr,total_pr;
    String nuev_area,seleccionarid,seleccionarcliente,resultado=null,pro_id;
    String [] producto_ele = new String[5];
    String [] listado = new String [5];
    conectar cc = new conectar();
     Connection cn = cc.conexion();
     DefaultTableModel model;
     ArrayList lista = new ArrayList();
     ArrayList lista2 = new ArrayList();
     ArrayList lista_de_areas = new ArrayList();
     ArrayList descripcion =new ArrayList();
     Calendar c1 = Calendar.getInstance();
     
    
     
    public Altacotizacion() {
        initComponents();
         this.setDefaultCloseOperation(Principal.DO_NOTHING_ON_CLOSE); 
         
 
        
         costo_per.setText("0.0");
        costo_mat.setText("0.0");
        iva.setText("0.0");
        subtotal.setText("0.0");
        costo_t.setText("0.0");
        Calendar calendario= Calendar.getInstance();
        año=calendario.get(Calendar.YEAR);
        mes=calendario.get(Calendar.MONTH);
        dia=calendario.get(Calendar.DATE);
        
        fecha.setText(String.valueOf(año)+"-"+String.valueOf(mes)+"-"+String.valueOf(dia));
         
    }
   //Método para mostrar proyectos ya registrados 
 private void MostrarProyecto(String valor) {
        String [] titulos = {"ID", "Nombre", "Cliente", "Estado"};
        String [] registros = new String[4];

        String sql = "SELECT DISTINCT PRO_ID,PRO_Nombre,PRO_Estatus FROM proyecto WHERE PRO_ID LIKE '%"+valor+"%' OR (PRO_Nombre LIKE '%"+valor+"%') OR (PRO_Estatus LIKE '%"+valor+"%')";
        String sql2="select *from proyecto INNER JOIN clientes ON proyecto.CLI_ID=clientes.CLI_ID";
        model = new DefaultTableModel(null, titulos);

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql2);
//          
            while(rs.next()) {
		//Agregar elementos al vector.
		registros[0] = rs.getString("PRO_ID");
		registros[1] = rs.getString("PRO_Nombre");
		registros[2] = rs.getString("CLI_Nombre");
		registros[3] = rs.getString("PRO_Estatus");
		model.addRow(registros);
            }
            consultarpro.setModel(model);
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
//        }
//        try{
//            Statement ST = cn.createStatement();
//            ResultSet RS = ST.executeQuery(sql2);
//            while(RS.next()) {
//		
//		registros[2] = RS.getString("CLI_Nombre");
//		
//		model.addRow(registros);
//            }
//            
//        } catch (SQLException ex) {
//             Logger.getLogger(Consulta_proyecto.class.getName()).log(Level.SEVERE, null, ex);
//         }
        
        }
        }
        //Método para mostrar productos a cotizar
 private void MostrarProductos(String valor) {
       
        String [] registros = new String[5];
        String [] titulos = {"ID","Nombre", "Categoria", "Descripcion", "Precio"};
        
        String sql = "SELECT DISTINCT PR_ID, PR_Nombre, PR_Categoria, PR_Descripcion, PR_Precio FROM productos WHERE PR_ID LIKE '%"+valor+"%' OR (PR_Nombre LIKE '%"+valor+"%') OR (PR_Categoria LIKE '%"+valor+"%') OR (PR_Descripcion LIKE '%"+valor+"%') OR (PR_Precio LIKE '%"+valor+"%')";
       model = new DefaultTableModel(null,titulos);

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()) {
		//Agregar elementos al vector.
                registros[0] = rs.getString("PR_ID");
		registros[1] = rs.getString("PR_Nombre");
		registros[2] = rs.getString("PR_Categoria");
		registros[3] = rs.getString("PR_Descripcion");
		registros[4] = rs.getString("PR_Precio");
		model.addRow(registros);
            }
            
            elegir_producto.setModel(model);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        }
        
        //Método para consultar id del producto
 
 
 
 private String ConsultarID(String id){
     
     String sql="SELECT DISTINTIC PR_ID FROM productos where PR_ID LIKE '%"+id+"%' OR ";
     try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()) {
		resultado=rs.getString("PR_ID");
                
            }
        
 }      catch (SQLException ex) {
            Logger.getLogger(Altacotizacion.class.getName()).log(Level.SEVERE, null, ex);
        }
     return resultado;
 }
        //Método para consultar los precios de los productos
 private void ConsultarPrecios(String valor){
      String sql="SELECT  PR_ID, PR_Descripcion, PR_Precio FROM productos where PR_ID LIKE '%"+valor+"%' OR (PR_Descripcion LIKE '%"+valor+"%') OR (PR_Precio LIKE '%"+valor+"%')" ;
     try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()) {
		txtprecio.setText(rs.getString("PR_Precio"));
                area_descripcion1.setText(rs.getString("PR_Descripcion"));
                
                
            }
        
 }      catch (SQLException ex) {
            Logger.getLogger(Altacotizacion.class.getName()).log(Level.SEVERE, null, ex);
        }
 }
        //Método para generar la cotización en PDF
 public void GenerarReporte(String valor1,int valor2){
     Document Documento = new Document();
     try{
         
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
        Paragraph terminos = new Paragraph();
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
                   + "direccion_c.CLI_Estado FROM clientes INNER JOIN direccion_c ON clientes.CLI_ID=direccion_c.CLI_ID WHERE clientes.CLI_ID="+valor1;
           
           String sql2="SELECT proyecto.PRO_ID, proyecto.PRO_Nombre, proyecto.PR_Ciudad, proyecto.PRO_Estado, direccion_p.PRO_Calle, direccion_p.PRO_Colonia, "
                   + "direccion_p.PRO_C_Postal FROM proyecto INNER JOIN direccion_p ON proyecto.PRO_ID=direccion_p.PRO_ID WHERE proyecto.PRO_ID="+valor2;
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
                cliente_d.setAlignment(Paragraph.ALIGN_LEFT);
                cliente_d.setFont(FontFactory.getFont("Arial",12, Font.NORMAL, BaseColor.BLACK));    
                }
            }
            PdfPTable tabla_cot = new PdfPTable(6);
            //tabla_cot.addCell("ROW"); tabla_cot.addCell("QTY."); tabla_cot.addCell("Merchant #"); tabla_cot.addCell("PRODUCT DESCRIPTION"); tabla_cot.addCell("EACH"); tabla_cot.addCell("TOTAL");
            float[] columnWidths = { 1, 2, 5, 2, 2};
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
            for (int counter = 0; counter < tabla1.getRowCount(); counter++) {
            
                table.addCell(String.valueOf(tabla1.getValueAt(counter, 1)));
                table.addCell(String.valueOf(tabla1.getValueAt(counter, 0)) );
                table.addCell(String.valueOf(descripcion.get(counter)) );
                table.addCell(String.valueOf(tabla1.getValueAt(counter, 2)) );
                table.addCell(String.valueOf(tabla1.getValueAt(counter, 3)) );
                
                
            }
            //Cuadro de totales
            
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
"terminates, connects to, or otherwise interferes with Audio Impact wiring \n"+
        " ");  
            } 
                 //terminos y condiciones
            float[] columnWidths3 = {3,3 };
            PdfPTable table3 = new PdfPTable(columnWidths3);
            table3.setWidthPercentage(100);
            table3.getDefaultCell().setUseAscender(true);
            table3.getDefaultCell().setUseDescender(true);
            
//            Paragraph k= new Paragraph();
//            c.add("This is a header");
//            c.setFont(FontFactory.getFont("Arial",12, Font.NORMAL, BaseColor.WHITE)); 
            
            PdfPCell cell3 = new PdfPCell();
            cell3.setBackgroundColor(GrayColor.GRAYBLACK);
            cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell3.setColspan(2);
            table3.addCell(cell3);
            table3.getDefaultCell().setBackgroundColor(new GrayColor(0.75f));
            table3.setHeaderRows(1);
            table3.addCell(" ");
            table3.addCell("Total");
//            table2.setFooterRows(1);
            table3.getDefaultCell().setBackgroundColor(GrayColor.GRAYWHITE);
            table3.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
              for (int counter = 1; counter < 2; counter++) {
              table3.addCell("Equipment");
              table3.addCell(costo_mat.getText());
              table3.addCell("Labor");
              table3.addCell("");
              table3.addCell("IVA");
              table3.addCell(iva.getText());
              table3.addCell("Subtotal");
              table3.addCell(subtotal.getText());
              table3.addCell("Total");
              table3.addCell(costo_t.getText());
              table3.addCell("Payments");
              
              }
             
                Documento.add(header); 
                Documento.add(audio_d);
                Documento.add(parrafo1);
                Documento.add(cliente_d);
                Documento.add(tabla_cot);
                Documento.add(table);
                Documento.add(table2);
                Documento.add(terminos);
                Documento.add(table3);
                Documento.close();
                JOptionPane.showMessageDialog(rootPane, "Documento creado");
        }catch(SQLException e){
            
        }
     }catch(DocumentException | FileNotFoundException e){
         
     } catch (IOException ex) {
           Logger.getLogger(Altacotizacion.class.getName()).log(Level.SEVERE, null, ex);
       }
 }
 private void CalcularIva(){
     DecimalFormat df= new DecimalFormat("#.0");
     double calcular_iva,resiva;
     calcular_iva=Double.parseDouble(txtprecio.getText());
            resiva=calcular_iva*IVA;
            txtiva.setText(String.valueOf(df.format(resiva)));
            txtsubtotal.setText(String.valueOf(df.format(calcular_iva)));
            txttotal.setText(String.valueOf(df.format(calcular_iva + resiva)));
            cant_pr=Double.parseDouble(txttotal.getText());
 }
 private void tamaño(JTextField textfield){
     RestrictedTextField r = new RestrictedTextField(textfield);
     r.setLimit(10);
 }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Seleccionar_Proyecto = new javax.swing.JFrame();
        Jpanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        consultarpro = new javax.swing.JTable();
        ID = new javax.swing.JTextField();
        proyecto_p = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        uno2 = new javax.swing.JButton();
        uno3 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        uno6 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        uno7 = new javax.swing.JButton();
        Seleccionar_Producto = new javax.swing.JFrame();
        jPanel3 = new javax.swing.JPanel();
        ID1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        uno5 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        elegir_producto = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        combobox = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        uno8 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        nueva_area = new javax.swing.JTextField();
        jDialog1 = new javax.swing.JDialog();
        jScrollPane5 = new javax.swing.JScrollPane();
        celdas = new javax.swing.JTable();
        Ventana_Producto = new javax.swing.JFrame();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        nombre_producto = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        txtprecio = new javax.swing.JTextField();
        txtiva = new javax.swing.JTextField();
        txtsubtotal = new javax.swing.JTextField();
        txttotal = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        area_descripcion1 = new javax.swing.JTextArea();
        labelfoto = new javax.swing.JLabel();
        cantidad_productos = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        fecha = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        costo_p = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        costo_mat = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        subtotal = new javax.swing.JTextField();
        costo_per = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        costo_t = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        iva = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        uno1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        uno = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        uno4 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtnombrepro = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        uno9 = new javax.swing.JButton();

        Seleccionar_Proyecto.setUndecorated(true);

        Jpanel.setBackground(new java.awt.Color(255, 255, 255));
        Jpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel2.setText("ID:");
        Jpanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        consultarpro = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndes, int colIndex){
                return false;
            }
        };
        consultarpro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Cliente", "Estado"
            }
        ));
        jScrollPane2.setViewportView(consultarpro);

        Jpanel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 580, 320));

        ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDActionPerformed(evt);
            }
        });
        ID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                IDKeyTyped(evt);
            }
        });
        Jpanel.add(ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 150, -1));

        proyecto_p.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                proyecto_pKeyTyped(evt);
            }
        });
        Jpanel.add(proyecto_p, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 130, -1));

        jLabel4.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel4.setText("Cliente:");
        Jpanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        uno2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/button_buscar.png"))); // NOI18N
        uno2.setBorder(null);
        uno2.setContentAreaFilled(false);
        uno2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        uno2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uno2ActionPerformed(evt);
            }
        });
        Jpanel.add(uno2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 90, 40));

        uno3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/button_anadir.png"))); // NOI18N
        uno3.setBorder(null);
        uno3.setContentAreaFilled(false);
        uno3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        uno3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uno3ActionPerformed(evt);
            }
        });
        Jpanel.add(uno3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 510, 100, -1));

        jPanel8.setBackground(new java.awt.Color(0, 133, 186));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        uno6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/IconoSalir_1.png"))); // NOI18N
        uno6.setBorder(null);
        uno6.setContentAreaFilled(false);
        uno6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        uno6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                uno6MouseClicked(evt);
            }
        });
        uno6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uno6ActionPerformed(evt);
            }
        });
        jPanel8.add(uno6, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, 70, 40));

        jLabel5.setFont(new java.awt.Font("Decker", 1, 26)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Proyectos");
        jPanel8.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 220, 40));

        Jpanel.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 60));

        uno7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/button_cancelar.png"))); // NOI18N
        uno7.setBorder(null);
        uno7.setContentAreaFilled(false);
        uno7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        uno7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uno7ActionPerformed(evt);
            }
        });
        Jpanel.add(uno7, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 510, 120, 40));

        javax.swing.GroupLayout Seleccionar_ProyectoLayout = new javax.swing.GroupLayout(Seleccionar_Proyecto.getContentPane());
        Seleccionar_Proyecto.getContentPane().setLayout(Seleccionar_ProyectoLayout);
        Seleccionar_ProyectoLayout.setHorizontalGroup(
            Seleccionar_ProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Jpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Seleccionar_ProyectoLayout.setVerticalGroup(
            Seleccionar_ProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Jpanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Seleccionar_Producto.setUndecorated(true);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ID1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ID1ActionPerformed(evt);
            }
        });
        ID1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ID1KeyTyped(evt);
            }
        });
        jPanel3.add(ID1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 70, -1));

        jLabel6.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel6.setText("ID:");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));

        nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreActionPerformed(evt);
            }
        });
        nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombreKeyTyped(evt);
            }
        });
        jPanel3.add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 170, -1));

        uno5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/button_buscar.png"))); // NOI18N
        uno5.setBorder(null);
        uno5.setContentAreaFilled(false);
        uno5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        uno5.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/BotonBuscar2.png"))); // NOI18N
        uno5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uno5ActionPerformed(evt);
            }
        });
        jPanel3.add(uno5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 90, 110, 40));

        elegir_producto = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndes, int colIndex){
                return false;
            }
        };
        elegir_producto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Categoría", "Descripción", "Precio"
            }
        ));
        jScrollPane3.setViewportView(elegir_producto);
        if (elegir_producto.getColumnModel().getColumnCount() > 0) {
            elegir_producto.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel3.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 189, 560, 323));

        jLabel7.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel7.setText("Area:");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 151, 42, -1));

        jScrollPane4.setViewportView(jTextPane1);

        jPanel3.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 560, 60));

        combobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Seleccione -" }));
        jPanel3.add(combobox, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 149, 110, -1));

        jPanel4.setBackground(new java.awt.Color(0, 133, 186));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Decker", 1, 26)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Añadir producto");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 210, 60));

        uno8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/IconoSalir_1.png"))); // NOI18N
        uno8.setBorder(null);
        uno8.setContentAreaFilled(false);
        uno8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        uno8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                uno8MouseClicked(evt);
            }
        });
        uno8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uno8ActionPerformed(evt);
            }
        });
        jPanel4.add(uno8, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, 60, 40));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 1, 600, -1));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/button_anadir.png"))); // NOI18N
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(343, 530, 101, 47));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/button_cancelar.png"))); // NOI18N
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(451, 530, 129, 47));

        nueva_area.setText("Nueva Área");
        nueva_area.setToolTipText("");
        nueva_area.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nueva_areaActionPerformed(evt);
            }
        });
        jPanel3.add(nueva_area, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 149, 124, -1));

        javax.swing.GroupLayout Seleccionar_ProductoLayout = new javax.swing.GroupLayout(Seleccionar_Producto.getContentPane());
        Seleccionar_Producto.getContentPane().setLayout(Seleccionar_ProductoLayout);
        Seleccionar_ProductoLayout.setHorizontalGroup(
            Seleccionar_ProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        Seleccionar_ProductoLayout.setVerticalGroup(
            Seleccionar_ProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        celdas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Cantidad", "ID", "Descripción", "Precio", "Total"
            }
        ));
        jScrollPane5.setViewportView(celdas);

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
                .addContainerGap())
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Ventana_Producto.setUndecorated(true);
        Ventana_Producto.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(0, 133, 186));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Decker", 1, 26)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Añadir producto");
        jPanel6.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 210, 60));

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 1, 529, -1));

        jLabel18.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel18.setText("IVA:");
        jPanel5.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, 52, 40));

        jLabel20.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jPanel5.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 410, -1, 40));

        jLabel21.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel21.setText("Precio:");
        jPanel5.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, 55, 40));

        jLabel22.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel22.setText("Subtotal:");
        jPanel5.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, 70, 20));

        nombre_producto.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        nombre_producto.setText("Nombre del Producto");
        jPanel5.add(nombre_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 160, 30));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtprecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtprecioActionPerformed(evt);
            }
        });
        txtprecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtprecioKeyReleased(evt);
            }
        });
        jPanel7.add(txtprecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 70, -1));

        txtiva.setEditable(false);
        txtiva.setBackground(new java.awt.Color(255, 255, 255));
        txtiva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtivaActionPerformed(evt);
            }
        });
        jPanel7.add(txtiva, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 70, -1));

        txtsubtotal.setEditable(false);
        txtsubtotal.setBackground(new java.awt.Color(255, 255, 255));
        txtsubtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsubtotalActionPerformed(evt);
            }
        });
        jPanel7.add(txtsubtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 70, -1));

        txttotal.setEditable(false);
        txttotal.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.add(txttotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 70, -1));

        jLabel23.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel23.setText("Total:");
        jPanel7.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 161, 50, -1));

        jPanel5.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, 170, 220));

        area_descripcion1.setColumns(20);
        area_descripcion1.setRows(5);
        jScrollPane6.setViewportView(area_descripcion1);

        jPanel5.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 200, 100));
        jPanel5.add(labelfoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 240, 260));
        jPanel5.add(cantidad_productos, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 320, 70, -1));

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/button_aceptar.png"))); // NOI18N
        jButton8.setContentAreaFilled(false);
        jButton8.setFocusPainted(false);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 402, 110, -1));

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/button_cancelar.png"))); // NOI18N
        jButton7.setBorderPainted(false);
        jButton7.setContentAreaFilled(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 400, 120, 50));

        jLabel31.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel31.setText("Cantidad:");
        jPanel5.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 320, 70, 20));

        Ventana_Producto.getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 480));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel10.setText("Proyecto:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 109, -1, 40));

        fecha.setEditable(false);
        jPanel1.add(fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 323, 100, -1));

        jLabel11.setFont(new java.awt.Font("Decker", 0, 15)); // NOI18N
        jLabel11.setText("Costo del material:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 196, -1, 20));

        costo_p.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                costo_pKeyTyped(evt);
            }
        });
        jPanel1.add(costo_p, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 156, 159, -1));

        jLabel12.setFont(new java.awt.Font("Decker", 0, 15)); // NOI18N
        jLabel12.setText("Costo del personal:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 242, -1, 20));

        costo_mat.setEditable(false);
        costo_mat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                costo_matKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                costo_matKeyTyped(evt);
            }
        });
        jPanel1.add(costo_mat, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 198, 100, -1));

        jLabel13.setFont(new java.awt.Font("Decker", 0, 15)); // NOI18N
        jLabel13.setText("Fecha:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 324, 60, -1));

        subtotal.setEditable(false);
        subtotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                subtotalKeyTyped(evt);
            }
        });
        jPanel1.add(subtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 366, 100, -1));

        costo_per.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                costo_perKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                costo_perKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                costo_perKeyTyped(evt);
            }
        });
        jPanel1.add(costo_per, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 242, 100, -1));

        jLabel15.setFont(new java.awt.Font("Decker", 0, 15)); // NOI18N
        jLabel15.setText("Costo total:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 420, -1, 22));

        costo_t.setEditable(false);
        costo_t.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                costo_tKeyTyped(evt);
            }
        });
        jPanel1.add(costo_t, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 420, 100, -1));

        jLabel16.setFont(new java.awt.Font("Decker", 0, 15)); // NOI18N
        jLabel16.setText("IVA:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 282, 60, -1));

        iva.setEditable(false);
        iva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ivaKeyTyped(evt);
            }
        });
        jPanel1.add(iva, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 282, 100, -1));

        jLabel17.setFont(new java.awt.Font("Decker", 0, 15)); // NOI18N
        jLabel17.setText("Servicio:");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 156, -1, 20));

        tabla1 = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndes, int colIndex){
                return false;
            }
        };
        tabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Cantidad", "Precio", "Total"
            }
        ));
        jScrollPane1.setViewportView(tabla1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(297, 156, 340, 310));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/button_anadir.png"))); // NOI18N
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2MouseEntered(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(532, 109, 104, 40));

        uno1.setBorder(null);
        uno1.setContentAreaFilled(false);
        uno1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        uno1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uno1ActionPerformed(evt);
            }
        });
        jPanel1.add(uno1, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 536, 100, 40));

        jPanel2.setBackground(new java.awt.Color(0, 133, 186));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        uno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/IconoSalir_1.png"))); // NOI18N
        uno.setBorder(null);
        uno.setContentAreaFilled(false);
        uno.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        uno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                unoMouseClicked(evt);
            }
        });
        uno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unoActionPerformed(evt);
            }
        });
        jPanel2.add(uno, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 50, 40));

        jLabel3.setFont(new java.awt.Font("Decker", 1, 26)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nueva cotización");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 240, 60));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 1, 660, -1));

        uno4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/button_guardar.png"))); // NOI18N
        uno4.setBorder(null);
        uno4.setContentAreaFilled(false);
        uno4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        uno4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                uno4MouseClicked(evt);
            }
        });
        uno4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uno4ActionPerformed(evt);
            }
        });
        jPanel1.add(uno4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 490, -1, -1));

        jLabel19.setFont(new java.awt.Font("Decker", 0, 15)); // NOI18N
        jLabel19.setText("Subtotal:");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 366, 60, 22));

        jButton1.setText("Seleccione");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 119, 140, -1));

        txtnombrepro.setEditable(false);
        jPanel1.add(txtnombrepro, new org.netbeans.lib.awtextra.AbsoluteConstraints(297, 120, 132, -1));

        jLabel14.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel14.setText("Producto:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(447, 115, 80, 28));

        uno9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/button_cancelar.png"))); // NOI18N
        uno9.setBorder(null);
        uno9.setContentAreaFilled(false);
        uno9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        uno9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uno9ActionPerformed(evt);
            }
        });
        jPanel1.add(uno9, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 490, 120, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 660, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void costo_pKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_costo_pKeyTyped
          
        
        // TODO add your handling code here:
    }//GEN-LAST:event_costo_pKeyTyped

    private void costo_matKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_costo_matKeyTyped
        char c=evt.getKeyChar();
        if(c<'0'||c>'9'){
            evt.consume();
        }
        tamaño(costo_mat);
        // TODO add your handling code here:
    }//GEN-LAST:event_costo_matKeyTyped

    private void subtotalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_subtotalKeyTyped
        char c=evt.getKeyChar();
        if(c<'0'||c>'9'){
            evt.consume();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_subtotalKeyTyped

    private void costo_perKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_costo_perKeyTyped
        char c=evt.getKeyChar();
        if(c<'0'||c>'9'){
            evt.consume();
        }
       tamaño(costo_per);
    }//GEN-LAST:event_costo_perKeyTyped

    private void costo_tKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_costo_tKeyTyped
        char c=evt.getKeyChar();
        if(c<'0'||c>'9'){
            evt.consume();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_costo_tKeyTyped

    private void ivaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ivaKeyTyped
        char c=evt.getKeyChar();
        if(c<'0'||c>'9'){
            evt.consume();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_ivaKeyTyped

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
   if(txtnombrepro.getText().isEmpty()){
       JOptionPane.showMessageDialog(rootPane, "Seleccione un proyecto", "Error",NORMAL);
   }else{
    Seleccionar_Producto.setVisible(true);
    Seleccionar_Producto.setSize(600, 600);
    Seleccionar_Producto.setLocationRelativeTo(null);
       

    }//GEN-LAST:event_jButton2ActionPerformed
    }
    private void uno1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uno1ActionPerformed

    }//GEN-LAST:event_uno1ActionPerformed

    private void unoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_unoMouseClicked
          this.dispose();
    }//GEN-LAST:event_unoMouseClicked

    private void unoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unoActionPerformed

    }//GEN-LAST:event_unoActionPerformed

    private void uno4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uno4MouseClicked

    }//GEN-LAST:event_uno4MouseClicked

    private void uno4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uno4ActionPerformed
        if(costo_p.getText().isEmpty()||costo_per.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Ingrese todos los dato","Error",JOptionPane.PLAIN_MESSAGE);
        }else{
            String sql,sql2,sql3,res = null;
            sql="INSERT INTO `cotizacion` (`COT_ID`, `PRO_ID`, `COT_CostoMaterial`, `COTT_CostoProyecto`, `COT_Fecha`, `COT_Subtotal`, `COT_IVA`, `COT_Total`, `COT_Aprobada`, `COT_Estatus`) VALUES (NULL,?,?,?,?,?,?,?,?,?) ";
            sql2="INSERT INTO direccion_c (CLI_ID,CLI_Calle,CLI_Colonia,CLI_Num_Interior,CLI_Num_Exterior,CLI_C_Postal,CLI_Estado)VALUES (?,?,?,?,?,?,?)";
            
            
            try{
             PreparedStatement pst=(PreparedStatement) cn.prepareStatement(sql);
                   
                    pst.setString(1, pro_id);
                    pst.setDouble(2, Double.parseDouble(costo_mat.getText()));
                    pst.setDouble(3, Double.parseDouble(costo_per.getText()));
                    pst.setString(4, fecha.getText());
                    pst.setDouble(5, Double.parseDouble(subtotal.getText()));
                    pst.setDouble(6, Double.parseDouble(iva.getText()));
                    pst.setDouble(7, Double.parseDouble(costo_t.getText()));
                    pst.setString(8, "APROBADA");
                    pst.setString(9, "ACTIVO");
                    pst.executeUpdate();
                   GenerarReporte(pro_id,1246);
                    JOptionPane.showMessageDialog(null, "Se ha registrado una nueva cotización", "Completado", JOptionPane.INFORMATION_MESSAGE);
                   
            }catch (SQLException ex) {
                Logger.getLogger(Altacliente.class.getName()).log(Level.SEVERE, null, sql);
                System.out.println(ex);
            } 
            
        }
           
           
           
//       }
    }//GEN-LAST:event_uno4ActionPerformed

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2MouseEntered

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
//        Cotizacion_productos c=new Cotizacion_productos();
//        c.setVisible(true);
//        c.setLocationRelativeTo(null);
//Seleccionar_Producto.setVisible(true);
//    Seleccionar_Producto.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Seleccionar_Proyecto.setVisible(true);
        Seleccionar_Proyecto.setSize(660, 581);
        Seleccionar_Proyecto.setLocationRelativeTo(null);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDActionPerformed

    private void IDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_IDKeyTyped
        char c=evt.getKeyChar();
        if(c<'0'||c>'9'){
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_IDKeyTyped

    private void proyecto_pKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_proyecto_pKeyTyped
        char c=evt.getKeyChar();
        if (((c <'A')||(c>'Z'))&&((c<'a')||(c>'z'))&&(c!=32)){
            evt.consume();
        }       // TODO add your handling code here:
    }//GEN-LAST:event_proyecto_pKeyTyped

    private void uno2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uno2ActionPerformed
        MostrarProyecto(ID.getText());
        MostrarProyecto(proyecto_p.getText());
        ID.setText("");
        proyecto_p.setText("");
    }//GEN-LAST:event_uno2ActionPerformed

    private void uno3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uno3ActionPerformed

      
        DefaultTableModel model = (DefaultTableModel) consultarpro.getModel();

        

        if(consultarpro.getSelectedRow() >= 0) {
            seleccionarid=consultarpro.getValueAt(consultarpro.getSelectedRow(), 0).toString();
            seleccionarcliente = consultarpro.getValueAt(consultarpro.getSelectedRow(), 1).toString();
            txtnombrepro.setText(seleccionarcliente);
            pro_id=seleccionarid;
            Seleccionar_Proyecto.setVisible(false);
//            pro_id=consultarpro.getValueAt(consultarpro.getSelectedRow(), 0);
            System.out.println(pro_id);
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un Proyecto.", "Seleccionar Proyecto",
                JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_uno3ActionPerformed

    private void ID1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ID1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ID1ActionPerformed

    private void ID1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ID1KeyTyped
        char c=evt.getKeyChar();
        if(c<'0'||c>'9'){
            evt.consume();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_ID1KeyTyped

    private void nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreActionPerformed

    private void nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreKeyTyped
        char c=evt.getKeyChar();
        if (((c <'A')||(c>'Z'))&&((c<'a')||(c>'z'))&&(c!=32)){
            evt.consume();
        }       // TODO add your handling code here:
    }//GEN-LAST:event_nombreKeyTyped

    private void uno5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uno5ActionPerformed
        MostrarProductos(ID1.getText());
        MostrarProductos(nombre.getText());
        ID1.setText("");
        nombre.setText("");
        
    }//GEN-LAST:event_uno5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
     String ver ;
     
        if(elegir_producto.getSelectedRow() >= 0) {
            
            ver=String.valueOf(elegir_producto.getValueAt(elegir_producto.getSelectedRow(), 0));
//            ConsultarPrecios(ver);
            Ventana_Producto.setVisible(true); 
            Ventana_Producto.setSize(525, 500);
            Ventana_Producto.setLocationRelativeTo(null);
         
            
            Seleccionar_Producto.setVisible(false);
            String sql="SELECT DISTINCT PR_ID, PR_Nombre, PR_Descripcion, PR_Precio, foto FROM productos where PR_ID LIKE '%"+ver+"%' OR (PR_Descripcion LIKE '%"+ver+"%') OR (PR_Nombre LIKE '%"+ver+"%' ) OR (PR_Precio LIKE '%"+ver+"%') OR (foto LIKE '%"+ver+"%')" ;
     try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()) {
		txtprecio.setText(String.valueOf(rs.getDouble("PR_Precio")));
                area_descripcion1.setText(rs.getString("PR_Descripcion"));
                nombre_producto.setText(rs.getString("PR_Nombre"));
                        try {
                             
//                             Imagen imagen=new Imagen();
                             Blob blob = rs.getBlob("foto");
                             byte[] data = blob.getBytes(1, (int)blob.length());
                             BufferedImage img = null;
                             img = ImageIO.read(new ByteArrayInputStream(data));
                             ImageIcon ima = new ImageIcon(img.getScaledInstance(200, 200, 1));
                             labelfoto.setIcon(ima);
                             
                            
                             
//                             rs.close();
                             } catch (SQLException ex) {
                             Logger.getLogger(Altacotizacion.class.getName()).log(Level.SEVERE, null, ex);
                             } catch (IOException ex) {
                    Logger.getLogger(Altacotizacion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        
 }      catch (SQLException ex) {
            Logger.getLogger(Altacotizacion.class.getName()).log(Level.SEVERE, null, ex);
        }
            if(!nueva_area.getText().isEmpty()){
                combobox.addItem(nueva_area.getText());
                nueva_area.setText("");
                for (int i = 0; i < combobox.getItemCount(); i++) {
                    
                }
                lista_de_areas.add("");
                combobox.getItemAt(cont_combo);
                
            }
                
                       //Lista de areas
                        for (int i = 0; i <combobox.getItemCount(); i++) {
                            
            }
            CalcularIva();
                       
        } else {
                JOptionPane.showMessageDialog(null, "Seleccione un Producto", "Seleccionar Productos",
                JOptionPane.ERROR_MESSAGE);
            }
    
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void nueva_areaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nueva_areaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nueva_areaActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    
        for (int i = 0; i < tabla1.getRowCount(); i++) {
             total=total+Double.parseDouble(String.valueOf(tabla1.getValueAt(i, 3)));
             
       }
        costo_mat.setText(String.valueOf(total));
        Seleccionar_Producto.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtprecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtprecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtprecioActionPerformed

    private void txtprecioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprecioKeyReleased
        
        if(!txtprecio.getText().isEmpty()){
           CalcularIva(); 
        }
    }//GEN-LAST:event_txtprecioKeyReleased

    private void txtivaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtivaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtivaActionPerformed

    private void txtsubtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsubtotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsubtotalActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
               DefaultTableModel model = (DefaultTableModel) elegir_producto.getModel();
        DefaultTableModel model2 = (DefaultTableModel) tabla1.getModel();
        if(cantidad_productos.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Ingrese cantidad de producto", "Aviso", JOptionPane.ERROR_MESSAGE);
        }
        else{
        int FilaSelec = elegir_producto.getSelectedRow();
        if(FilaSelec >= 0) {
            Seleccionar_Producto.setVisible(true);
            Seleccionar_Producto.setSize(610, 620);
            if(tabla1.getRowCount()> 0){
                for (int i = 0; i <tabla1.getRowCount(); i++) {
                    //                        for (int j = 0; j < lista2.size(); j++) {
                        if(elegir_producto.getValueAt(FilaSelec, 1).equals(tabla1.getValueAt(i, 0).toString())){
                            tabla1.setValueAt(String.valueOf(tabla1.getValueAt(i, 1)+cantidad_productos.getText()), i, 1);
                            tabla1.setValueAt(String.valueOf(txtprecio.getText()), i, 2);
                            tabla1.setValueAt(String.valueOf(txttotal.getText()), i, 3);
                            System.out.println(lista.size());
                            System.out.println(lista2.size());
                            model2.removeRow(i);
                            lista.remove(i);
                            lista2.remove(i);
                        }

                        //                        }
                }
            }

            lista.add(elegir_producto.getValueAt(FilaSelec, 0).toString());
            lista2.add(elegir_producto.getValueAt(FilaSelec, 1).toString());
//            System.out.println(lista);
//            System.out.println(lista2);
            total_pr=Double.parseDouble(cantidad_productos.getText())*cant_pr;
            producto_ele[0]=elegir_producto.getValueAt(FilaSelec, 1).toString();
            producto_ele[1]=cantidad_productos.getText();
            producto_ele[2]=String.valueOf(txtprecio.getText());
            producto_ele[3]=String.valueOf(total_pr);
            producto_ele[4]=elegir_producto.getValueAt(FilaSelec, 0).toString();
            
            model2.addRow(producto_ele);
            tabla1.setModel(model2);
            
            //agregar descripcion del producto
            descripcion.add(area_descripcion1.getText());
            Ventana_Producto.setVisible(false);
            txtprecio.setText("");
            txtiva.setText("");
            txtsubtotal.setText("");
            txttotal.setText("");
            System.out.println(descripcion);
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un Producto", "Seleccionar Productos",
                JOptionPane.ERROR_MESSAGE);
        }
        }  
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        Seleccionar_Producto.setVisible(true);
        Seleccionar_Producto.setSize(620, 630);
        Ventana_Producto.setVisible(false);

    }//GEN-LAST:event_jButton7ActionPerformed

    private void costo_perKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_costo_perKeyPressed
        
    }//GEN-LAST:event_costo_perKeyPressed

    private void costo_matKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_costo_matKeyReleased
      
    }//GEN-LAST:event_costo_matKeyReleased

    private void costo_perKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_costo_perKeyReleased
        DecimalFormat df= new DecimalFormat("#.0");
      double calcular_iva,resiva;
      calcular_iva=Double.parseDouble(costo_mat.getText())+Double.parseDouble(costo_per.getText());
      subtotal.setText(String.valueOf(Double.parseDouble(costo_mat.getText())+Double.parseDouble(costo_per.getText())));
      resiva=IVA*calcular_iva;
      iva.setText(String.valueOf(resiva));
      costo_t.setText(String.valueOf(Double.parseDouble(subtotal.getText())+resiva));
    }//GEN-LAST:event_costo_perKeyReleased

    private void uno6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uno6MouseClicked
        this.dispose();
    }//GEN-LAST:event_uno6MouseClicked

    private void uno6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uno6ActionPerformed

    }//GEN-LAST:event_uno6ActionPerformed

    private void uno7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uno7ActionPerformed
        Seleccionar_Proyecto.dispose();
    }//GEN-LAST:event_uno7ActionPerformed

    private void uno8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uno8MouseClicked
        Seleccionar_Producto.dispose();
    }//GEN-LAST:event_uno8MouseClicked

    private void uno8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uno8ActionPerformed

    }//GEN-LAST:event_uno8ActionPerformed

    private void uno9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uno9ActionPerformed
        this.dispose();
    }//GEN-LAST:event_uno9ActionPerformed

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
            java.util.logging.Logger.getLogger(Altacotizacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Altacotizacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Altacotizacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Altacotizacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Altacotizacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ID;
    private javax.swing.JTextField ID1;
    private javax.swing.JPanel Jpanel;
    private javax.swing.JFrame Seleccionar_Producto;
    private javax.swing.JFrame Seleccionar_Proyecto;
    private javax.swing.JFrame Ventana_Producto;
    private javax.swing.JTextArea area_descripcion1;
    private javax.swing.JTextField cantidad_productos;
    private javax.swing.JTable celdas;
    private javax.swing.JComboBox<String> combobox;
    private javax.swing.JTable consultarpro;
    private javax.swing.JTextField costo_mat;
    private javax.swing.JTextField costo_p;
    private javax.swing.JTextField costo_per;
    private javax.swing.JTextField costo_t;
    private javax.swing.JTable elegir_producto;
    private javax.swing.JTextField fecha;
    private javax.swing.JTextField iva;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JLabel labelfoto;
    private javax.swing.JTextField nombre;
    private javax.swing.JLabel nombre_producto;
    private javax.swing.JTextField nueva_area;
    private javax.swing.JTextField proyecto_p;
    private javax.swing.JTextField subtotal;
    private javax.swing.JTable tabla1;
    private javax.swing.JTextField txtiva;
    private javax.swing.JTextField txtnombrepro;
    private javax.swing.JTextField txtprecio;
    private javax.swing.JTextField txtsubtotal;
    private javax.swing.JTextField txttotal;
    private javax.swing.JButton uno;
    private javax.swing.JButton uno1;
    private javax.swing.JButton uno2;
    private javax.swing.JButton uno3;
    private javax.swing.JButton uno4;
    private javax.swing.JButton uno5;
    private javax.swing.JButton uno6;
    private javax.swing.JButton uno7;
    private javax.swing.JButton uno8;
    private javax.swing.JButton uno9;
    // End of variables declaration//GEN-END:variables
}
