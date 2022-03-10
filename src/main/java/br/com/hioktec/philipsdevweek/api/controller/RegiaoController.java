package br.com.hioktec.philipsdevweek.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.hioktec.philipsdevweek.domain.entity.Regiao;
import br.com.hioktec.philipsdevweek.domain.repository.RegiaoRepo;

@RestController
@RequestMapping("/api/regioes")
public class RegiaoController {
	
	private final RegiaoRepo repository;

	public RegiaoController(RegiaoRepo repository) {
		this.repository = repository;
	}
	
	@GetMapping
	public List<Regiao> getAllRegiao() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Regiao> getRegiaoById(@PathVariable Long id) {
		Optional<Regiao> regiaoOptional = repository.findById(id);
		
		if (regiaoOptional.isPresent()) {
			return ResponseEntity.ok(regiaoOptional.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/novo")
	@ResponseStatus(HttpStatus.CREATED)
	public Regiao createRegiao(@RequestBody Regiao newRegiao) {
		return repository.save(newRegiao);
	}
	
}
