package com.hackathon.repository;

import com.hackathon.domain.Correntista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorrentistaRepository extends JpaRepository <Correntista, Integer> {
}
