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
}
