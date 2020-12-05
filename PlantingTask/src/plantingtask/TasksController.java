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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Joman
 */
public class TasksController implements Initializable {
   
            
      @FXML
    void backtowelcome(ActionEvent event) throws IOException {
      Parent registerParent1 = FXMLLoader.load(getClass().getResource("WelcomSignINUp.fxml"));
        
        Scene registerScene1=new Scene(registerParent1);
        
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(registerScene1);
        window.show();
    }
    
      @FXML
    void toaddtask(ActionEvent event) throws IOException {
Parent registerParent1 = FXMLLoader.load(getClass().getResource("AddTasks.fxml"));
        
        Scene registerScene1=new Scene(registerParent1);
        
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(registerScene1);
        window.show();
    }
           @FXML
    void toplant(MouseEvent event) throws IOException {
Parent registerParent1 = FXMLLoader.load(getClass().getResource("Plant.fxml"));
        
        Scene registerScene1=new Scene(registerParent1);
        
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(registerScene1);
        window.show();
    }
    
   
//    //Revietive from database.
//     @FXML
//    public void alternateViewTable(Connection con) throws IOException, SQLException{
//        
//    String query = "select score from User";
//    
//    try (Statement stmt = con.createStatement()) {
//      ResultSet rs = stmt.executeQuery(query);
//      while (rs.next()) {
//        String ScoreCol = rs.getString(1);
//      
//        System.out.println(ScoreCol);
//      }
//    } catch (SQLException e) {
//      User.printSQLException(e);
//    }
//  }
//    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
       
     }
    
      
    

