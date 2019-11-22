package sample;

import blockchain.Date;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;
import java.util.Random;
import java.util.Scanner;
import blockchain.*;

import javax.swing.*;

import static blockchain.newaccount.generatepassword;
import static blockchain.newaccount.generateusername;

import java.util.*;

public class Controller {
    @FXML
    private Button Login;
    @FXML
    private Button createnewaccount;
    @FXML
    private Label show;
    @FXML
    private Label status;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    @FXML
    private TextArea view;

    @FXML
    private TextField Receiver;

    @FXML
    private TextField Transaction;


    public void newaccount(ActionEvent event) throws Exception {
        newaccount newaccount1 = new newaccount();

        newaccount1.setUsername(String.valueOf(generateusername(10)));
        newaccount1.setPassword(String.valueOf(generatepassword(8)));
        newaccount1.setUniqueid(String.valueOf(generatepassword(10)));
        newaccount1.setBalance(500.f);
        newaccount1.writetofile();
        status.setText("Username,Password and Balance is:\t" + newaccount1.toString());
    }

    public void Loginwindow(ActionEvent event) throws Exception {
        Stage primaryStages = new Stage();
        primaryStages.setTitle("Western Union Bitcoin Transfers");
        Parent root = FXMLLoader.load(getClass().getResource("login window.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        primaryStages.setScene(scene);
        primaryStages.show();
        handleCloseButtonAction();
    }

    public void handleCloseButtonAction() {
        Stage stage = (Stage) Login.getScene().getWindow();
        stage.close();
    }

    public void Loginvalidation(ActionEvent event) throws Exception {

        Scanner file = null;
        try {
            file = new Scanner(new File("username.txt"));
            String username_from_file = "";
            String password_from_file = "";
            String uniq = "";
            float balance_from_file;
            boolean found = false;
            while (file.hasNext()) {
                username_from_file = file.next();//gets the username from the file
                password_from_file = file.next();//gets the password from the file
                uniq = file.next();
                balance_from_file = file.nextFloat();//gets the balance from the file


                String user = "";
                String pass = "";
                user = username.getText();//gets the username from the text field
                pass = password.getText();//gets the username from the password field
                if (username.getText().equals("") || password.getText().equals("")) {
                    System.out.println("Error.No Fields should be left empty");
                    break;
                } else if (username_from_file.equals(user) && password_from_file.equals(pass)) {
                    found = true;
                    Stage primaryStage = new Stage();
                    Parent root = FXMLLoader.load(getClass().getResource("Account Transaction window.fxml"));
                    Scene scene = new Scene(root);
                    scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
                    primaryStage.setTitle("Western Union Bitcoin Transfers");
                    primaryStage.setScene(scene);
                    primaryStage.show();
                    handleCloseButtonAction();
                    break;
                }
            }
        } catch (IOException ioex) {
            ioex.getMessage();
        } finally {
            file.close();
        }
    }

    public void ViewAccountinfowindow(ActionEvent event) throws Exception {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("viewaccountinfo.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Western Union Bitcoin Transfers");
        primaryStage.show();
    }

    public void View_Transaction_receive_window(ActionEvent event) throws Exception {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Transaction Receive Window.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Western Union Bitcoin Transfers");
        primaryStage.show();

    }
    public void sent_window(ActionEvent event) throws Exception {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Transaction Receive sent.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Western Union Bitcoin Transfers");
        primaryStage.show();

    }


    public void ViewAccounts(ActionEvent event) {
        Scanner file = null;
        //  view.appendText("Username\t\t"+"Unique id"+"\t\t"+ "Password\t\t" +"Balance\n");
        try {
            if (password.getText().equals("")) {
                System.out.println("Error.password field is blank;");
            } else {
                file = new Scanner(new File("username.txt"));
                String username_from_file;
                String pass_from_file, unique_id_from_file;
                float balance_from_file;

                while (file.hasNext()) {
                    username_from_file = file.next();
                    pass_from_file = file.next();
                    unique_id_from_file = file.next();
                    balance_from_file = file.nextFloat();
                    if (password.getText().equals(pass_from_file)) {
                        view.appendText(username_from_file + "\t\t" + pass_from_file + "\t\t" + unique_id_from_file + "\t\t" + balance_from_file + "\n");
                        break;

                    }
                }
            }
        } catch (IOException io) {
            io.getMessage();
        } finally {
            file.close();
        }
    }

    public void Remittancetool(ActionEvent event) throws Exception {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Remittance Tool.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        primaryStage.setTitle("Western Union Bitcoin Transfers");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void MoneyTransaction() {
        boolean wrtietofile = false;
        Scanner file = null;
        try {
            file = new Scanner(new File("username.txt"));
            String username_for_sender = "";
            String password_for_sender = "";
            String id_for_sender = "";
            float balaance_for_sender = 0.f;

            String username_for_receiver = "";
            String password_for_receiver = "";
            String id_for_receiver = "";
            float balaance_for_receiver = 0.f;

            while (file.hasNext()){
                System.out.println("a");
                username_for_sender = file.next();//gets the senders username from the file
                password_for_sender = file.next();//gets the sender password from the file
                id_for_sender = file.next();//gets the senders unique id from the file
                balaance_for_sender = file.nextFloat();//gets the senders balance from the file

                username_for_receiver = file.next();//gets the receivers username from the file
                password_for_receiver = file.next();//gets the receivers password from the file
                id_for_receiver = file.next();//gets the receivers unique id from the file
                balaance_for_receiver = file.nextFloat();//gets the receivers balance from the file
                if (username.getText().equals("") || Receiver.getText().equals("")) {
                    System.out.println("Error. No Fields should be left empty");
                    break;
                } else {
                    if (IfExist(username_for_sender) && IfExist(username_for_receiver)) {
                        balaance_for_sender = (balaance_for_sender - 1) - Float.valueOf(Transaction.getText());
                        balaance_for_receiver = balaance_for_receiver + Float.valueOf(Transaction.getText());
                        System.out.println(balaance_for_sender + "\t" + balaance_for_receiver);
                        System.out.println("Transaction was Successful between:" + username.getText() + "\t\t" + "and" + "\t\t" + Receiver.getText());
                        blockchain.Transaction newTranaction = new Transaction();
                        newTranaction.setTransaction_hash("1002");
                        newTranaction.setSender(username_for_sender);
                        newTranaction.setSender_amount(balaance_for_sender);
                        newTranaction.setReceiver(username_for_receiver);
                        newTranaction.setAmount(balaance_for_receiver);
                        newTranaction.setDate(new Date(1, 1, 17));
                        newTranaction.setStatus("Good to good");
                        newTranaction.writetofile();
                        Writeto_Transaction_sent_receive_file(newTranaction);
                        wrtietofile = true;
                        while (username.getText().equals(username_for_sender)&&Receiver.getText().equals(username_for_receiver)) {
                            FileWriter tempfile = null;
                            try {
                                newaccount newaccount = new newaccount();
                                tempfile = new FileWriter(new File("temp.txt"), true);
                                tempfile.write(username_for_sender + "\t" + password_for_sender + "\t" + id_for_sender + "\t" + balaance_for_sender + "\r\n");
                                tempfile.write(username_for_receiver + "\t" + password_for_receiver + "\t" + id_for_receiver + "\t" + balaance_for_receiver + "\r\n");
                                newaccount.searchfile(username.getText(),Receiver.getText());
                                break;
                            } catch (IOException iox) {
                                iox.getMessage();
                            } finally {
                                try {
                                    tempfile.close();
                                } catch (IOException io) {
                                    io.printStackTrace();
                                }
                            }
                        }
                        break;
                    } else {
                        System.out.println("Error");
                    }

                }

            }
        } catch (IOException ex) {
            ex.getMessage();
        } finally {
            file.close();
        }

    }

    private boolean IfExist(String username) {
        boolean exist = false;
        Scanner file = null;
        String a, b, c;
        float d;
        try {
            file = new Scanner(new File("username.txt"));
            while (file.hasNext()) {
                a = file.next();
                b = file.next();
                c = file.next();
                d = file.nextFloat();
                if (a.equals(username)) {
                    exist = true;
                    break;
                }
            }
        } catch (Exception ex) {
        } finally {
            file.close();
        }
        return exist;
    }

    public void ViewTransaction_sent() {
        Scanner file=null;
            try {
                file=new Scanner(new File("transactionsent.txt"));
                while (file.hasNext()){
                    String transh_has=file.next();
                    String sender_username=file.next();
                    float sender_bal=file.nextFloat();
                    String Receiver_username=file.next();
                    float Receiver_bal=file.nextFloat();
                    if(username.getText().equals("")){
                        view.appendText("Error.no Field should be left empty.");
                    }else {
                        while (username.equals(username.getText())) {
                            view.appendText(sender_username + "\t" + sender_bal + "\n\n");
                            break;
                        }
                    }
                }
            }catch (IOException io){
                io.printStackTrace();
            }finally {
                file.close();
            }
    }

    public Transaction Writeto_Transaction_sent_receive_file(Transaction obj) {
        FileWriter file = null;
        try {
            file = new FileWriter(new File("transactionsent.txt"), true);
            file.write(obj.getTransaction_hash() + "\t" + obj.getSender() + "\t" + Transaction.getText() + "\t" + obj.getReceiver() + "\t" + Transaction.getText() + "\r\n");
        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            try {
                file.close();
            } catch (IOException i) {
                //
            }
        }
        return obj;
    }
    public void ViewTransaction_receive() {
        Scanner file=null;
        try {
            file=new Scanner(new File("transactionsent.txt"));
            while (file.hasNext()){
                String transh_has=file.next();
                String sender_username=file.next();
                float sender_bal=file.nextFloat();
                String Receiver_username=file.next();
                float Receiver_bal=file.nextFloat();
                if(Receiver.getText().equals("")){
                    view.appendText("Error.no Field should be left empty.");
                }else {
                    while (Receiver_username.equals(Receiver.getText())) {
                        view.appendText(sender_username + "\t" + sender_bal + "\n\n");
                        break;
                    }
                }
            }
        }catch (IOException io){
            io.printStackTrace();
        }finally {
            file.close();
        }
    }



}


