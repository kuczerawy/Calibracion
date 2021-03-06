/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calibracion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author d.kuczerawy
 */
public class Login extends javax.swing.JFrame {

    
            
    public Login() {
        initComponents();
        leyendaLabel.setVisible(false);
        nulo = false;
    }

    Login(VentPrincipal frame) {
        vp = frame;
        initComponents();
        leyendaLabel.setVisible(false);
        nulo = false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        usuarioTF = new javax.swing.JTextField();
        contraseñaTF = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        leyendaLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Login");
        setAlwaysOnTop(true);
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("Usuario:");

        jLabel2.setText("Contraseña:");

        contraseñaTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contraseñaTFActionPerformed(evt);
            }
        });

        jButton1.setText("Ingresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresarBActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarBActionPerformed(evt);
            }
        });

        leyendaLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        leyendaLabel.setText("  ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(usuarioTF, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                            .addComponent(contraseñaTF)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jButton1)
                        .addGap(41, 41, 41)
                        .addComponent(jButton2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(leyendaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(usuarioTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(contraseñaTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(leyendaLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void contraseñaTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contraseñaTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contraseñaTFActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
       cerrar(this);
    }//GEN-LAST:event_formWindowClosing

    private void cancelarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBActionPerformed
        cerrar(this);
    }//GEN-LAST:event_cancelarBActionPerformed

    private void ingresarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresarBActionPerformed
        StringBuffer cadena = new StringBuffer();
        char[] pass;
        vp.usuario = usuarioTF.getText();
        pass = contraseñaTF.getPassword();
        for (int x=0;x<pass.length;x++){
            cadena =cadena.append(pass[x]);
        }
        vp.contraseña = cadena.toString();
        if(validarUsuario()){
            dispose();
            vp.setEnabled(true);
            vp.toFront();
            vp.pestañaTabbedPane.setVisible(true);
            vp.usuarioLogedLabel.setText("Usuario: " + vp.usuario);
        }
        else if(nulo)
            leyendaLabel.setText("Usuario inexistente");
        else
            leyendaLabel.setText("Contraseña incorrecta");
            leyendaLabel.setVisible(true);    
    }//GEN-LAST:event_ingresarBActionPerformed

     private boolean validarUsuario(){
         vp.sql = "SELECT Usuario.[Usuario], Usuario.[Contraseña], Usuario.[Nivel] "+"FROM Usuario " + "WHERE Usuario.[Usuario] = ?";
         PreparedStatement pstm;
         
        try {
            pstm = vp.conexion.prepareStatement( vp.sql );
            pstm.setString(1, vp.usuario);
            ResultSet res = pstm.executeQuery();
            
            if(!res.next()){
                nulo = true;
                res.close();
                return false;
            }
            
            
                   
            if(vp.contraseña.equals(res.getString("Contraseña"))){ 
                vp.nivel = res.getString("Nivel");
                res.close();
                return true;
            }
            else{
                res.close();
                return false;
            }
        } catch (SQLException ex) {
            
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return false;
     }
    
     private void cerrar(Login o){
        o.setEnabled(false);
        o.toBack();
        CloseWindows c = new CloseWindows(o);
        c.setVisible(true);
        c.setLocationRelativeTo(null);        
    }
    
    private boolean nulo; 
    private VentPrincipal vp;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField contraseñaTF;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel leyendaLabel;
    private javax.swing.JTextField usuarioTF;
    // End of variables declaration//GEN-END:variables
}
