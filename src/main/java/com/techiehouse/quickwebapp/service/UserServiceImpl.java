package com.techiehouse.quickwebapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techiehouse.quickwebapp.entity.User;
import com.techiehouse.quickwebapp.repositories.UserRepository;
import com.techiehouse.quickwebapp.vo.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	public UserServiceImpl() {

	}

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<UserVO> getAllUsers() {
		List<UserVO> userVOs = new ArrayList<UserVO>();
		List<User> users = (List<User>) this.userRepository.findAll();
		if (users != null) {
			for (User user : users) {
				UserVO userVO = new UserVO();
				BeanUtils.copyProperties(user, userVO);
				userVOs.add(userVO);
			}
		}

		return userVOs;
	}

	@Override
	public UserVO getById(String id) {

		User user = this.userRepository.getById(id);
		UserVO userVO = new UserVO();
		BeanUtils.copyProperties(user, userVO);
		return userVO;
	}

	@Override
	public UserVO createNewUser(UserVO userVO) {
		User user = new User();
		String id = UUID.randomUUID().toString();
		userVO.setId((id));
		BeanUtils.copyProperties(userVO, user);
		user = this.userRepository.create(user);
		BeanUtils.copyProperties(user, userVO);

		return userVO;
	}

	@Override
	public UserVO update(UserVO userVO) {
		User user = new User();
		BeanUtils.copyProperties(userVO, user);
		user = this.userRepository.update(user);
		BeanUtils.copyProperties(user, userVO);

		return userVO;
	}

	@Override
	public void remove(String id) {
		this.userRepository.remove(id);
	}

	@Override
	public int getNumberOfUsers() {
		return this.userRepository.getNumberOfUsers();
	}
}
