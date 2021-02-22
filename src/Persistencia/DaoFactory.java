package Persistencia;
public abstract class DaoFactory {
    public abstract IDaoMaterial getMaterial();
    public abstract IDaoGrupo getGrupo();
    public abstract IDaoEtapa getEtapa();
    public abstract IDaoEncargado getEncargado();
}

