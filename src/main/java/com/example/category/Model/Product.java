package com.example.category.Model;

import java.util.Locale.Category;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Double price;

	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	@JsonBackReference
	private Categoryy categoryy;

	public Product() {
		super();
	}

	public Product(Long id, String name, Double price, Categoryy categoryy) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.categoryy = categoryy;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Categoryy getCategoryy() {
		return categoryy;
	}

	public void setCategory(Categoryy categoryy) {
		this.categoryy = categoryy;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", category=" + categoryy + "]";
	}

}
