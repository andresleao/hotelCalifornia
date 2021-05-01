package com.hotelCalifornia.hotelCalifornia.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor   //Criação de construtores padrões
@NoArgsConstructor    //Criação de construtor vazio
@Data                 //Criação de gets and setters, equals, toString, hashcodes, etc
@Entity               //Entidade(tabela) no banco de dados
public class Hotel {

	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private long id;
	private String nome;
	private float valor_diaria;
	private String cidade;
	private float estrelas;
	
	
}
