package com.hotelCalifornia.hotelCalifornia.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor   
@NoArgsConstructor 
@Data
@Entity
public class Cliente {

	@Id
	private String cpf;
	private String nome;
	private int idade;
	private String fone;
	private String email;
	private int matricula;
}
