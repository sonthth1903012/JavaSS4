package com.example.springboot_rest_auth.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.springboot_rest_auth.model.Loan;
import com.example.springboot_rest_auth.repository.LoanRepository;
import com.example.springboot_rest_auth.service.LoanService;



import java.util.List;

@Service
public class LoanServiceImpl implements LoanService{
    @Autowired
    private LoanRepository loanRepository;

    @Override
    public List<Loan> listLoans() {
        try{
            List<Loan> list = loanRepository.findAll();
            return list;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Loan getLoanById(long loan_id) {
        try{
            Loan loan = loanRepository.findById(loan_id).get();
            return loan;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Loan> listLoanByStatus(int status) {
        try{
            List<Loan> list = loanRepository.findAllByStatus(status);
            return list;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean saveLoan(Loan loan) {
        try{
            loanRepository.save(loan);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateLoan(Loan loan) {
        try{
            loanRepository.save(loan);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteLoan(long loan_id) {
        try{
            Loan loan= loanRepository.findById(loan_id).get();
            loan.setStatus("done");
            loanRepository.save(loan);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

//    @Override
//    public boolean checkLoanName(String loan_name) {
//        Loan loan = loanRepository.findByLoanName(loan_name);
//        if (loan==null)
//        {
//            return true;
//        }else {
//            return false;
//        }
//    }

}
