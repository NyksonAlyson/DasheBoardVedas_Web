package com.devnyk.dbvendas.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devnyk.dbvendas.dto.SaleDTO;
import com.devnyk.dbvendas.entities.Sale;
import com.devnyk.dbvendas.entities.Seller;
import com.devnyk.dbvendas.repositories.SaleRepository;
import com.devnyk.dbvendas.repositories.SellerRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository salerRepository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@org.springframework.transaction.annotation.Transactional
	(readOnly =true )
	public Page<SaleDTO> findAll(Pageable pageable){
		sellerRepository.findAll();
		Page<Sale>  result = salerRepository.findAll(pageable);
		return result.map(x -> new SaleDTO(x));
	}
	
	
}
