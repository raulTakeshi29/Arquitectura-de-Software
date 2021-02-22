package InterfacesPresentador;

import Logica.Etapa;

public interface IPBEtapa {
    void asignarEtapa();
    void mostrar(String[][] matriz);
    Etapa getEtapa();
    void buscar();
}
