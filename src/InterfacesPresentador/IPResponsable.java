/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfacesPresentador;

/**
 *
 * @author TAKESHI
 */
public interface IPResponsable {
    void nuevo();
    void guardar();
    void cancelar();
    void editar();
    void eliminar();
    void mostrar(String[][] matriz);
    void buscar();
}
