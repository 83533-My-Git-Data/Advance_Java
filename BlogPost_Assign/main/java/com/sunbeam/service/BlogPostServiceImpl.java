package com.sunbeam.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.custom_exceptions.ResourceNotFoundException;
import com.sunbeam.dao.BlogPostDao;
import com.sunbeam.dao.CategoryDao;
import com.sunbeam.dao.UserDao;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.BlogPostReqDTO;
import com.sunbeam.entities.BlogPost;
import com.sunbeam.entities.Category;
import com.sunbeam.entities.User;

@Service
@Transactional
public class BlogPostServiceImpl implements BlogPostService {

	
	@Autowired
	private BlogPostDao blogPostDao;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Override
	public ApiResponse postNewBlog(BlogPostReqDTO requestDTO) {
	   Category category = categoryDao.findById(requestDTO.getCategoryId())
			               .orElseThrow(()-> new ResourceNotFoundException("Invalid category id !!!"));
	  
	   User blogger = userDao.findById(requestDTO.getCategoryId())
			          .orElseThrow(()-> new ResourceNotFoundException("Invalid blogger id!!!"));
	   
	   BlogPost blogPost = modelMapper.map(requestDTO, BlogPost.class);
	   
	   category.addBlogPost(blogPost);
	   
	   blogPost.setBlogger(blogger);
	   
	   BlogPost persistentBlog = blogPostDao.save(blogPost);
	   return new ApiResponse("New blog added with ID -"+persistentBlog.getId());
	}

	
}
