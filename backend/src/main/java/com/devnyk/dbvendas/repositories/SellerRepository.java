package com.devnyk.dbvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devnyk.dbvendas.entities.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long> {
	

}
