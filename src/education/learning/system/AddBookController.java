
package education.learning.system;

import static education.learning.system.AdminlogingPageController.stageAddBookPage;
import static education.learning.system.BookShopLoginPageController.stageAdminlogingPage;
import static education.learning.system.ELSFontPageController.stageSMainManupage;
import static education.learning.system.ELSFontPageController.stageSinginpage;
import static education.learning.system.EducationLearningSystem.stageFirstLoginPage;
import static education.learning.system.SingInPageController.stageCongtrtulationPage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class AddBookController implements Initializable {

    @FXML
    private TextField BooknameTf;
    @FXML
    private TextField AuthornameTf;
    @FXML
    private TextField CategoryTf;
    @FXML
    private TextField PricebookTf;
    @FXML
    private TextField NumberBookTf;
    
    ObservableList<Book> book = FXCollections.observableArrayList();
      
    @FXML
    private TableView<Book> BookTable;
    @FXML
    private TableColumn<Book, String> nameColl;
    @FXML
    private TableColumn<Book, String> AuthorColl;
    @FXML
    private TableColumn<Book, String> Price;
    @FXML
    private TableColumn<Book, String> Quantity;
    @FXML
    private Label display2;
    @FXML
    private TableColumn<Book, String> CategoryColl;
    
    public static Stage stageorderTextFieldPage;
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        book.clear();
          
          File fileRead = new File("Books.txt");
           Scanner sc;
        try {
            sc = new Scanner(fileRead);
                 
        while(sc.hasNext()){
    
            String line = sc.nextLine();
             if(!line.equals("")){
                String[] arr = line.split("-");
                String b_name = arr[0];
                String a_Nane = arr[1];
                String typeBook = arr[2];
                String bk_Price = arr[3];
                String item= arr[4];
         
               Book bk = new Book(b_name,a_Nane,typeBook,bk_Price,item);
               book.add(bk);
             }
    
        }
        
                nameColl.setCellValueFactory(new PropertyValueFactory<Book, String>("Name"));
                AuthorColl.setCellValueFactory(new PropertyValueFactory<Book, String>("Author"));
                CategoryColl.setCellValueFactory(new PropertyValueFactory<Book, String>("Category"));
                Price.setCellValueFactory(new PropertyValueFactory<Book, String>("Price"));
                Quantity.setCellValueFactory(new PropertyValueFactory<Book, String>("Quantity"));
                BookTable.setItems(book);
        
        
        } catch (FileNotFoundException ex) {
         
        }    
            
    }    

    @FXML
    private void AddButton(ActionEvent event) {
       String bookName = BooknameTf.getText();
       String Authorname = AuthornameTf.getText();
       String Category = CategoryTf.getText();
       String Pricebook = PricebookTf.getText();
       String NumberOfBook = NumberBookTf.getText(); 
       
    
     
         try{
           FileWriter file = new FileWriter("Books.txt", true);
           PrintWriter pw  = new PrintWriter(file);

       
           if(bookName.isEmpty()){
               display2.setText("Please enter book name");
           }else if(Authorname.isEmpty()){
                display2.setText("Please enter author name");
           }else if(Category.isEmpty()){
                display2.setText("Please enter category");
           }else if(Pricebook.isEmpty()){
                display2.setText("Please enter price of book");
           }else if(NumberOfBook.isEmpty()){
                display2.setText("Please enter your number Of book");
           }else {
               
       
                Book bk = new Book(bookName,Authorname,Category,Pricebook,NumberOfBook);
                book.add(bk);
                pw.println(bookName+"-"+Authorname+"-"+Category+"-"+Pricebook+"-"+NumberOfBook);         
                pw.close();
                
                nameColl.setCellValueFactory(new PropertyValueFactory<Book, String>("Name"));
                AuthorColl.setCellValueFactory(new PropertyValueFactory<Book, String>("Author"));
                CategoryColl.setCellValueFactory(new PropertyValueFactory<Book, String>("Category"));
                Price.setCellValueFactory(new PropertyValueFactory<Book, String>("Price"));
                Quantity.setCellValueFactory(new PropertyValueFactory<Book, String>("Quantity"));
                BookTable.setItems(book);
    
                BooknameTf.clear();
                AuthornameTf.clear();
                CategoryTf.clear();
                PricebookTf.clear();
                NumberBookTf.clear();
                  
            } 
           
       }catch(IOException e){
           System.out.println("Error: "+e);
       }
       
       
    }


    @FXML
    private void ExitButton(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void BackButton(ActionEvent event) {
        display2.setText("");
        stageAdminlogingPage.show();
        stageAddBookPage.close();
    }

    @FXML
    private void menuBtn(ActionEvent event) {
          stageSMainManupage.show();
          stageAddBookPage.close();
    }

    @FXML
    private void orderBook(ActionEvent event)throws IOException {
        Parent root = javafx.fxml.FXMLLoader.load(getClass().getResource("orderTextField.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stageorderTextFieldPage = stage;
        stage.show();
        stageFirstLoginPage.close();

       
    }
    
}


