/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksystemdb;

import java.util.ArrayList;

/**
 *
 * @author ToniGeorge
 */
public class BankProxy {
    
           private String userId;
    
           private static ArrayList <BankAccount> bankAccountList = new ArrayList<BankAccount>();
           
           public BankProxy() {
               
           }
           
           void getLoan(BankAccount BA,double amount){
               LoanApprover A = new Manager();
               LoanApprover B = new ZonalManager();
               LoanApprover C = new HeadOffice();
               A.SetNextApprover(B);
               B.SetNextApprover(C);
               A.ApproveLoan(new Loan(amount));
               A.ApproveLoan(new Loan(amount));
               A.ApproveLoan(new Loan(amount));
    
        }

           public BankProxy(String userId) {
               this.userId = userId;
               
           }
           
           public void AddAccount(BankAccount BA){
//               System.out.println("BankOwner "+BA.owner);
               bankAccountList.add(BA);
               
               
           }
           
           public Boolean uniqueId(String ID){
               if(validateUserId(ID)){
                   System.out.println("From Proxy This User ID have been used for another account");

                   return false;
               }else {
                   return true;}
           }

//           // let your proxy do the transactions
//           public void performTransaction(BankAccount customer, String transactionType, double amount) throws Exception {
//                     if (validateUserId(customer.ID)) {
//                               customer.performTransaction(transactionType,amount);
//                     } else {
//                               throw new Exception("Invalid user account.");
//                     }
//           }
           public void Print(){
               System.out.println("BankSize "+bankAccountList.size());
               for (int i = 0; i < bankAccountList.size(); i++) {
                   System.out.println("AccountList :"+i+ " " +bankAccountList.get(i).owner);
               }
               
           }

           public BankAccount searchForAccount(String userID){
               for(int i=0;i<bankAccountList.size();i++){
                   if(bankAccountList.get(i).ID.equalsIgnoreCase(userID)){
                       
                       return bankAccountList.get(i);
                   }
               }
               return null;
           }
           
          private boolean validateUserId(String ID) {
              for(int i =0; i<bankAccountList.size(); i++){
                  if(bankAccountList.get(i).ID.equalsIgnoreCase(ID)){
                      return true;
                      
                  }
                  
              }
              return false;
//                for(int i =0; i<bankAccountList.size(); i++){
//
//                if(!(ID.equals(bankAccountList.get(i).ID)) && (i==bankAccountList.size()-1)){
//                    
//                    return true;
//                    
//                }
//              }
//              
//                    // using validation module validate the userId.
//                    return false; // or return true if userId is valid
          }
          
}
