
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Charlie Rivera
 */
public class Altacliente extends javax.swing.JFrame {

    Login mod;
    
    String cli_nombre,cli_apellidop,cli_apellidom,cli_estado,cli_calle,cli_colonia,cli_telefono1,cli_correo;
    int cli_telefono,cli_numint,cli_numext,cli_cpostal;
     conectar cc = new conectar();
     Connection cn = cc.conexion();
     
     
     
    public Altacliente() {
        initComponents();
        
    }
    //Componentes iniciales para determinar el tipo de usuario
     public Altacliente(Login mod) {
        initComponents();
        this.mod= mod;
        if(mod.getTipo_usuario().equals("admin")){
            System.out.println("Usuario Administrador");
        }
    }
     //Método para limpiar campos
     public void  limpiar() {
    No_interno.setText("");
    ape_materno.setText("");
    apellido_pat.setText("");
    calle.setText("");
    ciudad.setText("");
    colonia.setText("");
    correo.setText("");
    cp.setText("");
    telefono.setText("");
    nombre.setText("");
    sexo.setSelectedIndex(0);
   estado.setSelectedIndex(0);
}
     //Método para obtener información de los campos
public void ObtenerP(){
   cli_nombre=nombre.getText();
   cli_apellidop=apellido_pat.getText();
   cli_apellidom=ape_materno.getText();
   cli_calle=calle.getText();
   cli_colonia=colonia.getText();
   cli_telefono1=telefono.getText();
   cli_correo=correo.getText();       
   cli_numint=Integer.parseInt(No_interno.getText()); 
   cli_cpostal=Integer.parseInt(cp.getText());
   cli_estado=String.valueOf(estado.getSelectedItem());
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        apellido_pat = new javax.swing.JTextField();
        correo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        ape_materno = new javax.swing.JTextField();
        sexo = new javax.swing.JComboBox<>();
        estado = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        cp = new javax.swing.JTextField();
        ciudad = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        calle = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        telefono = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        colonia = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        No_interno = new javax.swing.JTextField();
        nombre = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        uno = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        uno4 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel10.setText("Nombre: ");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, -1));

        jLabel11.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel11.setText("Primer Apellido: ");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, -1, -1));

        jLabel12.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel12.setText("Segundo Apellido:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 120, 130, 20));

        jLabel13.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel13.setText("Correo:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 50, -1));

        jLabel14.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel14.setText("Código postal:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, -1, -1));

        apellido_pat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                apellido_patKeyTyped(evt);
            }
        });
        jPanel1.add(apellido_pat, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 160, -1));
        jPanel1.add(correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, 130, -1));

        jLabel2.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel2.setText("Sexo: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 40, -1));

        ape_materno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ape_maternoKeyTyped(evt);
            }
        });
        jPanel1.add(ape_materno, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 140, 170, -1));

        sexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Seleccione-", "Mujer", "Hombre", "Otro" }));
        jPanel1.add(sexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 100, -1));

        estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "  --Seleccione--", "Aguascalientes", "Baja California", "Baja California Sur", "Campeche", "Chiapas", "Chihuahua", "Coahuila de Zaragoza", "Colima", "Durango", "Estado de México", "Guanajuato", "Guerrero", "Hidalgo", "Jalisco", "Michoacán de Ocampo", "Morelos", "Nayarit", "Nuevo León", "Oaxaca", "Puebla", "Querétaro", "Quintana Roo", "San Luis Potosí", "Sinaloa", "Sonora", "Tabasco", "Tamaulipas", "Tlaxcala", "Veracruz de Ignacio de la Llave", "Yucatán", "Zacatecas" }));
        jPanel1.add(estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 130, -1));

        jLabel17.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel17.setText("Estado:");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, -1));

        cp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cpKeyTyped(evt);
            }
        });
        jPanel1.add(cp, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, 70, -1));

        ciudad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ciudadKeyTyped(evt);
            }
        });
        jPanel1.add(ciudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 230, 110, -1));

        jLabel19.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel19.setText("Calle:");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 270, -1, 40));

        calle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                calleKeyTyped(evt);
            }
        });
        jPanel1.add(calle, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 280, 140, -1));

        jLabel21.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel21.setText("Teléfono: ");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 180, -1, -1));

        telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telefonoActionPerformed(evt);
            }
        });
        telefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                telefonoKeyTyped(evt);
            }
        });
        jPanel1.add(telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 180, 110, -1));

        jLabel20.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel20.setText("Colonia:");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 230, -1, -1));

        jLabel22.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel22.setText("Ciudad:");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, -1, 20));

        colonia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                coloniaKeyTyped(evt);
            }
        });
        jPanel1.add(colonia, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 230, 90, -1));

        jLabel15.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel15.setText("No. interior");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 280, -1, -1));

        No_interno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                No_internoKeyTyped(evt);
            }
        });
        jPanel1.add(No_interno, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 280, 60, -1));

        nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombreKeyTyped(evt);
            }
        });
        jPanel1.add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 150, -1));

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
        jPanel2.add(uno, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 10, 50, 40));

        jLabel3.setFont(new java.awt.Font("Decker", 1, 26)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nuevo cliente");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(256, 0, 190, 60));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -3, 670, 60));

        jLabel5.setFont(new java.awt.Font("Decker", 0, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Ingrese datos");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 130, 30));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 470, 10));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 100, 10, 240));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 610, 20));

        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 10, 240));

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
        jPanel1.add(uno4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 360, 120, 50));

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/button_cancelar.png"))); // NOI18N
        jButton7.setBorderPainted(false);
        jButton7.setContentAreaFilled(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 360, 120, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void apellido_patKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_apellido_patKeyTyped
        char c=evt.getKeyChar();
        if (((c <'A')||(c>'Z'))&&((c<'a')||(c>'z'))&&(c!=32)){
            evt.consume();
        }
    }//GEN-LAST:event_apellido_patKeyTyped

    private void ape_maternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ape_maternoKeyTyped
        char c=evt.getKeyChar();
        if (((c <'A')||(c>'Z'))&&((c<'a')||(c>'z'))&&(c!=32)){
            evt.consume();
        }
    }//GEN-LAST:event_ape_maternoKeyTyped

    private void cpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cpKeyTyped
        char c=evt.getKeyChar();
        if(c<'0'||c>'9'){
            evt.consume();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_cpKeyTyped

    private void ciudadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ciudadKeyTyped
        char c=evt.getKeyChar();
        if (((c <'A')||(c>'Z'))&&((c<'a')||(c>'z'))&&(c!=32)){
            evt.consume();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_ciudadKeyTyped

    private void calleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_calleKeyTyped
        char c=evt.getKeyChar();
        if (((c <'A')||(c>'Z'))&&((c<'a')||(c>'z'))&&(c!=32)){
            evt.consume();
        }
    }//GEN-LAST:event_calleKeyTyped

    private void telefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telefonoKeyTyped
        char c=evt.getKeyChar();
        if(c<'0'||c>'9'){
            evt.consume();
        }
    }//GEN-LAST:event_telefonoKeyTyped

    private void coloniaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_coloniaKeyTyped
        char c=evt.getKeyChar();
        if(c<'a'||c>'z'){
            evt.consume();
        }
    }//GEN-LAST:event_coloniaKeyTyped

    private void No_internoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_No_internoKeyTyped
        char c=evt.getKeyChar();
        if(c<'0'||c>'9'){
            evt.consume();
        }
    }//GEN-LAST:event_No_internoKeyTyped

    private void nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreKeyTyped
        char c=evt.getKeyChar();
        if (((c <'A')||(c>'Z'))&&((c<'a')||(c>'z'))&&(c!=32)){
            evt.consume();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreKeyTyped

    private void unoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unoActionPerformed
        
    }//GEN-LAST:event_unoActionPerformed

    private void unoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_unoMouseClicked
        this.dispose();
    }//GEN-LAST:event_unoMouseClicked

    private void uno4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uno4MouseClicked

    }//GEN-LAST:event_uno4MouseClicked

    private void uno4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uno4ActionPerformed
        //verificar que todos los campos estén llenos
        if(nombre.getText().isEmpty()||apellido_pat.getText().isEmpty()||ape_materno.getText().isEmpty()||calle.getText().isEmpty()
                ||calle.getText().isEmpty()||colonia.getText().isEmpty()||correo.getText().isEmpty()||cp.getText().isEmpty()
                    ||telefono.getText().isEmpty()||No_interno.getText().isEmpty()||nombre.getText().isEmpty()||sexo.getSelectedIndex()==0||estado.getSelectedIndex()==0){
        JOptionPane.showMessageDialog(null, "Complete todos los campos","Error",JOptionPane.PLAIN_MESSAGE);
        }else{
             
            ObtenerP();
            String sql,sql2,sql3,res = null;
            sql="INSERT INTO `clientes` (`CLI_ID`, `CLI_Nombre`, `CLI_ApellidoPat`, `CLI_APellidoMat`,`CLI_Sexo`, `CLI_Telefono`, `CLI_Correo`, `CLI_Estatus`) VALUES(NULL,?,?,?,?,?,?,?)";
            sql2="INSERT INTO direccion_c (CLI_ID,CLI_Calle,CLI_Colonia,CLI_Num_Interior,CLI_Num_Exterior,CLI_C_Postal,CLI_Estado)VALUES (?,?,?,?,?,?,?)";
            
            try{
             PreparedStatement pst=(PreparedStatement) cn.prepareStatement(sql);
                    pst.setString(1,nombre.getText());
                    pst.setString(2, apellido_pat.getText());
                    pst.setString(3, ape_materno.getText());
                    pst.setString(4, String.valueOf(sexo.getSelectedItem()));
                    pst.setInt(5, cli_telefono);
                    pst.setString(6, cli_correo);
                    pst.setString(7, "ACTIVO");
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Cliente registrado", "Completado", JOptionPane.INFORMATION_MESSAGE);
                         limpiar();
            }catch (SQLException ex) {
                Logger.getLogger(Altacliente.class.getName()).log(Level.SEVERE, null, sql);
            }  
        try {
            
                
             sql3 = "SELECT max(CLI_ID) from clientes;";
            Statement st = cn.createStatement();
            ResultSet rs=st.executeQuery(sql3);
            while(rs.next()) {
                   res=rs.getString(1);
                   System.out.println(res);
            }
	} catch(Exception e) {System.out.println(e);}
                    
            try{
 
                    PreparedStatement pst2=(PreparedStatement) cn.prepareStatement(sql2);
                    pst2.setString(1,res);
                    pst2.setString(2,cli_calle);
                    pst2.setString(3, cli_colonia);
                    pst2.setInt(4, cli_numint);
                    pst2.setInt(5, cli_numext);
                    pst2.setInt(6, cli_cpostal);
                    pst2.setString(7, estado.getSelectedItem().toString());
                    pst2.executeUpdate();   
                   
                    
//                    JOptionPane.showMessageDialog(null, "Se ha registrado un nuevo cliente", "Completado", JOptionPane.INFORMATION_MESSAGE);   
            } catch (SQLException ex) {
                Logger.getLogger(Altacliente.class.getName()).log(Level.SEVERE, null, sql);
                
            } 
         
            
        }
      
    }//GEN-LAST:event_uno4ActionPerformed

    private void telefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telefonoActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

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
            java.util.logging.Logger.getLogger(Altacliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Altacliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Altacliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Altacliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Altacliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField No_interno;
    private javax.swing.JTextField ape_materno;
    private javax.swing.JTextField apellido_pat;
    private javax.swing.JTextField calle;
    private javax.swing.JTextField ciudad;
    private javax.swing.JTextField colonia;
    private javax.swing.JTextField correo;
    private javax.swing.JTextField cp;
    private javax.swing.JComboBox<String> estado;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTextField nombre;
    private javax.swing.JComboBox<String> sexo;
    private javax.swing.JTextField telefono;
    private javax.swing.JButton uno;
    private javax.swing.JButton uno4;
    // End of variables declaration//GEN-END:variables
}
