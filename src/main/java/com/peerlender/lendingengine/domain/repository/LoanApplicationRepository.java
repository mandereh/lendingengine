package com.peerlender.lendingengine.domain.repository;

import com.peerlender.lendingengine.domain.model.LoanApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LoanApplicationRepository extends JpaRepository<LoanApplication, Long>{
}
