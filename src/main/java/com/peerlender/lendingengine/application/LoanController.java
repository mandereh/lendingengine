package com.peerlender.lendingengine.application;

import com.peerlender.lendingengine.application.domain.LoanRequest;
import com.peerlender.lendingengine.domain.model.LoanApplication;
import com.peerlender.lendingengine.domain.model.User;
import com.peerlender.lendingengine.domain.repository.LoanApplicationRepository;
import com.peerlender.lendingengine.domain.repository.UserRepository;
import com.peerlender.lendingengine.domain.service.LoanApplicationAdapter;
import com.peerlender.lendingengine.domain.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LoanController {

    private final LoanApplicationRepository loanApplicationRepository;
    private final UserRepository userRepository;
    private final LoanApplicationAdapter loanApplicationAdapter;
    private final LoanService loanService;

    @Autowired
    public LoanController(LoanApplicationRepository loanApplicationRepository, UserRepository userRepository, LoanApplicationAdapter loanApplicationAdapter, LoanService loanService) {
        this.loanApplicationRepository = loanApplicationRepository;
        this.userRepository = userRepository;
        this.loanApplicationAdapter = loanApplicationAdapter;
        this.loanService = loanService;
    }

    @PostMapping(value = "/loan/request")
    public LoanApplication requestLoan(@RequestBody final LoanRequest loanRequest) {
        LoanApplication loanApplication = loanApplicationAdapter.transform(loanRequest);
        return loanApplicationRepository.save(loanApplication);
    }

    @GetMapping(value = "/loan/requests")
    public List<LoanApplication> getAllLoanApplications() {
        return loanApplicationRepository.findAll();
    }

    @GetMapping(value = "/users")
    public List<User> findUsers() {
        return userRepository.findAll();
    }

    @PostMapping(value = "/loan/accept/{lenderId}/{loanApplicationId}")
    public void acceptLoan(@PathVariable final String lenderId, @PathVariable final String loanApplicationId) {
        loanService.acceptLoan(Long.parseLong(loanApplicationId), Long.parseLong(lenderId));
    }
}
