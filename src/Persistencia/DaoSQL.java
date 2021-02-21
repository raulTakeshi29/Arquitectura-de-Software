package Persistencia;
public class DaoSQL extends DaoFactory{
    @Override
    public IDaoMaterial getMaterial() {
       return new DaoMaterial();
    }
}
