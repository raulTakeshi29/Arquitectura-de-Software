package Vistas;

import javax.swing.JOptionPane;

public class Validacion {
     private void mostrarErrorSwing(String formato) {
        JOptionPane.showMessageDialog(null,
                formato,
                "ERROR", JOptionPane.ERROR_MESSAGE);
    }
    
    public int IntSwing(String input,String nombre) {
        try{
            int entrada = Integer.parseInt(input);
            return entrada;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Debe ingresar un número");
            int entrada = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero para "+nombre));
            return entrada;
        }

    }
    
    public long LongSwing(String input,String nombre) {
        try{
            long entrada = Long.parseLong(input);
            return entrada;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Debe ingresar un número");
            long entrada = Long.parseLong(JOptionPane.showInputDialog("Ingrese un numero para "+nombre));
            return entrada;
        }

    }
    public String intToString(int input,String nombre) {
        try{
            String entrada = String.valueOf(input);
            return entrada;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Debe ingresar un número");
            String entrada = JOptionPane.showInputDialog("Ingrese un numero para "+nombre);
            return entrada;
        }

    }
    
    public boolean numericSwing(String input){
        try{
            Integer.parseInt(input);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    public int Item(int input){
        if(input==0){
            JOptionPane.showMessageDialog(null, "No ha seleccionado una fila");
             int entrada = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id a editar"));
            return entrada;
        }else{
            return input;
        }
    }
    public String StringSwing(String input,String nombre){
        if(numericSwing(input)==true){
            JOptionPane.showMessageDialog(null, "Debe ingresar un dato cadena");
            String entrada = JOptionPane.showInputDialog("Ingrese el dato correcto para "+nombre);
            return entrada;
        }else if(input.isEmpty()){
            JOptionPane.showMessageDialog(null, "Debe ingresar un valor");
            String entrada= JOptionPane.showInputDialog("Ingrese el valor faltante para "+nombre);
            return entrada;
        }else{
            return input;
        }
    }
    
    public String cargo(int input){
        if(input==1){
            return "ADMINISTRADOR";
        }else{
            return "EMPLEADO";
        }
    }
    public String vacio(String input,String nombre){
        if(input.isEmpty()){
            JOptionPane.showMessageDialog(null, "Debe ingresar un valor");
            String entrada= JOptionPane.showInputDialog("Ingrese el valor faltante para "+nombre);
            return entrada;
        }else{
            return input;
        }
    }

}
