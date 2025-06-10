package ejercicio1;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ProxyTelefono implements Set {
    private final int idPersona;
    private final TelefonoDao dao;
    private List<Telefono> telefonos;

    public ProxyTelefono(int idPersona, TelefonoDao dao) {
        this.idPersona = idPersona;
        this.dao = dao;
    }

    private List<Telefono> obtenerTelefonos() {
        telefonos = dao.telefonosPorPersona(idPersona);
        return telefonos;
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
