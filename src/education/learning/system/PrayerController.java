
package education.learning.system;

import static education.learning.system.RhymesPageController.stagePrayer;
import static education.learning.system.RhymesPageController.stageRain;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;



public class PrayerController implements Initializable {

 
    private Media media;
    private File file;
    private MediaPlayer mediaPlayer;
    @FXML
    private MediaView mediaView;
    @FXML
    private Slider timeSlider;
    @FXML
    private Slider volumeSlider;
    

   
   
    
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        file  = new File("/Users/macbookpro/NetBeansProjects/Education Learning System/src/RhymesVideoFile/pussyCat.mp4");
        media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
        mediaView.setMediaPlayer(mediaPlayer);
        
            
              volumeSlider.valueProperty().addListener(new ChangeListener<Number>(){
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
              mediaPlayer.setVolume(volumeSlider.getValue()*0.01);
            }
            
        });
        

        
        mediaPlayer.currentTimeProperty().addListener(new ChangeListener<Duration>(){
            @Override
            public void changed(ObservableValue<? extends Duration> ov, Duration t, Duration t1) {
               
            Duration d = mediaPlayer.getCurrentTime();
            timeSlider.setValue(d.toSeconds());
            
            }
        
        
        });
        
        timeSlider.valueProperty().addListener(new ChangeListener<Number>(){
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
            
                if(timeSlider.isPressed()){
                  double value = timeSlider.getValue();
                  mediaPlayer.seek(new Duration(value*1000));
                }

            }
        
        
        });
    
    }    

    @FXML
    private void playBtn(ActionEvent event) {
        mediaPlayer.play();
    }

    @FXML
    private void pauseBtn(ActionEvent event) {
        mediaPlayer.pause();
    }

    @FXML
    private void closeBtn(ActionEvent event) {
        mediaPlayer.stop();
        stagePrayer.close();
    }


    
}
