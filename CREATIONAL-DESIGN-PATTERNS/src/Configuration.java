public class Configuration {

    private static Configuration instance;

    private Configuration() {
        // Private constructor to prevent instantiation
    }

    public static Configuration getInstance() {
        if (instance == null) {
            instance = new Configuration();
        }
        return instance;
    }

}
