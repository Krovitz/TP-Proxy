package ejercicio1;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ProxyTelefono implements Set {
    private final int idPersona;
    private final TelefonoDao dao = new TelefonoDao();
    //Estaria bien setear los telefonos en una variable de instancia?? o asi esta bien?

    public ProxyTelefono(int idPersona) {
        this.idPersona = idPersona;
    }

    private List<Telefono> obtenerTelefonos() {
        return dao.telefonosPorPersona(idPersona);
    }


    @Override
    public int size() {
        return obtenerTelefonos().size();
    }

    @Override
    public boolean isEmpty() {
        return obtenerTelefonos().isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return obtenerTelefonos().toArray();
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return obtenerTelefonos().toArray(new Telefono[0]);
    }
}
