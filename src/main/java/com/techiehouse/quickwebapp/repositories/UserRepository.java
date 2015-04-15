package com.techiehouse.quickwebapp.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.techiehouse.quickwebapp.entity.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {
	User create(User user);

	User update(User user);

	void remove(String id);

	int getNumberOfUsers();

	List<User> getAllUsers();

	User createNewUser(User user);

	User getById(String id);
}
