/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifriend.model;

public class Contacts {
    
    private String ContactID;
    private String Name;
    private String PhoneNumber;
    private String BirthDay;
    private double Salary;
    
    public Contacts(String ContactID,String Name,String PhoneNumber,String BirthDay,double Salary){
        this.ContactID=ContactID;
        this.Name=Name;
        this.PhoneNumber=PhoneNumber;
        this.BirthDay=BirthDay;
        this.Salary=Salary;
        
    }
    public String toString(){
        return "ContactID : "+ContactID+"\nName : "+Name+"\nPhoneNumber : "+PhoneNumber+"\nBirthDay : "+BirthDay+"\nSalary : "+Salary;
    }
    
    public String getContactID(){
        return ContactID;
    }
    public String getName(){
        return Name;
    }
    public String getPhoneNumber(){
        return PhoneNumber;
    }
    public String getBirthDay(){
        return BirthDay;
    }
    public double getSalary(){
        return Salary;
    }
    
}
