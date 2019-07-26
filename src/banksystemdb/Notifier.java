package banksystemdb;


import banksystemdb.BankAccount;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ToniGeorge
 */
public abstract class Notifier implements Observer{
    BankAccount bankAccount;
    double account;
    String event;

    public Notifier(BankAccount bankAccount){
        this.bankAccount = bankAccount;
        bankAccount.addObserver(this);
    }

    @Override
    public void update(double account, String event){
        this.account = account;
        this.event = event;
        display();
    }

    public abstract void display();
}
