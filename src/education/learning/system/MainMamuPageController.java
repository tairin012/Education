
package education.learning.system;

import static education.learning.system.ELSFontPageController.stageSMainManupage;
import static education.learning.system.EducationLearningSystem.stageFirstLoginPage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MainMamuPageController implements Initializable {

     public static Stage stageOnlineEducation;
     public static Stage stageTutionPlatformPage;
     public static Stage stageBookShopLoginPage;
     
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
    }    

 

  

    @FXML
    private void onlineBookShopBtn(ActionEvent event) throws IOException {
       
        Parent root = FXMLLoader.load(getClass().getResource("BookShopLoginPage.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stageBookShopLoginPage = stage;
        stage.show();
        stageSMainManupage.close();
    }

    @FXML
    private void backBtn(ActionEvent event) {
        stageFirstLoginPage.show();
        stageSMainManupage.close();
    }

    @FXML
    private void exitBtn(ActionEvent event) {
        System.exit(0);
    }
    
}
