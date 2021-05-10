package com.example.springboot_rest_auth.web;

import com.example.springboot_rest_auth.model.Loan;
import com.example.springboot_rest_auth.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class LoanController {
    @Autowired
    private LoanService loanService;


    @RequestMapping(path = "loanList")
    public String getLoans(Model model)
    {
        Loan loan = new Loan();
        model.addAttribute("loanNew",loan);
        return "loanList";
    }

    @RequestMapping(path = "saveLoan",method = RequestMethod.POST)
    public String saveLoan(@Valid Loan loan, BindingResult result, Model model)
    {
        if (result.hasErrors())
        {
            return "welcome";
        }

        loan.setCreated(new Date());
        loan.setUpdated(new Date());
        model.addAttribute("loanNew", new Loan());
        boolean bl = loanService.saveLoan(loan);
        if (bl)
        {
            return "redirect:/?success=Add New Loan success";
        }
        return "redirect:/?success=Add New Loan failed";
    }

    @RequestMapping(path = "editLoan")
    public String editLoan(@RequestParam("id")Integer id, Model model)
    {
        Loan loan = loanService.getLoanById(id);
        model.addAttribute("loanNew",loan);
        return "loanEdit";
    }

    @RequestMapping(path = "updateLoan",method = RequestMethod.POST)
    public String updateLoan(@ModelAttribute("loanEdit")Loan loan)
    {
        loan.setUpdated(new Date());
        boolean bl = loanService.updateLoan(loan);
        if (bl)
        {
            return "redirect:/?success=Update loan success";
        }
        return "redirect:/?error=Update loan failed";
    }

    @RequestMapping(path = "deleteLoan")
    public String deleteLoan(@RequestParam("id")long id)
    {
        boolean bl = loanService.deleteLoan(id);
        if (bl)
        {
            return "redirect:/?success=Delete loan success";
        }
        return "redirect:/?error=Delete loan failed";
    }
}
