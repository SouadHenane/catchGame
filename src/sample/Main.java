package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Random;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
       // Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Attraper le loup");

        VBox mainVbox = new VBox(6);
        HBox h1 = new HBox(50);

        Label titre = new Label("Attraper le loup");
        titre.setStyle("-fx-alignment: center");
        h1.getChildren().add(titre);
        h1.setStyle("-fx-alignment: center;-fx-padding: 50 0 50 0 ");
        mainVbox.getChildren().add(h1);


        HBox h2 = new HBox(50);
        Label l1 = new Label("Vous êtes le chasseur. Donnez un depart au loup s'il vous plait.");
        TextField tf1 = new TextField();
        Button btn1 = new Button("Commencer");

        h2.setStyle("-fx-alignment: center ");
        h2.getChildren().addAll(l1,tf1,btn1);
        mainVbox.getChildren().add(h2);

        HBox h3 = new HBox(50);
        Label l2 = new Label("Votre pas (1 <= pas <= 10)");
        TextField tf2 = new TextField();
        Button btn2 = new Button("Courrir");
        h3.setStyle("-fx-padding: 20 ");
        h3.getChildren().addAll(l2,tf2,btn2);
        mainVbox.getChildren().add(h3);

        HBox h4 = new HBox(50);
        Label l3 = new Label("Vous");
        ProgressBar pb1 = new ProgressBar(0);

        pb1.prefWidthProperty().bind(h4.widthProperty().subtract(200));
        h4.setStyle("-fx-padding: 20 ");
        h4.getChildren().addAll(l3,pb1);
        mainVbox.getChildren().add(h4);

        HBox h5 = new HBox(50);
        Label l4 = new Label("Loup");
        ProgressBar pb2 = new ProgressBar(0);
        pb2.prefWidthProperty().bind(h5.widthProperty().subtract(200));
        h5.getChildren().addAll(l4,pb2);
        mainVbox.getChildren().add(h5);

        h5.setStyle("-fx-padding: 20 ");

        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                Double vl1 =Double.valueOf(tf1.getText())/100 ;
                pb2.setProgress(vl1);
                btn1.setDisable(true);

            }
        });
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                Double vl1 =Double.valueOf(tf2.getText())/100 ;
                if (vl1 *100 > 10 || vl1 *100 < 1){
                    Alert alert = new Alert(Alert.AlertType.ERROR,"Valeur doit être entre 1 et 10",ButtonType.APPLY);
                    alert.show();
                }else{
                    pb1.setProgress(pb1.getProgress()+vl1);
                    Random rand = new Random();

                    int randomNum = rand.nextInt((10 - 1) + 1) + 1;
                    Double doub=Double.valueOf(randomNum);
                    pb2.setProgress(pb2.getProgress()+doub/100);

                    if (pb1.getProgress()==pb2.getProgress()) {

                        Alert alert = new Alert(Alert.AlertType.INFORMATION,"Vous avez gagné",ButtonType.APPLY);
                        alert.show();
                        pb1.setProgress(0);
                        pb2.setProgress(0);
                        btn1.setDisable(false);



                    }else if (pb2.getProgress()>=1){
                        Alert alert = new Alert(Alert.AlertType.INFORMATION,"Vous avez perdu",ButtonType.APPLY);
                        alert.show();
                        pb1.setProgress(0);
                        pb2.setProgress(0);
                        btn1.setDisable(false);

                    }
                }
            }
        });

      //  mainVbox.setStyle("-fx-alignment: center ");

        Scene mainScene = new Scene(mainVbox, 700, 400);






        primaryStage.setScene(mainScene);
        primaryStage.show();
    }




    public static void main(String[] args) {
        launch(args);
    }
}
