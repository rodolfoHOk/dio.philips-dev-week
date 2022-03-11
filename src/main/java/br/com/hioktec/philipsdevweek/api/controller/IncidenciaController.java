package br.com.hioktec.philipsdevweek.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.hioktec.philipsdevweek.domain.entity.Incidencia;
import br.com.hioktec.philipsdevweek.domain.repository.IncidenciaRepo;

@RestController
@RequestMapping("/api/incidencias")
public class IncidenciaController {
	
	private final IncidenciaRepo repository;
	
	public IncidenciaController(IncidenciaRepo repository) {
		this.repository = repository;
	}

	@GetMapping
	public List<Incidencia> getAllIncidencia() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Incidencia> getIncidenciaById(@PathVariable Long id) {
		Optional<Incidencia> incidenciaOptional = repository.findById(id);
		
		if (incidenciaOptional.isPresent()) {
			return ResponseEntity.ok(incidenciaOptional.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/novo")
	@ResponseStatus(HttpStatus.CREATED)
	public Incidencia createIncidencia(@RequestBody Incidencia newIncidencia) {
		return repository.save(newIncidencia);
	}
	
	@DeleteMapping("/remover/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> deleteIncidencia(@PathVariable Long id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
