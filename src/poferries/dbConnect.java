package poferries;

import apackage.MySQLAccess;

public class dbConnect {
    public static void main(String[] args) throws Exception {
        MySQLAccess dao = new MySQLAccess();
        dao.readDataBase();
    }

}