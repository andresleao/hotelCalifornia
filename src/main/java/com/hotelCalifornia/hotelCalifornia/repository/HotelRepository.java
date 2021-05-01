package com.hotelCalifornia.hotelCalifornia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotelCalifornia.hotelCalifornia.model.Hotel;

@Repository                // Long -> responsabilidade do banco em criar
public interface HotelRepository extends JpaRepository<Hotel, Long> {

}
