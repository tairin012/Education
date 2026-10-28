
package education.learning.system;

import static education.learning.system.AdminRegistrationController.stageCongtrtulationPage4;
import static education.learning.system.BookShopLoginPageController.stageAdminlogingPage;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;


public class CongratulationPage4Controller implements Initializable {
    
 
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }    

    @FXML
    private void goToLoginPageBtn(ActionEvent event) {
        stageAdminlogingPage.show();
        stageCongtrtulationPage4.close();
    }
    
}
