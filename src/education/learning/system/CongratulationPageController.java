/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package education.learning.system;

import static education.learning.system.EducationLearningSystem.stageFirstLoginPage;
import static education.learning.system.SingInPageController.stageCongtrtulationPage;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author macbookpro
 */
public class CongratulationPageController implements Initializable {


     
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }    

    @FXML
    private void goToLoginPageBtn(ActionEvent event) {
        stageFirstLoginPage.show();
        stageCongtrtulationPage.close();
    }
    
}
