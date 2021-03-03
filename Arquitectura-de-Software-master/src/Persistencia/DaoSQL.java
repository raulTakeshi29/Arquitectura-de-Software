package Persistencia;
public class DaoSQL extends DaoFactory{
    @Override
    public IDao getMaterial() {
       return new DaoMaterial();
    }

    @Override
    public IDao getGrupo() {
        return new DaoGrupo();
    }

    @Override
    public IDao getResponsable() {
        return new DaoResponsable();
    }
    @Override
    public IDao getEtapa() {
        return new DaoEtapa();
    }
    
    @Override
    public IDao getEncargado() {
        return new DaoEncargado();
    }
    
    @Override
    public IDao getProyecto(){
        return new DaoProyecto();
    }
    
     @Override
    public IDao getCentroCostos() {
        return new DaoCentroCostos();
    }
}
