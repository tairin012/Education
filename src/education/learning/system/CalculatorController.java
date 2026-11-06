
package education.learning.system;
import static education.learning.system.TutionBookPageForStudentController.stageCalculatorPage;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;


/**
 *
 * @author rcz
 */
public class CalculatorController implements Initializable {
    
    private Label label;
    @FXML
    private TextField display;
    
    
    String optr = " ";
    double num1 = 0.0;
    Boolean start = true;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    

    @FXML
    private void numberButton(ActionEvent event) {
        
        if(start == true){
            display.setText("");
            start = false;
        }
        
        String oldNumber = display.getText();  
        String newNumber = ((Button)event.getSource()).getText();   
        String Number = oldNumber + newNumber;
     
     display.setText(Number);
     
    }

    @FXML
    private void arithmaticButton(ActionEvent event) {
            
            
            
       String oldNumber = display.getText();  
       num1 = Double.parseDouble(display.getText())  ;  
       optr = ( (Button)event.getSource()).getText();
       display.setText("");
   
    }

    @FXML
    private void cButton(ActionEvent event) {
        
          String oldNumber = display.getText(); 
          
          if(oldNumber.equals("")) return;
          
          String sub = oldNumber.substring(0 , oldNumber.length()-1);         
          display.setText(sub);
        
        
    }

    @FXML
    private void acButton(ActionEvent event) {
            display.setText("");
    }

    @FXML
    private void offButton(ActionEvent event) {
        
        stageCalculatorPage.close();
        
    }

    @FXML
    private void dosomicButton(ActionEvent event) {
        
           String oldNumber = display.getText(); 
           
           if(oldNumber.contains(".")) return;
               
           display.setText(oldNumber+".");
             
    }

    @FXML
    private void persentButton(ActionEvent event) {
        
          double n =Double.parseDouble(display.getText()) ;
        
          display.setText(  " " +(n/100) );
        
    }

    @FXML
    private void equalButton(ActionEvent event) {
    
        double num2 =Double.parseDouble(display.getText()) ;
         
        
     if(optr.equals("+")){
                
     display.setText( num1+ optr+ num2 + " ="+  " " +(num1+num2) );
      
       
     }else if(optr.equals("-")){
          display.setText( num1+ optr+ num2 + " ="+  " " +(num1-num2) );
            
     }else if(optr.equals("X")){
          display.setText( num1+ optr+ num2 + " ="+  " " +(num1*num2) );
           
     }else if(optr.equals("/")){
         
         if(num2 == 0){  
               display.setText("MATH ERROR" );
           
         }else{
                 display.setText( num1+ optr+ num2 + " ="+  " " +(num1/num2) );
                   
         }
                
     }
    
       start = true;
        
    }
    
}

