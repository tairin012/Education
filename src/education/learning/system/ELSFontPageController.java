
package education.learning.system;

import static education.learning.system.EducationLearningSystem.stageFirstLoginPage;
import java.awt.Desktop;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class ELSFontPageController implements Initializable {
    
    public static Stage stageSinginpage;
    public static Stage stageSMainManupage;
    public static Stage stageABCGamePage;

    @FXML
    private TextField emailTF;
    @FXML
    private PasswordField passwordTF;
    @FXML
    private Label display1;

   

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void loginBtn(ActionEvent event) throws IOException {
        
       String passWord = passwordTF.getText();
       String email = emailTF.getText();  
       int count = 0;
        
       String stringConvertCount ;
       
        File fileRead = new File("AllInformation.txt");
        Scanner sc = new Scanner(fileRead);
       
        
        while(sc.hasNext()){
    
            String line = sc.nextLine();
             if(!line.equals("")){
                String[] arr = line.split(" ");
                String name = arr[0];
                String phoneNumber = arr[1];
                String address = arr[2];
                String emailFmFile = arr[3];
                String pass= arr[4];
                String cmPass = arr[5];
            
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
        Parent root = FXMLLoader.load(getClass().getResource("MainMamuPage.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stageSMainManupage = stage;
        stage.show();
        stageFirstLoginPage.close();

        
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
    private void singinBtn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SingInPage.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stageSinginpage = stage;
        stage.show();
        stageFirstLoginPage.close();
        passwordTF.clear();
        emailTF.clear();
        display1.setText("");
    }


    
    
}
