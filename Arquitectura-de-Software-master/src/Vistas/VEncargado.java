/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import InterfacesVistas.IEncargado;
import Presentador.PEncargado;
import javax.swing.JOptionPane;

/**
 *
 * @author sroma
 */
public class VEncargado extends javax.swing.JFrame implements IEncargado{
Validacion v= new Validacion();
    /**
     * Creates new form VEncargado
     */
    public VEncargado() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buscar = new javax.swing.JTextField();
        editar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnBus = new javax.swing.JButton();
        nombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        apellido = new javax.swing.JTextField();
        guardar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 168, 109, -1));

        editar.setText("Editar");
        getContentPane().add(editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(269, 92, -1, -1));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Apellido"
            }
        ));
        jScrollPane1.setViewportView(tabla);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, 131));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("ENCARGADOS");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(251, 11, -1, -1));

        jLabel1.setText("Nombre:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 71, -1, -1));

        btnBus.setText("Buscar");
        getContentPane().add(btnBus, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, -1, -1));
        getContentPane().add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 68, 109, -1));

        jLabel2.setText("Apellido:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 109, -1, -1));

        apellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apellidoActionPerformed(evt);
            }
        });
        getContentPane().add(apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 106, 106, -1));

        guardar.setText("Registrar");
        getContentPane().add(guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(267, 63, -1, -1));

        cancelar.setText("Cancelar");
        getContentPane().add(cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(269, 121, -1, -1));

        eliminar.setText("Eliminar");
        getContentPane().add(eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(269, 155, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void apellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_apellidoActionPerformed

    /**
     * @param m
     * @param args the command line arguments
     */
    
@Override
    public void setPresentador(PEncargado m) {
        guardar.addActionListener(m);
        cancelar.addActionListener(m);
        editar.addActionListener(m);
        eliminar.addActionListener(m);
        btnBus.addActionListener(m);
    }

    @Override
    public void iniciar() {
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public String getnombre() {
       return v.StringSwing(nombre.getText(),"nombre");
    }
    
     @Override
    public String getapellido() {
       return v.StringSwing(apellido.getText(),"apellido");
    }

    @Override
    public String getBusqueda() {
       return v.StringSwing(buscar.getText(),"buscar");
    }

    @Override
    public int getItem() {
        if(tabla.getSelectedRow()!=-1){
            return Integer.parseInt(String.valueOf(tabla.getValueAt(tabla.getSelectedRow(), 0)));
        } else{
            return -1;
        }
    }

    @Override
    public void setSalida(String[][] lista) {
       tabla.setModel(new javax.swing.table.DefaultTableModel(lista,new String [] {"Id", "Nombre"}));
    }

    @Override
    public void mostrarMensaje(String output) {
        JOptionPane.showMessageDialog(null, output);
    }

    @Override
    public void restaurar() {
        nombre.setText("");
        apellido.setText("");
    }

     
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellido;
    private javax.swing.JButton btnBus;
    private javax.swing.JTextField buscar;
    private javax.swing.JButton cancelar;
    private javax.swing.JButton editar;
    private javax.swing.JButton eliminar;
    private javax.swing.JButton guardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nombre;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
