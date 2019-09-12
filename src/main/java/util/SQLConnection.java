package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SQLConnection extends AbstractDBStrategy {

    private final String UNIFORM_RESOURCE_LOCATION = "jdbc:mysql://localhost/biblioteca";
    private final String USER = "bibliotecario";
    private final String PASSWORD = "ies9024";

    private Connection connection;


    @Override
    public Object getConextion(){
        Connection result = connection;
        if (connection == null){
            connection = (Connection) statConnection();
        }
        return connection;
    }

    @Override
    public int executeStatement(String statement) {
        this.getConextion();
        int rowsAffected = 0;
        try {
            Statement statementLocal = this.connection.createStatement();
            rowsAffected = statementLocal.executeUpdate(statement);

            statementLocal.close(); // <- Cierre de sentencia.

        } catch (SQLException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,"Can't execute Statement ",ex);
        }

        this.closeConnection(); // <- Cierre de conexión.

        return rowsAffected;
    }

    @Override
    public List executeSelectStatement(String statement) {
        this.getConextion();
        System.out.println(statement);
        ArrayList Lista_completa = new ArrayList();
        ResultSet rs;
        ResultSetMetaData rsmd;
        try {
            Statement sentencia = this.connection.createStatement();
            rs = sentencia.executeQuery(statement);
            rsmd = rs.getMetaData();
            int Columnas = rsmd.getColumnCount();
            while (rs.next()) {
                ArrayList Fila = new ArrayList();
                for (int i = 1; i <= Columnas; i++) {
                    Fila.add(rs.getString(i));
                }
                Lista_completa.add(Fila);
            }

            sentencia.close(); // <- Cierre de sentencia.

        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.closeConnection(); // <- Cierre de conexión.

        return Lista_completa;
    }

    @Override
    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE,"Cannot close the connection" , ex);
        }
    }

    @Override
    public boolean makeTransactions(List<String> statements) {
        boolean respuesta;
        this.getConextion();
        try {
            this.connection.setAutoCommit(false);

            Statement sentencia = this.connection.createStatement();
            for(String param :  statements){
                System.out.println(param);
                sentencia.executeUpdate(param);
            }
            connection.commit();
            respuesta = true;

        } catch (SQLException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING,"Cannot Commit...Trying rollBack",ex);

            try {
                connection.rollback();

            } catch (SQLException e) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE,"Cannot Rollback, Call all Fucking Fireman!",e);
            }
            respuesta = false;
        }

        this.closeConnection(); // <- Cierre de conexión.
        return respuesta;
    }

    @Override
    public void makeBackUp() {
        Date date = new Date();
        Timer temporizador = new Timer();
        temporizador.schedule(new BackUp(), date, 86400000);
    }

    @Override
    public Object statConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(UNIFORM_RESOURCE_LOCATION, USER, PASSWORD);
            System.out.println("Conexión.");
        } catch (SQLException e) {
            System.out.println("Conexión: Error.");
            System.out.println("Revisar Contraseña");
        } catch (ClassNotFoundException e) {
            System.out.println("Clase del Driver no encontrada");
        }
    return connection;
    }
}
