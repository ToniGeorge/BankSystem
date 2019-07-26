/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package banksystemdb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author ToniGeorge
 */
public class BankSystemDB {

    /**
     * @param args the command line arguments
     */
//    static ArrayList <BankAccount> bankAccountList = new ArrayList<BankAccount>();

    private static BankProxy bank,bank2;
    public static void main(String[] args) {
        // TODO code application logic here
        
        

            


        Scanner scanner = new Scanner(System.in);
        String answer = null;
        
       
        
//        LoanApprover A = new Manager();
//        LoanApprover B = new ZonalManager();
//        LoanApprover C = new HeadOffice();
//        A.SetNextApprover(B);
//        B.SetNextApprover(C);
//        A.ApproveLoan(new Loan(500000));  
//        A.ApproveLoan(new Loan(500000));  
//        A.ApproveLoan(new Loan(500000));  
        
        BankAccount bankAccount2 = BankAccount.getInstance("Mirna","900",120000);

        BankAccount bankAccount3 = BankAccount.getInstance("Toni","1900",120000);

   
        BankAccount bankAccount4 = BankAccount.getInstance("tom","1800",220000);

        System.out.println("Welcome if you already have an account press 0 ");
        System.out.println("Welcome if you don't have one press 1 ");
        int x = scanner.nextInt();
        if(x==0){
            System.out.println("Please enter your ID");
            String ID = scanner.next();
            bank= new BankProxy(ID);
            BankAccount Bk = bank.searchForAccount(ID); 
            bank.getLoan(Bk, 500000);

            if(Bk==null){
                System.out.println("There is no UserID like that");
                
            }else {
//            System.out.println(Bk.owner);
                while (true){
                    System.out.println("Welcome " +  Bk.owner + " to Java Bank!");
                    System.out.println("Which operation do you want to do?");
                    System.out.println("(1) Withdrawal Operation");
                    System.out.println("(2) Credit Operation");
                    System.out.println("(Other) Exit");

                    int a = scanner.nextInt();
                    if(a == 1){
                        System.out.println("Your balance is " + Bk.balance + "$");
                        System.out.println("How many money do you want to withdraw?");

                        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
                        try {
                            answer = input.readLine();

                            double withdraw_amount = Double.parseDouble(answer);
                            Bk.withdraw(withdraw_amount);

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    else if(a == 2){
                        System.out.println("Your balance is " + Bk.balance + "$");
                        System.out.println("How many mone do you want to credit?");

                        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
                        try {
                            answer = input.readLine();

                            double credit_amount = Double.parseDouble(answer);
                            Bk.credit(credit_amount);

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    else{
                        System.out.println("Good Bye!");
                        break;
                    }
            }
            
            
            }
            
            

        
        }
        else if(x==1){
            
            System.out.println("Enter your Name : ");
            String name = scanner.next();
            System.out.println("Please enter your ID");
            String ID = scanner.next();
            bank2 = new BankProxy(ID);
            if(bank2.uniqueId(ID)){
            System.out.println("Enter the value you want to initiate it in your Account");
            Double initBalance = scanner.nextDouble();
            BankAccount bankAccount1 = BankAccount.getInstance(name,ID,initBalance);
            
            while (true){
            System.out.println("Welcome " +  bankAccount1.owner + " to Java Bank!");
            System.out.println("Which operation do you want to do?");
            System.out.println("(1) Withdrawal Operation");
            System.out.println("(2) Credit Operation");
            System.out.println("(Other) Exit");

            int a = scanner.nextInt();
            if(a == 1){
                System.out.println("Your balance is " + initBalance + "$");
                System.out.println("How many money do you want to withdraw?");

                BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
                try {
                    answer = input.readLine();

                    double withdraw_amount = Double.parseDouble(answer);
                    bankAccount1.withdraw(withdraw_amount);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            else if(a == 2){
                System.out.println("Your balance is " + bankAccount1.balance + "$");
                System.out.println("How many mone do you want to credit?");

                BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
                try {
                    answer = input.readLine();

                    double credit_amount = Double.parseDouble(answer);
                    bankAccount1.credit(credit_amount);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else{
                System.out.println("Good Bye!");
                break;
            }
        }
        
            }
        
        }


        
//        System.out.println("Enter your Name : ");
//        String name = scanner.next();
//        System.out.println("Please enter your ID");
//        String ID = scanner.next();
//        System.out.println("Enter the value you want to initiate it in your Account");
//        Double initBalance = scanner.nextDouble();
//        BankAccount bankAccount1 = BankAccount.getInstance(name,ID,initBalance);
////        bank.AddAccount(bankAccount1);
//        
//        
////        for(int i =0; i<bankAccountList.size(); i++){
////            System.out.println(bankAccountList.get(i).owner + "  " + bankAccountList.get(i).balance);
////        }
//
//
//        
//
//        while (true){
//            System.out.println("Welcome " +  bankAccount1.owner + " to Java Bank!");
//            System.out.println("Which operation do you want to do?");
//            System.out.println("(1) Withdrawal Operation");
//            System.out.println("(2) Credit Operation");
//            System.out.println("(Other) Exit");
//
//            int a = scanner.nextInt();
//            if(a == 1){
//                System.out.println("Your balance is " + initBalance + "$");
//                System.out.println("How many money do you want to withdraw?");
//
//                BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
//                try {
//                    answer = input.readLine();
//
//                    double withdraw_amount = Double.parseDouble(answer);
//                    bankAccount1.withdraw(withdraw_amount);
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            else if(a == 2){
//                System.out.println("Your balance is " + bankAccount1.balance + "$");
//                System.out.println("How many mone do you want to credit?");
//
//                BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
//                try {
//                    answer = input.readLine();
//
//                    double credit_amount = Double.parseDouble(answer);
//                    bankAccount1.credit(credit_amount);
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            else{
//                System.out.println("Good Bye!");
//                break;
//            }
//        }
    }
    
}