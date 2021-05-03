
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class Altaproyecto extends javax.swing.JFrame {

    String pro_cliente, pro_nproyecto, pro_colonia, pro_calle;
    int pro_cpostal, pro_numint, pro_numext,cli_id;
    conectar cc = new conectar();
     Connection cn = cc.conexion();
     DefaultTableModel model;
    public Altaproyecto() {
        initComponents();
         this.setDefaultCloseOperation(Altaproyecto.DO_NOTHING_ON_CLOSE);
    }
     public void  limpiar() {
         nombre_p.setText("");
         colonia_p.setText("");
         calle_p.setText("");
         ciudad_p.setText("");
         ninterior_p.setText("");
         nexterior_p.setText("");
         cpostal_p.setText("");
         descripcion_p.setText("");
         txtclientep.setText("");
         estado_p.setSelectedItem(null);
     }
        //Método para mostrar clientes ya registrados
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
   private void ObtenerID(){
     try {
            String sql3,res=null;
                
             sql3 = "SELECT CLI_ID from clientes where CLI_;";
            Statement st = cn.createStatement();
            ResultSet rs=st.executeQuery(sql3);
            while(rs.next()) {
                   res=rs.getString(1);
                   System.out.println(res);
            }
	} catch(Exception e) {System.out.println(e);}
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Seleccionar_clientes = new javax.swing.JFrame();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        nombre_b = new javax.swing.JTextField();
        uno2 = new javax.swing.JButton();
        ID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        consultarcli = new javax.swing.JTable();
        uno1 = new javax.swing.JButton();
        uno5 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        uno3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        nombre_p = new javax.swing.JTextField();
        ciudad_p = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        colonia_p = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        uno = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        uno4 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        clientep = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        descripcion_p = new javax.swing.JTextArea();
        nexterior_p = new javax.swing.JTextField();
        cpostal_p = new javax.swing.JTextField();
        ninterior_p = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        estado_p = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        calle_p = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtclientep = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();

        Seleccionar_clientes.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        Seleccionar_clientes.setUndecorated(true);
        Seleccionar_clientes.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel4.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel4.setText("Nombre:");

        nombre_b.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombre_bActionPerformed(evt);
            }
        });
        nombre_b.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombre_bKeyTyped(evt);
            }
        });

        uno2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/button_cancelar.png"))); // NOI18N
        uno2.setBorder(null);
        uno2.setContentAreaFilled(false);
        uno2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        uno2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                uno2MouseClicked(evt);
            }
        });
        uno2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uno2ActionPerformed(evt);
            }
        });

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

        jLabel2.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel2.setText("ID:");

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
        jScrollPane2.setViewportView(consultarcli);

        uno1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/button_anadir.png"))); // NOI18N
        uno1.setBorder(null);
        uno1.setContentAreaFilled(false);
        uno1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        uno1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uno1ActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2)
                .addGap(14, 14, 14)
                .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel4)
                .addGap(5, 5, 5)
                .addComponent(nombre_b, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(uno5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(369, 369, 369)
                .addComponent(uno1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(uno2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(uno5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(nombre_b, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(uno1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(uno2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        Seleccionar_clientes.getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 640, 550));

        jPanel4.setBackground(new java.awt.Color(0, 133, 186));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        uno3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/IconoSalir_1.png"))); // NOI18N
        uno3.setBorder(null);
        uno3.setContentAreaFilled(false);
        uno3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        uno3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                uno3MouseClicked(evt);
            }
        });
        uno3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uno3ActionPerformed(evt);
            }
        });
        jPanel4.add(uno3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, 60, 40));

        jLabel6.setFont(new java.awt.Font("Decker", 1, 26)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Añadir cliente");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 220, 60));

        Seleccionar_clientes.getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -3, 640, 60));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel8.setText("No. exterior:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 80, 40));

        nombre_p.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombre_pKeyTyped(evt);
            }
        });
        jPanel1.add(nombre_p, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 240, -1));

        ciudad_p.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ciudad_pKeyTyped(evt);
            }
        });
        jPanel1.add(ciudad_p, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 250, 120, -1));

        jLabel11.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel11.setText("Ciudad:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 250, 60, -1));

        jLabel14.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel14.setText("Nombre del proyecto:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 140, 40));

        colonia_p.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                colonia_pKeyTyped(evt);
            }
        });
        jPanel1.add(colonia_p, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, 130, -1));

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
        jPanel2.add(uno, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 60, 40));

        jLabel3.setFont(new java.awt.Font("Decker", 1, 26)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nuevo proyecto");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 220, 60));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -3, 500, 60));

        jLabel5.setFont(new java.awt.Font("Decker", 0, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Ingrese datos");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 130, 30));

        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 10, 210));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 290, 10));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 430, 20));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 10, 230));

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
        jPanel1.add(uno4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 570, 120, 50));

        jLabel9.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel9.setText("Cliente:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 60, 40));

        clientep.setText("-Seleccione-");
        clientep.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clientepMouseClicked(evt);
            }
        });
        clientep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientepActionPerformed(evt);
            }
        });
        jPanel1.add(clientep, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 140, -1));

        jLabel12.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel12.setText("Descripción:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 100, 40));

        jLabel13.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel13.setText("No. interior:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 80, 40));

        jLabel15.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel15.setText("Estado:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 60, 40));

        jLabel16.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel16.setText("Código Postal:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 360, 100, 40));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, 430, 20));

        descripcion_p.setColumns(20);
        descripcion_p.setRows(5);
        jScrollPane1.setViewportView(descripcion_p);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 410, 280, 120));
        jPanel1.add(nexterior_p, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 370, 70, -1));
        jPanel1.add(cpostal_p, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 370, 70, -1));
        jPanel1.add(ninterior_p, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 330, 70, -1));

        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, 10, 210));

        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 320, 10, 230));
        jPanel1.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 430, 20));

        estado_p.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "  --Seleccione--", "Aguascalientes", "Baja California", "Baja California Sur", "Campeche", "Chiapas", "Chihuahua", "Coahuila de Zaragoza", "Colima", "Durango", "Estado de México", "Guanajuato", "Guerrero", "Hidalgo", "Jalisco", "Michoacán de Ocampo", "Morelos", "Nayarit", "Nuevo León", "Oaxaca", "Puebla", "Querétaro", "Quintana Roo", "San Luis Potosí", "Sinaloa", "Sonora", "Tabasco", "Tamaulipas", "Tlaxcala", "Veracruz de Ignacio de la Llave", "Yucatán", "Zacatecas" }));
        jPanel1.add(estado_p, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, 130, -1));

        jLabel17.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel17.setText("Colonia:");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 80, -1));
        jPanel1.add(calle_p, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 210, 130, -1));

        jLabel18.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jLabel18.setText("Calle:");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, 40, -1));

        txtclientep.setEditable(false);
        jPanel1.add(txtclientep, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, 160, -1));

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/button_cancelar.png"))); // NOI18N
        jButton7.setBorderPainted(false);
        jButton7.setContentAreaFilled(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 570, 120, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void colonia_pKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_colonia_pKeyTyped
        char c=evt.getKeyChar();
        if (((c <'A')||(c>'Z'))&&((c<'a')||(c>'z'))&&(c!=32)){
            evt.consume();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_colonia_pKeyTyped

    private void ciudad_pKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ciudad_pKeyTyped
        char c=evt.getKeyChar();
        if (((c <'A')||(c>'Z'))&&((c<'a')||(c>'z'))&&(c!=32)){
            evt.consume();
        }            // TODO add your handling code here:
    }//GEN-LAST:event_ciudad_pKeyTyped

    private void nombre_pKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombre_pKeyTyped
        char c=evt.getKeyChar();
        if (((c <'A')||(c>'Z'))&&((c<'a')||(c>'z'))&&(c!=32)){
            evt.consume();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_nombre_pKeyTyped

    private void unoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unoActionPerformed

    }//GEN-LAST:event_unoActionPerformed

    private void unoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_unoMouseClicked
        this.dispose();
    }//GEN-LAST:event_unoMouseClicked

    private void uno4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uno4MouseClicked

    }//GEN-LAST:event_uno4MouseClicked

    private void uno4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uno4ActionPerformed
        if(calle_p.getText().isEmpty()||colonia_p.getText().isEmpty()||
                nombre_p.getText().isEmpty()||estado_p.getSelectedIndex()==0||ciudad_p.getText().isEmpty()){  
             JOptionPane.showMessageDialog(null, "Llene todos los campos","Error",JOptionPane.PLAIN_MESSAGE);
        }else{
          String sql,sql2,sql3,res=null;
          sql="INSERT INTO `proyecto` (`PRO_ID`, `CLI_ID`, `PRO_Nombre`,`PR_Ciudad`,`PRO_Estado`, `PRO_Estatus`) VALUES (?,?,?,?,?,?) ";
          sql2="INSERT INTO `direccion_p` (`PRO_ID`, `PRO_Calle`, `PRO_Colonia`, `PRO_Num_Interior`, `PRO_Num_Exterior`, `PRO_C_Postal`) VALUES (?,?,?,?,?,?)";
            try{
                ObtenerID();
                PreparedStatement pst=(PreparedStatement) cn.prepareStatement(sql);
                    pst.setString(1,"1269");
                    pst.setInt(2, cli_id);
                    pst.setString(3, nombre_p.getText());
                     pst.setString(4, ciudad_p.getText());
                    pst.setString(5, estado_p.getSelectedItem().toString());
                    pst.setString(6, "ACTIVO");
                    pst.executeUpdate();      
            } catch (SQLException ex) {
                Logger.getLogger(Altaproyecto.class.getName()).log(Level.SEVERE, null, ex);
            }
           try {
            
                
             sql3 = "SELECT max(PRO_ID) from proyecto;";
            Statement st = cn.createStatement();
            ResultSet rs=st.executeQuery(sql3);
            while(rs.next()) {
                   res=rs.getString(1);
                   System.out.println(res);
            }
	} catch(Exception e) {
            System.out.println(e);
        }
            try{
 
                    PreparedStatement pst2=(PreparedStatement) cn.prepareStatement(sql2);
                    pst2.setString(1,res);
                    pst2.setString(2,calle_p.getText());
                    pst2.setString(3, colonia_p.getText());
                    pst2.setInt(4, Integer.parseInt(ninterior_p.getText()));
                    pst2.setInt(5, Integer.parseInt(nexterior_p.getText()));
                    pst2.setInt(6, Integer.parseInt(cpostal_p.getText()));
                    
                    pst2.executeUpdate();   
                   
                    
                    JOptionPane.showMessageDialog(null, "Proyecto registrado", "Completado", JOptionPane.INFORMATION_MESSAGE); 
                    limpiar();
            } catch (SQLException ex) {
                Logger.getLogger(Altaproyecto.class.getName()).log(Level.SEVERE, null, sql);
            } 
        }
    }//GEN-LAST:event_uno4ActionPerformed

    private void clientepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientepActionPerformed
    
        
    }//GEN-LAST:event_clientepActionPerformed

    private void nombre_bActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombre_bActionPerformed
        MostrarCliente("");
    }//GEN-LAST:event_nombre_bActionPerformed

    private void nombre_bKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombre_bKeyTyped
        //        char c=evt.getKeyChar();
        //        if (((c <'A')||(c>'Z'))&&((c<'a')||(c>'z'))&&(c!=32)){
            //            evt.consume();
            //        }     // TODO add your handling code here:
    }//GEN-LAST:event_nombre_bKeyTyped

    private void uno2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uno2ActionPerformed
       
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

    private void uno1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uno1ActionPerformed

        String seleccionarcliente,seleccionarid;
        DefaultTableModel model = (DefaultTableModel) consultarcli.getModel();

        int FilaSelec = consultarcli.getSelectedRow();

        if(FilaSelec >= 0) {
            seleccionarid=consultarcli.getValueAt(FilaSelec, 0).toString();
            seleccionarcliente = consultarcli.getValueAt(FilaSelec, 1).toString();
            txtclientep.setText(seleccionarcliente);
            cli_id=Integer.parseInt(seleccionarid);
            Seleccionar_clientes.setVisible(false);
            

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila.", "Seleccionar Registro",
                JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_uno1ActionPerformed

    private void uno3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uno3MouseClicked
        Seleccionar_clientes.setVisible(false);
    }//GEN-LAST:event_uno3MouseClicked

    private void uno3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uno3ActionPerformed

    }//GEN-LAST:event_uno3ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void uno5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uno5ActionPerformed
        MostrarCliente(ID.getText());
     MostrarCliente(nombre_b.getText());
     nombre_b.setText("");
     ID.setText("");
    }//GEN-LAST:event_uno5ActionPerformed

    private void clientepMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clientepMouseClicked
         // Seleccionar_cliente s=new Seleccionar_cliente();
      //s.setVisible(true);
      //s.setLocationRelativeTo(null);
       Seleccionar_clientes.setVisible(true);
       Seleccionar_clientes.setLocation(600, 100);
       Seleccionar_clientes.setSize(641, 598);
    }//GEN-LAST:event_clientepMouseClicked

    private void uno2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uno2MouseClicked
        Seleccionar_clientes.dispose();
    }//GEN-LAST:event_uno2MouseClicked

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
            java.util.logging.Logger.getLogger(Altaproyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Altaproyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Altaproyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Altaproyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Altaproyecto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ID;
    private javax.swing.JFrame Seleccionar_clientes;
    private javax.swing.JTextField calle_p;
    private javax.swing.JTextField ciudad_p;
    private javax.swing.JButton clientep;
    private javax.swing.JTextField colonia_p;
    private javax.swing.JTable consultarcli;
    private javax.swing.JTextField cpostal_p;
    private javax.swing.JTextArea descripcion_p;
    private javax.swing.JComboBox<String> estado_p;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JTextField nexterior_p;
    private javax.swing.JTextField ninterior_p;
    private javax.swing.JTextField nombre_b;
    private javax.swing.JTextField nombre_p;
    public static javax.swing.JTextField txtclientep;
    private javax.swing.JButton uno;
    private javax.swing.JButton uno1;
    private javax.swing.JButton uno2;
    private javax.swing.JButton uno3;
    private javax.swing.JButton uno4;
    private javax.swing.JButton uno5;
    // End of variables declaration//GEN-END:variables
}
