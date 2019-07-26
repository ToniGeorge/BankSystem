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
public class EmailNotifier extends Notifier {

    public EmailNotifier(BankAccount bankAccount) {
        super(bankAccount);
    }

    @Override
    public void display(){
        System.out.println("Sending Email to " + bankAccount.owner);

        if(event.equals("Withdraw")){
            System.out.println("Withdrawal operation is successful. Withdrawal amount is " + bankAccount.amount + "$");
        }
        else if(event.equals("Credit")){
            System.out.println("Investment operation is successful. Investment amount is " + bankAccount.amount + "$");
        }

        System.out.println("The amount of your account is " + bankAccount.balance + "$");
        System.out.println("");
    }
}

