package InterfacesPresentador;

import Logica.Responsable;

public interface IPBResponsable {
    void asignarResponsable();
    void mostrar(String[][] matriz);
    Responsable getResponsable();
    void buscar();
}
