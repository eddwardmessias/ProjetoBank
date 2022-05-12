package com.projetobank.api.repository;

import com.projetobank.api.models.Correntista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorrentistaRepository extends JpaRepository<Correntista, Integer> {
}
