
package education.learning.system;


import static education.learning.system.ELSFontPageController.stageSMainManupage;
import static education.learning.system.MainMamuPageController.stageBookShopLoginPage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class BookShopLoginPageController implements Initializable {

    @FXML
    private Label txt1;
   
    private Label display1;
    @FXML
    private Button adminBtn;
    
    public static Stage stageUserPage;
    public static Stage stageAdminlogingPage;
    public static Stage stageUserLoginPage;
    public static Stage stageOnlineBookReview;
    @FXML
    private Button bookReviews;

 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    

    @FXML
    private void backBtn(ActionEvent event) {
        stageSMainManupage.show();
        stageBookShopLoginPage.close();
        
    }

    @FXML
    private void exitBtn(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void userBtn(ActionEvent event) throws IOException {

            Parent root = FXMLLoader.load(getClass().getResource("UserLogin.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stageUserLoginPage = stage;
            stage.show();
            stageBookShopLoginPage.close(); 


    }

    @FXML
    private void adminBtn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AdminlogingPage.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stageAdminlogingPage = stage;
        stage.show();
        stageBookShopLoginPage.close();  
    }
    

    @FXML
    private void bookReview(ActionEvent event) throws IOException {
          Parent root = FXMLLoader.load(getClass().getResource("OnlineBookReview.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stageOnlineBookReview = stage;
        stage.show();
        stageBookShopLoginPage.close(); 
    }
    
   
}

    
        
        
    
    

    

   
