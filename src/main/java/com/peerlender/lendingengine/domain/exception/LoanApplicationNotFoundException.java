package com.peerlender.lendingengine.domain.exception;

public class LoanApplicationNotFoundException extends RuntimeException{
public LoanApplicationNotFoundException(long loanApplicationId){
        super("LoanApplication with loanApplicationId" + loanApplicationId + "was not found");
    }
}
