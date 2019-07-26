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
public class ZonalManager extends LoanApprover {

    @Override
    public void ApproveLoan(Loan i) {
        if (i.Amount() <= 250000)
            System.out.println("Loan amount of " + i.Amount() + " approved by the Manager and Zonal Manager"); 
            else
                nextApprover.ApproveLoan(i);
    }
    

    
    
}
