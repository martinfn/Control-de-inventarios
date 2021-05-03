
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import paneles.CambiaPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Charlie Rivera
 */
public class Consulta_proyecto extends javax.swing.JPanel {
     Principal mod;
     conectar cc = new conectar();
     Connection cn = cc.conexion();
     DefaultTableModel model;
    public Consulta_proyecto() {
        initComponents();
    }
    //Componentes iniciales para determinar el tipo de usuario
    public Consulta_proyecto(Principal mod) {
        initComponents();
        this.mod = mod;
        if(mod.getUsuario_t().equals("user2")||mod.getUsuario_t().equals("user3")){
            uno4.setEnabled(false);
           
        }
    }
    public void limpiar(){
        ID.setText("");
        proyecto_p.setText("");
    }

    
private void MostrarProyecto(String valor) {
        String [] titulos = {"ID", "Nombre", "Cliente", "Estado"};
        String [] registros = new String[4];

        String sql = "SELECT DISTINCT PRO_ID,PRO_Nombre,PRO_Estatus FROM proyecto WHERE PRO_ID LIKE '%"+valor+"%' OR (PRO_Nombre LIKE '%"+valor+"%') OR (PRO_Estatus LIKE '%"+valor+"%')";
        String sql2="select *from proyecto INNER JOIN clientes ON proyecto.CLI_ID=clientes.CLI_ID";
        String sql3=" SELECT clientes.CLI_ID, clientes.CLI_Nombre, proyecto.PRO_ID, proyecto.PRO_Nombre, proyecto.PRO_Estatus FROM clientes INNER JOIN proyecto ON clientes.CLI_ID=proyecto.CLI_ID WHERE proyecto.PRO_ID LIKE '%"+valor+"%' OR (proyecto.PRO_Nombre LIKE %"+valor+"%')";
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        consultarpro = new javax.swing.JTable();
        ID = new javax.swing.JTextField();
        proyecto_p = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        uno2 = new javax.swing.JButton();
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

        jLabel2.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel2.setText("ID:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

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
        jScrollPane1.setViewportView(consultarpro);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 580, 380));

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
        jPanel1.add(ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 150, -1));

        proyecto_p.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                proyecto_pKeyTyped(evt);
            }
        });
        jPanel1.add(proyecto_p, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 130, -1));

        jLabel3.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel3.setText("Cliente");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

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
        jPanel1.add(uno2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 90, 40));

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
        jLabel6.setText("Dar de alta un nuevo proyecto");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 240, 40));

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
        jPanel2.add(uno4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 90, 40));

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 640, 100));

        jLabel1.setFont(new java.awt.Font("Decker", 0, 24)); // NOI18N
        jLabel1.setText("Proyectos");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 0, 130, 50));
    }// </editor-fold>//GEN-END:initComponents

    private void IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDActionPerformed

    private void uno2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uno2ActionPerformed
        MostrarProyecto(ID.getText());
        MostrarProyecto(proyecto_p.getText());
        ID.setText("");
        proyecto_p.setText("");
    }//GEN-LAST:event_uno2ActionPerformed

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

    private void uno4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uno4MouseClicked
      
    }//GEN-LAST:event_uno4MouseClicked

    private void uno4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uno4ActionPerformed
      Altaproyecto a=new Altaproyecto();
      a.setVisible(true);
      a.setLocationRelativeTo(null);

    }//GEN-LAST:event_uno4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ID;
    private javax.swing.JTable consultarpro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField proyecto_p;
    private javax.swing.JButton uno2;
    private javax.swing.JButton uno4;
    // End of variables declaration//GEN-END:variables
}
