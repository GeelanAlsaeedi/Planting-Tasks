/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plantingtask;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
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
    private Label label;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        File fileread = new File("BeProductive.txt");
        int range = 17;
        int random = (int)(Math.random() * range);
        try{
                Scanner input = new Scanner(fileread);
                if (fileread.getPath() != null) {
                    input.useDelimiter(" ");
                    String str = Files.readAllLines(Paths.get("BeProductive.txt")).get(random);
                    input.close();
                    label.setText(str);
                }
            } catch (FileNotFoundException ex) {
                System.out.println(ex);

            } catch (IOException ex) {
            Logger.getLogger(WelcomSignINUpController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    @FXML
    void goLeft(MouseEvent event) {
        TranslateTransition trans = new TranslateTransition();
        trans.setDuration(Duration.seconds(2));
        trans.setNode(panel);
        trans.setToX(308);
        trans.play();
    }

    @FXML
    void goRight(MouseEvent event) {
        TranslateTransition trans = new TranslateTransition();
        trans.setDuration(Duration.seconds(2));
        trans.setNode(panel);
        trans.setToX(0);
        trans.play();
    }

}

