
package Logica;

public class CentroCostos {
   private int idCentroCostos;
   private String tipo;
   public CentroCostos(){
       
   }

    public CentroCostos(int idCentroCostos, String tipo) {
        this.idCentroCostos = idCentroCostos;
        this.tipo = tipo;
    }

    public int getIdCentroCostos() {
        return idCentroCostos;
    }

    public void setIdCentroCostos(int idCentroCostos) {
        this.idCentroCostos = idCentroCostos;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
   
   
}
