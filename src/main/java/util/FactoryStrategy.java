package util;
/*
Singleton Class using Factory Pattern for Strategy Pattern
 */
public class FactoryStrategy {

    private static FactoryStrategy factoryStrategy;
    public static String MYSQL = "mysql";
    public static String SQLITE = "sqlite";


    public static FactoryStrategy getInstance(){

        if (factoryStrategy ==null){
            factoryStrategy = new FactoryStrategy();
        }
    return factoryStrategy;
    }
    public DBStrategy getDBStrategy(String option){
        DBStrategy result = null;
        if (option == MYSQL){
            result = new SQLConnection();
        }else if(option == SQLITE){
            //TODO:Make SQLITE Strategy
        }

    return result;
    }


}
