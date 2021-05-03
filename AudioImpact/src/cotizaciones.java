
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
public class cotizaciones extends javax.swing.JPanel {
     DefaultTableModel model;
     conectar cc = new conectar();
     Connection cn = cc.conexion();
     
    Principal mod;
    public cotizaciones() {
        initComponents();
    }
    //Componentes iniciales para determinar el tipo de usuario
    public cotizaciones(Principal mod) {
        initComponents();
        this.mod = mod;
        if(mod.getUsuario_t().equals("user3")){
            uno4.setEnabled(false);
        }
    }
    private void MostrarCotizaciones(String valor) {
       
        String [] registros = new String[4];
        String [] titulos = {"NUMERO","Proyecto", "Subtotal","Total"};
        
        String sql = "SELECT COT_ID, PRO_ID, COT_Subtotal, COT_Total FROM cotizacion WHERE COT_ID LIKE '%"+valor+"%' OR (PRO_ID LIKE '%"+valor+"%') OR (COT_Subtotal LIKE '%"+valor+"%')OR (COT_Total LIKE '%"+valor+"%')";
       model = new DefaultTableModel(null,titulos);

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()) {
		//Agregar elementos al vector.
                registros[0] = rs.getString("COT_ID");
		registros[1] = rs.getString("PRO_ID");
		registros[2] = rs.getString("COT_Subtotal");
		registros[3] = rs.getString("COT_Total");
		
		model.addRow(registros);
            }
            consultarcot.setModel(model);
            
            
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, ex);
        }
        }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        consultarcot = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        ID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        uno2 = new javax.swing.JButton();
        proyecto = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        uno4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(241, 241, 241));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        consultarcot.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Número", "Proyecto", "Subtotal", "Total"
            }
        ));
        jScrollPane2.setViewportView(consultarcot);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 560, 390));

        jLabel2.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel2.setText("ID:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 33, -1));

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
        jPanel1.add(ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 72, -1));

        jLabel3.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel3.setText("Proyecto:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

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
        jPanel1.add(uno2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, -1, 40));

        proyecto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "  --Selecione--" }));
        jPanel1.add(proyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 115, -1));

        jLabel4.setFont(new java.awt.Font("Decker", 0, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Consulta");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 40));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 640, 540));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Decker", 0, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Nuevo");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 80, 40));

        jLabel6.setFont(new java.awt.Font("Decker", 0, 16)); // NOI18N
        jLabel6.setText("Dar de alta una cotización");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 200, 40));

        uno4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/BotonNuevo_1.png"))); // NOI18N
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
        jPanel2.add(uno4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 90, 40));

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 640, 100));

        jLabel1.setFont(new java.awt.Font("Decker", 0, 24)); // NOI18N
        jLabel1.setText("Cotizaciones");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 0, 170, 50));
    }// </editor-fold>//GEN-END:initComponents

    private void IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDActionPerformed

    private void uno2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uno2ActionPerformed
    MostrarCotizaciones(ID.getText());
    ID.setText("");
    }//GEN-LAST:event_uno2ActionPerformed

    private void IDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_IDKeyTyped
  char c=evt.getKeyChar();
        if(c<'0'||c>'9'){
evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_IDKeyTyped

    private void uno4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uno4MouseClicked
          
          
    }//GEN-LAST:event_uno4MouseClicked

    private void uno4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uno4ActionPerformed
       Altacotizacion n=new Altacotizacion();
          n.setLocationRelativeTo(null);
          n.setVisible(true); 
    }//GEN-LAST:event_uno4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ID;
    private javax.swing.JTable consultarcot;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> proyecto;
    private javax.swing.JButton uno2;
    private javax.swing.JButton uno4;
    // End of variables declaration//GEN-END:variables
}
