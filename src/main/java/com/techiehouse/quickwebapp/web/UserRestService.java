package com.techiehouse.quickwebapp.web;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.techiehouse.quickwebapp.service.UserService;
import com.techiehouse.quickwebapp.vo.UserVO;

@RestController
@RequestMapping("/querywebapp")
public class UserRestService {

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public int getNumberOfUsers() {
		return userService.getNumberOfUsers();
	}

	@RequestMapping("/allPerson")
	public List<UserVO> getAllUsersInJSON() {
		return userService.getAllUsers();
	}

	@RequestMapping("/person/{id}")
	public UserVO getUserById(@PathVariable("id") String id) {
		return userService.getById(id);
	}

	@RequestMapping("/addPerson2/{fn}/{ln}")
	@ResponseStatus(HttpStatus.CREATED)
	public UserVO create2(@PathVariable("fn") String fn,
			@PathVariable("ln") String ln) {
		UserVO userVO = new UserVO();
		userVO.setFirstName(fn);
		userVO.setLastName(ln);
		return userService.createNewUser(userVO);
	}
	
	@RequestMapping(value="/addPerson", method=RequestMethod.POST )
	@ResponseStatus(HttpStatus.CREATED)
	public UserVO create(@RequestBody UserVO user) {
		UserVO userVO = new UserVO();
		userVO.setFirstName(user.getFirstName());
		userVO.setLastName(user.getLastName());
		return userService.createNewUser(userVO);
	}

	@RequestMapping(value = "/updatePerson", method = RequestMethod.PUT)
	public UserVO update(@RequestBody UserVO userVO) {
		return userService.update(userVO);
	}

	@RequestMapping(value="/deletePerson/{id}", method=RequestMethod.DELETE )
	public void remove(@PathVariable("id") String id) {
		userService.remove(id);
	}
}
