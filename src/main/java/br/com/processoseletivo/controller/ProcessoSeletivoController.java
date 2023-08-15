package br.com.processoseletivo.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.processoseletivo.model.ProcessoSeletivo;
import br.com.processoseletivo.model.dto.ProcessoSeletivoDTO;
import br.com.processoseletivo.service.ProcessoSeletivoService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/selecao")
public class ProcessoSeletivoController {

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private ProcessoSeletivoService service;
	

	@PostMapping
	public void criar(@RequestBody @Valid ProcessoSeletivoDTO novo) throws Exception {

		service.criar(mapper.map(novo, ProcessoSeletivo.class)); 
	}

	@PutMapping
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void atualizar(ProcessoSeletivoDTO processoSeletivo) {
		service.atualizar(mapper.map(processoSeletivo, ProcessoSeletivo.class));
	}

	@GetMapping
	public ResponseEntity<?> listarTodos() {
		List<ProcessoSeletivoDTO> resultado = mapper.map(service.listarTodos(), List.class);
		return ResponseEntity.ofNullable(resultado);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> obterPorId(@PathVariable("id") Long id) {
		return ResponseEntity.ofNullable(service.obterPorId(id));
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void excluir(@PathVariable("id") Long id) {
		service.excluir(id);
	}

}
