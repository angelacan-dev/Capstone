package com.meritamericabank.bank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meritamericabank.bank.models.BankAccount;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Integer>{

}
