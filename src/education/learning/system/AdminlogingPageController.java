
package education.learning.system;

import static education.learning.system.BookShopLoginPageController.stageAdminlogingPage;
import static education.learning.system.ELSFontPageController.stageSMainManupage;
import static education.learning.system.EducationLearningSystem.stageFirstLoginPage;
import static education.learning.system.MainMamuPageController.stageBookShopLoginPage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class AdminlogingPageController implements Initializable {

    public static Stage stageAddBookPage;
    public static Stage stageAdminRegistrationPage;
    @FXML
    private TextField emailTF;
    @FXML
    private TextField passwordTF;
    @FXML
    private Label display1;
    
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    

    @FXML
    private void Backbt(ActionEvent event) {
        stageBookShopLoginPage.show();
        stageAdminlogingPage.close();
    }

    @FXML
    private void Exitbt(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void loginBtn(ActionEvent event) throws IOException {
 
     String passWord = passwordTF.getText();
     String email = emailTF.getText();  
     int count = 0;


     File fileRead = new File("AdminRegistrationInformation.txt");
     Scanner sc = new Scanner(fileRead);
       
        
        while(sc.hasNext()){
            
            String line = sc.nextLine();
             if(!line.equals("")){
                String[] arr = line.split("-");
                String name = arr[0];
                String emailFmFile = arr[1];
                String phoneNumber = arr[2];
                String pass= arr[3];
                String cmPass = arr[4];
            
             if(passWord.contains(pass)){
                 count++;
             }
                
             }
    
        }

       
       if(email.isEmpty()){
           display1.setText("Please inter your email");
       }else if(passWord.isEmpty()){
           display1.setText("Please inter your password");
       }else if(!email.contains("@gmail.com")){
           display1.setText("Invalide email");
           
       }else if(count >= 1){
    
        display1.setText("");
        Parent root = FXMLLoader.load(getClass().getResource("AddBook.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stageAddBookPage = stage;
        stage.show();
        stageAdminlogingPage.close(); 
        
        passwordTF.clear();
        emailTF.clear();
         count=0;
        }else{
           
            display1.setText("Wrong Password. Please try again");
            passwordTF.clear();
           
            count=0;
        }
        
        


        
    }

    @FXML
    private void signinBtn(ActionEvent event) throws IOException {
       
        Parent root = FXMLLoader.load(getClass().getResource("AdminRegistration.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stageAdminRegistrationPage = stage;
        stage.show();
        stageAdminlogingPage.close(); 
        display1.setText("");
        
    }
    
}
