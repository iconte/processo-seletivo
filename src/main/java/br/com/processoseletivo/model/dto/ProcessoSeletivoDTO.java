package br.com.processoseletivo.model.dto;

import java.util.Date;

import jakarta.validation.constraints.NotNull;

public class ProcessoSeletivoDTO {

	
	private Long id;
	@NotNull(message = "nome deve ser informado")
	private String nome;
	@NotNull(message = "data de inicio deve ser informado")
	private Date dataInicioInscricao;
	
	private Date dataFimInscricao;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataInicioInscricao() {
		return dataInicioInscricao;
	}

	public void setDataInicioInscricao(Date dataInicioInscricao) {
		this.dataInicioInscricao = dataInicioInscricao;
	}

	public Date getDataFimInscricao() {
		return dataFimInscricao;
	}

	public void setDataFimInscricao(Date dataFimInscricao) {
		this.dataFimInscricao = dataFimInscricao;
	}
	
	
	
	
	
}
