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
public abstract class LoanApprover {
    
//    String name ;
//    String ID ;
//    String purpose;
//    double amount;
//    public LoanApproval nextRequest;
    
     protected LoanApprover nextApprover;
     public Boolean Approved;
    
    public void SetNextApprover(LoanApprover nextApprover)
        {
            this.nextApprover = nextApprover;
        }
    public abstract void ApproveLoan(Loan i);



//    
//    public void getRequest(){
//        
//        
//    }
//    public void handleRequest(){
//
//        
//    }
//    public abstract Boolean passRequest(LoanApprover nextPass);
    
    
}
