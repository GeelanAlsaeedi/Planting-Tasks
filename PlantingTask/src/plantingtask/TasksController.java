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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
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

    @FXML
    private TextField TotalScore;

        @FXML
    private ListView<?> AllTasks;

    @FXML
    private ListView<?> TodayTasks;

    @FXML
    private ListView<?> Processing;
    
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
        Parent registerParent1 = FXMLLoader.load(getClass().getResource("Plant.fxml"));
        Scene registerScene1 = new Scene(registerParent1);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(registerScene1);
        window.show();
    }

    public void initData(String userN) {
        USER = userN;
        System.out.println("userName is " + USER + userN);
        Score();
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Score();
    }

}
