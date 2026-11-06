
package education.learning.system;

import static education.learning.system.ELSFontPageController.stageSinginpage;
import static education.learning.system.EducationLearningSystem.stageFirstLoginPage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
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


public class SingInPageController implements Initializable {
    
    public static Stage stageCongtrtulationPage;
    
    @FXML
    private TextField nameTf;
    @FXML
    private TextField phonNumberTf;
    @FXML
    private TextField AddressTf;
    @FXML
    private TextField EmailTf;
    @FXML
    private TextField PasswordTF;
    @FXML
    private TextField confirmPassTf;
    @FXML
    private Label display2;

 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    

    @FXML
    private void saveBtn(ActionEvent event) {
       String name = nameTf.getText();
       String phnNum = phonNumberTf.getText();
       String adrs = AddressTf.getText();
       String email = EmailTf.getText();
       String pass = PasswordTF.getText(); 
       String cnfrmPass = confirmPassTf.getText(); 
     
       int count = 0;      
       String stringConvertCount ;
   
       try{
           FileWriter file = new FileWriter("AllInformation.txt", true);
           PrintWriter pw  = new PrintWriter(file);
            
       
            File fileRead = new File("AllInformation.txt");
            Scanner sc = new Scanner(fileRead);
       
        
        while(sc.hasNext()){
     
            String line = sc.nextLine();
             if(!line.equals("")){
                String[] arr = line.split(" ");
                String nameAll = arr[0];
                String phoneNumber = arr[1];
                String address = arr[2];
                String emailFmFile = arr[3];
                String passAll= arr[4];
                String AllcmPass = arr[5];
            
             if(pass.contains(passAll)){
                 count++;
             }
                
             }
    
        }
        

       
           if(name.isEmpty()){
               display2.setText("Please enter your name");
           }else if(phnNum.isEmpty()){
                display2.setText("Please enter your phone number");
           }else if(adrs.isEmpty()){
                display2.setText("Please enter your address");
           }else if(email.isEmpty()){
                display2.setText("Please enter your email");
           }else if(pass.isEmpty()){
                display2.setText("Please enter your new password");
           }else if(cnfrmPass.isEmpty()){
                display2.setText("Please enter your comfirm password");              
           }else if(!cnfrmPass.contains(pass)){
                  display2.setText("Your new password and confirm password are not matched"); 
                  confirmPassTf.clear();  
           
           }else {
               
                pw.println(name+" "+phnNum+" "+adrs+" "+email+" "+pass+" "+cnfrmPass);         
                pw.close();
   
                Parent root = FXMLLoader.load(getClass().getResource("CongratulationPage.fxml"));
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stageCongtrtulationPage = stage;
                stage.show();
                stageSinginpage.close();
                
                nameTf.clear();
                phonNumberTf.clear();
                AddressTf.clear();
                EmailTf.clear();
                PasswordTF.clear();
                confirmPassTf.clear();
                count=0;  
            } 
           
       }catch(IOException e){
           System.out.println("Error: "+e);
       }
       
  
        
    }

    @FXML
    private void backBtn(ActionEvent event) {
        stageFirstLoginPage.show();
         stageSinginpage.close();
    }

    @FXML
    private void closeBtn(ActionEvent event) {
        System.exit(0);
    }
    
}
