package plantingtask;
import java.applet.Applet;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.IntegerBinding;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaErrorEvent;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Text;




public class PlantController implements Initializable {
      @FXML
    private ImageView textim;
    @FXML
    private ImageView eggImage;


     @FXML
    private ImageView  image5;

    @FXML
    private ImageView imagev4;
    @FXML
    private ImageView imagev2;

    @FXML
    private ImageView imagev3;
    @FXML
    private ImageView BaseImage;
    @FXML
    private CheckBox cb1;

    @FXML
    private CheckBox cb2;

    @FXML
    private CheckBox cb3;

    @FXML
    private CheckBox cb4;

    @FXML
    private CheckBox cb5;

    @FXML
    private CheckBox cb6;

    int counter = 1;




    //lists
   private ObservableSet<CheckBox> selectedCheckBoxes = FXCollections.observableSet();
   private ObservableSet<CheckBox> unselectedCheckBoxes = FXCollections.observableSet();

   private IntegerBinding numCheckBoxesSelected = Bindings.size(selectedCheckBoxes);
   private IntegerBinding numunCheckBoxesSelected = Bindings.size(unselectedCheckBoxes);
   // max number of selecting
   private final int maxNumSelected = 6;


    //First animation
    Image plant2 = new Image("plantOne1@3x.png");
    Image plant3 = new Image("plantOne2@3x.png");
    Image plant4 = new Image("plantOne3@3x.png");
    Image plant5 = new Image("plantOne4@3x.png");
    Image plant6 = new Image("plantOne5@3x.png");
    Image plant7 = new Image("plantOne6@3x.png");
    Image plant8 = new Image("plantOne7@3x.png");


    //Image plant9 = new Image("plantfinalpartTwo2@3x.png");

    //2nd animation
    Image plant9 = new Image("plantOne7@3x.png");
    Image plant10 = new Image("plantanimation2-1@3x.png");
    Image plant11 = new Image("plantanimation2 – 3@3x.png");
    Image plant12 = new Image("plantanimation2 – 4@3x.png");
    Image plant13 = new Image("plantanimation2 – 5@3x.png");
    Image plant14 = new Image("plantanimation2 – 6@3x.png");
    Image plant15 = new Image("plantanimation2 – 7@3x.png");


    //3rd animation
    Image plant16 = new Image("plantanimation2 – 7@3x.png");
    Image plant17 = new Image("plantanimation3 – 1@3x.png");
    Image plant18 = new Image("plantanimation3 – 3@3x.png");
    Image plant19 = new Image("plantanimation3 – 4@3x.png");
    Image plant20 = new Image("plantanimation3 – 5@3x.png");
    Image plant21 = new Image("plantanimation3 – 6@3x.png");
    Image plant22 = new Image("plantanimation3 – 7@3x.png");
    Image plant23 = new Image("plantanimation3 – 8@3x.png");



     //4th animation
    Image plant24 = new Image("plantanimation3 – 8@3x.png");
    Image plant25 = new Image("plantanimation4 – 1@3x.png");
    Image plant26 = new Image("plantanimation4 – 2@3x.png");
    Image plant27 = new Image("plantanimation4 – 3@3x.png");
    Image plant28 = new Image("plantanimation4 – 4@3x.png");
    Image plant29 = new Image("plantanimation4 – 5@3x.png");
    Image plant30 = new Image("plantanimation4 – 6@3x.png");
    Image plant31 = new Image("plantanimation4 – 77@3x.png");



    //5th animation
    Image plant32 = new Image("plantanimation4 – 77@3x.png");
    Image plant33 = new Image("plantanimation5 – 1@3x.png");
    Image plant34 = new Image("plantanimation5 – 2@3x.png");
    Image plant35 = new Image("plantanimation5 – 3@3x.png");
    Image plant36 = new Image("plantanimation5 – 4@3x.png");
    Image plant37 = new Image("plantanimation5 – 5@3x.png");
    Image plant38 = new Image("plantanimation5 – 6@3x.png");
    Image plant39 = new Image("plantanimation5 – 7@3x.png");
    Image plant40 = new Image("plantanimation5 – 8@3x.png");



    //6th animation
    Image plant41 = new Image("plantanimation5 – 8@3x.png");
    Image plant42 = new Image("plantanimation6 – 1@3x.png");
    Image plant43 = new Image("plantanimation6 – 2@3x.png");
    Image plant45 = new Image("plantanimation6 – 3@3x.png");
    Image plant46 = new Image("plantanimation6 – 4@3x.png");
    Image plant47 = new Image("plantanimation6 – 5@3x.png");
    Image plant48 = new Image("plantanimation6 – 6@3x.png");
    Image plant49 = new Image("plantanimation6 – 7@3x.png");
    Image plant50 = new Image("plantanimation6 – 8@3x.png");

