package plantingtask;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Geela
 */
public class PlantController implements Initializable {
    
        private String USER;
        
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

    @FXML
    private ImageView imageviewforcb;

    /* @FXML
    void handlercheckbox(ActionEvent event) throws FileNotFoundException {

        if(cb1.isSelected()){
           FileInputStreeam inst=new FileInputStream("plant – 1@3x.png");
                   Image plant1im=new Image(inst);
                   imageviewforcb.setImage(plant1im);
                   return;
       }
        if(cb2.isSelected()){
           FileInputStreeam inst=new FileInputStream("plant – 2@2x.png");
                   Image plant2im=new Image(inst);
                   imageviewforcb.setImage(plant2im);
                   return;
       }
         if(cb3.isSelected()){
           FileInputStreeam inst=new FileInputStream("plant – 3@3x.png");
                   Image plant3im=new Image(inst);
                   imageviewforcb.setImage(plant3im);
                   return;
       }
          if(cb4.isSelected()){
           FileInputStreeam inst=new FileInputStream("plant – 4@3x.png");
                   Image plant4im=new Image(inst);
                   imageviewforcb.setImage(plant4im);
                   return;
       }
           if(cb5.isSelected()){
           FileInputStreeam inst=new FileInputStream("plant – 5@3x.png");
                   Image plant5im=new Image(inst);
                   imageviewforcb.setImage(plant5im);
                   return;
       }
            if(cb6.isSelected()){
           FileInputStreeam inst=new FileInputStream("plant – 6@3x.png");
                   Image plant6im=new Image(inst);
                   imageviewforcb.setImage(plant6im);
                   return;
       }
    }*/
 /* final static javafx.scene.image.Image plant1 = new javafx.scene.image.Image(TasksController.class.getResource("plant – 1@3x.png").toString());
    final static javafx.scene.image.Image plant2 = new javafx.scene.image.Image(TasksController.class.getResource("plant – 2@2x.png").toString());
    final static javafx.scene.image.Image plant3 = new javafx.scene.image.Image(TasksController.class.getResource("plant – 3@3x.png").toString());
    final static javafx.scene.image.Image plant4 = new javafx.scene.image.Image(TasksController.class.getResource("plant – 4@3x.png").toString());
    final static javafx.scene.image.Image plant5 = new javafx.scene.image.Image(TasksController.class.getResource("plant – 5@3x.png").toString());
    final static javafx.scene.image.Image plant6 = new javafx.scene.image.Image(TasksController.class.getResource("plant – 6@3x.png").toString());
    
    
     ImageView imgv1 = new ImageView(plant1);
     ImageView imgv2 = new ImageView(plant2);

     ImageView imgv3 = new ImageView(plant3);
     ImageView imgv4 = new ImageView(plant4);

     ImageView imgv5 = new ImageView(plant5);
     ImageView imgv6 = new ImageView(plant6);

     public Group g1=new Group(imgv1);
  


        Timeline t = new Timeline();
        Timeline t2 = new Timeline();
        Timeline t3 = new Timeline();
        Timeline t4 = new Timeline();
        Timeline t5 = new Timeline(); 
        
      // g1.setTranlateX(200);
      // g1.setTranslateY(220);
        
        
        t.getKeyFrames().add(new KeyFrame(//الصورة التانية
            Duration.millis(200),
            (ActionEvent event) -> {
             g1.getChildren().setAll(g1);
                }
        ));
    


       t.play();*/
    /**
     * Initializes the controller class.
     */
        @FXML
    void backtotask(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Tasks.fxml"));
        Parent registerParent1 = loader.load();

        Scene WelcomeScene = new Scene(registerParent1);

        //access the controller and call a method
        TasksController controller = loader.getController();
        controller.initData(USER);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(WelcomeScene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
