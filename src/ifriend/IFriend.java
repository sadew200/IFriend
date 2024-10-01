/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ifriend;
import ifriend.Controller.Controller;
import ifriend.Controller.Version1;


/**
 *
 * @author Dell
 */
public class IFriend {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Controller controller=Version1.getVersion1();
        controller.CreateHomePage();
      
        // TODO code application logic here
    }
    
}
