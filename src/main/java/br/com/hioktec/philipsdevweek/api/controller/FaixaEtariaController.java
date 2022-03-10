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

import br.com.hioktec.philipsdevweek.domain.entity.FaixaEtaria;
import br.com.hioktec.philipsdevweek.domain.repository.FaixaEtariaRepo;

@RestController
@RequestMapping("/api/faixasetaria")
public class FaixaEtariaController {
	
	private final FaixaEtariaRepo repository;
	
	public FaixaEtariaController(FaixaEtariaRepo repository) {
		this.repository = repository;
	}

	@GetMapping
	public List<FaixaEtaria> getAllFaixaEtaria() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<FaixaEtaria> getFaixaEtariaById(@PathVariable Long id) {
		Optional<FaixaEtaria> faixaEtariaOptional = repository.findById(id);
		
		if (faixaEtariaOptional.isPresent()) {
			return ResponseEntity.ok(faixaEtariaOptional.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/novo")
	@ResponseStatus(HttpStatus.CREATED)
	public FaixaEtaria createFaixaEtaria(@RequestBody FaixaEtaria newFaixaEtaria) {
		return repository.save(newFaixaEtaria);
	}
	
	@DeleteMapping("/remover/{id}") 
	public ResponseEntity<Void> deleteFaixaEtaria(@PathVariable Long id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
}
