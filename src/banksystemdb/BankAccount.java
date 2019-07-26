package banksystemdb;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ToniGeorge
 */
import java.util.ArrayList;

public class BankAccount implements Observable{
    private static BankAccount uniqueInstance;

    private ArrayList<Observer> observers;
    private double account;
    public String owner;
    public double amount;
    public double balance;
    public String event;
    public String ID;
    
    


    private BankAccount(String owner, String ID, double balance){
        this.owner = owner;
        this.balance = balance;
        this.ID = ID;

        observers = new ArrayList<>();
    }
    

    public static BankAccount getInstance(String owner, String ID, double balance){
//        for(int i =0; i<BankSystemDB.bankAccountList.size(); i++){
//            if(!(ID.equals(BankSystemDB.bankAccountList.get(i).ID))){
//                uniqueInstance = null;
//            }
//        }
        BankProxy proxy = new BankProxy(ID);

        if(proxy.uniqueId(ID)){
                uniqueInstance = null;
        }
        if(uniqueInstance == null){
            uniqueInstance = new BankAccount(owner,ID, balance);
            SmsNotifier smsNotifier = new SmsNotifier(uniqueInstance);
            EmailNotifier emailNotifier = new EmailNotifier(uniqueInstance);
            proxy.AddAccount(uniqueInstance);
        }
        return uniqueInstance;
    }


    


    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers){
            o.update(account, event);
        }
    }

    public void statusChanged(){
        notifyObservers();
    }
    public void performTransaction(String transactionType,double amount){
        if(transactionType.equalsIgnoreCase("Withdraw")){
            withdraw(amount);
        }else credit(amount);
    }

    public void withdraw(double amount){
        this.amount = amount;
        if((balance - amount) > 0){
            balance -= amount;
            this.event = "Withdraw";
            statusChanged();
        }
        else{
            System.out.println("You cannot withdraw!");
            System.out.println("");
        }
    }

    public void credit(double amount){
        this.amount = amount;
        balance += amount;
        this.event = "Credit";
        statusChanged();
    }
}

    

    