package Persistencia;
public class DaoSQL extends DaoFactory{
    @Override
    public IDaoMaterial getMaterial() {
       return new DaoMaterial();
    }

    @Override
    public IDaoGrupo getGrupo() {
        return new DaoGrupo();
    }

    @Override
    public IDaoResponsable getResponsable() {
        return new DaoResponsable();
    }
    @Override
    public IDaoEtapa getEtapa() {
        return new DaoEtapa();
    }
    
    @Override
    public IDaoEncargado getEncargado() {
        return new DaoEncargado();
    }
    
    @Override
    public IDaoProyecto getProyecto(){
        return new DaoProyecto();
    }
    
     @Override
    public IDaoCentroCostos getCentroCostos() {
        return new DaoCentroCostos();
    }
}
