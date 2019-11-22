package blockchain;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Transaction  {
    private String transaction_hash;
    private String sender;
    private Float sender_amount;
    private String receiver;
    private Float receiver_amount;
    private Date date;
    private String status;

    public Transaction()throws InputMismatchException{
        this.transaction_hash="";
        this.sender="";
        this.sender_amount=0.f;
        this.receiver="";
        this.receiver_amount=0.0f;
        this.date=date;
        this.status=status;
    }
    public Transaction(String transaction_hash, String sender, Float sender_amount,String reciever, Float amount, Date date, String status)throws InputMismatchException{
        this.transaction_hash=transaction_hash;
        this.sender=sender;
        this.sender_amount=sender_amount;
        this.receiver=reciever;
        this.receiver_amount=amount;
        this.sender_amount=sender_amount;
        this.date=date;
        this.status=status;
    }
    public Transaction(Transaction obj)throws InputMismatchException{
        transaction_hash=obj.getTransaction_hash();
        sender=obj.getSender();
        sender_amount=obj.getSender_amount();
        receiver=obj.getReceiver();
        receiver_amount=obj.getAmount();
        date=obj.getDate();
        status=obj.getStatus();
        sender_amount=obj.getSender_amount();
    }

    public void setTransaction_hash(String transaction_hash) {
        this.transaction_hash = transaction_hash;
    }

    public String getTransaction_hash() {
        return transaction_hash;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getSender() {
        return sender;
    }
    public void setDate(Date date){
        this.date=date;
    }
    public Date getDate() {
        return date;
    }

    public void setAmount(Float amount) {
        this.receiver_amount = amount;
    }

    public Float getAmount() {
        return receiver_amount;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public float getSender_amount() {
        return sender_amount;
    }

    public void setSender_amount(float sender_amount) {
        this.sender_amount = sender_amount;
    }

    public String toString(){
        String out;
        out=getTransaction_hash()+"\t"+getSender()+"\t"+getAmount()+"\t"+getDate().getDay()+"\t"+getDate().getMonth()+"\t"+getDate().getYear()+"\t"+getStatus();
        return out;
    }

    public void  writetofile(){
        FileWriter file=null;
        try{
            file=new FileWriter(new File("transaction-db.txt"),true);
            file.write(getTransaction_hash()+"\t"+getSender()+"\t"+getSender_amount()+"\t"+getReceiver()+"\t"+getAmount()+"\t"+getDate().getDay()+"\t"+getDate().getMonth()+"\t"+getDate().getYear()+"\t"+getStatus()+"\t"+"\r\n");
        }catch (IOException ioex){
            ioex.printStackTrace();
        }finally {
            try{
                file.close();
            }catch (IOException io){
                //
            }
        }
    }
    public void searchfile(String searchid){
        Scanner file=null;
        String trans_hash,sender,status,receiver;
        Float amount,r_amount;
        Date date=new Date();
        try{
            file=new Scanner(new File("transaction.txt"));
            while (file.hasNext()){
                trans_hash=file.next();
                sender=file.next();
                status=file.next();
                receiver=file.next();
                amount=file.nextFloat();
                date.setDay(file.nextInt());
                date.setMonth(file.nextInt());
                date.setYear(file.nextInt());
                r_amount= file.nextFloat();
                if(searchid==trans_hash){
                    Transaction trans=new Transaction(trans_hash,sender,r_amount,receiver,amount,date,status);
                    break;
                }
            }
        }catch (IOException ioex){
            ioex.printStackTrace();
        }finally {
            file.close();
        }
    }
    public void money(){


    }
}
