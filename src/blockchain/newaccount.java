package blockchain;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class newaccount {
    private String username;
    private String uniqueid;
    private String password;
    private float balance;


    public newaccount(){
        username="";
        uniqueid="";
        password="";
        balance=0.f;
    }
    public  newaccount(String username,String uniqueid,String password,float balance){
        this.username=username;
        this.uniqueid=uniqueid;
        this.password=password;
        this.balance=balance;
    }
    public newaccount( newaccount obj){
        this.username=obj.getUsername();
        this.uniqueid=obj.getUniqueid();
        this.password=obj.getPassword();
        this.balance=obj.getBalance();
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUniqueid(String uniqueid) {
        this.uniqueid = uniqueid;
    }

    public String getUniqueid() {
        return uniqueid;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public float getBalance() {
        return balance;
    }

    public String toString(){
        String out;
        out=getUsername()+"\t"+getPassword()+"\t"+getBalance();
        return out;
    }

    public  void writetofile(){
        FileWriter file=null;
        try{
            file=new FileWriter(new File("username.txt"),true);
            file.write(getUsername()+"\t"+getUniqueid()+"\t"+getPassword()+"\t"+getBalance()+"\r\n");
        }catch (IOException iox){
            iox.getMessage();
        }finally {
            try{
                file.close();
            }catch (IOException i){
                //
            }
        }
    }

    public void searchfile(String username_sender,String username_re){
        Scanner file=null;
        try{
            file=new Scanner(new File("username.txt"));
            String user,unq,pass;
            String user1="",unq1="",pass1="";
            float sender_bal=0.f,re_bal=0.f;
            while (file.hasNext()){
                user=file.next();
                unq=file.next();
                pass=file.next();
                sender_bal=file.nextFloat();

                user1=file.next();
                pass1=file.next();
                unq1=file.next();
                re_bal=file.nextFloat();

                while(user!=username_sender&&user!=username_re){
                    FileWriter tempfile = null;
                    try {
                        newaccount newaccount = new newaccount();
                        tempfile = new FileWriter(new File("temp.txt"), true);
                        tempfile.write(user+"\t"+pass+"\t"+unq+"\t"+sender_bal+"\r\n");
                        tempfile.write(user1+"\t"+pass1+"\t"+unq1+"\t"+re_bal+"\r\n");
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
            }
        }catch (IOException iox){
            iox.getMessage();
        }finally {
            file.close();
        }

    }

    public static char[] generatepassword(int length) {
        String letter = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghiklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "!@#$%^&*";
        String pwd = letter + numbers + symbols;
        Random r = new Random();
        char[] newPass = new char[length];
        for (int i = 0; i < length; i++) {
            newPass[i] = pwd.charAt(r.nextInt(pwd.length()));
        }
        return newPass;
    }

    public static char[] generateusername(int length) {
        String letter = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghiklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String pwd = letter + numbers;
        Random r = new Random();
        char[] newPass = new char[length];
        for (int i = 0; i < length; i++) {
            newPass[i] = pwd.charAt(r.nextInt(pwd.length()));
        }
        return newPass;
    }
    public  void tepmtofile(){

    }

}

