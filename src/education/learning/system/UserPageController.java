
package education.learning.system;

import static education.learning.system.BookShopLoginPageController.stageUserLoginPage;
import static education.learning.system.BookShopLoginPageController.stageUserPage;
import static education.learning.system.ELSFontPageController.stageSMainManupage;
import static education.learning.system.MainMamuPageController.stageBookShopLoginPage;
import static education.learning.system.UserLoginController.stageUserPage1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;


public class UserPageController implements Initializable {

    @FXML
    private TextField BookTf;
    @FXML
    private TextField QuantityTf;
    @FXML
    private TextField BillnumTf;
    @FXML
    private TextField PriceTf;
    @FXML
    private TextField AuthornameTf;
    @FXML
    private TextField BooksearchTf;
    @FXML
    private Label UsseridTf;
    @FXML
    private TextField locationTf;
    @FXML
    private TextField MobileNumber;
    @FXML
    private VBox mainDisplay;
    @FXML
    private Label labelDisplay;

    
    public static String BookName;
    public static String quantityName;
    public static String billNumber;
    public static String price;
    public static String athorName;
    public static String location;
    public static String mobileNumber;
    public static String dateNum;
    
    public static String book_search;
    

    @FXML
    private TextField dateTf;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        String getPass = UserLoginController.userPass;
        
        try {
            Parent root = javafx.fxml.FXMLLoader.load(getClass().getResource("booksTable.fxml"));
            mainDisplay.getChildren().setAll(root);
        } catch (IOException ex) {
           
        }
        
        
        
        try{
             ArrayList<userClass> usrCls = new ArrayList<>();
             FileReader file = new FileReader("UserRegistrationInformation.txt");
             BufferedReader reader = new BufferedReader(file);
             
             while(true){
                 String line = reader.readLine();
                 if(line==null) break;
                 
                 if(line.length() !=0){
                     String[] partsOfLine = line.split("-");
                     String nm = partsOfLine[0];
                     String eml = partsOfLine[1];
                     String phn = partsOfLine[2];
                     String passw = partsOfLine[3];               
                     usrCls.add(new userClass(nm,eml,phn,passw));
                 }
             }
             
             for(userClass uc : usrCls){
                 if(uc == null) break;
                 
                 if(getPass.contains(uc.passwrd)){
                   UsseridTf.setText(uc.name);
                    
                 }
             }
             
        }catch(Exception e){
            System.out.println("Error: "+e); 
        }
        
        
    }    

    @FXML
    private void SearchBt(ActionEvent event) throws IOException {
        
       String book = BooksearchTf.getText();
       book_search=book;
       
       if(book.isEmpty()){
            labelDisplay.setText("Please enter book name to search");
       }else{
            BooksearchTf.clear();
            Parent root = javafx.fxml.FXMLLoader.load(getClass().getResource("searchTestField.fxml"));
            mainDisplay.getChildren().setAll(root);
            labelDisplay.setText("");
       }
    

    }

    @FXML
    private void AddbillBt(ActionEvent event) throws IOException {
         String bn = BookTf.getText();
         String qn = QuantityTf.getText();
         String bln = BillnumTf.getText();
         String p = PriceTf.getText();
         String an = AuthornameTf.getText();
         String lc = locationTf.getText();
         String mn = MobileNumber.getText();
         String dt = dateTf.getText();
         
         BookName= bn;
         quantityName= qn;
         billNumber= bln;
         price = p;
         athorName= an;
         location= lc;
         mobileNumber = mn;
         dateNum= dt;
      
         
         
       if(bn.isEmpty()){
           labelDisplay.setText("Please inter your book name");
       }else if(qn.isEmpty()){
           labelDisplay.setText("Please inter quantity");
       }else if(bln.isEmpty()){
           labelDisplay.setText("Please inter bill number");
       }else if(p.isEmpty()){
           labelDisplay.setText("Please inter price");
       }else if(an.isEmpty()){
           labelDisplay.setText("Please inter author name");
       }else if(lc.isEmpty()){
           labelDisplay.setText("Please inter location");
       }else if(mn.isEmpty()){
           labelDisplay.setText("Please inter mobile number");
       }else if(dt.isEmpty()){
           labelDisplay.setText("Please inter date");
       }else{
         labelDisplay.setText("");
         Parent root = javafx.fxml.FXMLLoader.load(getClass().getResource("bookDisplayTF.fxml"));
         mainDisplay.getChildren().setAll(root);
           
          BookTf.clear();
          QuantityTf.clear();
          BillnumTf.clear();
          PriceTf.clear();
          AuthornameTf.clear();
          locationTf.clear();
          MobileNumber.clear();
          dateTf.clear();
        
         
       }
              
    }

    @FXML
    private void ExitBtn(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void BackBtn(ActionEvent event) {
      stageUserLoginPage.show();
      stageUserPage1.close();
      
    }

    @FXML
    private void menuBtn(ActionEvent event) {
       stageSMainManupage.show();
       stageUserPage1.close();
    }

    @FXML
    private void displayBtn(ActionEvent event) throws IOException {
          Parent root = javafx.fxml.FXMLLoader.load(getClass().getResource("booksTable.fxml"));
          mainDisplay.getChildren().setAll(root);
    }
    
}
