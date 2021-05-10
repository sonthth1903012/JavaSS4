package com.example.springboot_rest_auth.repository;

import com.example.springboot_rest_auth.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    List<Loan> findAllByStatus(int status);

//    @Query("SELECT c FROM Loan c WHERE status = 1 OR status = 2")
//    List<Loan> findActiveLoanStatus();

    @Query("SELECT m FROM Loan m WHERE id = m")
    Loan findByLoanUser(long id);
}
