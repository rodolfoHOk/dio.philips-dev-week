package br.com.hioktec.philipsdevweek.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hioktec.philipsdevweek.domain.entity.Incidencia;

public interface IncidenciaRepo extends JpaRepository<Incidencia, Long> {

}
