package com.devnyk.dbvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devnyk.dbvendas.dto.SaleSuccessDTO;
import com.devnyk.dbvendas.dto.SaleSumDTO;
import com.devnyk.dbvendas.entities.Sale;


public interface SaleRepository extends JpaRepository<Sale, Long> {

	@Query("SELECT new com.devnyk.dbvendas.dto.SaleSumDTO(obj.seller, SUM(obj.amount))"
			+ "FROM Sale AS obj GROUP BY obj.seller ")
	List<SaleSumDTO> amountGroupedBySeller();
	
	
	  @Query("SELECT new com.devnyk.dbvendas.dto.SaleSuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals))"
	  + "FROM Sale AS obj GROUP BY obj.seller ") List<SaleSuccessDTO>
	  successGroupedBySeller();
	 

}
