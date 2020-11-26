/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plantingtask;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Joman
 */
public class WelcomSignINUpController implements Initializable {
    @FXML
    private Pane panel;
    @FXML
    private AnchorPane root;
    @FXML
    private ImageView pic;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TranslateTransition trans = new TranslateTransition();
        trans.setDuration(Duration.seconds(2));
        trans.setNode(pic);
        trans.setToX(600);
        trans.play();
    }    
    
    @FXML
    void goLeft(MouseEvent event) {

    }

    @FXML
    void goRight(MouseEvent event) {

    }

}

