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
import com.hotelCalifornia.hotelCalifornia.model.Hotel;
import com.hotelCalifornia.hotelCalifornia.repository.HotelRepository;

@RestController
@RequestMapping({"/hotel"})
public class HotelController {
	
	@Autowired // Possibilita o acesso aos métodos da interface repository
	private HotelRepository repository;
	
//  Criar um novo contato - http://localhost:8000/hotel	
	@PostMapping
	public Hotel create(@RequestBody Hotel hotel) {
		return repository.save(hotel);
	}
	
//  Listar todos os hoteis - http://localhost:8000/hotel	
	@GetMapping
	public List listarTodos() {
		return repository.findAll();
	}
	
//  Pesquisar pelo ID - http://localhost:8000/hotel/{id}
	@GetMapping(value = "/{id}")
	public ResponseEntity findById(@PathVariable long id) {
		return repository.findById(id)
			.map(record -> ResponseEntity.ok().body(record))
			.orElse(ResponseEntity.notFound().build());
	}
	
//  Atualizar hotel  - http://localhost:8000/hotel/id	
	@PutMapping(value = "/{id}")
	public ResponseEntity update(@PathVariable long id, @RequestBody Hotel hotel) {
		return repository.findById(id)
			.map(record ->{
				record.setNome(hotel.getNome());
				record.setValor_diaria(hotel.getValor_diaria());
				record.setCidade(hotel.getCidade());
				record.setEstrelas(hotel.getEstrelas());
				Hotel update = repository.save(record);
				return ResponseEntity.ok().body(update);
			}).orElse(ResponseEntity.notFound().build());
	}
	
//  Deletar hotel - http://localhost:8000/hotel/id
	@DeleteMapping(path = {"/{id}"})
	public ResponseEntity delete(@PathVariable long id) {
		return repository.findById(id)
			.map(record->{
				repository.deleteById(id);
				return ResponseEntity.ok().body("Hotel deletado com sucesso!");
			}).orElse(ResponseEntity.notFound().build());
	}
		
}
