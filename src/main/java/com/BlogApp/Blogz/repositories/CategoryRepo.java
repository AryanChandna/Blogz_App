package com.BlogApp.Blogz.repositories;

import com.BlogApp.Blogz.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
}
