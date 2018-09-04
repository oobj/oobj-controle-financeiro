package br.com.oobj.controlefinanceiro.domain.lancamento.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.oobj.controlefinanceiro.domain.lancamento.model.Lancamento;
import br.com.oobj.controlefinanceiro.domain.lancamento.service.LancamentoService;
import br.com.oobj.controlefinanceiro.service.exception.NotFoundException;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/lancamentos")
@Api(tags = "Lançamentos")
public class LancamentoController {
	
	private final LancamentoService lancamentoService;
	private final LancamentoConverter lancamentoConverter;
	
	@Autowired
	public LancamentoController(LancamentoService lancamentoService, LancamentoConverter lancamentoConverter) {
		this.lancamentoService = lancamentoService;
		this.lancamentoConverter = lancamentoConverter;
	}
	
	@PostMapping
	public void novoLancamento(@RequestBody LancamentoDTO lancamento) {
		lancamentoService.create(lancamentoConverter.convertToEntity(lancamento));
	}
	
	@GetMapping(path="/{id}")
	public LancamentoDTO getLancamento(@PathVariable Long id) {
		try {
			Lancamento lancamento = lancamentoService.findById(id);
			return lancamentoConverter.convertToDTO(lancamento);
		} catch (NotFoundException e) {
			return null;
		}
	}
	
	@PutMapping(path="/{id}")
	public void editarLancamento(@PathVariable Long id, @RequestBody LancamentoDTO lancamento) {
		
	}
	
	@DeleteMapping(path="/{id}")
	public void deletarLancamento(@PathVariable Long id) {
		lancamentoService.delete(id);
	}
	
	@GetMapping
	public List<LancamentoDTO> listarTodos() {
		List<LancamentoDTO> todos = new ArrayList<>();
		
		lancamentoService.findAll().forEach(e -> todos.add(lancamentoConverter.convertToDTO(e)));
		
		return todos;
	}
	
}
