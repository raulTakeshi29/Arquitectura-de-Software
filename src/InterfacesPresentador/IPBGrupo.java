/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfacesPresentador;

import Logica.Grupo;

/**
 *
 * @author TAKESHI
 */
public interface IPBGrupo {
    void asignarGrupo();
    void mostrar(String[][] matriz);
    Grupo getGrupo();
    void buscar();
}
