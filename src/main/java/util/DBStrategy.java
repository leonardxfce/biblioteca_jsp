package util;

import java.util.List;

/**
 * This is the Strategy defined to all DataBase Connect
 *
 *
 */
public interface DBStrategy {

   Object getConextion();

    int executeStatement(String statement);

    List executeSelectStatement(String statement);

    void closeConnection();

    boolean makeTransactions(List<String> statements);

    void makeBackUp();

   Object statConnection();

}
