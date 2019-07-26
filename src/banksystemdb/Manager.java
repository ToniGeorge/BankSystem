/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksystemdb;

/**
 *
 * @author ToniGeorge
 */
public class Manager extends LoanApprover{
    

    @Override
    public void ApproveLoan(Loan i) {
                   if (i.Amount() <= 100000)
                System.out.println("Loan amount of " + i.Amount() + " approved only by the Manager"); 
            else
                nextApprover.ApproveLoan(i);
    }
    
    
    
//    public Manager(String name, String ID, String purpose, double amount) {
//        
//    }
//
//    @Override
//    public Boolean passRequest(LoanApprover nextPass) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
}