    //egg animation


    Image egg6 = new Image("growegg – 5@3x.png");


    Image egg7 = new Image("growegg – 4@3x.png");

    Image egg8 = new Image("growegg – 3@3x.png");

    Image egg9 = new Image("growegg – 2@3x.png");

    Image egg10 = new Image("growegg – 1@3x.png");

    Image textem = new Image("DID@3x.png");



  public  void backtotask(ActionEvent event) throws IOException {
        Parent registerParent1 = FXMLLoader.load(getClass().getResource("Tasks.fxml"));

        Scene registerScene1=new Scene(registerParent1);

        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(registerScene1);
        window.show();
    }

    public void action(ActionEvent event){
        configureCheckBox(cb1);
        configureCheckBox(cb2);
        configureCheckBox(cb3);
        configureCheckBox(cb4);
        configureCheckBox(cb5);
        configureCheckBox(cb6);
        //cb1.setSelected(true);

         numCheckBoxesSelected.addListener((obs, oldSelectedCount, newSelectedCount) -> {

            if(newSelectedCount.intValue() == maxNumSelected) {
                   //eggImage.setVisible(true);
                    Timeline timeline = new Timeline(
                            new KeyFrame(Duration.ZERO, new KeyValue(BaseImage.imageProperty(),       plant41)),
                            new KeyFrame(Duration.seconds(1), new KeyValue(BaseImage.imageProperty(), plant42)),
                            new KeyFrame(Duration.seconds(2), new KeyValue(BaseImage.imageProperty(), plant43)),
                            new KeyFrame(Duration.seconds(3), new KeyValue(BaseImage.imageProperty(), plant45)),
                            new KeyFrame(Duration.seconds(4), new KeyValue(BaseImage.imageProperty(), plant46)),
                            new KeyFrame(Duration.seconds(5), new KeyValue(BaseImage.imageProperty(), plant47)),
                            new KeyFrame(Duration.seconds(6), new KeyValue(BaseImage.imageProperty(), plant48)),
                            new KeyFrame(Duration.seconds(7), new KeyValue(BaseImage.imageProperty(), plant49)),
                            new KeyFrame(Duration.seconds(8), new KeyValue(BaseImage.imageProperty(), plant50)),
                            new KeyFrame(Duration.seconds(9), new KeyValue(BaseImage.imageProperty(),  egg6)),
                            new KeyFrame(Duration.seconds(10), new KeyValue(BaseImage.imageProperty(), egg7)),
                            new KeyFrame(Duration.seconds(11), new KeyValue(BaseImage.imageProperty(), egg8)),
                            new KeyFrame(Duration.seconds(12), new KeyValue(BaseImage.imageProperty(), egg9)),
                            new KeyFrame(Duration.seconds(13), new KeyValue(BaseImage.imageProperty(), egg10))
                    );

                    timeline.setCycleCount(1);
                    timeline.play();
                    timeline.setRate(3);
                    textanimation();





             }




            if(newSelectedCount.intValue() == maxNumSelected-1) {
            Timeline timeline = new Timeline(
            new KeyFrame(Duration.ZERO, new KeyValue(BaseImage.imageProperty(),       plant32)),
            new KeyFrame(Duration.seconds(1), new KeyValue(BaseImage.imageProperty(), plant33)),
            new KeyFrame(Duration.seconds(2), new KeyValue(BaseImage.imageProperty(), plant34)),
            new KeyFrame(Duration.seconds(3), new KeyValue(BaseImage.imageProperty(), plant35)),
            new KeyFrame(Duration.seconds(4), new KeyValue(BaseImage.imageProperty(), plant36)),
            new KeyFrame(Duration.seconds(5), new KeyValue(BaseImage.imageProperty(), plant37)),
            new KeyFrame(Duration.seconds(6), new KeyValue(BaseImage.imageProperty(), plant38)),
            new KeyFrame(Duration.seconds(7), new KeyValue(BaseImage.imageProperty(), plant39)),
            new KeyFrame(Duration.seconds(8), new KeyValue(BaseImage.imageProperty(), plant40))
            );
     timeline.setCycleCount(1);
     timeline.play();
     timeline.setRate(3);
    }
            if(newSelectedCount.intValue() == maxNumSelected-2) {
            Timeline timeline = new Timeline(
            new KeyFrame(Duration.ZERO, new KeyValue(BaseImage.imageProperty(),       plant24)),
            new KeyFrame(Duration.seconds(1), new KeyValue(BaseImage.imageProperty(), plant25)),
            new KeyFrame(Duration.seconds(2), new KeyValue(BaseImage.imageProperty(), plant26)),
            new KeyFrame(Duration.seconds(3), new KeyValue(BaseImage.imageProperty(), plant27)),
            new KeyFrame(Duration.seconds(4), new KeyValue(BaseImage.imageProperty(), plant28)),
            new KeyFrame(Duration.seconds(5), new KeyValue(BaseImage.imageProperty(), plant29)),
            new KeyFrame(Duration.seconds(6), new KeyValue(BaseImage.imageProperty(), plant30)),
            new KeyFrame(Duration.seconds(7), new KeyValue(BaseImage.imageProperty(), plant31))
            );
     timeline.setAutoReverse(true);
     timeline.setCycleCount(1);
     timeline.play();
     timeline.setRate(3);
    }     if(newSelectedCount.intValue() == maxNumSelected-3){
            Timeline timeline = new Timeline(
            new KeyFrame(Duration.ZERO, new KeyValue(BaseImage.imageProperty(),       plant16)),
            new KeyFrame(Duration.seconds(1), new KeyValue(BaseImage.imageProperty(), plant17)),
            new KeyFrame(Duration.seconds(2), new KeyValue(BaseImage.imageProperty(), plant18)),
            new KeyFrame(Duration.seconds(3), new KeyValue(BaseImage.imageProperty(), plant19)),
            new KeyFrame(Duration.seconds(4), new KeyValue(BaseImage.imageProperty(), plant20)),
            new KeyFrame(Duration.seconds(5), new KeyValue(BaseImage.imageProperty(), plant21)),
            new KeyFrame(Duration.seconds(6), new KeyValue(BaseImage.imageProperty(), plant22)),
            new KeyFrame(Duration.seconds(7), new KeyValue(BaseImage.imageProperty(), plant23))

            );
     timeline.setAutoReverse(true);
     timeline.setCycleCount(1);
     timeline.play();
     timeline.setRate(3);

    }   if(newSelectedCount.intValue() == maxNumSelected-4){
            Timeline timeline = new Timeline(
            new KeyFrame(Duration.ZERO, new KeyValue(BaseImage.imageProperty(),       plant9)),
            new KeyFrame(Duration.seconds(1), new KeyValue(BaseImage.imageProperty(), plant10)),
            new KeyFrame(Duration.seconds(2), new KeyValue(BaseImage.imageProperty(), plant11)),
            new KeyFrame(Duration.seconds(3), new KeyValue(BaseImage.imageProperty(), plant12)),
            new KeyFrame(Duration.seconds(4), new KeyValue(BaseImage.imageProperty(), plant13)),
            new KeyFrame(Duration.seconds(5), new KeyValue(BaseImage.imageProperty(), plant14)),
            new KeyFrame(Duration.seconds(6), new KeyValue(BaseImage.imageProperty(), plant15))
            );
     timeline.setAutoReverse(true);
     timeline.setCycleCount(1);
     timeline.play();
     timeline.setRate(3);
    }
    if(newSelectedCount.intValue() == maxNumSelected-5)
    {
        Timeline timeline = new Timeline(
            new KeyFrame(Duration.ZERO,       new KeyValue(BaseImage.imageProperty(), plant2)),
            new KeyFrame(Duration.seconds(1), new KeyValue(BaseImage.imageProperty(), plant3)),
            new KeyFrame(Duration.seconds(2), new KeyValue(BaseImage.imageProperty(), plant4)),
            new KeyFrame(Duration.seconds(3), new KeyValue(BaseImage.imageProperty(), plant5)),
            new KeyFrame(Duration.seconds(4), new KeyValue(BaseImage.imageProperty(), plant6)),
            new KeyFrame(Duration.seconds(5), new KeyValue(BaseImage.imageProperty(), plant7)),
            new KeyFrame(Duration.seconds(6), new KeyValue(BaseImage.imageProperty(), plant8))
            );
     timeline.setAutoReverse(true);
     timeline.setCycleCount(1);
     timeline.play();
     timeline.setRate(3);


    }

    });


    }

    void textanimation(){
          Timeline timeline = new Timeline(
            new KeyFrame(Duration.seconds(2),new KeyValue(textim.imageProperty(), textem))

            );
     timeline.setAutoReverse(true);
     timeline.setCycleCount(1);
     timeline.play();
     timeline.setRate(3);
       sounds();
    }


      private void configureCheckBox(CheckBox checkBox) {

       checkBox.selectedProperty().addListener((obs, wasSelected, isNowSelected) -> {
            if (isNowSelected) {
                unselectedCheckBoxes.remove(checkBox);
                selectedCheckBoxes.add(checkBox);
            } else {
                selectedCheckBoxes.remove(checkBox);
                unselectedCheckBoxes.add(checkBox);
            }

        });

    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }


    void sounds(){

    }
}
