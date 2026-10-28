
package education.learning.system;

import static education.learning.system.AddBookController.stageorderTextFieldPage;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;


public class OrderTextFieldController implements Initializable {

    @FXML
    private TextArea orderDisplay;

  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        File fileRead = new File("OrderBook.txt");
        Scanner sc;
        try {
            sc = new Scanner(fileRead);
            
                  while(sc.hasNext()){
      
            String line = sc.nextLine();
             if(!line.equals("")){
                String[] arr = line.split("-");
                String All_name = arr[0];    
                String athorName = arr[1];
                String address = arr[2];
                String mobileNum = arr[3];
                String Quantity = arr[4];
                String price = arr[5];               
                String date= arr[6];
          
       orderDisplay.appendText("\t------------------------\n\tBook Name: "+All_name+"\n"+"\tAthor Name: "+athorName+"\n"+"\tLocation: "+address+"\n"+"\tMobile Number: "+mobileNum+"\n"+"\tQuantity: "+Quantity+"\n"+"\tPrice: "+price+"\n"+"\tDate: "+date+"\n\t------------------------\n");
               
        }
             
     
     }
        
           
            
        } catch (FileNotFoundException ex) {
           
        }
       
        
  
       
    }    

    @FXML
    private void okBtn(ActionEvent event) {
        stageorderTextFieldPage.close();
    }
    
}
