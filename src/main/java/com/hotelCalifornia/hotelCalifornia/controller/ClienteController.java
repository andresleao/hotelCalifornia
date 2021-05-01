package com.hotelCalifornia.hotelCalifornia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelCalifornia.hotelCalifornia.model.Cliente;
import com.hotelCalifornia.hotelCalifornia.model.Hotel;
import com.hotelCalifornia.hotelCalifornia.repository.ClienteRepository;

@RestController
@RequestMapping({"/cliente"})
public class ClienteController {

	@Autowired 
	private ClienteRepository repository;
	
//  Criar um novo cliente - http://localhost:8000/cliente	
	@PostMapping
	public Cliente create(@RequestBody Cliente cliente) {
		return repository.save(cliente);
	}
	
//  Listar todos os clientes - http://localhost:8000/cliente	
	@GetMapping
	public List listarTodos() {
		return repository.findAll();
	}
	
//  Pesquisar cliente pelo CPF - http://localhost:8000/cliente/{cpf}
	@GetMapping(value = "/{cpf}")
	public ResponseEntity findById(@PathVariable String cpf) {
		return repository.findById(cpf)
			.map(record -> ResponseEntity.ok().body(record))
			.orElse(ResponseEntity.notFound().build());
	}
	
//  Atualizar cliente - http://localhost:8000/cliente/cpf
	@PutMapping(value = "/{cpf}")
	public ResponseEntity update(@PathVariable String cpf, @RequestBody Cliente cliente) {
		return repository.findById(cpf)
			.map(record ->{
				record.setCpf(cliente.getCpf());
				record.setNome(cliente.getNome());
				record.setIdade(cliente.getIdade());
				record.setFone(cliente.getFone());
				record.setEmail(cliente.getEmail());
				record.setMatricula(cliente.getMatricula());
				Cliente update = repository.save(record);
				return ResponseEntity.ok().body(update);
			}).orElse(ResponseEntity.notFound().build());
	}
	
//  Deletar cliente - http://localhost:8000/cliente/cpf
	@DeleteMapping(path = {"/{cpf}"})
	public ResponseEntity delete(@PathVariable String cpf) {
		return repository.findById(cpf)
			.map(record->{
				repository.deleteById(cpf);
				return ResponseEntity.ok().body("Cliente deletado com sucesso!");
			}).orElse(ResponseEntity.notFound().build());
	}
	
}
