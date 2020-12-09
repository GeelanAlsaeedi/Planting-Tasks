package plantingtask;

import java.io.*;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.IntegerBinding;
import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Text;
import org.hibernate.*;

public class PlantController implements Initializable {
    
    private String USER;
    
    @FXML
    private TextField scoresTF;
    
    @FXML
    private ImageView textim;
    @FXML
    private ImageView eggImage;
    @FXML
    private ImageView image5;
    @FXML
    private ImageView imagev4;
    @FXML
    private ImageView imagev2;
    @FXML
    private ImageView imagev3;
    @FXML
    private ImageView BaseImage;
    @FXML
    private CheckBox cb1;
    @FXML
    private CheckBox cb2;
    
    @FXML
    private CheckBox cb3;
    
    @FXML
    private CheckBox cb4;
    
    @FXML
    private CheckBox cb5;
    
    @FXML
    private CheckBox cb6;
    
    @FXML
    private Text task1;
    @FXML
    private Text task2;
    @FXML
    private Text task3;
    @FXML
    private Text task4;
    @FXML
    private Text task5;
    @FXML
    private Text task6;
    
    List<Task_POJO> sList = null;
    private Task_POJO taskObj;
    
    private int task1ID;
    private int task2ID;
    private int task3ID;
    private int task4ID;
    private int task5ID;
    private int task6ID;
    
    private int allScore = 0;
    private int taskScore1;
    private int taskScore2;
    private int taskScore3;
    private int taskScore4;
    private int taskScore5;
    private int taskScore6;
    
    int counter = 1;

    //lists
    private ObservableSet<CheckBox> selectedCheckBoxes = FXCollections.observableSet();
    private ObservableSet<CheckBox> unselectedCheckBoxes = FXCollections.observableSet();
    
    private IntegerBinding numCheckBoxesSelected = Bindings.size(selectedCheckBoxes);
    private IntegerBinding numunCheckBoxesSelected = Bindings.size(unselectedCheckBoxes);
    // max number of selecting
    private final int maxNumSelected = 6;

    //First animation
    Image plant2 = new Image("plantOne1@3x.png");
    Image plant3 = new Image("plantOne2@3x.png");
    Image plant4 = new Image("plantOne3@3x.png");
    Image plant5 = new Image("plantOne4@3x.png");
    Image plant6 = new Image("plantOne5@3x.png");
    Image plant7 = new Image("plantOne6@3x.png");
    Image plant8 = new Image("plantOne7@3x.png");

    //Image plant9 = new Image("plantfinalpartTwo2@3x.png");
    //2nd animation
    Image plant9 = new Image("plantOne7@3x.png");
    Image plant10 = new Image("plantanimation2-1@3x.png");
    Image plant11 = new Image("plantanimation2 – 3@3x.png");
    Image plant12 = new Image("plantanimation2 – 4@3x.png");
    Image plant13 = new Image("plantanimation2 – 5@3x.png");
    Image plant14 = new Image("plantanimation2 – 6@3x.png");
    Image plant15 = new Image("plantanimation2 – 7@3x.png");

    //3rd animation
    Image plant16 = new Image("plantanimation2 – 7@3x.png");
    Image plant17 = new Image("plantanimation3 – 1@3x.png");
    Image plant18 = new Image("plantanimation3 – 3@3x.png");
    Image plant19 = new Image("plantanimation3 – 4@3x.png");
    Image plant20 = new Image("plantanimation3 – 5@3x.png");
    Image plant21 = new Image("plantanimation3 – 6@3x.png");
    Image plant22 = new Image("plantanimation3 – 7@3x.png");
    Image plant23 = new Image("plantanimation3 – 8@3x.png");

    //4th animation
    Image plant24 = new Image("plantanimation3 – 8@3x.png");
    Image plant25 = new Image("plantanimation4 – 1@3x.png");
    Image plant26 = new Image("plantanimation4 – 2@3x.png");
    Image plant27 = new Image("plantanimation4 – 3@3x.png");
    Image plant28 = new Image("plantanimation4 – 4@3x.png");
    Image plant29 = new Image("plantanimation4 – 5@3x.png");
    Image plant30 = new Image("plantanimation4 – 6@3x.png");
    Image plant31 = new Image("plantanimation4 – 77@3x.png");

    //5th animation
    Image plant32 = new Image("plantanimation4 – 77@3x.png");
    Image plant33 = new Image("plantanimation5 – 1@3x.png");
    Image plant34 = new Image("plantanimation5 – 2@3x.png");
    Image plant35 = new Image("plantanimation5 – 3@3x.png");
    Image plant36 = new Image("plantanimation5 – 4@3x.png");
    Image plant37 = new Image("plantanimation5 – 5@3x.png");
    Image plant38 = new Image("plantanimation5 – 6@3x.png");
    Image plant39 = new Image("plantanimation5 – 7@3x.png");
    Image plant40 = new Image("plantanimation5 – 8@3x.png");

