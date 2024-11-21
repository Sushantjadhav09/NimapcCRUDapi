package com.example.category.CategoryService;

import java.util.List;
import java.util.Locale.Category;

import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.category.CategoryRepository.CategoryRepository;
import com.example.category.Model.Categoryy;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    
	public Categoryy getCategoryById(Long id) {
		return categoryRepository.findById(id).get();
	}
	
	public List<Categoryy>getaLLCategoryy() {
		return categoryRepository.findAll();
	}
	

	public Categoryy addCategoryy(Categoryy s) {
		return categoryRepository.save(s);
	}

	public Categoryy updateCategoryy(Long id, Categoryy newCategoryy) {
		  Categoryy currentDbvalues =	categoryRepository.findById(id).get();
		  currentDbvalues.setId(newCategoryy.getId());
		  currentDbvalues.setName(newCategoryy.getName());
		  currentDbvalues.setDescription(newCategoryy.getDescription());
		return categoryRepository.save(currentDbvalues);
	}

	public void DeleteCategory(Long id) {
		categoryRepository.deleteById(id);
	}
	
	// Get all categories with pagination
		public org.springframework.data.domain.Page<Categoryy> getAllCategories(int page, int size) {
			return categoryRepository.findAll(PageRequest.of(page,size));
		}
   

}
