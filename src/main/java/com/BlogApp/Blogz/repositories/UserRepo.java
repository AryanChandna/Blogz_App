package com.BlogApp.Blogz.repositories;

import com.BlogApp.Blogz.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
}
