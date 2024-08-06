
package connectionProvider;



import java.sql.DriverManager;
import java.sql.Connection;



public class CP 
{
    private static Connection con;
   
    public static Connection getconnection()  
    {
        try
        {
            //load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
           
           
            String username = "root";
            String pwd = "Nayan@2002";
            String url = "jdbc:mysql://localhost:3306/studentManagement";
            con = DriverManager.getConnection(url, username, pwd);
        
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return con;
    }
}
