package com.sunbeam.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "posts")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString(callSuper = true,exclude="selectedCategory")
public class BlogPost extends BaseEntity {
	@Column(length = 30, unique = true)
	private String title;
	private String description;
	private String content;

	// blogpost * ----> 1 category---bi dir
	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	private Category selectedCategory;

	//Blogpost * ----> 1 user ----unidirectional
	@ManyToOne
	@JoinColumn(name = "author_id", nullable = false)
	private User blogger;
}
