/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ifriend.Controller;

import ifriend.HomePage;
import ifriend.SearchContacts;
import ifriend.UpdateContacts;
import ifriend.model.Contacts;
import java.util.ArrayList;
import javax.swing.JFrame;


public interface Controller {
    public void openAddContact(HomePage homePage);
    public void addData(String ContactID,String Name,String PhoneNumber,String BirthDay, String Salary);
    public String getContactID();
    public void backToHomePage(JFrame obj);
    public void openSearchContacts(HomePage homePage);
    public void openUpdateContacts(HomePage homePage);
    public void openDeleteContact();
    public void openViewContacts();
    public void Search(String PhoneNumberOrContactID,int No);
    public void UpdateName(String ContactID,String Name);
    public void UpdatePhoneNumber(String ContactID,String PhoneNumber);
    public void UpdateP(String ContactID,String PhoneNumber);
    public void CreateHomePage();
    public void UpdateSalary(String ContactID,double Salary);
    public void UpdateS(String ContactID,double Salary);
    public void UpdateBirthDay(String ContactID,String BirthDay);
    public void UpdateB(String ContactID,String BirthDay);
    public void DeleteContact(String ContactID);
    public ArrayList<Contacts> getAllData();
}
