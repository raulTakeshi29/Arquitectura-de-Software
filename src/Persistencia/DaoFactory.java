package Persistencia;
public abstract class DaoFactory {
    public abstract IDaoMaterial getMaterial();
    public abstract IDaoGrupo getGrupo();
    public abstract IDaoResponsable getResponsable();
    
}

