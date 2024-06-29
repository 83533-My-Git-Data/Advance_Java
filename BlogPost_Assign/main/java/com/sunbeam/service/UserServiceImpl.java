package com.sunbeam.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.custom_exceptions.AuthenticationException;
import com.sunbeam.dao.UserDao;
import com.sunbeam.dto.AuthRequest;
import com.sunbeam.dto.UserReqDTO;
import com.sunbeam.dto.UserRespDTO;
import com.sunbeam.entities.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public User addUser(UserReqDTO requestDTO) {
     User user = userDao.save(mapper.map(requestDTO,User.class));
		return user ;
	}

	@Override
	public UserRespDTO authenticateUser(AuthRequest dto) {
		User user = userDao.findByEmailAndPassword(dto.getEmail(),dto.getPwd())
				.orElseThrow(()-> new AuthenticationException("Invalid Email or password"));
		
		return mapper.map(user, UserRespDTO.class);
				
		
	}

}
