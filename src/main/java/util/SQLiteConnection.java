package util;

import java.util.List;

public class SQLiteConnection extends AbstractDBStrategy {


    @Override
    public Object getConextion() {
        return null;
    }

    @Override
    public int executeStatement(String statement) {
        return 0;
    }

    @Override
    public List executeSelectStatement(String statement) {
        return null;
    }

    @Override
    public void closeConnection() {

    }

    @Override
    public boolean makeTransactions(List<String> statements) {
        return false;
    }

    @Override
    public void makeBackUp() {

    }

    @Override
    public Object statConnection() {
        return null;
    }
}
