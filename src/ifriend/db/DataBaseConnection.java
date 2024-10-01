/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifriend.db;

import ifriend.model.Contacts;
import java.util.ArrayList;
import java.util.logging.Level;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.logging.Logger;


public class DataBaseConnection {
    private static String sql;

    private DataBaseConnection(){}
    
    public static void addData(Contacts c){
        sql="insert into Contacts values('"+c.getContactID()+"','"+c.getName()+"','"+c.getPhoneNumber()+"','"+c.getBirthDay()+"',"+c.getSalary()+");";
        System.out.println(sql);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/ifriend","root","sadew200");
            Statement stm=connection.createStatement();
            stm.executeUpdate(sql);
        } catch (Exception ex) {
            System.out.println("something wrong");
        }
    }
    public static boolean isPhoneNumberDuplicate(String PhoneNumber){
        sql="select PhoneNumber from Contacts";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/ifriend","root","sadew200");
            Statement stm=connection.createStatement();
            ResultSet result=stm.executeQuery(sql);
            while(result.next()){
                if(PhoneNumber.equals(result.getString("PhoneNumber"))){
                    System.out.println(PhoneNumber.equals(result.getString("PhoneNumber")));
                    return true;
                }
            }
            return false;
        }
        catch(Exception ex){
            System.out.println("something wrong");
            return true;
        }
    }
    
    public static Contacts SearchPhoneNumberOrContactID(String PhoneNumberOrContactID){
        sql="select* from Contacts;";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            java.sql.Connection connection=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/ifriend","root","sadew200");
            java.sql.Statement stm=connection.createStatement();
            java.sql.ResultSet result=stm.executeQuery(sql);
            while(result.next()){
                if(PhoneNumberOrContactID.equals(result.getString("PhoneNumber")) ||PhoneNumberOrContactID.equals(result.getString("ContactID")) ){
                    return new Contacts(result.getString("ContactID"),result.getString("Name"),result.getString("PhoneNumber"),result.getString("birthday"),result.getDouble("salary"));
                }
            }
            return null;
        }
        catch(Exception ex){
            System.out.println("something wrong");
            return null;
        }
    }
    
    public static void UpdateName(String Name,String ContactID){
        sql="select ContactID from Contacts;";
        try{
            System.out.println(sql);
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/ifriend","root","sadew200");
            Statement stm=connection.createStatement();
            ResultSet result=stm.executeQuery(sql);
            while(result.next()){
                System.out.println(ContactID.equals(result.getString("ContactID")));
                if(ContactID.equals(result.getString("ContactID"))){
                    sql="update Contacts set Name='"+Name+"' where ContactID='"+ContactID+"';";
                    System.out.println(sql);
                    stm.executeUpdate(sql);
                    return;
                }
            }
        }
        catch(Exception ex){
            System.out.println("something wrong");
        }
    
    }
    

    public static void UpdatePhoneNumber(String ContactID,String PhoneNumber){
        sql="select ContactID from Contacts;";
        try{
            System.out.println(sql);
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/ifriend","root","sadew200");
            Statement stm=connection.createStatement();
            ResultSet result=stm.executeQuery(sql);
            while(result.next()){
                System.out.println(ContactID.equals(result.getString("ContactID")));
                if(ContactID.equals(result.getString("ContactID"))){
                    sql="update Contacts set PhoneNumber='"+PhoneNumber+"' where ContactID='"+ContactID+"';";
                    System.out.println(sql);
                    stm.executeUpdate(sql);
                    return;
                }
            }
        }
        catch(Exception ex){
            System.out.println("something wrong");
        }
    
    }
    
    
    public static void UpdateSalary(String ContactID,String Salary){
        sql="select ContactID from Contacts;";
        try{
            System.out.println(sql);
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/ifriend","root","sadew200");
            Statement stm=connection.createStatement();
            ResultSet result=stm.executeQuery(sql);
            while(result.next()){
                System.out.println(ContactID.equals(result.getString("ContactID")));
                if(ContactID.equals(result.getString("ContactID"))){
                    sql="update Contacts set Salary='"+Salary+"' where ContactID='"+ContactID+"';";
                    System.out.println(sql);
                    stm.executeUpdate(sql);
                    return;
                }
            }
        }
        catch(Exception ex){
            System.out.println("something wrong");
        }
    
    }
    
    
    public static void UpdateBirthDay(String ContactID,String BirthDay){
        sql="select ContactID from Contacts;";
        try{
            System.out.println(sql);
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/ifriend","root","sadew200");
            Statement stm=connection.createStatement();
            ResultSet result=stm.executeQuery(sql);
            while(result.next()){
                System.out.println(ContactID.equals(result.getString("ContactID")));
                if(ContactID.equals(result.getString("ContactID"))){
                    sql="update Contacts set BirthDay='"+BirthDay+"' where ContactID='"+ContactID+"';";
                    System.out.println(sql);
                    stm.executeUpdate(sql);
                    return;
                }
            }
        }
        catch(Exception ex){
            System.out.println("something wrong");
        }
    
    }
    
    
    
    public static String sendContactID(){
        sql="select ContactID from Contacts;";
        String ContactID="C0000";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            java.sql.Connection connection=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/ifriend","root","sadew200");
            java.sql.Statement stm=connection.createStatement();
            java.sql.ResultSet result=stm.executeQuery(sql);
            while(result.next()){
                if(Integer.parseInt(ContactID.substring(1))<Integer.parseInt(result.getString("ContactID").substring(1)) ){
                    ContactID=result.getString("ContactID");
                }
                
                System.out.println(ContactID);
            }
 
           
            if(ContactID=="") return "C0000";
            return ContactID;
        }
        catch(Exception ex){
            System.out.println("something wrong");
            return "Null";
        }
        
    }
    
    public static void DeleteDetails(String ContactID){
    sql="select ContactID from Contacts;";
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        java.sql.Connection connection=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/ifriend","root","sadew200");
        java.sql.Statement stm=connection.createStatement();
        java.sql.ResultSet result=stm.executeQuery(sql);
        while(result.next()){
            if(ContactID.equals(result.getString("ContactID"))){
                sql="delete from Contacts where ContactID='"+ContactID+"';";
                stm.executeUpdate(sql);
                return;
            }
        }
    }
    catch(Exception ex){
        System.out.println("something wrong");
    }
    }
    public static ArrayList<Contacts> sendAllData(){
        ArrayList<Contacts> ar=new ArrayList<>();
        sql="select*from Contacts;";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/ifriend","root","sadew200");
            Statement stm=connection.createStatement();
            ResultSet result=stm.executeQuery(sql);
            while(result.next()){
                ar.add(new Contacts(result.getString("ContactID"),result.getString("Name"),result.getString("PhoneNumber"),result.getString("birthday"),result.getDouble("salary")));
            }
            return ar;
        }
        catch(Exception ex){
            System.out.println("something wrong");
            return null;
        }
    }
        
 
}
