
package education.learning.system;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class BooksTableController implements Initializable {

    @FXML
    private TableView<Book> BookTable;
    @FXML
    private TableColumn<Book, String> nameColl;
    @FXML
    private TableColumn<Book, String> AuthorColl;
    @FXML
    private TableColumn<Book, String> CategoryColl;
    @FXML
    private TableColumn<Book, String> Price;
    @FXML
    private TableColumn<Book, String> Quantity;
    
       
   ObservableList<Book> book = FXCollections.observableArrayList();
      

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
    
}
