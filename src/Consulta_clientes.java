
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

public class Consulta_clientes extends javax.swing.JPanel {
    Principal mod;
     conectar cc = new conectar();
     Connection cn = cc.conexion();
     DefaultTableModel model;
    public Consulta_clientes() {
        initComponents();
    }
    //Componentes iniciales para determinar el tipo de usuario
    public Consulta_clientes(Principal mod) {
        initComponents();
        this.mod = mod;
        if(mod.getUsuario_t().equals("user2")){
            System.out.println("Usuario 2");
            uno4.setEnabled(false);
        }
          
        
    }
    public void limpiar(){
        ID.setText("");
        nombre.setText("");
    }
    private void MostrarCliente(String valor) {
        String [] titulos = {"ID", "Nombre", "Apellido Pat.", "Apellido Mat."};
        String [] registros = new String[4];

        String sql = "SELECT DISTINCT CLI_ID, CLI_Nombre, CLI_ApellidoPat, CLI_ApellidoMat FROM clientes WHERE CLI_ID LIKE '%"+valor+"%' OR (CLI_Nombre LIKE '%"+valor+"%') OR (CLI_ApellidoPat LIKE '%"+valor+"%') OR (CLI_ApellidoMat LIKE '%"+valor+"%')";
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

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        uno2 = new javax.swing.JButton();
        ID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        consultarcli = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        uno4 = new javax.swing.JButton();

        setBackground(new java.awt.Color(241, 241, 241));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Decker", 0, 24)); // NOI18N
        jLabel1.setText("Clientes");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 0, 100, 50));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Decker", 0, 16)); // NOI18N
        jLabel3.setText("Nombre:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        nombre.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombreKeyTyped(evt);
            }
        });
        jPanel1.add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 190, -1));

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
        jPanel1.add(uno2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, 90, 40));

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

        jLabel4.setFont(new java.awt.Font("Decker", 0, 22)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Consulta");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 40));

        consultarcli = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndes, int colIndex){
                return false;
            }
        };
        consultarcli.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Apellido Pat.", "Apellido Mat."
            }
        ));
        jScrollPane1.setViewportView(consultarcli);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 580, 370));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 640, 540));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Decker", 0, 22)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Nuevo");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 80, 40));

        jLabel6.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel6.setText("Dar de alta un nuevo cliente");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 240, 40));

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

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 640, 100));
    }// </editor-fold>//GEN-END:initComponents

    private void IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDActionPerformed

    private void uno2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uno2ActionPerformed
        MostrarCliente(nombre.getText());
        MostrarCliente(ID.getText());
        nombre.setText("");
        ID.setText("");
    }//GEN-LAST:event_uno2ActionPerformed

    private void IDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_IDKeyTyped
   char c=evt.getKeyChar();
        if(c<'0'||c>'9'){
evt.consume();
}        // TODO add your handling code here:
    }//GEN-LAST:event_IDKeyTyped

    private void nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreKeyTyped
  char c=evt.getKeyChar();
        if (((c <'A')||(c>'Z'))&&((c<'a')||(c>'z'))&&(c!=32)){
evt.consume();
}     // TODO add your handling code here:
    }//GEN-LAST:event_nombreKeyTyped

    private void uno4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uno4ActionPerformed
        Altacliente a=new Altacliente();
        a.setVisible(true);
        a.setLocationRelativeTo(null);
        
    }//GEN-LAST:event_uno4ActionPerformed

    private void uno4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uno4MouseClicked
         
    }//GEN-LAST:event_uno4MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ID;
    private javax.swing.JTable consultarcli;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nombre;
    private javax.swing.JButton uno2;
    private javax.swing.JButton uno4;
    // End of variables declaration//GEN-END:variables
}
