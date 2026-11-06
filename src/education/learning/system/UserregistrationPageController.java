
package education.learning.system;

import static education.learning.system.AdminRegistrationController.stageCongtrtulationPage4;
import static education.learning.system.AdminlogingPageController.stageAdminRegistrationPage;
import static education.learning.system.BookShopLoginPageController.stageUserLoginPage;
import static education.learning.system.UserLoginController.stageUserPRgistrationPage;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class UserregistrationPageController implements Initializable {

    @FXML
    private TextField LastnamrTf;
    @FXML
    private TextField EmailTf;
    @FXML
    private TextField MobilenumTf;
    @FXML
    private TextField PasswordTf;
    @FXML
    private Label display2;
    @FXML
    private TextField firstName;

    public static Stage stagebookShopUserCnrsPage;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void BackBt(ActionEvent event) {  
        stageUserPRgistrationPage.close();
        stageUserLoginPage.show();
    }

    @FXML
    private void ExitBt(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void SaveBtn(ActionEvent event) {
        
       String F_name = firstName.getText();
       String L_name = LastnamrTf.getText();
       String email = EmailTf.getText();
       String phnNum = MobilenumTf.getText();
       String pass = PasswordTf.getText(); 
    
   
       try{
           FileWriter file = new FileWriter("UserRegistrationInformation.txt", true);
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
           }else {
               
                pw.println(F_name+" "+L_name+"-"+email+"-"+phnNum+"-"+pass);         
                pw.close();
 
                Parent root = javafx.fxml.FXMLLoader.load(getClass().getResource("bookShopUserCnrsPage.fxml"));
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stagebookShopUserCnrsPage = stage;
                stage.show();
                stageUserPRgistrationPage.close();
                
                firstName.clear();
                LastnamrTf.clear();
                EmailTf.clear();
                MobilenumTf.clear();
                PasswordTf.clear();
                display2.setText("");
              
            } 
           
       }catch(IOException e){
           System.out.println("Error: "+e);
       }
       
        
    }
    
}
