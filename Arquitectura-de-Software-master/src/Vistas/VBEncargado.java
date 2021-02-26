/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import InterfacesVistas.IBEncargado;
import Presentador.PBEncargado;
import javax.swing.JOptionPane;

/**
 *
 * @author sroma
 */
public class VBEncargado extends java.awt.Dialog implements IBEncargado{

    /**
     * Creates new form VBEncargado
     */
    public VBEncargado(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        encargado = new javax.swing.JTextField();
        buscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        encargados = new javax.swing.JTable();
        aceptar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Buscar:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, -1, -1));
        jPanel1.add(encargado, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 90, 30));

        buscar.setText("Buscar");
        jPanel1.add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, -1, -1));

        encargados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Nombre", "Apellidol"
            }
        ));
        jScrollPane1.setViewportView(encargados);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 290, 110));

        aceptar.setText("Aceptar");
        jPanel1.add(aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, -1, -1));

        cancelar.setText("Cancelar");
        jPanel1.add(cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 250, -1, -1));

        add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    /**
     * @param p
     * @param args the command line arguments
     */
     @Override
    public void setPresentador(PBEncargado p) {
        aceptar.addActionListener(p);
        cancelar.addActionListener(p);
        buscar.addActionListener(p);
    }

    @Override
    public void iniciar() {
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public String getBusqueda() {
        return encargado.getText();
    }

    @Override
    public int getItem() {
        if(encargados.getSelectedRow()!=-1){
            return Integer.parseInt(String.valueOf(encargados.getValueAt(encargados.getSelectedRow(), 0)));
        } else{
            return -1;
        }
    }

    @Override
    public void setSalida(String[][] lista) {
        encargados.setModel(new javax.swing.table.DefaultTableModel(lista,new String [] {"Id", "Nombre","Apellido"}));
    }

    @Override
    public void mostrarMensaje(String output) {
        JOptionPane.showMessageDialog(null, output);
    }        
    
    @Override
    public void cerrar(){
        this.dispose();
    } 


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptar;
    private javax.swing.JButton buscar;
    private javax.swing.JButton cancelar;
    private javax.swing.JTextField encargado;
    private javax.swing.JTable encargados;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}