
package education.learning.system;

import static education.learning.system.BookShopLoginPageController.stageUserLoginPage;
import static education.learning.system.MainMamuPageController.stageBookShopLoginPage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.stage.Stage;


public class UserLoginController implements Initializable {

     public static Stage stageUserPage1;
     public static Stage stageUserPRgistrationPage;
     public static String userPass;
    @FXML
    private TextField emailTf;
    @FXML
    private TextField passwordTf;
    @FXML
    private Label display1;
    
   

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

  
    @FXML
    private void ExitBt(ActionEvent event) {
        System.exit(0);
    }


    @FXML
    private void LoginBtn(ActionEvent event) throws IOException {
     String passWord = passwordTf.getText();
     String email = emailTf.getText();  
     int count = 0;
     userPass=passWord;

     File fileRead = new File("UserRegistrationInformation.txt");
     Scanner sc = new Scanner(fileRead);
       
        
        while(sc.hasNext()){
            
            String line = sc.nextLine();
             if(!line.equals("")){
                String[] arr = line.split("-");
                String name = arr[0];
                String emailFmFile = arr[1];
                String phoneNumber = arr[2];
                String pass= arr[3];
              
            
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
        Parent root = javafx.fxml.FXMLLoader.load(getClass().getResource("UserPage.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stageUserPage1 = stage;
        stage.show();
        stageUserLoginPage.close(); 
        
        passwordTf.clear();
        emailTf.clear();
         count=0;
        }else{
           
            display1.setText("Wrong Password. Please try again");
            passwordTf.clear();
          
            count=0;
        }
        
    }

    @FXML
    private void BackBtn(ActionEvent event) {
      stageUserLoginPage.close();
      stageBookShopLoginPage.show();
    }

    @FXML
    private void signUpBtn(ActionEvent event) throws IOException {
        Parent root = javafx.fxml.FXMLLoader.load(getClass().getResource("UserregistrationPage.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stageUserPRgistrationPage = stage;
        stage.show();
        stageUserLoginPage.close(); 
    }
    
}



