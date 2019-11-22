package sample;

//import com.jfoenix.controls.JFXButton;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import  blockchain.*;
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //primaryStage stage=new primaryStage();
        Parent root = FXMLLoader.load(getClass().getResource("Western Union.fxml"));
        primaryStage.setTitle("Western Union Bitcoin Transfers");
        primaryStage.setScene(new Scene(root));
        root.getStylesheets().add(getClass().getResource("/sample/styles.css").toExternalForm());
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);


        /*Transaction transaction=new Transaction();

        Node test=new Node();

        LinkList test13=new LinkList();
        test13.addToList(new Node(new Transaction()));



        //System.out.println(test13.isEmpty());
        System.out.println(test13.count());
        test13.checksizeoflist();

       // System.out.println(test13.validation(test13));
       */


    }




}
