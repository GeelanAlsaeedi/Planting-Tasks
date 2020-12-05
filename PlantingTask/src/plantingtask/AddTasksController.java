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
import javafx.scene.layout.HBox;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * FXML Controller class
 *
 * @author Joman
 */
public class AddTasksController implements Initializable {

    private double score = 0;
    private String taskState;
    private String USER;
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
    private DatePicker datePicker;

    @FXML
    void Min2N(ActionEvent event) {
        score = score + 500;
        System.out.println("the score: " + score);
        WhoDoesIt.setVisible(true);
        WhoDoesItHB.setVisible(true);
    }

    @FXML
    void Min2Y(ActionEvent event) {
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
        taskState = "Today";
        score = score + 500;
        System.out.println("the score: " + score);
        DueDate.setVisible(true);
        DueDateHB.setVisible(true);
    }

    @FXML
    void canBeDoneN(ActionEvent event) {
        //trash image
        taskState = "cannot be set";
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
        taskState = "Today";
        score = score + 500;
        System.out.println("the score: " + score);
    }

    @FXML
    void waitingY(ActionEvent event) {
        taskState = "Waiting";
        score = score + 500;
        System.out.println("the score: " + score);
    }

    @FXML
    void AddTask(ActionEvent event) throws IOException {
        System.out.println("the score: " + score);
        String Tname = TaskNameField.getText();
        Task_POJO task = new Task_POJO(0, Tname, score, taskState, USER);
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
        Parent registerParent1 = FXMLLoader.load(getClass().getResource("Tasks.fxml"));
        Scene registerScene1 = new Scene(registerParent1);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(registerScene1);
        window.show();
    }

    public void initData(String userN) {
        USER = userN;
    }
}
