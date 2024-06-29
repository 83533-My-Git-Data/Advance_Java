package com.sunbeam.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "categories")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Category extends BaseEntity {
	@Column(name = "name", length = 30, unique = true)
	private String categoryName;
	private String description;

	
	//category 1 --> *blogposts
	@OneToMany(mappedBy ="selectedCategory", cascade = CascadeType.ALL)
	private List<BlogPost> posts = new ArrayList<>();

	public void addBlogPost(BlogPost post) {
		this.posts.add(post);
		post.setSelectedCategory(this);

	}
	
	public void removeBlogPost(BlogPost post) {
		this.posts.remove(post);
		post.setSelectedCategory(null);
	}
}
