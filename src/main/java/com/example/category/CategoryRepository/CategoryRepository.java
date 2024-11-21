package com.example.category.CategoryRepository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.category.Model.Categoryy;

@Repository
public interface CategoryRepository extends JpaRepository<Categoryy, Long> {
	
	@Query (value = "select * from categoryy where id like ?1",nativeQuery = true)
	 List <Categoryy> FindCategoryByID(Long  id);

	
	@Transactional
	@Modifying
	@Query(value = "UPDATE categoryy SET id = ?1, name = ?2, description = ?3 WHERE id = ?4", nativeQuery = true)
	void findById(Long id, String name, String description );
	
	
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM categoryy WHERE id = ?1", nativeQuery = true)
	void deleteById(Long id);

}
	


