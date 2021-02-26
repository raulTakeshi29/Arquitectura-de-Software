package InterfacesPresentador;

import Logica.Proyecto;

public interface IPBProyecto {
    void asignarProyecto();
    void mostrar(String[][] matriz);
    Proyecto getProyecto();
    void buscar();
}
