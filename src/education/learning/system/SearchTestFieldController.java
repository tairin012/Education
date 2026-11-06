
package education.learning.system;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;


public class SearchTestFieldController implements Initializable {

    @FXML
    private TextArea searchDisplayTA;

  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       int count =0;
        try {
                  
       ArrayList<Book> books =new ArrayList<>();            
       FileReader fileRead = new FileReader("Books.txt");
       BufferedReader b_r = new BufferedReader(fileRead);
       
       String search_books = UserPageController.book_search;
       
     
              
       while(true){
           String line = b_r.readLine();
           if(line ==null) break;
           
           if(line.length()!=0){
               String[] partsOfLine = line.split("-");
               String Book_Name = partsOfLine[0];
               String Atho_Name = partsOfLine[1];
               String Catagory_Name = partsOfLine[2];
               String Price_Mony = partsOfLine[3];
               String Quantity_Number = partsOfLine[4];
               
               books.add(new Book(Book_Name,Atho_Name,Catagory_Name,Price_Mony,Quantity_Number));
           }
       }
          
           for(Book bo_ok:books){
               if(bo_ok==null) break;
               
              if(search_books.contains(bo_ok.getName())){
                  searchDisplayTA.setText("\n\n\n\n\t\t\t\t\t\t-------------------------\n\t\t\t\t\t\tBook Name: "+bo_ok.getName()+"\n"+"\t\t\t\t\t\tAthor Name: "+bo_ok.getAuthor()+"\n"+"\t\t\t\t\t\tQuantity: "+bo_ok.getQuantity()+"\n"+"\t\t\t\t\t\tCategory: "+bo_ok.getCategory()+"\n"+"\t\t\t\t\t\tPrice: "+bo_ok.getPrice()+"\n\t\t\t\t\t\t-------------------------\n");                  
                  count++;
              }          
           
           }
         
          
          if(count==0){
              searchDisplayTA.setText("\n\n\n\n\n\n\n\t\t\t\t\t\tNo Books Available");
          }
       
        }catch(Exception ex){
        
            System.out.println("Error: "+ex);
    }
        
    }    
    
}
