package com.example.demo.entity;
 
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
 
@Entity
@Table(name = "CATEGORY")
public class Category {
 
@Id
@Column(name = "CATEGORY_ID")
private Integer categoryId;
 
@Column(name = "CATEGORY_NAME", nullable = false)
private String categoryName;
 
public Category() {
}
 
public Integer getCategoryId() {
return categoryId;
}
 
public void setCategoryId(Integer categoryId) {
this.categoryId = categoryId;
}
 
public String getCategoryName() {
return categoryName;
}
 
public void setCategoryName(String categoryName) {
this.categoryName = categoryName;
}
}