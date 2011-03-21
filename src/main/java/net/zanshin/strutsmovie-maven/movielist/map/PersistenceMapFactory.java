package movielist.map;

import java.util.ResourceBundle;

public class PersistenceMapFactory {

    /**
     * 
     * @uml.property name="instance"
     * @uml.associationEnd multiplicity="(0 1)"
     */
    private static PersistenceMapFactory instance = null;

    /**
     * 
     * @uml.property name="instance"
     */
    public static synchronized PersistenceMapFactory getInstance() {
        if (instance == null) {
            instance = new PersistenceMapFactory();
        }

        return instance;
    }


	private PersistenceMapFactory() {
	}

    /**
     * 
     * @uml.property name="map"
     */
    public synchronized PersistenceMap getMap() throws MapException {
        try {
            ResourceBundle rb = ResourceBundle.getBundle("persistence");
            String s = rb.getString("persistence.map.implementation.class");

            Class clazz = Class.forName(s);
            PersistenceMap map=(PersistenceMap) clazz.newInstance();
            return map;
        } catch (Exception e) {
            throw new MapException("Map Cannot Be Created");
        }
    }

}