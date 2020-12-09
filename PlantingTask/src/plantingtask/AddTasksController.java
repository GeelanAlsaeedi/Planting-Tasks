/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plantingtask;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * FXML Controller class
 *
 * @author Joman
 */
public class AddTasksController implements Initializable {

    private int score = 0;
    private String taskState;
    private String USER;
    private java.util.Date Due;
    int countToday=0, countAll=0, countWait=0;

    @FXML
    private TextField TaskNameField;

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
    private DatePicker datePicker;

    @FXML
    private Label waiting;

    @FXML
    private HBox waitingHB;

    @FXML
    void Min2N(ActionEvent event) {
        countAll++;
        score = score + 500;
        System.out.println("the score: " + score);
        WhoDoesIt.setVisible(true);
        WhoDoesItHB.setVisible(true);
    }

    @FXML
    void Min2Y(ActionEvent event) {
        countToday=countToday+10;
        score = score + 1000;
        System.out.println("the score: " + score);
        WhoDoesIt.setVisible(true);
        WhoDoesItHB.setVisible(true);
    }

    @FXML
    void SoloN(ActionEvent event) {
        score = score + 500;
        System.out.println("the score: " + score);
        DueDate.setVisible(true);
        DueDateHB.setVisible(true);
        waiting.setVisible(true);
        waitingHB.setVisible(true);
    }

    @FXML
    void SoloY(ActionEvent event) {
        countToday= countToday + 1;
        score = score + 500;
        System.out.println("the score: " + score);
        DueDate.setVisible(true);
        DueDateHB.setVisible(true);
    }

    @FXML
    void canBeDoneN(ActionEvent event) {
        //trash image
        score = 0;
        taskState = "cannot be set";
        Time.setVisible(false);
        TimeHB.setVisible(false);
    }

    @FXML
    void canBeDoneY(ActionEvent event) {
        score = score + 500;
        System.out.println("the score: " + score);
        Time.setVisible(true);
        TimeHB.setVisible(true);
    }

    @FXML
    void dueN(ActionEvent event) {
        countAll++;
        Due = null;
        score = score + 500;
        System.out.println("the score: " + score);
    }

    @FXML
    void dueY(ActionEvent event) {
        score = score + 1000;
        datePicker.setVisible(true);
        System.out.println("the score: " + score);
    }

    @FXML
    void waitingN(ActionEvent event) {
        countAll++;
        score = score + 500;
        System.out.println("the score: " + score);
    }

    @FXML
    void waitingY(ActionEvent event) {
        countWait= countWait+100;
        score = score + 500;
        System.out.println("the score: " + score);
    }
    
    @FXML
    void addDate(ActionEvent event) {
        Due = java.sql.Date.valueOf(datePicker.getValue());
        checkStatus(Due);
    }

    @FXML
    void AddTask(ActionEvent event) throws IOException {
        System.out.println("the score: " + score);
        String Tname = TaskNameField.getText();
        if (countAll > countWait && countAll > countToday){
            taskState="All";
        }else if (countToday > countWait){
            taskState="Today";
        }else 
            taskState = "Waiting";
        Task_POJO task = new Task_POJO(0, Tname, score, taskState, USER, Due , "not done");
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(task);
        tx.commit();
        session.close();
        System.out.println("inserted a contact: " + task.getTaskName());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO String Uname= TaskNameField.getText();
    }

    @FXML
    void totask(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Tasks.fxml"));
        Parent registerParent1 = loader.load();

        Scene WelcomeScene = new Scene(registerParent1);

        //access the controller and call a method
        TasksController controller = loader.getController();
        controller.initData(USER);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(WelcomeScene);
        stage.show();
    }

    public void initData(String userN) {
        USER = userN;
    }

    private void checkStatus(Date dueDate) {
        String state ;
        System.out.println("the date is: " + dueDate);
        // get current date and format it just like the one we used in the database 
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date dateobj = new Date();
        System.out.println(df.format(dateobj));
        
        //variables to compare monthes 
        //get substring were months are
        String monthNow = (df.format(dateobj)).substring(5,7); 
        String monthDue = dueDate.toString().substring(5,7);
        //make them into integers
        int intmonthNow =Integer.parseInt(monthNow); 
        int intmonthDue =Integer.parseInt(monthDue); 
        System.out.println("month now "+intmonthNow + " due date "+ intmonthDue);
        
        //variables to compare days 
        String DayNow = (df.format(dateobj)).substring(8,10); 
        String DayDue = dueDate.toString().substring(8,10); 
        int intDayNow =Integer.parseInt(DayNow); 
        int intDayDue =Integer.parseInt(DayDue); 
        System.out.println("Day now "+intDayNow + " due date "+ intDayDue);
        
        //comarition and status determination 
        //if the due date has past or it has 2 or less days to come we will set the status to Today
        //other wise the task might wait 
            if(intmonthNow == intmonthDue){
                if((intDayDue-intDayNow)<=2){
                    countToday = countToday +10;
                }else
                countAll ++;  
            }else  
                countAll++; 
            
    }
}
