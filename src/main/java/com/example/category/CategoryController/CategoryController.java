package com.example.category.CategoryController;

import java.util.List;

import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.category.CategoryService.CategoryService;
import com.example.category.Model.Categoryy;

@RestController
@RequestMapping
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    
    
    @GetMapping("/getCategoryById/{id}")
	public Categoryy getStudentByrno(@PathVariable Long id) {
		
		return categoryService.getCategoryById(id);
	}
    
    
    @GetMapping("/getallCategory")
	public List <Categoryy>getaLLCategory() {
		
		return categoryService.getaLLCategoryy();
	}
    
    @PostMapping("/addCategory")
	public String addCategory(@RequestBody Categoryy categoryy){
    	categoryService.addCategoryy(categoryy);
	    return "New record inserted successfully";
    }

    
    @PutMapping("/updateCategory/{id}")
	public String updateCategory(@RequestBody Categoryy newCategoryy,@PathVariable("id") Long id) {
		
    	categoryService.updateCategoryy(id, newCategoryy);
		
		return "record updated successfully";
	}
    
    @DeleteMapping("/DeleteCategory/{id}")
	public String DeleteCategoryy(@PathVariable("id") Long id) {
		
    	categoryService.DeleteCategory(id);
		return "record deleted";
	}
    
 // 1.GET all categories (with pagination)
 	@GetMapping("/categories")
 	public org.springframework.data.domain.Page<Categoryy> getAllCategories(@RequestParam(defaultValue = "0") int page,
 			@RequestParam(defaultValue = "10") int size) {
 		return categoryService.getAllCategories(page,size);
 	}


}
