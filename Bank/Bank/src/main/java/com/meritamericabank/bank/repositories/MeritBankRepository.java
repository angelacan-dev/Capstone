package com.meritamericabank.bank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meritamericabank.bank.models.MeritBank;

@Repository
public interface MeritBankRepository extends JpaRepository<MeritBank, Integer> {

}
