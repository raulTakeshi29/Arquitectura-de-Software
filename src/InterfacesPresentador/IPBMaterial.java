package InterfacesPresentador;

import Logica.Material;

public interface IPBMaterial {
    void asignarMaterial();
    void mostrar(String[][] matriz);
    Material getMaterial();
    void buscar();
}
