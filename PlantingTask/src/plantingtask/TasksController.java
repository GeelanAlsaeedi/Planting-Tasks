/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plantingtask;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * FXML Controller class
 *
 * @author Joman
 */
public class TasksController implements Initializable {

    private int UserTotalScore;
    private String USER;
    public ObservableList<String> OBLTodayTask;
    public ObservableList<String> OBLWaitngTask;
    public ObservableList<String> OBLAllTask;

    @FXML
    private TextField TotalScore;

    @FXML
    private ListView<String> AllTasks;

    @FXML
    private ListView<String> TodayTasks;

    @FXML
    private ListView<String> Processing;

    @FXML
    void backtowelcome(ActionEvent event) throws IOException {
        Parent registerParent1 = FXMLLoader.load(getClass().getResource("WelcomSignINUp.fxml"));

        Scene registerScene1 = new Scene(registerParent1);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(registerScene1);
        window.show();
    }

    @FXML
    void toaddtask(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("AddTasks.fxml"));
        Parent registerParent1 = loader.load();
        Scene WelcomeScene = new Scene(registerParent1);
        //access the controller and call a method
        AddTasksController controller = loader.getController();
        controller.initData(USER);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(WelcomeScene);
        window.show();
    }

    @FXML
    void toplant(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Plant.fxml"));
        Parent plantPage = loader.load();
        Scene WelcomeScene = new Scene(plantPage);
        //access the controller and call a method
        PlantController controller = loader.getController();
        controller.initData(USER);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(WelcomeScene);
        window.show();
        
    }

    public void initData(String userN) {
        USER = userN;
        System.out.println("userName is " + USER + userN);
        TodayTasks();
        Score();
        Processing();
        All();
    }

    public void Score() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session = HibernateUtil.getSessionFactory().openSession();
        List<User> userList = null;
        String queryStr = "from User";
        Query query = session.createQuery(queryStr);
        userList = query.list();
        session.close();
        for (User u : userList) {
            if (u.getUserName().equals(USER)) {
                UserTotalScore = u.getScore();
                System.out.println(UserTotalScore + " ");
            }
        }
        TotalScore.setText(UserTotalScore + " ");
    }

    public void TodayTasks() {
        OBLTodayTask = FXCollections.observableArrayList();
        TodayTasks.setItems(OBLTodayTask);
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Task_POJO> sList = null;
        String queryStr = "from Task_POJO";
        Query query = session.createQuery(queryStr);
        sList = query.list();
        session.close();
        for (Task_POJO s : sList) {
            if (USER.equals(s.getUserName()) && "Today".equals(s.getTaskState()) && "not done".equals(s.getIsDone())) {
                OBLTodayTask.add(s.getTaskName());
            }
        }
    }

    public void Processing() {
        OBLWaitngTask = FXCollections.observableArrayList();
        Processing.setItems(OBLWaitngTask);
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Task_POJO> sList = null;
        String queryStr = "from Task_POJO";
        Query query = session.createQuery(queryStr);
        sList = query.list();
        session.close();
        for (Task_POJO s : sList) {
            if (USER.equals(s.getUserName()) && "Waiting".equals(s.getTaskState()) && "not done".equals(s.getIsDone())) {
                OBLWaitngTask.add(s.getTaskName());
            }
        }
    }

    public void All() {
        OBLAllTask = FXCollections.observableArrayList();
        AllTasks.setItems(OBLAllTask);
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Task_POJO> sList = null;
        String queryStr = "from Task_POJO";
        Query query = session.createQuery(queryStr);
        sList = query.list();
        session.close();
        for (Task_POJO s : sList) {
            if (USER.equals(s.getUserName()) && "All".equals(s.getTaskState()) && "not done".equals(s.getIsDone())) {
                OBLAllTask.add(s.getTaskName());
            }
        }
    }
    
     @FXML
    void fromProcesstoTodyTasks(ActionEvent event) {
      String str =Processing.getSelectionModel().getSelectedItem();
      if(str != null){
            Processing.getSelectionModel().clearSelection();
            OBLWaitngTask.remove(str);
            OBLTodayTask.add(str);
        }
         Session session = HibernateUtil.getSessionFactory().openSession();
         session.beginTransaction();
         List<Task_POJO> sList = null;
         String queryStr = "from Task_POJO";
         Query query = session.createQuery(queryStr);
         sList = query.list();
         
        for (Task_POJO s : sList) {
            if (USER.equals(s.getUserName()) && "Waiting".equals(s.getTaskState()) && str.equals(s.getTaskName())) {
                s.setTaskState("Today");
                session.update(s);
                session.getTransaction().commit();
                session.close();
                break;
            }
        }
    }
    @FXML
    void toAllTasks(ActionEvent event) {
      String str =TodayTasks.getSelectionModel().getSelectedItem();
      if(str != null){
            TodayTasks.getSelectionModel().clearSelection();
            OBLTodayTask.remove(str);
            OBLAllTask.add(str);
        }
        Session session = HibernateUtil.getSessionFactory().openSession();
         session.beginTransaction();
         List<Task_POJO> sList = null;
         String queryStr = "from Task_POJO";
         Query query = session.createQuery(queryStr);
         sList = query.list();
         
        for (Task_POJO s : sList) {
            if (USER.equals(s.getUserName()) && "Today".equals(s.getTaskState()) && str.equals(s.getTaskName())) {
                s.setTaskState("All");
                session.update(s);
                session.getTransaction().commit();
                session.close();
                break;
            }
        }
    }
    @FXML
    void fromAllToTodayTasks(ActionEvent event) {
      String str =AllTasks.getSelectionModel().getSelectedItem();
      if(str != null){
            AllTasks.getSelectionModel().clearSelection();
            OBLAllTask.remove(str);
            OBLTodayTask.add(str);
        }
        Session session = HibernateUtil.getSessionFactory().openSession();
         session.beginTransaction();
         List<Task_POJO> sList = null;
         String queryStr = "from Task_POJO";
         Query query = session.createQuery(queryStr);
         sList = query.list();
         
        for (Task_POJO s : sList) {
            if (USER.equals(s.getUserName()) && "All".equals(s.getTaskState()) && str.equals(s.getTaskName())) {
                s.setTaskState("Today");
                session.update(s);
                session.getTransaction().commit();
                session.close();
                break;
            }
        }
    }
    
    @FXML
    void toProcessingTasks(ActionEvent event) {
      String str =TodayTasks.getSelectionModel().getSelectedItem();
      if(str != null){
            TodayTasks.getSelectionModel().clearSelection();
            OBLTodayTask.remove(str);
            OBLWaitngTask.add(str);
        }
      Session session = HibernateUtil.getSessionFactory().openSession();
         session.beginTransaction();
         List<Task_POJO> sList = null;
         String queryStr = "from Task_POJO";
         Query query = session.createQuery(queryStr);
         sList = query.list();
         
        for (Task_POJO s : sList) {
            if (USER.equals(s.getUserName()) && "Today".equals(s.getTaskState()) && str.equals(s.getTaskName())) {
                s.setTaskState("Waiting");
                session.update(s);
                session.getTransaction().commit();
                session.close();
                break;
            }
        }
    }
    
    @FXML
    void allTaskLV(KeyEvent event) {
        String str =AllTasks.getSelectionModel().getSelectedItem();
        
        Session session = HibernateUtil.getSessionFactory().openSession();
         session.beginTransaction();
         List<Task_POJO> sList = null;
         String queryStr = "from Task_POJO";
         Query query = session.createQuery(queryStr);
         sList = query.list();
         
        if(event.getCode()==KeyCode.RIGHT && str!= null){
    
            AllTasks.getSelectionModel().clearSelection();
            OBLAllTask.remove(str);
            OBLTodayTask.add(str);
           
           for (Task_POJO s : sList) {
            if (USER.equals(s.getUserName()) && "All".equals(s.getTaskState()) && str.equals(s.getTaskName())) 
            {   s.setTaskState("Today");
                session.update(s);
                session.getTransaction().commit();
                session.close();
                break;
            }
           }
        }
        AllTasks.requestFocus();
    }
    
    @FXML
    void todayLV(KeyEvent event) {
        String str =TodayTasks.getSelectionModel().getSelectedItem();
        
        Session session = HibernateUtil.getSessionFactory().openSession();
         session.beginTransaction();
         List<Task_POJO> sList = null;
         String queryStr = "from Task_POJO";
         Query query = session.createQuery(queryStr);
         sList = query.list();
         
        if(event.getCode()==KeyCode.LEFT && str!= null){
    
            TodayTasks.getSelectionModel().clearSelection();
            OBLTodayTask.remove(str);
            OBLAllTask.add(str);
           
           for (Task_POJO s : sList) {
            if (USER.equals(s.getUserName()) && "Today".equals(s.getTaskState()) && str.equals(s.getTaskName())) 
            {   s.setTaskState("All");
                session.update(s);
                session.getTransaction().commit();
                session.close();
                break;
            }
           }
        }
        if(event.getCode()==KeyCode.RIGHT && str!= null){
    
            TodayTasks.getSelectionModel().clearSelection();
            OBLTodayTask.remove(str);
            OBLWaitngTask.add(str);
           
           for (Task_POJO s : sList) {
            if (USER.equals(s.getUserName()) && "Today".equals(s.getTaskState()) && str.equals(s.getTaskName())) 
            {   s.setTaskState("Waiting");
                session.update(s);
                session.getTransaction().commit();
                session.close();
                break;
            }
           }
        }
        
        TodayTasks.requestFocus();
    }
    
    @FXML
    void processingLV(KeyEvent event) {
        String str =Processing.getSelectionModel().getSelectedItem();
        
        Session session = HibernateUtil.getSessionFactory().openSession();
         session.beginTransaction();
         List<Task_POJO> sList = null;
         String queryStr = "from Task_POJO";
         Query query = session.createQuery(queryStr);
         sList = query.list();
         
        if(event.getCode()==KeyCode.LEFT && str!= null){
    
            Processing.getSelectionModel().clearSelection();
            OBLWaitngTask.remove(str);
            OBLTodayTask.add(str);
           
           for (Task_POJO s : sList) {
            if (USER.equals(s.getUserName()) && "Waiting".equals(s.getTaskState()) && str.equals(s.getTaskName())) 
            {   s.setTaskState("Today");
                session.update(s);
                session.getTransaction().commit();
                session.close();
                break;
            }
           }
        }
        Processing.requestFocus();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
