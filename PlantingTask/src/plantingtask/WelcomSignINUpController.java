/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plantingtask;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.hibernate.*;



public class WelcomSignINUpController implements Initializable {
    @FXML
    private Pane panel;
    @FXML
    private Label label;
    
    @FXML
    private TextField userNameLog;

    @FXML
    private TextField userPassLog;

    @FXML
    private TextField userNameUp;

    @FXML
    private TextField emailUp;

    @FXML
    private TextField passUp;
    
    
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
    
   
    
    
     @FXML
      protected void signIn(ActionEvent event) throws IOException{
        Parent registerParent1 = FXMLLoader.load(getClass().getResource("Tasks.fxml"));
        
        Scene registerScene1=new Scene(registerParent1);
        
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(registerScene1);
        window.show();
    }
       @FXML
      protected void signup(ActionEvent event) throws IOException{
        Parent registerParent1 = FXMLLoader.load(getClass().getResource("Tasks.fxml"));
        
        Scene registerScene1=new Scene(registerParent1);
        
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(registerScene1);
        window.show();
    }
       @FXML
      protected void ConGuest(ActionEvent event) throws IOException{
        Parent registerParent1 = FXMLLoader.load(getClass().getResource("Tasks.fxml"));
        
        Scene registerScene1=new Scene(registerParent1);
        
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(registerScene1);
        window.show();
    }
       
     
     @FXML
      protected void signUp (ActionEvent event) throws IOException{
          
        User user= new User();
        user.setUserName(userNameUp.getText());
        user.setEmail(emailUp.getText());
        user.setPassword(passUp.getText());
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        String userId = (String)session.save(user);
        tx.commit();
        session.close();
       
        if(userId != " "){
          
        Parent registerParent1 = FXMLLoader.load(getClass().getResource("Tasks.fxml"));
        
        Scene registerScene1=new Scene(registerParent1);
        
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(registerScene1);
        window.show();
        
        }
    }
}

