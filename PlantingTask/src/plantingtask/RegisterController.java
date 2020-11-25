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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Joman
 */
public class RegisterController implements Initializable {
 @FXML
      public void changeScreenButton5Pushed(ActionEvent event) throws IOException{
        Parent registerParent1 = FXMLLoader.load(getClass().getResource("Tasks.fxml"));
        
        Scene registerScene1=new Scene(registerParent1);
        
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(registerScene1);
        window.show();
    }
       @FXML
      public void BackToWelcome(ActionEvent event) throws IOException{
        Parent pane = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene gameScene = new Scene(pane);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(gameScene);
        window.show();
      }
      
       @FXML
      public void ToLoginScene(ActionEvent event) throws IOException{
          
        Parent registerParent2 = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene registerScene2=new Scene(registerParent2);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(registerScene2);
        window.show();
      }
      
          @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
