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

public class MySQLConnection extends AbstractDBStrategy {

    private final String UNIFORM_RESOURCE_LOCATION = connectionResourceLocation.MYSQL.resource;
    private final String USER = connectionResourceLocation.MYSQL.username;
    private final String PASSWORD = connectionResourceLocation.MYSQL.password;
    private final Integer BACKUP_PERIOD = 86400000;

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
        List completeList = new ArrayList();
        ResultSet rs;
        ResultSetMetaData rsmd;
        try {
            Statement sentencia = this.connection.createStatement();
            rs = sentencia.executeQuery(statement);
            rsmd = rs.getMetaData();
            int columns = rsmd.getColumnCount();
            while (rs.next()) {
                List row = new ArrayList();
                for (int i = 1; i <= columns; i++) {
                    row.add(rs.getString(i));
                }
                completeList.add(row);
            }

            sentencia.close(); // <- Cierre de sentencia.

        } catch (SQLException e) {
            Logger.getLogger(getClass().getName()).log(Level.WARNING,"Cannot execute Select statement",e);
        }

        this.closeConnection(); // <- Cierre de conexión.

        return completeList;
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
        boolean result;
        this.getConextion();
        try {
            this.connection.setAutoCommit(false);

            Statement localStatement = this.connection.createStatement();
            for(String param :  statements){
                System.out.println(param);
                localStatement.executeUpdate(param);
            }
            connection.commit();
            result = true;

        } catch (SQLException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING,"Cannot Commit...Trying rollBack",ex);

            try {
                connection.rollback();

            } catch (SQLException e) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE,"Cannot Rollback, Call all Fucking Fireman!",e);
            }
            result = false;
        }

        this.closeConnection(); // <- Cierre de conexión.
        return result;
    }

    @Override
    public void makeBackUp() {
        Date date = new Date();
        Timer temporizador = new Timer();
        temporizador.schedule(new BackUp(), date, BACKUP_PERIOD);
    }

    @Override
    public Object statConnection() {
        try {
            connection = DriverManager.getConnection(UNIFORM_RESOURCE_LOCATION, USER, PASSWORD);
            Logger.getLogger(getClass().getName()).log(Level.INFO,"Connexion Success!");
        } catch (SQLException e) {
            Logger.getLogger(getClass().getName()).log(Level.INFO,"Connexion Failed!",e);

        }
    return connection;
    }
}
