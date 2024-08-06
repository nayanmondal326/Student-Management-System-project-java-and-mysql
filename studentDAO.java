
package DataAccessObject;


import com.mysql.cj.protocol.Resultset;
import connectionProvider.CP;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import entity.student;
import java.sql.Statement;
import java.sql.ResultSet;


public class studentDAO 
{

    
    public static boolean insertstudentToDB(student student)
           
    {
       boolean status =false; 
       try{
           Connection con = CP.getconnection();
           DatabaseMetaData meta = con.getMetaData();
           ResultSet set = meta.getTables(null, null, "student", null);
           
          if(set.next())
          {   //Table Exists...
              //insert...
              String insertQuery="INSERT INTO student(sName,sNumber,sCity) values(?,?,?)";
              
              PreparedStatement preparedStatemnt = con.prepareStatement(insertQuery);
              preparedStatemnt.setString(1, student.getName());
              preparedStatemnt.setString(2, student.getNumber());
              preparedStatemnt.setString(3, student.getCity());
               
              preparedStatemnt.executeUpdate();
          }
          else
          {
              // creating the table...
              String createTable = "create table student(sid int auto_increment,sName varchar(200),sNumber varchar(200),sCity varchar(100),primary key(sid))";
              Statement statement = con.createStatement();
              statement.executeUpdate(createTable);
              //now insert....
              String insertQuery="INSERT INTO student(sName,sNumber,sCity) values(?,?,?)";
              PreparedStatement preparedStatemnt = con.prepareStatement(insertQuery);
              preparedStatemnt.setString(1, student.getName());
              preparedStatemnt.setString(2, student.getNumber());
              preparedStatemnt.setString(3, student.getCity());
               
               preparedStatemnt.executeUpdate();
                 
          }
          status=true;

       }
       catch (Exception e)
       {
           e.printStackTrace();
           return status;
       }
       return status;
             
    }
    
    public static boolean updatestudent(int sid,int option, String val)
    {
        boolean status =false; 
       try
       {
           Connection con = CP.getconnection();
           if(option==1)
           {
               //update Name...
              String query = "update student set SName=? where sid =?";
              PreparedStatement preparedStatemnt = con.prepareStatement(query);
              preparedStatemnt.setString(1, val);
              preparedStatemnt.setInt(2, sid);
              
              preparedStatemnt.executeUpdate();
           }
           else if(option==2)
           {
               //update phone number.....
              String query = "update student set sNumber = ? where sid = ?";
              PreparedStatement preparedStatemnt = con.prepareStatement(query);
              preparedStatemnt.setString(1, val);
              preparedStatemnt.setInt(2, sid);
              
              preparedStatemnt.executeUpdate();
           }
           else 
           {
             //update city...  
              String query = "UPDATE student SET sCity=? where sid = ?";
              PreparedStatement preparedStatemnt = con.prepareStatement(query);
              preparedStatemnt.setString(1, val);
              preparedStatemnt.setInt(2, sid);
              
              preparedStatemnt.executeUpdate();
           }
           status = true;
      
       }
       catch(Exception e)
       {
           e.printStackTrace();
           
           return status;
       }
        return status;
    } 
    public static boolean deletestudent(int sid)
    {
        boolean status =false; 
       try
       {
           Connection con = CP.getconnection();
            
              //now DELETE...
              String query="DELETE from student where sid = ?";
              
              PreparedStatement preparedStatemnt = con.prepareStatement(query);
              preparedStatemnt.setInt(1, sid);
             
              preparedStatemnt.executeUpdate();
              
              status = true;
       }
       
     catch (Exception e)
       {
           e.printStackTrace();
           return status;
       }
       return status;
    
 
    }
    public static void displaystudent()
    {
      
       try{
           Connection con = CP.getconnection();
           String query= "SELECT * from student";
           Statement statement = con.createStatement();
          ResultSet set = statement.executeQuery(query);
          int count=0;
          while(set.next())
          {
              count++;
              System.out.println("Student ID= "+set.getInt(1));
              System.out.println("Student Name= "+set.getString(2));
              System.out.println("Student Number= "+set.getString(3));
              System.out.println("Student City= "+set.getString(4));
              System.out.println("***********************************************");
              
              
          } 
          if(count==0)
          {
            System.out.println("No Data Found !! Please Insert some data first to display");  
          }
           
       }
       catch(Exception e)
       {
           e.printStackTrace();
       }
       
    }
      
}
