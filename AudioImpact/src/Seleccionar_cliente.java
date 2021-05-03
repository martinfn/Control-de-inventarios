
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class Seleccionar_cliente extends javax.swing.JFrame {

        conectar cc = new conectar();
        Connection cn = cc.conexion();
        DefaultTableModel model;
    public Seleccionar_cliente() {
        initComponents();
    }

private void MostrarCliente(String valor) {
        String [] titulos = {"ID", "Nombre", "Apellido Pat.", "Apellido Mat."};
        String [] registros = new String[4];

        String sql = "SELECT DISTINCT CLI_ID, CLI_Nombre, CLI_ApellidoPat, CLI_ApellidoMat FROM clientes WHERE CLI_ID LIKE '%"+valor+"%' OR (CLI_Nombre LIKE '%"+valor+"%') OR (CLI_ApellidoPat LIKE '%"+valor+"%') OR (CLI_ApellidoMat LIKE '%"+valor+"%') ORDER BY CLI_Nombre";
        model = new DefaultTableModel(null, titulos);

        

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()) {
		//Agregar elementos al vector.
		registros[0] = rs.getString("CLI_ID");
		registros[1] = rs.getString("CLI_Nombre");
		registros[2] = rs.getString("CLI_ApellidoPat");
		registros[3] = rs.getString("CLI_ApellidoMat");
		model.addRow(registros);
            }
            
            consultarcli.setModel(model);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        uno2 = new javax.swing.JButton();
        ID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        consultarcli = new javax.swing.JTable();
        uno1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        uno = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel3.setText("Nombre:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

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
        jPanel1.add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 190, -1));

        uno2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/BotonBuscar1.png"))); // NOI18N
        uno2.setBorder(null);
        uno2.setContentAreaFilled(false);
        uno2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        uno2.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/BotonBuscar2.png"))); // NOI18N
        uno2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uno2ActionPerformed(evt);
            }
        });
        jPanel1.add(uno2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, 90, 40));

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

        jLabel2.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel2.setText("ID:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        consultarcli.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Apellido Pat.", "Apellido Mat."
            }
        ));
        jScrollPane1.setViewportView(consultarcli);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 580, 320));

        uno1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/BotonAñadir.png"))); // NOI18N
        uno1.setBorder(null);
        uno1.setContentAreaFilled(false);
        uno1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        uno1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/BotonAñadir2.png"))); // NOI18N
        uno1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uno1ActionPerformed(evt);
            }
        });
        jPanel1.add(uno1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 480, 100, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 640, 550));

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
        jPanel2.add(uno, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, 60, 40));

        jLabel5.setFont(new java.awt.Font("Decker", 1, 26)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Añadir cliente");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 220, 60));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -3, 640, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreKeyTyped
//        char c=evt.getKeyChar();
//        if (((c <'A')||(c>'Z'))&&((c<'a')||(c>'z'))&&(c!=32)){
//            evt.consume();
//        }     // TODO add your handling code here:
    }//GEN-LAST:event_nombreKeyTyped

    private void uno2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uno2ActionPerformed
     MostrarCliente(ID.getText());
     MostrarCliente(nombre.getText());
     nombre.setText("");
     ID.setText("");
    }//GEN-LAST:event_uno2ActionPerformed

    private void IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDActionPerformed

    private void IDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_IDKeyTyped
        char c=evt.getKeyChar();
        if(c<'0'||c>'9'){
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_IDKeyTyped

    private void unoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_unoMouseClicked
        this.dispose();
    }//GEN-LAST:event_unoMouseClicked

    private void unoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unoActionPerformed

    }//GEN-LAST:event_unoActionPerformed

    private void uno1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uno1ActionPerformed
        
        String seleccionarcliente;
        DefaultTableModel model = (DefaultTableModel) consultarcli.getModel();
        
        int FilaSelec = consultarcli.getSelectedRow();
        
        if(FilaSelec >= 0) {
            seleccionarcliente = consultarcli.getValueAt(FilaSelec, 0).toString();
            Altaproyecto alta=new Altaproyecto();
            alta.pro_cliente=seleccionarcliente;
            
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila.", "Seleccionar Registro", 
                JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_uno1ActionPerformed

    private void nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreActionPerformed
      MostrarCliente("");
    }//GEN-LAST:event_nombreActionPerformed

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
            java.util.logging.Logger.getLogger(Seleccionar_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Seleccionar_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Seleccionar_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Seleccionar_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Seleccionar_cliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ID;
    private javax.swing.JTable consultarcli;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nombre;
    private javax.swing.JButton uno;
    private javax.swing.JButton uno1;
    private javax.swing.JButton uno2;
    // End of variables declaration//GEN-END:variables
}
