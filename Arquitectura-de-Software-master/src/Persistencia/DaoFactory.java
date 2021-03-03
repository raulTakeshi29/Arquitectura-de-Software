package Persistencia;
public abstract class DaoFactory {
    public abstract IDao getMaterial();
    public abstract IDao getGrupo();
    public abstract IDao getResponsable();
    public abstract IDao getEtapa();
    public abstract IDao getEncargado();
    public abstract IDao getProyecto();
    public abstract IDao getCentroCostos();
}

