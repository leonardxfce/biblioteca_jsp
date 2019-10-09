package modelo;
import util.ConectorDB;
import java.util.ArrayList;
import util.ManejadorDeArchivos;

/**
* Esta clase permite guardar una nueva carrera, modificar una carrera ya cargada, o leer todas las carreras existentes en la base de datos.
* @author IES 9-024 LAVALLE.
* @version 2.018.
*/
public class Carrera implements IModelo{
    private String NombreCarrera;
       ConectorDB conector = new ConectorDB();

    // Constructor:
    /**
     * Constructor de la clase Carrera (no se inicializan atributos).
     */
    public Carrera() {
    }

    /**
     * Este método (getNombreCarrera) devuelve la carrera actualmente almacenada en memoria.
     * @return NombreCarrera (de tipo String).
     */
    public String getNombreCarrera() {
        return NombreCarrera;
    }

    /**
     * Este método (setNombreCarrera) asigna la nueva carrera almacenándola en memoria.
     * @param NombreCarrera (de tipo String).
     */
    public void setNombreCarrera(String NombreCarrera) {
        this.NombreCarrera = NombreCarrera;
    }
    
    /**
     * Este método (insert) envía la petición para insertar una nueva carrera en la base de datos.
     */
    @Override
    public void insert(){
        String insert = this.insert2();
        conector.ejecutarSentencia(insert);
    
     /**String insert = "INSERT INTO `carrera`" +
            "(`nombreCarrera`)" +
            "VALUES" +
            "('"+this.NombreCarrera+"');";
     CONECTOR.ejecutarSentencia(insert);
     */
    }
    public String insert2(){
        ManejadorDeArchivos ma = new ManejadorDeArchivos();
        String sql = ma.abrirArchivo("plantillas/nuevacarrera.sql");
        sql = sql.replace("{NombreCarrera}", this.NombreCarrera);    
        return sql;
    }

    /**
     * Este método (update) envía la petición para modificar una carrera ya existente en la base de datos.
     */
    @Override
    public int update(String identificador) {
        String update = this.update2();
        //conector.ejecutarSentencia(update);
        return CONECTOR.ejecutarSentencia(update);
    }
   
    public String update2 (){
          ManejadorDeArchivos ma = new ManejadorDeArchivos();
        String sql = ma.abrirArchivo("plantillas/actualizar.sql");
        sql = sql.replace("{NombreCarrera}", this.NombreCarrera);  
        return sql;
    }

    /**
     * Este método (selectTodos) envía un String que contiene la consulta que permite obtener las carreras (ya cargados en la base de datos).
     * @return (se retornan todas las carreras obtenidas desde la base de datos).
     */
    @Override
    public ArrayList selectTodos() {
        String select = this.selecTodos2();
        return CONECTOR.ejecutarConsulta(select);
    }
    public String selecTodos2(){
         ManejadorDeArchivos ma = new ManejadorDeArchivos();
        String sql = ma.abrirArchivo("plantillas/seleccionartodos.sql");
        sql = sql.replace("{NombreCarrera}", this.NombreCarrera); 
        return sql;
    }

    @Override
    public int comprobarExistenciaDeRegistro(String[] data) {
        String lo = this.comprobarExistenciaDeRegistro2();
        return Integer.parseInt(((ArrayList) CONECTOR.ejecutarConsulta(lo).get(0)).get(0).toString());
    }
    public String comprobarExistenciaDeRegistro2(){
          ManejadorDeArchivos ma = new ManejadorDeArchivos();
        String sql = ma.abrirArchivo("plantillas/comprobarusuario.sql");
        sql = sql.replace("{NombreCarrera}", this.NombreCarrera); 
        return sql;
    }
    
    @Override
    public int delete(int id){
        String delete = this.delete2();
        return CONECTOR.ejecutarSentencia(delete);
    }
    public String delete2(){
             ManejadorDeArchivos ma = new ManejadorDeArchivos();
        String sql = ma.abrirArchivo("plantillas/borrar.sql");
        sql = sql.replace("{NombreCarrera}", this.NombreCarrera); 
        return sql;
    }

    public ArrayList selectUno(String id) {
        String select = this.selectUno2();
        ArrayList existencia = CONECTOR.ejecutarConsulta(select);
        System.out.println(select);
        return (ArrayList) existencia.get(0); 
    }
    public String selectUno2(){
             ManejadorDeArchivos ma = new ManejadorDeArchivos();
        String sql = ma.abrirArchivo("plantillas/seleccionaruno.sql");
        sql = sql.replace("{NombreCarrera}", this.NombreCarrera); 
        return sql;
    
    }
}
