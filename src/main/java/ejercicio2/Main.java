package ejercicio2;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        var usuario = new Usuario("Juan", List.of(Permiso.BASICO));

        var file = new ProxySeguridad(new FileAccess("C:/Users/Tomas/Desktop/", "marchivo.txt"),
                usuario);

        var contenido = file.readFile();
        System.out.println(contenido);

    }
}
