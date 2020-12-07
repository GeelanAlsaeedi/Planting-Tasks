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
import java.util.List;
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

    private String loggedInUser;
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

    @FXML
    private Label signInErrMsg;

    @FXML
    private Label signUpErrMsg;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        File fileread = new File("BeProductive.txt");
        int range = 17;
        int random = (int) (Math.random() * range);
        try {
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
        trans.setDuration(Duration.seconds(1));
        trans.setNode(panel);
        trans.setToX(308);
        trans.play();
    }

    @FXML
    void goRight(MouseEvent event) {
        TranslateTransition trans = new TranslateTransition();
        trans.setDuration(Duration.seconds(1));
        trans.setNode(panel);
        trans.setToX(0);
        trans.play();
    }

    @FXML
    protected void signIn(ActionEvent event) throws IOException {
        //get values from textFields at sign In page & and store in variables 
        String Uname = userNameLog.getText();
        String Upass = userPassLog.getText();

        if (Uname.equals("") || Upass.equals("")) {
            signInErrMsg.setText("Fill all the required fields");
        } else {
            //retrive the rows of userinformation Table
            Session session = HibernateUtil.getSessionFactory().openSession();
            List<User> userList = null;
            String queryStr = "from User";//
            Query query = session.createQuery(queryStr);
            userList = query.list();
            session.close();

            //Declare variables to store attribute's vlause of User objects from list
            String userName = null, userPass = null;//for comparision
            for (User u : userList) {
                if (u.getUserName().equals(Uname) && u.getPassword().equals(Upass)) {//if the database has any 
                    userName = u.getUserName();
                    userPass = u.getPassword();
                    setLoggedInUser(userName);
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("Tasks.fxml"));
                    Parent registerParent1 = loader.load();

                    Scene WelcomeScene = new Scene(registerParent1);

                    //access the controller and call a method
                    TasksController controller = loader.getController();
                    controller.initData(loggedInUser);
                    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

                    window.setScene(WelcomeScene);
                    window.show();
                    break;
                }
            }
            if (userName == null || userPass == null)//if fields are empty 
            {
                signInErrMsg.setText("User Name or Password is incorrect");
            }
        }
    }

    @FXML
    protected void ConGuest(ActionEvent event) throws IOException {
        setLoggedInUser("Guest");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Tasks.fxml"));
        Parent registerParent1 = loader.load();

        Scene WelcomeScene = new Scene(registerParent1);

        //access the controller and call a method
        TasksController controller = loader.getController();
        controller.initData(getLoggedInUser());
//        Parent registerParent1 = FXMLLoader.load(getClass().getResource("Tasks.fxml"));
//        
//        Scene registerScene1=new Scene(registerParent1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(WelcomeScene);
        stage.show();
    }

    @FXML
    protected void signUp(ActionEvent event) throws IOException {

        User user = new User();
        user.setUserName(userNameUp.getText());
        user.setEmail(emailUp.getText());
        user.setPassword(passUp.getText());

        if (user.getUserName().equals("") || user.getEmail().equals("") || user.getPassword().equals("")) {
            signUpErrMsg.setText("Fill all the required fields");
        } else {
            //insert to userinformation Table in plantingtask DataBase
            Session session = HibernateUtil.getSessionFactory().openSession();
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            String userId = (String) session.save(user);
            tx.commit();
            session.close();

            if (userId != "") {
                setLoggedInUser(user.getUserName());
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("Tasks.fxml"));
                Parent registerParent1 = loader.load();

                Scene WelcomeScene = new Scene(registerParent1);

                //access the controller and call a method
                TasksController controller = loader.getController();
                controller.initData(getLoggedInUser());
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

                window.setScene(WelcomeScene);
                window.show();
            }
        }
    }

    public String getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(String loggedInUser) {
        this.loggedInUser = loggedInUser;
    }
}
