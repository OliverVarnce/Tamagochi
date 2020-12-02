package world.ucode;

import java.sql.*;

public class DataBase {
    public static Connection Connection;
    public static Statement statmt;
    public static ResultSet resSet;

    public static void Conn() throws ClassNotFoundException, SQLException {
        Connection = null;
        Class.forName("org.sqlite.JDBC");
        Connection = DriverManager.getConnection("jdbc:sqlite:Tamagotchi.sqlite");
    }

    public static void CreateDB() throws ClassNotFoundException, SQLException {
        statmt = Connection.createStatement();
        statmt.execute("CREATE TABLE if not exists 'minions' " +
                "('type' text, 'name' text, 'health' DOUBLE , 'happiness' DOUBLE, 'hunger' DOUBLE , 'thirst' DOUBLE, 'cleanliness' DOUBLE);");
    }

    public static void DeleteDB(String name) throws SQLException {
        statmt.execute("DELETE FROM 'minions' WHERE name = '" + name + "';");
    }

    public static void WriteDB(String type, String name, double health, double happiness, double hunger, double thirst, double cleanliness) throws SQLException {
        statmt.execute("DELETE FROM 'minions' WHERE name = '" + name + "';");
        statmt.execute("INSERT INTO 'minions' ('type', 'name', 'health', 'happiness', 'hunger', 'thirst', 'cleanliness') " +
                "VALUES ('"+type+"', '"+name+"', "+health+", "+happiness+", "+hunger+", "+thirst+", "+cleanliness+"); ");
    }

    public static ResultSet ReadDBNames() throws ClassNotFoundException, SQLException {
        resSet = statmt.executeQuery("SELECT name FROM minions");
        return resSet;
    }

    public static ResultSet ReadDBMinion(String name) throws ClassNotFoundException, SQLException {
        resSet = statmt.executeQuery("SELECT * FROM minions WHERE name = '" + name + "'");
        return resSet;
    }
}