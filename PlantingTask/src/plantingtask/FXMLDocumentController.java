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
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author Joman
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    /* @FXML
     public void changeScreenButtonPushed(ActionEvent event) throws IOException{
        Parent loginParent = FXMLLoader.load(getClass().getResource("LogIn.fxml"));
        Scene loginScene=new Scene(loginParent);
        
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(loginScene);
        window.show();
    }**/
     
           @FXML
     public void changeScreenButtonPushed(ActionEvent event) throws IOException{
        Parent registerParent = FXMLLoader.load(getClass().getResource("login.fxml"));
        
        Scene registerScene=new Scene(registerParent);
        
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(registerScene);
        window.show();
        
    }
        @FXML
        public void labelLoginToRegister(MouseEvent event) throws IOException{
        Parent pane = FXMLLoader.load(getClass().getResource("LogIn.fxml"));
        Scene gameScene = new Scene(pane);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(gameScene);
        window.show();
      }
        
        
        @FXML
      public void changeScreenButton3Pushed(ActionEvent event) throws IOException{
        Parent registerParent = FXMLLoader.load(getClass().getResource("Register.fxml"));
        
        Scene registerScene=new Scene(registerParent);
        
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(registerScene);
        window.show();
        
    }
      @FXML
        public void labelToRegister(MouseEvent event) throws IOException{
        Parent pane = FXMLLoader.load(getClass().getResource("Register.fxml"));
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
