package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SQLiteConnection extends MySQLConnection {

    private Connection connect;

    @Override
    public int executeStatement(String statement) {
        int result = 0;
        try {
            getConextion();
            PreparedStatement st = connect.prepareStatement(statement);
            result = st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING,"Cannot execute Statement",ex);
        }
        closeConnection();
       return result;
    }

    @Override
    public List executeSelectStatement(String statement) {
        List result = new ArrayList();
        ResultSet resultSet = null;
        try {
            getConextion();
            PreparedStatement st = connect.prepareStatement(statement);
            resultSet = st.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columns = metaData.getColumnCount();
            while (resultSet.next()) {
                List row = new ArrayList();
                for (int i = 1; i <= columns; i++) {
                    row.add(resultSet.getString(i));
                }
                result.add(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING,"Cannot execute Statement",ex);
        }
        closeConnection();
        return result;

    }


    @Override
    public boolean makeTransactions(List<String> statements) {
        boolean result = true;
        try {
            for (int i = 0 ; i < statements.size(); i++){
                executeSelectStatement(statements.get(i));
            }
        }catch (Exception e){
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE,"Cannot execute the statement",e);
            result = false;

        }
        return result;

    }

    @Override
    public void makeBackUp() {
        throw new UnsupportedOperationException("Not supported for Sqlite, We recommend copy the db file located in resource properties.");

    }

}
