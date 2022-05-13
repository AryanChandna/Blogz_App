package com.BlogApp.Blogz.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Categories")
@Getter
@Setter
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    private String categoryTitle;

    private String categoryDescription;

}
