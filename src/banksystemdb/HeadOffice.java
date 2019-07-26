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
public class HeadOffice extends LoanApprover {
//    public Boolean Approved;

    @Override
    public void ApproveLoan(Loan i) {
        System.out.println("Loan amount of " + i.Amount() + " approved by the Head Office, the Zonal Manager and The Head Office");
        ApprovedFunc();
    }
    public Boolean ApprovedFunc(){
        return true;
    }
    

    
}
