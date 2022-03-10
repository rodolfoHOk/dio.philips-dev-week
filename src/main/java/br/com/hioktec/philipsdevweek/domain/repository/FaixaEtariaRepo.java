package br.com.hioktec.philipsdevweek.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hioktec.philipsdevweek.domain.entity.FaixaEtaria;

public interface FaixaEtariaRepo extends JpaRepository<FaixaEtaria, Long> {
	
}
