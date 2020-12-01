/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plantingtask;
import java.util.List;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.hibernate.Query;
import org.hibernate.Session;


public class PlantingTask extends Application {
    
   // ObservableList<Double> obScore;
    @Override
    public void start(Stage stage) throws Exception {
   //     ObservableList<Double> obScore = FXCollections.observableArrayList();
    //    Session session = HibernateUtil.getSessionFactory().openSession();
    //    List<User> sList = null;
    //    String queryStr = "from userinformation";
    //    Query query = session.createQuery(queryStr);
    //    sList = query.list();
    //    session.close();
    //    for(User r: sList)
     //   {
     //       obScore.add(r.getScore());
     //   }
        
        Parent root = FXMLLoader.load(getClass().getResource("WelcomSignINUp.fxml"));
        
      


        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
    }
    
}
