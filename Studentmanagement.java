
package studentmanagement;

import DataAccessObject.studentDAO;
import entity.student;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.InputStreamReader;

public class Studentmanagement {

    /**
     *
     * @param args
     */
    
    public static void main(String[] args) throws IOException
    {
    //boolean f = studentDAO.insertstudentToDB(new student("nayan mondal","7679687362","kolkata"));
    //System.out.print(f);
      // boolean f = studentDAO.updatestudent(1, 3, "cooch Behar");
    //System.out.print(f);
      //boolean f = studentDAO.deletestudent(1);
      // System.out.println(f);
        
       // Scanner obj = new Scanner(System.in);
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int op=0;
        int id=0;
        String name="",city="",phone="";
        boolean status=false;
        while(true)
        {
        System.out.println("hello Welcome to Student Management app!");
        System.out.println("Enter 1 to Display all the Students");
        System.out.println("Enter 2 to Insert all the Students");
        System.out.println("Enter 3 to Update all the Students");
        System.out.println("Enter 4 to Delete all the Students");
        System.out.println("Enter 5 to Exit");

        op = Integer.parseInt(br.readLine());
        if(op==1)
        {
            studentDAO.displaystudent();
        }
        else if(op==2)
        {
            //Insert........
            System.out.println("Enter the Name of the Student");
            
            name =br.readLine();
            
            System.out.println("Enter the phone of the Student");
            
            phone = br.readLine();
            
            System.out.println("Enter the City of the Student");
            
            city = br.readLine();
            
            student st = new student(name,phone,city);
            status = studentDAO.insertstudentToDB(st);
           
            if(status)
            {
                System.out.println("success!");
            }
            else
            {
                System.out.println("something went wrong!! please try again.");
            }
        }
        else if(op==3)
        {
            //Update.........
            System.out.println("We suggest you to kindly all the Student for Student for confirming the student id, whom to be updated");
            System.out.println("Enter the student id");
            
            id=Integer.parseInt(br.readLine());
            
            System.out.println("Enter 1 to Update Name of Students");
            System.out.println("Enter 2 to Update phone_Number of Students");
            System.out.println("Enter 3 to Update City of Students"); 
            op  = Integer.parseInt(br.readLine());
           
            if(op==1)
            {   //name Update.........
                System.out.println("Enter the new Name");
               
                name= br.readLine();
                status=studentDAO.updatestudent(id, op, name);
                
                if(status)
                {
                    System.out.println("success!");
                }
                else
                {
                    System.out.println("something went wrong!! please try again.");
                }
            }
                else if(op==2)
            {       
                    //Number Update.........
                    System.out.println("Enter the new phone_Number");
                    
                    phone= br.readLine();
                    status = studentDAO.updatestudent(id, op,phone );
                    if(status)
                     {
                       System.out.println("success!");
                    }
                else
                {
                    System.out.println("something went wrong!! please try again.");
                }
            }
                else if(op==3)
                {   
                    //City Update.........
                    System.out.println("Enter the new City ");
                    
                    city= br.readLine();
                    status = studentDAO.updatestudent(id, op, city);
                    if(status)
                    {
                        System.out.println("success!");
                    }
                    else
                    {
                        System.out.println("something went wrong!! please try again.");
                    }
                }
                else
                {
                   System.out.println("please enter the right option! and try again");
                }
            
                        
        }
        else if(op==4)
        {
            //Delete....
            System.out.println("We suggest you to kindly all the Student for Student for confirming the student id, whom to be Deleted!!");
            System.out.println("Enter the student id");
            
            id=Integer.parseInt(br.readLine());    
            status = studentDAO.deletestudent(id);
            if(status)
                {
                    System.out.println("success!");
                }
                else
                {
                    System.out.println("something went wrong!! please try again.");
                }
            
        }
        else
        {
            System.out.println("Thanks for using our Application!! Hope you enjoyed!! see you.");
            break;
        }
        
                
        }
    }   
    
}
