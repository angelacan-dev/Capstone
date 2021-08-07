package com.meritamericabank.bank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meritamericabank.bank.models.CDAccount;

@Repository
public interface CDAccountRepository extends JpaRepository<CDAccount, Integer> {

}
