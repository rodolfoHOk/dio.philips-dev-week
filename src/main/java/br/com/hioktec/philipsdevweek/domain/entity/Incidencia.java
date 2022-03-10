package br.com.hioktec.philipsdevweek.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "incidencia_exame")
public class Incidencia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false)
	private Long id;
	
	@Column(name = "regiao_id")
    private Integer regiaoId;
    
	private Integer mes;
    
	@Column(name = "faixa_id")
    private Long faixaId;
    
	@Column(name = "qtd_exames")
    private Integer qtdExames;

	public Incidencia(Integer regiaoId, Integer mes, Long faixaId, Integer qtdExames) {
		this.regiaoId = regiaoId;
		this.mes = mes;
		this.faixaId = faixaId;
		this.qtdExames = qtdExames;
	}

	public Incidencia() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getRegiaoId() {
		return regiaoId;
	}

	public void setRegiaoId(Integer regiaoId) {
		this.regiaoId = regiaoId;
	}

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public Long getFaixaId() {
		return faixaId;
	}

	public void setFaixaId(Long faixaId) {
		this.faixaId = faixaId;
	}

	public Integer getQtdExames() {
		return qtdExames;
	}

	public void setQtdExames(Integer qtdExames) {
		this.qtdExames = qtdExames;
	}
	
}
