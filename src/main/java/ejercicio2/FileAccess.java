package ejercicio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileAccess implements LecturaDeArchivo {
    private String ruta;
    private String nombreArchivo;

    public FileAccess(String ruta, String nombre) {
        this.ruta = ruta;
        this.nombreArchivo = nombre;
    }

    @Override
    public String readFile() throws IOException {
        return Files.readString(Paths.get(this.ruta + "/" + this.nombreArchivo));
    }

    public String nombreArchivo() {
        return nombreArchivo;
    }

    public boolean empiezaCon(String unaLetra) {
        return nombreArchivo.startsWith(unaLetra);
    }
}
