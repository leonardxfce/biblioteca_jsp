package util;

import org.apache.commons.io.FileUtils;

import java.io.File;

public class ManejadorDeArchivos {

    String paquete = "/src/main/resources/";
    String directorioDeEjecucion = "user.dir";

    public String abrirArchivo(String nombreDeArchivo) {
        String directorio = System.getProperty(directorioDeEjecucion);
        File archivo = new File(directorio + paquete + nombreDeArchivo);
        String archivoEnFormaDeTexto = null;
        try {
            archivoEnFormaDeTexto = FileUtils.readFileToString(archivo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return archivoEnFormaDeTexto;
    }
}
