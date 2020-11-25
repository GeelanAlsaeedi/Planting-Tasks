/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plantingtask;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author Joman
 */
public class TasksController implements Initializable {
    
  @FXML
    public void MouseClick(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Register.fxml"));
        Scene gameScene = new Scene(pane);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(gameScene);
        window.show();
        
    }    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
       
     }
    
      
    

