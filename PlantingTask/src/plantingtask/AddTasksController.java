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
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author Joman
 */
public class AddTasksController implements Initializable {
    
    @FXML
    private TextField TaskNameField;

    @FXML
    private HBox ActionableHB;

    @FXML
    private Label Time;

    @FXML
    private HBox TimeHB;

    @FXML
    private Label WhoDoesIt;

    @FXML
    private HBox WhoDoesItHB;

    @FXML
    private Label DueDate;

    @FXML
    private HBox DueDateHB;

    @FXML
    private Label waiting;

    @FXML
    private HBox waitingHB;

    @FXML
    void BackToTasks(ActionEvent event) {

    }

    @FXML
    void Min2N(ActionEvent event) {

    }

    @FXML
    void Min2Y(ActionEvent event) {

    }

    @FXML
    void SoloN(ActionEvent event) {

    }

    @FXML
    void SoloY(ActionEvent event) {

    }

    @FXML
    void canBeDoneY(ActionEvent event) {

    }

    @FXML
    void dueN(ActionEvent event) {

    }

    @FXML
    void dueY(ActionEvent event) {

    }

    @FXML
    void waitingN(ActionEvent event) {

    }

    @FXML
    void waitingY(ActionEvent event) {

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
     @FXML
    void totask(ActionEvent event) throws IOException {
Parent registerParent1 = FXMLLoader.load(getClass().getResource("Tasks.fxml"));
        
        Scene registerScene1=new Scene(registerParent1);
        
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(registerScene1);
        window.show();
    }
    
}
