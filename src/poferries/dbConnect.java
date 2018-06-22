package poferries;

public class dbConnect {
    public static void connect(String[] args) throws Exception {
        MySQLAccess dao = new MySQLAccess();
        dao.readDataBase();
    }

}