    //6th animation
    Image plant41 = new Image("plantanimation5 – 8@3x.png");
    Image plant42 = new Image("plantanimation6 – 1@3x.png");
    Image plant43 = new Image("plantanimation6 – 2@3x.png");
    Image plant45 = new Image("plantanimation6 – 3@3x.png");
    Image plant46 = new Image("plantanimation6 – 4@3x.png");
    Image plant47 = new Image("plantanimation6 – 5@3x.png");
    Image plant48 = new Image("plantanimation6 – 6@3x.png");
    Image plant49 = new Image("plantanimation6 – 7@3x.png");
    Image plant50 = new Image("plantanimation6 – 8@3x.png");

    //egg animation
    Image egg6 = new Image("growegg – 5@3x.png");
    
    Image egg7 = new Image("growegg – 4@3x.png");
    
    Image egg8 = new Image("growegg – 3@3x.png");
    
    Image egg9 = new Image("growegg – 2@3x.png");
    
    Image egg10 = new Image("growegg – 1@3x.png");
    
    Image textem = new Image("DID@3x.png");
    
    public void action(ActionEvent event) {
        configureCheckBox(cb1);
        configureCheckBox(cb2);
        configureCheckBox(cb3);
        configureCheckBox(cb4);
        configureCheckBox(cb5);
        configureCheckBox(cb6);
        //cb1.setSelected(true);

        numCheckBoxesSelected.addListener((obs, oldSelectedCount, newSelectedCount) -> {
            
            if (newSelectedCount.intValue() == maxNumSelected) {
                //eggImage.setVisible(true);
                Timeline timeline = new Timeline(
                        new KeyFrame(Duration.ZERO, new KeyValue(BaseImage.imageProperty(), plant41)),
                        new KeyFrame(Duration.seconds(1), new KeyValue(BaseImage.imageProperty(), plant42)),
                        new KeyFrame(Duration.seconds(2), new KeyValue(BaseImage.imageProperty(), plant43)),
                        new KeyFrame(Duration.seconds(3), new KeyValue(BaseImage.imageProperty(), plant45)),
                        new KeyFrame(Duration.seconds(4), new KeyValue(BaseImage.imageProperty(), plant46)),
                        new KeyFrame(Duration.seconds(5), new KeyValue(BaseImage.imageProperty(), plant47)),
                        new KeyFrame(Duration.seconds(6), new KeyValue(BaseImage.imageProperty(), plant48)),
                        new KeyFrame(Duration.seconds(7), new KeyValue(BaseImage.imageProperty(), plant49)),
                        new KeyFrame(Duration.seconds(8), new KeyValue(BaseImage.imageProperty(), plant50)),
                        new KeyFrame(Duration.seconds(9), new KeyValue(BaseImage.imageProperty(), egg6)),
                        new KeyFrame(Duration.seconds(10), new KeyValue(BaseImage.imageProperty(), egg7)),
                        new KeyFrame(Duration.seconds(11), new KeyValue(BaseImage.imageProperty(), egg8)),
                        new KeyFrame(Duration.seconds(12), new KeyValue(BaseImage.imageProperty(), egg9)),
                        new KeyFrame(Duration.seconds(13), new KeyValue(BaseImage.imageProperty(), egg10))
                );
                
                timeline.setCycleCount(1);
                timeline.play();
                timeline.setRate(3);
                textanimation();
                
            }
            
            if (newSelectedCount.intValue() == maxNumSelected - 1) {
                Timeline timeline = new Timeline(
                        new KeyFrame(Duration.ZERO, new KeyValue(BaseImage.imageProperty(), plant32)),
                        new KeyFrame(Duration.seconds(1), new KeyValue(BaseImage.imageProperty(), plant33)),
                        new KeyFrame(Duration.seconds(2), new KeyValue(BaseImage.imageProperty(), plant34)),
                        new KeyFrame(Duration.seconds(3), new KeyValue(BaseImage.imageProperty(), plant35)),
                        new KeyFrame(Duration.seconds(4), new KeyValue(BaseImage.imageProperty(), plant36)),
                        new KeyFrame(Duration.seconds(5), new KeyValue(BaseImage.imageProperty(), plant37)),
                        new KeyFrame(Duration.seconds(6), new KeyValue(BaseImage.imageProperty(), plant38)),
                        new KeyFrame(Duration.seconds(7), new KeyValue(BaseImage.imageProperty(), plant39)),
                        new KeyFrame(Duration.seconds(8), new KeyValue(BaseImage.imageProperty(), plant40))
                );
                timeline.setCycleCount(1);
                timeline.play();
                timeline.setRate(3);
            }
            if (newSelectedCount.intValue() == maxNumSelected - 2) {
                Timeline timeline = new Timeline(
                        new KeyFrame(Duration.ZERO, new KeyValue(BaseImage.imageProperty(), plant24)),
                        new KeyFrame(Duration.seconds(1), new KeyValue(BaseImage.imageProperty(), plant25)),
                        new KeyFrame(Duration.seconds(2), new KeyValue(BaseImage.imageProperty(), plant26)),
                        new KeyFrame(Duration.seconds(3), new KeyValue(BaseImage.imageProperty(), plant27)),
                        new KeyFrame(Duration.seconds(4), new KeyValue(BaseImage.imageProperty(), plant28)),
                        new KeyFrame(Duration.seconds(5), new KeyValue(BaseImage.imageProperty(), plant29)),
                        new KeyFrame(Duration.seconds(6), new KeyValue(BaseImage.imageProperty(), plant30)),
                        new KeyFrame(Duration.seconds(7), new KeyValue(BaseImage.imageProperty(), plant31))
                );
                timeline.setAutoReverse(true);
                timeline.setCycleCount(1);
                timeline.play();
                timeline.setRate(3);
            }
            if (newSelectedCount.intValue() == maxNumSelected - 3) {
                Timeline timeline = new Timeline(
                        new KeyFrame(Duration.ZERO, new KeyValue(BaseImage.imageProperty(), plant16)),
                        new KeyFrame(Duration.seconds(1), new KeyValue(BaseImage.imageProperty(), plant17)),
                        new KeyFrame(Duration.seconds(2), new KeyValue(BaseImage.imageProperty(), plant18)),
                        new KeyFrame(Duration.seconds(3), new KeyValue(BaseImage.imageProperty(), plant19)),
                        new KeyFrame(Duration.seconds(4), new KeyValue(BaseImage.imageProperty(), plant20)),
                        new KeyFrame(Duration.seconds(5), new KeyValue(BaseImage.imageProperty(), plant21)),
                        new KeyFrame(Duration.seconds(6), new KeyValue(BaseImage.imageProperty(), plant22)),
                        new KeyFrame(Duration.seconds(7), new KeyValue(BaseImage.imageProperty(), plant23))
                );
                timeline.setAutoReverse(true);
                timeline.setCycleCount(1);
                timeline.play();
                timeline.setRate(3);
                
            }
            if (newSelectedCount.intValue() == maxNumSelected - 4) {
                Timeline timeline = new Timeline(
                        new KeyFrame(Duration.ZERO, new KeyValue(BaseImage.imageProperty(), plant9)),
                        new KeyFrame(Duration.seconds(1), new KeyValue(BaseImage.imageProperty(), plant10)),
                        new KeyFrame(Duration.seconds(2), new KeyValue(BaseImage.imageProperty(), plant11)),
                        new KeyFrame(Duration.seconds(3), new KeyValue(BaseImage.imageProperty(), plant12)),
                        new KeyFrame(Duration.seconds(4), new KeyValue(BaseImage.imageProperty(), plant13)),
                        new KeyFrame(Duration.seconds(5), new KeyValue(BaseImage.imageProperty(), plant14)),
                        new KeyFrame(Duration.seconds(6), new KeyValue(BaseImage.imageProperty(), plant15))
                );
                timeline.setAutoReverse(true);
                timeline.setCycleCount(1);
                timeline.play();
                timeline.setRate(3);
            }
            if (newSelectedCount.intValue() == maxNumSelected - 5) {
                Timeline timeline = new Timeline(
                        new KeyFrame(Duration.ZERO, new KeyValue(BaseImage.imageProperty(), plant2)),
                        new KeyFrame(Duration.seconds(1), new KeyValue(BaseImage.imageProperty(), plant3)),
                        new KeyFrame(Duration.seconds(2), new KeyValue(BaseImage.imageProperty(), plant4)),
                        new KeyFrame(Duration.seconds(3), new KeyValue(BaseImage.imageProperty(), plant5)),
                        new KeyFrame(Duration.seconds(4), new KeyValue(BaseImage.imageProperty(), plant6)),
                        new KeyFrame(Duration.seconds(5), new KeyValue(BaseImage.imageProperty(), plant7)),
                        new KeyFrame(Duration.seconds(6), new KeyValue(BaseImage.imageProperty(), plant8))
                );
                timeline.setAutoReverse(true);
                timeline.setCycleCount(1);
                timeline.play();
                timeline.setRate(3);
                
            }
        });// end of the addLitener

        if (cb1.isSelected()) {
            scoresTF.setText(Integer.toString(allScore));
            allScore = allScore + taskScore1;
            storeOverallScore();
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            taskObj = (Task_POJO) session.get(Task_POJO.class, task1ID);
            taskObj.setIsDone("Done!");
            session.getTransaction().commit();
            session.close();
        }
        if (cb2.isSelected()) {
            scoresTF.setText(Integer.toString(allScore));
            allScore = allScore + taskScore2;
            storeOverallScore();
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            taskObj = (Task_POJO) session.get(Task_POJO.class, task2ID);
            taskObj.setIsDone("Done!");
            session.getTransaction().commit();
            session.close();
        }
        if (cb3.isSelected()) {
            scoresTF.setText(Integer.toString(allScore));
            allScore = allScore + taskScore3;
            storeOverallScore();
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            taskObj = (Task_POJO) session.get(Task_POJO.class, task3ID);
            taskObj.setIsDone("Done!");
            session.getTransaction().commit();
            session.close();
        }
        if (cb4.isSelected()) {
            scoresTF.setText(Integer.toString(allScore));
            allScore = allScore + taskScore4;
            storeOverallScore();
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            taskObj = (Task_POJO) session.get(Task_POJO.class, task4ID);
            taskObj.setIsDone("Done!");
            session.getTransaction().commit();
            session.close();
        }
        if (cb5.isSelected()) {
            scoresTF.setText(Integer.toString(allScore));
            allScore = allScore + taskScore5;
            storeOverallScore();
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            taskObj = (Task_POJO) session.get(Task_POJO.class, task5ID);
            taskObj.setIsDone("Done!");
            session.getTransaction().commit();
            session.close();
        }
        if (cb6.isSelected()) {
            scoresTF.setText(Integer.toString(allScore));
            allScore = allScore + taskScore6;
            storeOverallScore();
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            taskObj = (Task_POJO) session.get(Task_POJO.class, task6ID);
            taskObj.setIsDone("Done!");
            session.getTransaction().commit();
            session.close();
        }
    }
    
