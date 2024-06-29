package com.sunbeam.service;

import com.sunbeam.dto.AuthRequest;
import com.sunbeam.dto.UserReqDTO;
import com.sunbeam.dto.UserRespDTO;
import com.sunbeam.entities.User;

public interface UserService {
	User addUser(UserReqDTO requestDTO);
	
	UserRespDTO authenticateUser(AuthRequest dto);
}
