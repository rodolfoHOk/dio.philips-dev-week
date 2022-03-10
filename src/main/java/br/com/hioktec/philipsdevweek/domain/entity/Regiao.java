package br.com.hioktec.philipsdevweek.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Regiao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false)
	private Long id;
	
    private String regiao;
    
    @Column(name = "qtd_exames")
    private Integer qtdExames;

	public Regiao(String regiao, Integer qtdExames) {
		this.regiao = regiao;
		this.qtdExames = qtdExames;
	}

	public Regiao() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRegiao() {
		return regiao;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}

	public Integer getQtdExames() {
		return qtdExames;
	}

	public void setQtdExames(Integer qtdExames) {
		this.qtdExames = qtdExames;
	}  

}
