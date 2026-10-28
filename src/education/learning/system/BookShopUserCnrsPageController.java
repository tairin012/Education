
package education.learning.system;

import static education.learning.system.BookShopLoginPageController.stageUserLoginPage;
import static education.learning.system.UserregistrationPageController.stagebookShopUserCnrsPage;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class BookShopUserCnrsPageController implements Initializable {
 
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }    

    @FXML
    private void goToLoginPageBtn(ActionEvent event) {
       stagebookShopUserCnrsPage.close();
       stageUserLoginPage.show();
    }
    
}
