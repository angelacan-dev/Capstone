package com.meritamericabank.bank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meritamericabank.bank.models.CDOffering;

@Repository
public interface CDOfferingRepository extends JpaRepository<CDOffering, Integer> {

}
