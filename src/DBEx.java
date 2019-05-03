import java.sql.*;
import java.util.Scanner;

/*import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
*/
public class DBEx {

    public static final String DEFAULT_DRIVER_CLASS = "com.mysql.jdbc.Driver";
    public static String hostname = "localhost";
    public static String dbName = "LaTriviataRP";
    public static int port = 3306;
    public static final String DEFAULT_URL = "jdbc:mysql://"+ hostname +"/"+dbName;
    private static final String DEFAULT_USERNAME = "david";
    private static final String DEFAULT_PASSWORD = "persson";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String choice;
        Connection connection = null;
        while (true){


            try {
                Class.forName(DEFAULT_DRIVER_CLASS);
                connection = DriverManager.getConnection(DEFAULT_URL, DEFAULT_USERNAME, DEFAULT_PASSWORD);

                // SQL queries goes here
                PreparedStatement ps = null;
                ResultSet js = null;
                ResultSet rs = null;
                ResultSet ls = null;
                int id = 1;
                ps = connection.prepareStatement("SELECT text FROM story WHERE id = " + id);
                rs = ps.executeQuery();
                ps = connection.prepareStatement("SELECT text FROM storylinks WHERE storyid = " + id);
                js = ps.executeQuery();



                while (rs.next()) {
                    String text1 = rs.getString("text");
                    System.out.println(text1);
                    while (js.next()) {
                        String text2 = js.getString("text");
                        System.out.println(text2);
                    }

                }
                choice = sc.nextLine();
                ps = connection.prepareStatement("SELECT target FROM storylinks WHERE text " +
                        "= '" + choice + "'AND storyid = '" + id +"' ");
                ls = ps.executeQuery();
                while (ls.next()) {
                    int target = js.getInt("target");
                    System.out.println(target);
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            } catch (Exception e) {

            }
        }
    }
}