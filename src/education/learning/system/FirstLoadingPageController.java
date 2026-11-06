
package education.learning.system;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;


public class FirstLoadingPageController implements Initializable {

    @FXML
    private ProgressBar loading;
    
    @FXML
    private Label progressLabel;
    

    
    public static ProgressBar startProgressBar;
    public static Label label;
   

 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        label = progressLabel;
        startProgressBar = loading;
   
     }
    
    public void changescene() throws IOException{
        Parent root = javafx.fxml.FXMLLoader.load(getClass().getResource("ELSFontPage.fxml"));
        Scene scene = new Scene(root);
        Stage stg =(Stage) loading.getScene().getWindow();
        stg.setScene(scene);
        stg.show();
            
    }
        
    
    }    
    

