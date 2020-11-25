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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author gooda
 */
public class PlantsController implements Initializable {

  
          
    @FXML
    public void backToTasks(ActionEvent event) throws IOException {
        
        Parent pane = FXMLLoader.load(getClass().getResource("Tasks.fxml"));
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
