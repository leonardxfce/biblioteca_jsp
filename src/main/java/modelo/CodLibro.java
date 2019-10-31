package modelo;

import util.ManejadorDeArchivos;

import java.util.ArrayList;

/**
 * Esta clase permite guardar un nuevo estado, modificar un estado ya cargado, o
 * leer todos los estados existentes en la base de datos. Los estados por
 * defecto puede ser uno de los siguientes: extraviado, en préstamo, devuelto y
 * vencido.
 *
 * @author IES 9-024 LAVALLE.
 * @version 2.018.
 */
public class CodLibro implements IModelo {

    private String codlibro;
    private int idlibro;

    public CodLibro() {

    }

    public String getCodlibro() {
        return codlibro;
    }

    public void setCodlibro(String codlibro) {
        this.codlibro = codlibro;
    }

    public int getIdlibro() {
        return idlibro;
    }

    public void setIdlibro(int idlibro) {
        this.idlibro = idlibro;
    }

    public String prepararInsert(){
        ManejadorDeArchivos ma = new  ManejadorDeArchivos();
        String sql = ma.abrirArchivo("plantillas/nuevo_codlibro.sql");
        sql = sql.replace("{COD_LIBRO}", this.codlibro);
        return sql;
    }

    @Override
    public void insert() {
        String insert = this.prepararInsert();
        CONECTOR.ejecutarSentencia(insert);
    }

    /**
     * @deprecated No tiene utlilidad actualmente en el sistema
     */
    @Override
    public int update(String identificador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList selectTodos() {
        String select = "SELECT\n" +
                        "codLibro.codLibro,\n" +
                        "libro.Titulo,\n" +
                        "tema.NombreTema,\n" +
                        "(select group_concat(autor.Nombre, ' ', autor.Apellido)\n" +
                        "from libro_has_autor\n" +
                        "INNER JOIN autor\n" +
                        "ON libro_has_autor.autor_idAutor = autor.idAutor\n" +
                        "WHERE libro_has_autor.libro_idlibro = codlibro.idlibro) as autor, \n" +
                        "codlibro.idlibro\n" +
                        "FROM codLibro\n" +
                        "INNER JOIN libro\n" +
                        "ON codLibro.idlibro = libro.idlibro\n" +
                        "JOIN tema\n" +
                        "ON libro.Tema_idTema = tema.idTema\n" +
                        "WHERE libro.Prestable = 1 \n" +
                        "Order By Titulo ASC;";
        return CONECTOR.ejecutarConsulta(select);
    }

    /**
     * @deprecated No tiene utlilidad actualmente en el sistema
     */
    @Override
    public int comprobarExistenciaDeRegistro(String[] data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Recibe un codigo libro tomado desde el formulario para compararlo con la
     * base de datos y verificar si existe.
     *
     * @param codigo recibe el nuevo codigo
     * @return Verdadero si el codigo existe en la base de datos Falso si el
     * codigo es nuevo
     */
    
    public String prepararComprobarCodigo(String codigo){
        ManejadorDeArchivos ma = new ManejadorDeArchivos();
        String sql = ma.abrirArchivo("plantillas/comprobarCodlibro.sql");
        sql = sql.replace("{CODLIBRO}", codigo);
        return sql;
    }
    
    public boolean comprobarCodigo(String codigo) {
        String consulta = prepararComprobarCodigo(codigo);
        ArrayList existencia = CONECTOR.ejecutarConsulta(consulta);
        if (existencia.isEmpty()) {
            return false;
        } else {
            return ((ArrayList) existencia.get(0)).get(0).toString().equals(codigo);
        }
    }

    public int totaLibros() {
        String select = "SELECT count(codLibro) FROM codLibro\n" +
        "INNER JOIN libro \n" +
        "ON codlibro.idlibro = libro.idlibro\n" +
        "WHERE libro.Prestable = 1;";
        ArrayList existencia = CONECTOR.ejecutarConsulta(select);
        if (existencia.isEmpty()) {
            System.out.println("Vacio");
            return 0;
        } else {
            System.out.println("No vacio");
            return Integer.parseInt(((ArrayList) existencia.get(0)).get(0).toString());
        }
    }

    @Override
    public int delete(int id) {
        return 0;
    }
    

    public String prepararBorrarCodigo(String codlib){
        ManejadorDeArchivos ma = new  ManejadorDeArchivos();
        String sql = ma.abrirArchivo("plantillas/borrarCodlibro.sql");
        sql = sql.replace("{CODLIBRO}", codlib);
        return sql;
    }

    public void borrarCodigo(String codlib){
        String borrarCodigo = this.prepararBorrarCodigo(codlib);
        CONECTOR.ejecutarSentencia(borrarCodigo);
    }
    
    public boolean comprobarExistencia(String id) {
        String lo = "SELECT `codLibro`, `idlibro` FROM `codlibro` WHERE `idlibro` = "+id+";";
        ArrayList existencia = CONECTOR.ejecutarConsulta(lo);
        if (existencia.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
    
    public String prepararSelectUno(String id){
        ManejadorDeArchivos ma = new ManejadorDeArchivos();
        String sql = ma.abrirArchivo("plantillas/selectUnoCodlibro.sql");
        sql = sql.replace("{ID_CODLIBRO}", id);
        return sql;
    }

    public ArrayList selectUno(String id){
        String consulta = prepararSelectUno(id);
        return CONECTOR.ejecutarConsulta(consulta);
    }
}
