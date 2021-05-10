package com.example.springboot_rest_auth.service;

import com.example.springboot_rest_auth.model.Loan;
import org.springframework.stereotype.Service;

import java.util.List;

public interface LoanService {
    List<Loan> listLoans();
    Loan getLoanById(long loan_id);
    List<Loan> listLoanByStatus(int status);
    boolean saveLoan(Loan loan);
    boolean updateLoan(Loan loan);
    boolean deleteLoan(long loan_id);
}
