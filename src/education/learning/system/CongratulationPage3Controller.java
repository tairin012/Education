
package education.learning.system;

import static education.learning.system.StudentRegistrationPageController.stageCongtrtulationPage3;
import static education.learning.system.TutionPlatformPageController.stageStudentLoginPage;
import static education.learning.system.TutionPlatformPageController.stageTeacherLoginPage;
import static education.learning.system.TutionPlatformSignInPageController.stageCongtrtulationPage2;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * FXML Controller class
 *
 * @author macbookpro
 */
public class CongratulationPage3Controller implements Initializable {

     String b_music = "/Users/macbookpro/NetBeansProjects/Education Learning System/src/AllBackgroundMusic/cngrs2.mp3";
     Media media = new Media(new File(b_music).toURI().toString()); 
     MediaPlayer mediaPlayerBM = new MediaPlayer(media);
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mediaPlayerBM.play();
    }    

    @FXML
    private void goToLoginPageBtn(ActionEvent event) {
       stageStudentLoginPage.show();
       stageCongtrtulationPage3.close();
    }
    
}
