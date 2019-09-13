package util;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractDBStrategy implements DBStrategy {

    
    public enum connectionResourceLocation {
        MYSQL("jdbc:mysql://localhost/biblioteca","bibliotecario","ies9024");
        //Add Here new connections constants


        private static final Map<String, connectionResourceLocation> RESOURCE = new HashMap<>();
        private static final Map<String, connectionResourceLocation> USERNAME = new HashMap<>();
        private static final Map<String, connectionResourceLocation> PASSWORD = new HashMap<>();

        static {
            for (connectionResourceLocation e : values()) {
                RESOURCE.put(e.resource, e);
                USERNAME.put(e.username, e);
                PASSWORD.put(e.password, e);
            }
        }

        public final String resource;
        public final String username;
        public final String password;

        private connectionResourceLocation(String resource, String username, String password) {
            this.resource = resource;
            this.username = username;
            this.password = password;
        }

        public static connectionResourceLocation valueOfLabel(String label) {
            return RESOURCE.get(label);
        }

        public static connectionResourceLocation valueOfAtomicNumber(String number) {
            return USERNAME.get(number);
        }

        public static connectionResourceLocation valueOfAtomicWeight(String weight) {
            return PASSWORD.get(weight);
        }
    }
/*
 * Note: use only this class when need to use the same generic method to different strategies
 */

}
