package br.com.processoseletivo.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.processoseletivo.model.ProcessoSeletivo;

public interface ProcessoRepository extends CrudRepository<ProcessoSeletivo, Long>{

	boolean existsByNome(String nome);
	
	

}
