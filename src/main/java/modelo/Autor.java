package modelo;

import util.ManejadorDeArchivos;

import java.util.ArrayList;

/**
 * Esta clase se encarga del manejo de datos de la tabla autor.<br>
 *
 * @author IES 9-024 LAVALLE.
 * @version 2.018.
 */
public class Autor implements IModelo {

    private String Nombre;
    private String Apellido;

    /**
     * No recibe argumentos/parametros ni inicializa atributos.
     */
    public Autor() {
    }

    /**
     * Devuelve el apellido del autor almacenado actualmente en memoria.
     *
     * @return String Apellido: Contiene el apellido almacenado.
     */
    public String getApellido() {
        return Apellido;
    }

    /**
     * Asigna el apellido del nuevo autor almacenándolo en memoria.
     *
     * @param Apellido String: Contiene el apellido a almacenar.
     */
    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    /**
     * Devuelve el nombre del autor actualmente almacenado en memoria.
     *
     * @return String Nombre: Contiene el nombre almacenado.
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * Asigna el nombre del nuevo autor almacenándolo en memoria.
     *
     * @param Nombre String: Contiene el nombre a almacenar.
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * Envia un String que contiene una consulta INSERT para agregar un nuevo autor.
     */
    @Override
    public void insert() {
        String insert = "INSERT INTO `biblioteca`.`autor`"
                + " (`Nombre`,`Apellido`) "
                + "VALUES"
                + " ('" + this.Nombre + "','" + this.Apellido + "');";
        CONECTOR.ejecutarSentencia(insert);
    }

    public String prepararInsert() {
        ManejadorDeArchivos ma = new ManejadorDeArchivos();
        String sql = ma.abrirArchivo("plantillas/nuevoAutor.sql");
        sql = sql.replace("{Nombre}", this.Nombre);
        sql = sql.replace("{Apellido}", this.Apellido);
        return sql;
    }

    /**
     * Envia un String que contiene una consulta SELECT para leer todos los autores.
     *
     * @return ArrayList: Identificador numérico, nombre y apellido de todos los autores de la tabla autor.
     */
    @Override
    public ArrayList selectTodos() {
        String select = "SELECT "
                + "idAutor,"
                + "concat(Nombre,' ',Apellido) as `Autor` "
                + "FROM `autor` "
                + "ORDER BY `Autor` ASC;";
        return CONECTOR.ejecutarConsulta(select);
    }

    public String prepararSelectTodos() {
        ManejadorDeArchivos ma = new ManejadorDeArchivos();
        String sql = ma.abrirArchivo("plantillas/selectTodos_autor.sql");
        return sql;
    }

    /**
     * Envia un String que contiene una consulta UPDATE para actualizar un autor especifico.
     *
     * @param identificador String: Identificador numérico del autor a modificar.
     * @return int: Cantidad de tuplas afectadas. 0 = Error.
     */
    @Override
    public int update(String identificador) {
        String update = "UPDATE `autor` SET `nombre` = '" + this.Nombre + "', `apellido` = '" + this.Apellido + "' WHERE `idautor` = " + identificador + ";";
        System.out.println(update);
        return CONECTOR.ejecutarSentencia(update);
    }

    public String prepararUpdate(String identificador) {
        ManejadorDeArchivos ma = new ManejadorDeArchivos();
        String sql = ma.abrirArchivo("plantillas/modificarAutor.sql");
        sql = sql.replace("{Nombre}", this.Nombre);
        sql = sql.replace("{Apellido}", this.Apellido);
        sql = sql.replace("{idAutor}", identificador);
        return sql;
    }

    /**
     * Envia un String que contiene una consulta SELECT que comprueba cuantos autores tienen el mismo nombre y apellido.
     *
     * @param data String[]: Nombre y apellido del autor
     * @return int: Cantidad (de 0 a 1) de autores con el mismo nombre y apellido:
     * <ul>
     * <li>0 si no existe un autor con esos datos.</li>
     * <li>1 si ya existe.</li>
     * </ul>
     */
    @Override
    public int comprobarExistenciaDeRegistro(String[] data) {
        String lo = "SELECT count(*) as Autor "
                + "FROM biblioteca.autor WHERE "
                + "autor.Nombre = \"" + data[1] + "\" && "
                + "autor.Apellido = \"" + data[2] + "\";";
        return Integer.parseInt(((ArrayList) CONECTOR.ejecutarConsulta(lo).get(0)).get(0).toString());
    }

    public String prepararComprobarExistenciaDeRegistro(String[] data) {
        ManejadorDeArchivos ma = new ManejadorDeArchivos();
        String sql = ma.abrirArchivo("plantillas/comprobarSiExisteAutor.sql");
        sql = sql.replace("{Nombre}", data[1]);
        sql = sql.replace("{Apellido}", data[2]);
        return sql;
    }

    /**
     * Envia un String que contiene una consulta DELETE para eliminar un autor especifico.
     *
     * @param id int: Identificador numérico del autor a eliminar.
     * @return
     */
    @Override
    public int delete(int id) {
        String delete = "DELETE FROM `autor` WHERE `idAutor` = " + id + ";";
        System.out.println(delete);
        return CONECTOR.ejecutarSentencia(delete);
    }

    public String prepararDelete(int id) {
        ManejadorDeArchivos ma = new ManejadorDeArchivos();
        String sql = ma.abrirArchivo("plantillas/borrarAutor.sql");
        sql = sql.replace("{idAutor}", Integer.toString(id));
        return sql;
    }

    /**
     * Envia un String que contiene una consulta SELECT para buscar un autor especifico.
     *
     * @param id String: Identificador numérico del autor buscado.
     * @return ArrayList existecia: Contiene nombre y apellido del autor buscado.
     */
    public ArrayList selectUno(String id) {
        String select = "SELECT Nombre, Apellido FROM `autor` WHERE idAutor = " + id + ";";
        ArrayList existencia = CONECTOR.ejecutarConsulta(select);
        return (ArrayList) existencia.get(0);
    }

    public String prepararSelectUno(String id) {
        ManejadorDeArchivos ma = new ManejadorDeArchivos();
        String sql = ma.abrirArchivo("plantillas/buscarAutorPorID.sql");
        sql = sql.replace("{idAutor}", id);
        return sql;
    }
}
