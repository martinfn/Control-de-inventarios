
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Charlie Rivera
 */
public class Consulta_productos extends javax.swing.JPanel {

    Principal mod;
     conectar cc = new conectar();
     Connection cn = cc.conexion();
     DefaultTableModel model,model2;
     ArrayList lista_requsicion = new ArrayList();
     String [] registros2 = new String[5];
        String [] titulos = {"ID","Nombre","Categoría", "Descripcion", "Precio"};
        
    public Consulta_productos() {
        initComponents();
    }
    //Componentes iniciales para determinar el tipo de usuario
    public Consulta_productos(Principal mod) {
        initComponents();
        this.mod = mod;
        if(mod.getUsuario_t().equals("admin")){
            
            
        }
    }
private void MostrarProductos(String valor) {
       
        String [] registros = new String[5];
        String [] titulos = {"ID","Nombre", "Descripcion","Cantidad", "Precio"};
        
        String sql = "SELECT DISTINCT PRD_ID, PRD_Nombre, PRD_Categoria, PRD_Precio, PRD_Cantidad, PRD_Descripcion FROM producto WHERE PRD_ID LIKE '%"+valor+"%' OR (PRD_Nombre LIKE '%"+valor+"%') OR (PRD_Categoria LIKE '%"+valor+"%')OR (PRD_Precio LIKE '%"+valor+"%')OR (PRD_Cantidad LIKE '%"+valor+"%') OR (PRD_Descripcion LIKE '%"+valor+"%')";
       model = new DefaultTableModel(null,titulos);

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()) {
		//Agregar elementos al vector.
                registros[0] = rs.getString("PRD_ID");
		registros[1] = rs.getString("PRD_Nombre");
		registros[2] = rs.getString("PRD_Descripcion");
		registros[3] = rs.getString("PRD_Cantidad");
		registros[4] = rs.getString("PRD_Precio");
		model.addRow(registros);
            }
            
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Ventana_Salida = new javax.swing.JFrame();
        jPanel3 = new javax.swing.JPanel();
        nombre1 = new javax.swing.JTextField();
        ID1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        uno5 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        elegir_producto = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabla_lista = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        ID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        uno2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        buscar_producto = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        uno4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        Ventana_Salida.setUndecorated(true);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        nombre1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombre1ActionPerformed(evt);
            }
        });
        nombre1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombre1KeyTyped(evt);
            }
        });

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

        jLabel8.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel8.setText("ID:");

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

        elegir_producto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Categoría", "Descripción", "Precio"
            }
        ));
        jScrollPane3.setViewportView(elegir_producto);

        jPanel4.setBackground(new java.awt.Color(0, 133, 186));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/button_anadir.png"))); // NOI18N
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/button_cancelar.png"))); // NOI18N
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/button_aceptar.png"))); // NOI18N
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        tabla_lista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Categoría", "Descripción", "Precio"
            }
        ));
        jScrollPane5.setViewportView(tabla_lista);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel8)
                        .addGap(174, 174, 174)
                        .addComponent(nombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(ID1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(uno5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(149, 149, 149))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(116, 116, 116)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jLabel8))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(ID1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(nombre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(uno5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );

        Ventana_Salida.getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        setBackground(new java.awt.Color(241, 241, 241));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ID.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
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
        jPanel1.add(ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 70, -1));

        jLabel2.setFont(new java.awt.Font("Decker", 0, 16)); // NOI18N
        jLabel2.setText("ID:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        nombre.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
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
        jPanel1.add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 130, -1));

        uno2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/button_buscar.png"))); // NOI18N
        uno2.setBorder(null);
        uno2.setContentAreaFilled(false);
        uno2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        uno2.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/BotonBuscar2.png"))); // NOI18N
        uno2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uno2ActionPerformed(evt);
            }
        });
        jPanel1.add(uno2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 100, 40));

        buscar_producto = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndes, int colIndex){
                return false;
            }
        };
        buscar_producto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Descripción", "Cantidad", "Precio"
            }
        ));
        jScrollPane2.setViewportView(buscar_producto);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 590, 380));

        jLabel4.setFont(new java.awt.Font("Decker", 0, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Consulta");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 40));

        jLabel3.setFont(new java.awt.Font("Decker", 0, 16)); // NOI18N
        jLabel3.setText("Nombre:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 660, 600));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Decker", 0, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Nuevo");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 80, 40));

        jLabel6.setFont(new java.awt.Font("Decker", 0, 17)); // NOI18N
        jLabel6.setText("Dar salida a un producto");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, 200, 40));

        uno4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/button_nuevo.png"))); // NOI18N
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
        jPanel2.add(uno4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 90, 40));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/button_salida.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 40, 90, 40));

        jLabel7.setFont(new java.awt.Font("Decker", 0, 17)); // NOI18N
        jLabel7.setText("Dar de alta un nuevo producto");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 240, 40));

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 660, 100));

        jLabel1.setFont(new java.awt.Font("Decker", 0, 24)); // NOI18N
        jLabel1.setText("Productos");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 0, 170, 50));
    }// </editor-fold>//GEN-END:initComponents

    private void IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDActionPerformed

    private void IDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_IDKeyTyped
        char c=evt.getKeyChar();
        if(c<'0'||c>'9'){
            evt.consume();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_IDKeyTyped

    private void nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreActionPerformed

    private void nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreKeyTyped
        char c=evt.getKeyChar();
        if (((c <'A')||(c>'Z'))&&((c<'a')||(c>'z'))&&(c!=32)){
            evt.consume();
        }       // TODO add your handling code here:
    }//GEN-LAST:event_nombreKeyTyped

    private void uno2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uno2ActionPerformed
        MostrarProductos(ID1.getText());
        MostrarProductos(nombre.getText());
        buscar_producto.setModel(model);
        ID1.setText("");
        nombre.setText("");
    }//GEN-LAST:event_uno2ActionPerformed

    private void uno4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uno4MouseClicked
        Altaproducto n=new Altaproducto();
        n.setLocationRelativeTo(null);
        n.setVisible(true);

    }//GEN-LAST:event_uno4MouseClicked

    private void uno4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uno4ActionPerformed

    }//GEN-LAST:event_uno4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Ventana_Salida.setVisible(true);
        Ventana_Salida.setSize(630, 620);
        Ventana_Salida.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton1ActionPerformed

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

    private void nombre1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombre1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombre1ActionPerformed

    private void nombre1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombre1KeyTyped
        char c=evt.getKeyChar();
        if (((c <'A')||(c>'Z'))&&((c<'a')||(c>'z'))&&(c!=32)){
            evt.consume();
        }       // TODO add your handling code here:
    }//GEN-LAST:event_nombre1KeyTyped

    private void uno5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uno5ActionPerformed
        MostrarProductos(ID1.getText());
        MostrarProductos(nombre.getText());
        elegir_producto.setModel(model);
        ID1.setText("");
        nombre.setText("");

    }//GEN-LAST:event_uno5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        if(tabla_lista.getRowCount()<=0){
        model2 = new DefaultTableModel(null,titulos);
        registros2 [0]= String.valueOf(elegir_producto.getValueAt(elegir_producto.getSelectedRow(),0));
        registros2 [1]= String.valueOf(elegir_producto.getValueAt(elegir_producto.getSelectedRow(),1));
        registros2 [2]= String.valueOf(elegir_producto.getValueAt(elegir_producto.getSelectedRow(),2));
        registros2 [3]= String.valueOf(elegir_producto.getValueAt(elegir_producto.getSelectedRow(),3));
        registros2 [4]= String.valueOf(elegir_producto.getValueAt(elegir_producto.getSelectedRow(),4));
        model2.addRow(registros2);
        tabla_lista.setModel(model2);
        }else{  
        registros2 [0]= String.valueOf(elegir_producto.getValueAt(elegir_producto.getSelectedRow(),0));
        registros2 [1]= String.valueOf(elegir_producto.getValueAt(elegir_producto.getSelectedRow(),1));
        registros2 [2]= String.valueOf(elegir_producto.getValueAt(elegir_producto.getSelectedRow(),2));
        registros2 [3]= String.valueOf(elegir_producto.getValueAt(elegir_producto.getSelectedRow(),3));
        registros2 [4]= String.valueOf(elegir_producto.getValueAt(elegir_producto.getSelectedRow(),4));
        model2.addRow(registros2);
        tabla_lista.setModel(model2);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Ventana_Salida.setVisible(false);
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      Document Documento = new Document();
     try{
         int valor=1234,valor2=1238;
        //Ruta donde será guradado el reporte 
        String ruta = System.getProperty("user.home");
        PdfWriter.getInstance(Documento, new FileOutputStream(ruta+"/Desktop/Requisición.pdf"));
        Documento.open();
        
        //Asignar cabecera
        Image header = Image.getInstance("src/ImagenReporte/Header1.jpg"); 
        header.scaleToFit(180,500);
        header.setAlignment(Chunk.ALIGN_LEFT);
        //Parrafo de la direccion del cliente y del proyecto
        Paragraph cliente_d = new Paragraph();
        Paragraph Firma = new Paragraph();
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
                   + "direccion_c.CLI_Estado FROM clientes INNER JOIN direccion_c ON clientes.CLI_ID=direccion_c.CLI_ID WHERE clientes.CLI_ID=1234;";
           
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
            float[] columnWidths = {1, 2, 2, 5, 1, 2};
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
                table.addCell("MERCHANT");
                table.addCell("Name");
                table.addCell("PRODUCT DESCRIPTION");
                table.addCell("QTY.");
                table.addCell("TOTAL");
//            }
            table.setHeaderRows(3);
            table.setFooterRows(1);
            table.getDefaultCell().setBackgroundColor(GrayColor.GRAYWHITE);
            table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            for (int counter = 0; counter < tabla_lista.getRowCount(); counter++) {
                table.addCell(String.valueOf(tabla_lista.getRowCount()-counter));
                table.addCell(String.valueOf(tabla_lista.getValueAt(counter,0)));
                table.addCell(String.valueOf(tabla_lista.getValueAt(counter,1)) );
                table.addCell(String.valueOf(tabla_lista.getValueAt(counter,2)) );
                table.addCell(String.valueOf(tabla_lista.getValueAt(counter,3)) );
                table.addCell(String.valueOf(tabla_lista.getValueAt(counter,4)) );
                
            }
                //Firma del cliente
               Firma.add("I hereby agree to pay the rates described to the right in full."
                       + "\n"
                       + "\n"
                       + "\n"
                       + "Signed:_____________________________Date:___/___/___");
               Firma.setAlignment(Paragraph.ANNOTATION);
               Firma.setFont(FontFactory.getFont("Arial",10, Font.NORMAL, BaseColor.BLACK));                                        
//                Documento.add(header); 
                Documento.add(audio_d);
                Documento.add(parrafo1);
                Documento.add(cliente_d);
                Documento.add(tabla_cot);
                Documento.add(table);
                Documento.add(Firma); 
                Documento.close();
                JOptionPane.showMessageDialog(nombre, "Se ha generado la Requisición");
        }catch(SQLException e){
            
        }
     }catch(DocumentException | FileNotFoundException e){
         
     } catch (IOException ex) {
           Logger.getLogger(Consulta_productos.class.getName()).log(Level.SEVERE, null, ex);
       }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ID;
    private javax.swing.JTextField ID1;
    private javax.swing.JFrame Ventana_Salida;
    private javax.swing.JTable buscar_producto;
    private javax.swing.JTable elegir_producto;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextField nombre;
    private javax.swing.JTextField nombre1;
    private javax.swing.JTable tabla_lista;
    private javax.swing.JButton uno2;
    private javax.swing.JButton uno4;
    private javax.swing.JButton uno5;
    // End of variables declaration//GEN-END:variables
}
