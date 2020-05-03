import java.sql.Connection;
import java.sql.DriverManager;



public class DBS {
    public Connection getConnection(){
        Connection con=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://selene.hud.ac.uk/u2053059","u2053059","HH29jan20hh");
        }

        catch(Exception e){System.out.println(e);}
        return con;
    }


}
