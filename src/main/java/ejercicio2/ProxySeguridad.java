package ejercicio2;

import java.io.IOException;

public class ProxySeguridad implements LecturaDeArchivo {
    private FileAccess fileAccess;
    private Usuario usuario;

    public ProxySeguridad(FileAccess fileAccess, Usuario usuario) {
        this.fileAccess = fileAccess;
        this.usuario = usuario;
    }

    @Override
    public String readFile() throws IOException {
        if (fileAccess.empiezaCon("i") && !usuario.poseePermiso(Permiso.ADMIN))
            throw new RuntimeException("No posees permiso para leer el contenido de este archivo");
        if (fileAccess.empiezaCon("m") && (!usuario.poseePermiso(Permiso.ADMIN) && !usuario.poseePermiso(Permiso.INTERMEDIO)))
            throw new RuntimeException("No posees permiso para leer el contenido de este archivo");
        return fileAccess.readFile();
    }


}
