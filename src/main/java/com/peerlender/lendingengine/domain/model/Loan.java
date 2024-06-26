package com.peerlender.lendingengine.domain.model;

import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class Loan {
    private long id;
    private User borrower;
    private User lender;
    private int amount;
    private double interestRate;
    private LocalDate dateLent;
    private LocalDate dateDue;

    public Loan(){

    }
    public Loan(User lender, LoanApplication loanApplication){
        this.borrower = loanApplication.getBorrower();
        this.lender = lender;
        this.amount = loanApplication.getAmount();
        this.interestRate = loanApplication.getInterestRate();
        this.dateLent = LocalDate.now();
        this.dateDue = LocalDate.now().plusDays(loanApplication.getRepaymentTermInDays());
    }
}
