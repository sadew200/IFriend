/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifriend.Controller;

import ifriend.AddContact;
import ifriend.DeleteContacts;
import ifriend.HomePage;
import ifriend.SearchContacts;
import ifriend.UpdateBirthDay;
import ifriend.UpdateContacts;
import ifriend.UpdateName;
import ifriend.UpdatePhoneNumber;
import ifriend.UpdateSalary;
import ifriend.ViewContacts;
import ifriend.db.DataBaseConnection;
import ifriend.model.Contacts;
import java.util.ArrayList;
import java.util.Objects;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */
public class Version1 implements Controller{
    private static Version1 version1;
    private HomePage homePage;
    SearchContacts searchContacts;
    UpdateContacts updateContacts;
    DeleteContacts deleteContacts;
    ViewContacts viewContacts;
    private String ContactID;
    private Version1(){}
    public static Version1 getVersion1(){
        if(version1==null){
            version1=new Version1();
        }
        return version1;
    }
    public String getContactID(){
        ContactID=DataBaseConnection.sendContactID();
        System.out.println(ContactID);
        int v=Integer.parseInt(ContactID.substring(1))+1;
        System.out.println(v);
        String ShowContactID= v>=1000 ? "C"+v : v>=100 ? "C0"+v : v>=10 ? "C00"+v : v<10 ? "C000"+v : "C0000";
        return ShowContactID;
    }
    
    public void openAddContact(HomePage homePage){
        this.homePage=homePage;
        this.homePage.setVisible(false);
        AddContact addContact=new AddContact();
        addContact.setVisible(true);
    }
    public void openSearchContacts(HomePage homePage){
        this.homePage=homePage;
        this.homePage.setVisible(false);
        searchContacts=new SearchContacts();
        searchContacts.setVisible(true);
    }
    
    public void openUpdateContacts(HomePage homePage){
        this.homePage=homePage;
        this.homePage.setVisible(false);
        updateContacts=new UpdateContacts();
    }
    
    private boolean isValidPhoneNumber(String PhoneNumber){
        if(PhoneNumber.length() != 10 || PhoneNumber.charAt(0)!='0'){
            JOptionPane.showMessageDialog(null, "Invalid Phone Number", "Error",JOptionPane.ERROR_MESSAGE);
            return true;
        }
        else if(DataBaseConnection.isPhoneNumberDuplicate(PhoneNumber)){
            JOptionPane.showMessageDialog(null, "This Phone Number Already Has Used", "Error",JOptionPane.ERROR_MESSAGE);
            return true;
        }
        return false;
        
    }
    private boolean isValidBirthDay(String BirthDay){
        if(BirthDay.length()==10 && (Integer.parseInt(BirthDay.substring(8,10))<30 && Integer.parseInt(BirthDay.substring(5,7))<12 && Integer.parseInt(BirthDay.substring(0,4))<2024 )){
            return false;   
        }
        JOptionPane.showMessageDialog(null, "Invalid BirthDay", "Error",JOptionPane.ERROR_MESSAGE);
        return true;
    }

    public void addData(String ContactID,String Name,String PhoneNumber,String BirthDay, String Salary){
        System.out.println("hi");
        if(isValidPhoneNumber(PhoneNumber)) return;
        else if(isValidBirthDay(BirthDay)) return;
        else if(Double.parseDouble(Salary)<=0) return;
        int v=Integer.parseInt(ContactID.substring(1))+1;
        this.ContactID= v>=1000 ? "C"+v : v>=100 ? "C0"+v : v>=10 ? "C00"+v : v<10 ? "C000"+v : "C000";
        DataBaseConnection.addData(new Contacts(ContactID,Name,PhoneNumber,BirthDay,Double.parseDouble(Salary)));
     
        
    }    
    public void backToHomePage(JFrame obj){
        homePage.setVisible(true);
        obj.dispose();
    }
    
    public void Search(String PhoneNumberOrContactID,int No){
        Contacts contact=DataBaseConnection.SearchPhoneNumberOrContactID(PhoneNumberOrContactID);
        if(contact!=null){
            if(No==1){
                searchContacts.getDetails(contact);
                return;
            }
            else if(No==2){
                updateContacts.getDetails(contact);
                return;
            }
            else if(No==3){
                deleteContacts.getDetails(contact);
                return;
            }

        }
        JOptionPane.showMessageDialog(null, "Invalid Phone Number or Contact ID", "Error",JOptionPane.ERROR_MESSAGE);
        
    }

    public void UpdateName(String ContactID,String Name){
        UpdateName updateName=new UpdateName(ContactID,Name);
    }
    public void UpdatePhoneNumber(String ContactID,String PhoneNumber){
        UpdatePhoneNumber updatePhoneNumber=new UpdatePhoneNumber(ContactID,PhoneNumber);
    }
    public void UpdateP(String ContactID,String PhoneNumber){
        if(isValidPhoneNumber(PhoneNumber)) return;
        DataBaseConnection.UpdatePhoneNumber(ContactID, PhoneNumber);
    }
    public void CreateHomePage(){
        homePage=new HomePage();
    }
    public void UpdateSalary(String ContactID,double Salary){
        UpdateSalary updateSalary=new UpdateSalary(ContactID,Salary);
    }
 
    public void UpdateS(String ContactID,double Salary){
        if(Salary<=0){
            JOptionPane.showMessageDialog(null, "Invalid Salary", "Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        DataBaseConnection.UpdateSalary(ContactID,Salary+"");
    }
    
    public void UpdateBirthDay(String ContactID,String BirthDay){
        UpdateBirthDay updateBirthDay=new UpdateBirthDay(ContactID,BirthDay);
    }
    public void UpdateB(String ContactID,String BirthDay){
        if(isValidBirthDay(BirthDay))return;
        DataBaseConnection.UpdateBirthDay(ContactID, BirthDay);
    }
    
    public void openDeleteContact(){
        this.homePage.setVisible(false);
        deleteContacts= new DeleteContacts();
    }
    
    public void DeleteContact(String ContactID){
        DataBaseConnection.DeleteDetails(ContactID);
    }
    public ArrayList<Contacts> getAllData(){
        return DataBaseConnection.sendAllData();
    }
    public void openViewContacts(){
        this.homePage.setVisible(false);
         viewContacts=new ViewContacts();
    }
}
