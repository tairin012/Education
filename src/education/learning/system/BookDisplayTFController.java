
package education.learning.system;

import static education.learning.system.UserPageController.BookName;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;


public class BookDisplayTFController implements Initializable {

    @FXML
  private TextArea allDisplayTf;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
      int count = 0;  
       
      int randonNumber =(int) (Math.random()*7)+1;
      String cnvrtRandomNumberToString =  randonNumber+"";
        
      FileWriter file;
        try {
  
         
       file = new FileWriter("OrderBook.txt", true);
       PrintWriter pw  = new PrintWriter(file);

            
       allDisplayTf.clear();
       String nm = UserPageController.BookName;
       String an = UserPageController.athorName;
       String ln = UserPageController.location;
       String mbn = UserPageController.mobileNumber;
       String qn = UserPageController.quantityName;
       String p = UserPageController.price; 
       String d = UserPageController.dateNum;
       
       int cnvtIntQnNum = Integer.parseInt(qn);
       double cnvrPriceDouble = Double.parseDouble(p);
       
       double result = cnvtIntQnNum * cnvrPriceDouble;
       
       String toStringRuselt = result+"";

       pw.println(nm+"-"+an+"-"+ln+"-"+mbn+"-"+qn+"-"+toStringRuselt+"-"+d);         
       pw.close();

       
            allDisplayTf.setText("\t\t\t\t\t\t\t\tMoney Receipt\n"+"\t\t\t\t--------------------------------------------------------------------\n"+"\n"+"\t\t\t\t----------------------------------------------------\n\t\t\t\tBook Name: "+nm+"\n"+"\t\t\t\tAthor Name: "+an+"\n"+"\t\t\t\tQuantity: "+qn+"\n"+"\t\t\t\tPer Book Price: "+p+" BDT"+"\n"+"\t\t\t\tLocation: "
                    +ln+"\n"+"\t\t\t\tMobile Number: "+mbn+"\n"+"\t\t\t\tTotal Price: "+toStringRuselt+" BDT"+"\n"+"\t\t\t\tDate: "+d+"\n\t\t\t\t----------------------------------------------------\n"+"\n\t\t\t\t\t\tYou will receive the book in "+cnvrtRandomNumberToString +" days\n\t\t\t\t\t\t\t\tThank You");
      
        
     
        } catch (IOException ex) {
            System.out.println("Error: "+ex);
        }
    
   
    }    
    
}   
