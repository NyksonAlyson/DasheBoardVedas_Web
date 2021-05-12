package com.devnyk.dbvendas.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devnyk.dbvendas.dto.SellerDTO;
import com.devnyk.dbvendas.entities.Seller;
import com.devnyk.dbvendas.repositories.SellerRepository;

@Service
public class SellerService {

	@Autowired
	private SellerRepository sellerRepository;
	
	public List<SellerDTO> findAll(){
		
		List<Seller>  result = sellerRepository.findAll();
		return result.stream().map(x -> new SellerDTO(x)).collect(Collectors.toList());
	}
	
	
}
