package Persistencia;
public abstract class DaoFactory {
    public abstract IDaoMaterial getMaterial();
    public abstract IDaoGrupo getGrupo();
    public abstract IDaoResponsable getResponsable();
    public abstract IDaoEtapa getEtapa();
    public abstract IDaoEncargado getEncargado();
    public abstract IDaoProyecto getProyecto();
    public abstract IDaoCentroCostos getCentroCostos();
}

