package com.techiehouse.quickwebapp.service;

import java.util.List;

import com.techiehouse.quickwebapp.vo.UserVO;

public interface UserService {

	List<UserVO> getAllUsers();

	UserVO getById(String id);

	UserVO createNewUser(UserVO userVO);

	UserVO update(UserVO userVO);

	void remove(String id);

	int getNumberOfUsers();
}
