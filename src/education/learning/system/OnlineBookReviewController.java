/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package education.learning.system;

import static education.learning.system.BookShopLoginPageController.stageOnlineBookReview;
import static education.learning.system.MainMamuPageController.stageBookShopLoginPage;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class OnlineBookReviewController implements Initializable {

    @FXML
    private WebView webView;
    
    private WebEngine engine;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          engine = webView.getEngine();
          engine.load("https://www.uiu.ac.bd/");
        
    }    

    @FXML
    private void backBtn(ActionEvent event) {
        stageBookShopLoginPage.show();
        stageOnlineBookReview.close();
    }

    @FXML
    private void exitBtn(ActionEvent event) {
         System.exit(0);
    }
    
}
