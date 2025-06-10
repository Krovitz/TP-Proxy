package ejercicio2;

import java.io.IOException;

public class ProxySeguridad implements LecturaDeArchivo {
    private FileAccess fileAccess;
    private String nombreArchivo;
    private Usuario usuario;

    public ProxySeguridad(FileAccess fileAccess, String nombreArchivo, Usuario usuario) {
        this.fileAccess = fileAccess;
        this.nombreArchivo = nombreArchivo;
        this.usuario = usuario;
    }

    @Override
    public String readFile() throws IOException {
        if (nombreArchivo.startsWith("i") && !usuario.poseePermiso(Permiso.ADMIN))
            throw new RuntimeException("No posees permiso para leer el contenido de este archivo");
        if (nombreArchivo.startsWith("m") && (!usuario.poseePermiso(Permiso.ADMIN) && !usuario.poseePermiso(Permiso.INTERMEDIO)))
            throw new RuntimeException("No posees permiso para leer el contenido de este archivo");
        return fileAccess.readFile();
    }
}
