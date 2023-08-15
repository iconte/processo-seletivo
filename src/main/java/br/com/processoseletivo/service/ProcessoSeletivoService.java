package br.com.processoseletivo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.processoseletivo.exception.ProcessoSeletivoExistenteException;
import br.com.processoseletivo.model.ProcessoSeletivo;
import br.com.processoseletivo.repository.ProcessoRepository;

@Service
public class ProcessoSeletivoService {

	@Autowired
	private ProcessoRepository repository;

	public void criar(ProcessoSeletivo novo) throws Exception {

		boolean existsByNome = repository.existsByNome(novo.getNome());
		if(existsByNome) {
			throw new ProcessoSeletivoExistenteException("Processo seletivo já existe com esse nome");
		}
			repository.save(novo);
	}

	public List<ProcessoSeletivo> listarTodos() {
		return (List<ProcessoSeletivo>) repository.findAll();

	}

	public void excluir(Long id) {
		repository.deleteById(id);
	}

	public Optional<ProcessoSeletivo> obterPorId(Long id) {

		return repository.findById(id);
	}

	public void atualizar(ProcessoSeletivo processoSeletivo) {
		Optional<ProcessoSeletivo> encontrado = repository.findById(processoSeletivo.getId());
		if (encontrado.isPresent()) {
			repository.save(processoSeletivo);
		}

	}
}
