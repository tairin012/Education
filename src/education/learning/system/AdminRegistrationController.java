
package education.learning.system;

import static education.learning.system.AdminlogingPageController.stageAdminRegistrationPage;
import static education.learning.system.BookShopLoginPageController.stageAdminlogingPage;
import static education.learning.system.ELSFontPageController.stageSinginpage;
import static education.learning.system.SchoolPageController.currentTime;
import static education.learning.system.SingInPageController.stageCongtrtulationPage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class AdminRegistrationController implements Initializable {

    public static Stage stageCongtrtulationPage4;
    
    @FXML
    private TextField FirstNametf;
    @FXML
    private TextField LastNametf;
    @FXML
    private TextField Emailtf;
    @FXML
    private TextField MobileNumtf;
    @FXML
    private TextField Passwordtf;
    @FXML
    private TextField cnfmTf;
    @FXML
    private Label display2;
  
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    

    @FXML
    private void SaveBt(ActionEvent event) {
        
       String F_name = FirstNametf.getText();
       String L_name = LastNametf.getText();
       String email = Emailtf.getText();
       String phnNum = MobileNumtf.getText();
       String pass = Passwordtf.getText(); 
       String cnfrmPass = cnfmTf.getText(); 
     
   
       try{
           FileWriter file = new FileWriter("AdminRegistrationInformation.txt", true);
           PrintWriter pw  = new PrintWriter(file);

       
           if(F_name.isEmpty()){
               display2.setText("Please enter your first name");
           }else if(L_name.isEmpty()){
               display2.setText("Please enter your last name");
           }else if(email.isEmpty()){
                display2.setText("Please enter your email");
           }else if(phnNum.isEmpty()){
                display2.setText("Please enter your mobile number");
           }else if(pass.isEmpty()){
                display2.setText("Please enter your new password");
           }else if(cnfrmPass.isEmpty()){
                display2.setText("Please enter your comfirm password");              
           }else if(!cnfrmPass.contains(pass)){
                  display2.setText("Your new password and confirm password are not matched"); 
                  cnfmTf.clear();  
           
           }else {
               
                pw.println(F_name+" "+L_name+"-"+email+"-"+phnNum+"-"+pass+"-"+cnfrmPass);         
                pw.close();
 
                Parent root = javafx.fxml.FXMLLoader.load(getClass().getResource("congratulationPage4.fxml"));
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stageCongtrtulationPage4 = stage;
                stage.show();
                stageAdminRegistrationPage.close();
                
                FirstNametf.clear();
                MobileNumtf.clear();
                LastNametf.clear();
                Emailtf.clear();
                Passwordtf.clear();
                cnfmTf.clear();
              
            } 
           
       }catch(IOException e){
           System.out.println("Error: "+e);
       }
       
    
    }

    @FXML
    private void BackBt(ActionEvent event) {
        stageAdminRegistrationPage.close();
        stageAdminlogingPage.show();
    }

    @FXML
    private void ExitBt(ActionEvent event) {
        System.exit(0);
    }

 
    
}
