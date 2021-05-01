package com.hotelCalifornia.hotelCalifornia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotelCalifornia.hotelCalifornia.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {

}