    void textanimation() {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(2), new KeyValue(textim.imageProperty(), textem))
        );
        timeline.setAutoReverse(true);
        timeline.setCycleCount(1);
        timeline.play();
        timeline.setRate(3);
        sounds();
    }
    
    private void configureCheckBox(CheckBox checkBox) {
        
        checkBox.selectedProperty().addListener((obs, wasSelected, isNowSelected) -> {
            if (isNowSelected) {
                unselectedCheckBoxes.remove(checkBox);
                selectedCheckBoxes.add(checkBox);
            } else {
                selectedCheckBoxes.remove(checkBox);
                unselectedCheckBoxes.add(checkBox);
            }
            
        });
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    void sounds() {
        
        AudioClip clip = new AudioClip(this.getClass().getResource("app-29.wav").toString());
        clip.play();
    }
    
    public void initData(String userN) {
        USER = userN;
        //set tasks' names beside checkboxes
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        String queryStr = "from Task_POJO";
        Query query = session.createQuery(queryStr);
        sList = query.list();
        
        int count = 0;
        for (Task_POJO s : sList) {
            
            if (USER.equals(s.getUserName()) && "Today".equals(s.getTaskState()) && "not done".equals(s.getIsDone()) && s.getTaskName() != null && count <= 6) {
                count++;
                
                if (task1.getText().isEmpty()) {
                    task1.setText(s.getTaskName());
                    task1ID = s.getTaskID();
                    taskScore1 = s.getTaskScore();
                } else if (task2.getText().isEmpty()) {
                    task2.setText(s.getTaskName());
                    task2ID = s.getTaskID();
                    taskScore2 = s.getTaskScore();
                } else if (task3.getText().isEmpty()) {
                    task3.setText(s.getTaskName());
                    task3ID = s.getTaskID();
                    taskScore3 = s.getTaskScore();
                } else if (task4.getText().isEmpty()) {
                    task4.setText(s.getTaskName());
                    task4ID = s.getTaskID();
                    taskScore4 = s.getTaskScore();
                } else if (task5.getText().isEmpty()) {
                    task5.setText(s.getTaskName());
                    task5ID = s.getTaskID();
                    taskScore5 = s.getTaskScore();
                } else {
                    task6.setText(s.getTaskName());
                    task6ID = s.getTaskID();
                    taskScore6 = s.getTaskScore();
                }
            }
        }
        session.getTransaction().commit();
        session.close();
    }
    
    @FXML
    void backtotask(ActionEvent event) throws IOException {
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
    
    private String toString(int taskScore1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void storeOverallScore() {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        User user = (User) session.get(User.class, USER);
        int Score = allScore + user.getScore();
        user.setScore(Score);
        session.getTransaction().commit();
        session.close();
        
    }    
    
}
