package education.learning.system;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EducationLearningSystem extends Application {

    public static Stage stageFirstLoginPage;
    public static Stage stageFirstLoadinPage;
    public static Stage stageFirstLoadinPage_1;

    public static FirstLoadingPageController clr;

    double pgs;

    private Task task;

    @Override
    public void start(Stage stage) throws Exception {
        this.stageFirstLoginPage = stage;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("firstLoadingPage.fxml"));

        Parent root0 = loader.load();
        clr = loader.getController();

        Scene scene0 = new Scene(root0);
        stage.setScene(scene0);
        stageFirstLoadinPage_1 = stage;
        stage.show();
        fill();

    }

    public void fill() {
        task = new Task();
        task.start();
    }

    public static void main(String[] args) {

        launch(args);

    }

    public class Task extends Thread {


        public void run() {
            for (double i = 0.0; i <= 1; i += 0.1) {              

                FirstLoadingPageController.startProgressBar.setProgress(i);
             
                try {
                    Thread.sleep(400);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

            Platform.runLater(new Runnable() {

                public void run() {
                    try {
                        clr.changescene();
                    } catch (IOException ex) {
                        Logger.getLogger(EducationLearningSystem.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            });

        }

    }

}
