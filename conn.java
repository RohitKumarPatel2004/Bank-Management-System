import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class conn {


    Connection c;
    Statement s;
    public conn(){


        try{

            c= DriverManager.getConnection("jdbc:mysql:///ATM","root","Rohit@2004");
            s=c.createStatement();

        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
