package com.example.category.CategoryRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.category.Model.Categoryy;
import com.example.category.Model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	@Query (value = "select * from Product where id like ?1",nativeQuery = true)
	 List <Categoryy> FindProductByID(Long  id);
	
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM Product WHERE id like ?1", nativeQuery = true)
	void deleteById(Long id);
	

	@Transactional
	@Modifying
	@Query(value = "UPDATE Product SET id = ?1, name = ?2, price = ?3 WHERE id = ?4", nativeQuery = true)
	void findById(Long id, String name, Double price );

}
